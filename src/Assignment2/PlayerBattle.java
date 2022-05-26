/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment2;

/**
 *
 * @author Jacob
 * Student Id: 20125914
 */
public class PlayerBattle extends Battle
{
    public int calculatePlayerAttack(Player player, Enemy enemy)
    {
        //Calculates the power of the Player's attack depending on their attack stat and the Enemy's defence stat.
        int playerAttack = (super.getAttack() + player.getAtk()) - enemy.getDef();
        return playerAttack;
    }
    
    public int calculatePlayerMagic(Player player, Enemy enemy)
    {
        //Calculates the power of the Player's magic attack depending on their attack stat and the Enemy's defence stat.
        int magicAttack = (super.getAttack() + player.getAtk() + super.MAGIC) - enemy.getDef(); //Attack power is incressed by a fixed amount as magic is a stronger attack
        //Removes MP from the Player
        player.setMp(player.getMp() - 1);
        return magicAttack;
    }
    
    public void playerBattle(Game game, int choice) throws InterruptedException
    {
        //Takes the Player's choice to ATTACK, MAGIC or RUN
        switch (choice)
        {
            // ATTACK is chosen
            case 1:
            {
                System.out.println("You attack!");
                for (int i = 0; i < 5; ++i)
                {
                    System.out.print("=");
                    Thread.sleep(500);
                }

                //Calculates the attacks's damage
                int attackOutput = this.calculatePlayerAttack(game.player, game.enemy);

                //Calculates if the attack misses or not
                super.rollMiss();
                if (super.getMiss() == 1 || attackOutput <= 0)
                {
                    System.out.println("\nYou miss!!!\n");
                    Thread.sleep(1000);
                }
                else
                {
                    System.out.println("\nHIT!\n");
                    Thread.sleep(1000);
                    System.out.println("You hit for " + attackOutput + "!\n");
                    Thread.sleep(1000);
                    //Removes the attack damage from the Enemy's health
                    game.enemy.setHp(game.enemy.getHp() - attackOutput);
                }

                //Checks to see if the Enemy HP is below 0
                if (game.enemy.getHp() < 0)
                {
                    System.out.println(game.enemy.getName() + "'s HP is 0\n");
                    Thread.sleep(1000);
                }
                else
                {
                    //Displays the Enemy's remaining health
                    System.out.println(game.enemy.getName() + "'s HP is " + game.enemy.getHp() + "\n");
                    Thread.sleep(1000);
                }
                break;
            }
            //MAGIC is chosen
            case 2:
            {
                System.out.println("You cast a Spell!");
                for (int i = 0; i < 5; ++i)
                {
                    System.out.print("=");
                    Thread.sleep(500);
                }
                int attackOutput = 0;

                //Checks if you are out of MP
                if (game.player.getMp() <= 0)
                {
                    System.out.println("\nYou are out of MP!");
                }
                else
                {
                    //Calculates the attacks's damage
                    attackOutput = this.calculatePlayerMagic(game.player, game.enemy);
                }

                //Calculates if the attack misses or not
                super.rollMiss();
                if (this.getMiss() == 1 || attackOutput <= 0)
                {
                    System.out.println("\nYou miss!!!\n");
                    Thread.sleep(1000);
                }
                else
                {
                    if (attackOutput > 0)
                    {
                        System.out.println("\nHIT!\n");
                        Thread.sleep(1000);
                        //Displays the dammage delt
                        System.out.println("You hit for " + attackOutput + "!\n");
                        Thread.sleep(1000);
                        //Removes the dammage from the Enemy's HP
                        game.enemy.setHp(game.enemy.getHp() - attackOutput);
                    }
                    if (game.player.getMp() >= 0)
                    {
                        //Displays the remaining MP for the player
                        System.out.println("Remaining MP is " + game.player.getMp() + "!\n");
                        Thread.sleep(1000);
                    }
                }
                //Checks to see if the Enemy's HP is below 0
                if (game.enemy.getHp() < 0)
                {
                    System.out.println(game.enemy.getName() + "'s HP is 0\n");
                }
                else
                {
                    //Displays the Enemy's remaining health
                    System.out.println(game.enemy.getName() + "'s HP is " + game.enemy.getHp() + "\n");
                }
                Thread.sleep(1000);
                break;
            }
            //RUN is chosen
            case 3:
            {
                System.out.println("You try to run!\n");
                for (int i = 0; i < 5; ++i)
                {
                    System.out.print("=");
                    Thread.sleep(500);
                }
                System.out.println("\n");
                
                //Calculates if the Player is able to run from battle
                super.rollRun();
                if (this.getRun() <= 1)
                {
                    //Running was unsuccessful
                    System.out.println("You failed to run!\n");
                    Thread.sleep(1000);
                }
                else
                {
                    //Able to run away
                    System.out.println("You ran away!\n");
                    Thread.sleep(1000);
                    game.run = true;
                }
                break;
            }
        }
    }
}
