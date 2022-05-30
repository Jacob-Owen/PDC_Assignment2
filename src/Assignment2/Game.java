/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jacob
 * Student Id: 20125914
 */
public class Game
{

    public Player player;
    public Enemy enemy;
    public boolean quit;
    public boolean run;
    public boolean load;

    public void Game()
    {
        this.player = null;
        this.enemy = null;
        this.quit = false;
        this.run = false;
        this.load = false;
    }

    public void newGame(String name) throws InterruptedException
    {
        //Creates a new player with the name chosen
        this.player = new Player(name);
        System.out.println("\nGreetings " + name + ". Your journey is about to begin.\n");
        Thread.sleep(1000);
    }

    public void loadGame(String name) throws InterruptedException
    {
        //makes a dummy player to write the stats to
        this.player = new Player("");
        //loads in the players stats
        this.player.loadPlayer(name);
        if (this.load == true)//Checks if the load is sucessful
        {
            System.out.println("\nWelcome back " + name + ". Your journey continues.\n");
            Thread.sleep(1000);
            this.load = false;
        }
    }

    public void generateEnemy() throws InterruptedException
    {
        //Randomly gets a number to decide what enemy to use
        Random rand = new Random();
        int enemyChosen = rand.nextInt(4) + 1;

        //Creates a enemy depending on what number was chosen 
        switch (enemyChosen)
        {
            case 1:
            {
                this.enemy = new Orc();
                break;
            }
            case 2:
            {
                this.enemy = new Wizard();
                break;
            }
            case 3:
            {
                this.enemy = new Giant();
                break;
            }
            case 4:
            {
                this.enemy = new Elf();
                break;
            }

        }
        //Displays what enemy is chosen
        System.out.println("A " + this.enemy.getName() + " appears!!\n");
        Thread.sleep(1000);
    }

    public void gameStart() throws InterruptedException
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease choose your option:\n");
        System.out.println("1. New Game");
        System.out.println("2. Load game\n");
        System.out.print("> ");
        int gameChoice = 0;
        gameChoice = this.checkIntInput(gameChoice, 2);//Checks to make sure the input is one of the options

        switch (gameChoice)
        {
            case 1: //New game is chosen
            {
                System.out.println("\nWhat is your heros name?: ");
                System.out.print("> ");
                String name = scan.nextLine();
                try
                {
                    //Creates a new character with the name given
                    this.newGame(name);
                }
                catch (InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
                break;
            }
            case 2: //Load game is chosen
            {
                System.out.println("\nPlease enter your heros name to load: ");
                System.out.print("> ");
                String name = scan.nextLine();
                try
                {
                    //Loads a character of the selected name
                    this.loadGame(name);
                }
                catch (InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
                break;
            }
        }
    }

    public int checkIntInput(int input, int range)
    {
        Scanner scan = new Scanner(System.in);
        do
        {
            try
            {
                input = scan.nextInt();//Gets input from the player
            }
            catch (InputMismatchException e)//Catches if the entered value is not a number
            {
                System.out.println("Please enter a number.");
                input = 0;
                scan.nextLine();
            }

            if (input <= 0 || input > range)//Checks to see if the number entered is out of range of the options given
            {
                System.out.println("Incorrect input! Please try again.");
                System.out.print("> ");
            }
        }
        while (input <= 0 || input > range);//Keeps looping if the number is not correct
        return input;
    }

    public String checkYNInput()
    {
        Scanner scan = new Scanner(System.in);
        String input;
        boolean exit = false;

        input = scan.nextLine();
        if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n"))//Checks to see if Y or N was entered
        {
            exit = true;//Lets the loop finish
        }
        else//Y or N was not inputted
        {
            System.out.println("Incorrect input. Please enter Y/N.");
            System.out.print("> ");
            this.checkYNInput();//Starts the check again
        }

        return input;
    }

    public void battleStart() throws InterruptedException
    {
        System.out.println(this.player.getName() + " HP :" + this.player.getHp());//Displays the Players HP
        System.out.println(this.player.getName() + " MP: " + this.player.getMp());//Displays the Players MP

        //Asks the Player what move they would like to use
        System.out.println("What will you do?");
        Thread.sleep(100);
        System.out.println("1. ATTACK");
        Thread.sleep(100);
        System.out.println("2. MAGIC");
        Thread.sleep(100);
        System.out.println("3. RUN");
        Thread.sleep(100);
        System.out.print("> ");
        int choice = 0;
        choice = this.checkIntInput(choice, 3);
        System.out.print("\n");

        //Starts the Players turn
        PlayerBattle pBattle = new PlayerBattle();

        

        if (this.enemy.getHp() > 0 && this.run == false)//Checks if the Enemys HP is 0 or if the Player has ran
        {
            //Starts the Enemy battle
            EnemyBattle eBattle = new EnemyBattle();
            //eBattle.enemyBattle(this);
        }
    }

    public void battleEnd() throws InterruptedException
    {
        System.out.println("The Monster is defeted! \n");
        Thread.sleep(1000);

        //Incresses the Players EXP 
        this.player.setExp(this.player.getExp() + this.enemy.getExpGain());
        System.out.println("CONGRATULATIONS!!!!\n");
        Thread.sleep(1000);
        System.out.println("You gained " + this.enemy.getExpGain() + " EXP!");//Displays the EXP gained
        Thread.sleep(1000);

        //Checks to see if the player has enough EXP to Level up
        if (this.player.getExp() >= this.player.getLvl() * 100)
        {
            this.player.levelUp();//Player levels up
        }
        else
        {
            //Advises how much how much EXP is left before Level up
            System.out.println("You have " + ((this.player.getLvl() * 100) - this.player.getExp()) + " EXP before next level up\n");
            Thread.sleep(1000);
        }

        //Checks if player wants to save.
        System.out.println("Do you wish to save? Y/N");
        System.out.print("> ");
        String saveConfirm = this.checkYNInput();

        if (saveConfirm.equalsIgnoreCase("y"))//If the player chooses to save
        {
            Save save = new Save(); //Saves the game
            save.saveGame(this.player);
            Thread.sleep(1000);
        }
        //Checks if player wants to quit.
        System.out.println("Do you wish to Quit? Y/N");
        System.out.print("> ");
        String quitConfirm = this.checkYNInput();

        if (quitConfirm.equalsIgnoreCase("y"))//If the player chooses to quit
        {
            this.quit = true; //Breaks the loop to quit the game
        }
        else
        {
            //Generates a random event to happen.
            RandomEvent event = new RandomEvent();
            event.calculateRandomEvent(this.player);
        }
    }

    public void gameEnd() throws InterruptedException
    {
        //If the Player decides to quit
        if (this.quit == true)
        {
            System.out.println("GAME OVER");
            System.out.println("Thanks for playing!!");
        }
        //If the Player Runs out of HP and Game Overs
        else
        {
            System.out.println("GAME OVER");
            System.out.println("Try again next time!");
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        Game game = new Game();

        //Title screen
        System.out.println("===============");
        System.out.println("Monster Slayer!");
        System.out.println("===============");
        Thread.sleep(1000);
        System.out.println("Your adventure begins");

        for (int i = 0; i < 5; i++)
        {
            System.out.print(".");
            Thread.sleep(500);
        }

        //Gives the option to play a new game or load a previous game
        game.gameStart();

        //Starts the first loop of the battle
        do
        {
            //Creates a random new enemy to battle
            game.generateEnemy();
            game.run = false;

            //Starts the battle loop
            while (game.enemy.getHp() > 0 && game.player.getHp() > 0 && game.run == false)
            {
                game.battleStart();
            }
            //Checks to see if the enemy is defeted
            if (game.enemy.getHp() <= 0)
            {
                game.battleEnd();
            }
        }
        //Checks to see if the player still has HP or if Quit has been selected.
        while (game.player.getHp() > 0 && game.quit == false);
        game.gameEnd();
    }
}
