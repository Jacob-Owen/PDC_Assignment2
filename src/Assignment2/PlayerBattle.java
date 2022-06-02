/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment2;

/**
 *
 * @author Jacob Student Id: 20125914
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

    public void playerAttack(GameGUI game)
    {
        System.out.println("You attack!\n");

        //Calculates the attacks's damage
        int attackOutput = this.calculatePlayerAttack(game.player, game.enemy);

        //Calculates if the attack misses or not
        super.rollMiss();
        if (super.getMiss() == 1 || attackOutput <= 0)
        {
            System.out.println("You miss!!!\n");

        }
        else
        {
            System.out.println("HIT!\n");

            System.out.println("You hit for " + attackOutput + "!\n");

            //Removes the attack damage from the Enemy's health
            game.enemy.setHp(game.enemy.getHp() - attackOutput);
        }

        //Checks to see if the Enemy HP is below 0
        if (game.enemy.getHp() < 0)
        {
            System.out.println(game.enemy.getName() + "'s HP is 0\n");

        }
        else
        {
            //Displays the Enemy's remaining health
            System.out.println(game.enemy.getName() + "'s HP is " + game.enemy.getHp() + "\n");

        }
    }

    public void playerMagic(GameGUI game)
    {
        System.out.println("You cast a Spell!");
        for (int i = 0; i < 5; ++i)
        {
            System.out.print("=");

        }
        System.out.print("\n");
        int attackOutput = 0;

        //Checks if you are out of MP
        if (game.player.getMp() <= 0)
        {
            System.out.println("You are out of MP!");
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
            System.out.println("You miss!!!\n");

        }
        else
        {
            if (attackOutput > 0)
            {
                System.out.println("HIT!\n");

                //Displays the dammage delt
                System.out.println("You hit for " + attackOutput + "!\n");

                //Removes the dammage from the Enemy's HP
                game.enemy.setHp(game.enemy.getHp() - attackOutput);
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
    }

    public boolean playerRun()
    {
        System.out.println("You try to run!\n");
        for (int i = 0; i < 5; ++i)
        {
            System.out.print("=");

        }
        System.out.print("\n");

        //Calculates if the Player is able to run from battle
        super.rollRun();
        if (this.getRun() <= 1)
        {
            //Running was unsuccessful
            System.out.println("You failed to run!\n");
            return false;
        }
        else
        {
            //Able to run away
            System.out.println("You ran away!\n");
            return true;
        }
    }
}
