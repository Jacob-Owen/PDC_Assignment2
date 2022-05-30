/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment2;

import java.util.Random;

/**
 *
 * @author Jacob
 * Student Id: 20125914
 */
public class EnemyBattle extends Battle
{

    public int calculateEnemyAttack(Player player, Enemy enemy)
    {
        //Calculates the power of the Enemy's attack depending on their attack stat and the Player's defence stat.
        int enemyAttack = (super.getAttack() + enemy.getAtk()) - player.getDef();
        return enemyAttack;
    }

    public int calculateEnemyMagic(Player player, Enemy enemy)
    {
        //Calculates the power of the Enemy's magic attack depending on their attack stat and the Player's defence stat.
        int magicAttack = (super.getAttack() + enemy.getAtk() + super.MAGIC) - player.getDef(); //Attack power is incressed by a static amount as magic is a stronger attack
        //Removes MP from the Enemy
        enemy.setMp(enemy.getMp() - 1);
        return magicAttack;
    }

    public void enemyBattle(GameGUI game) 
    {
        Random rand = new Random();
        //Randomly chooses what action the Enemy should perform
        int enemyChoice = rand.nextInt(6) + 1;

        //Enemy uses an attack (3/6 odds)
        if (enemyChoice > 0 && enemyChoice <= 3)
        {
            System.out.println(game.enemy.getName() + " attacks!");

            for (int i = 0; i < 5; ++i)
            {
                System.out.print("=");
                
            }
            System.out.println("\n");
            //Calculates the damage delt.
            int attackOutput = this.calculateEnemyAttack(game.player, game.enemy);
            
            //Rolls to see if the attack misses.
            super.rollMiss();
            if (super.getMiss() == 1 || attackOutput <= 0)//Enemy misses if their attack power is 0 or they roll a miss
            {
                System.out.println("The " + game.enemy.getName() + " misses!!!\n");
                
            }
            else
            {
                //Attack is sucessful.
                if (attackOutput > 0)
                {
                    System.out.println(game.enemy.battleCry());//Enemy does their battle cry
                    
                    System.out.println("The " + game.enemy.getName() + " hits for " + attackOutput + "!\n");
                    
                    game.player.setHp(game.player.getHp() - attackOutput);
                }
                //Checks to see if your HP is below 0.
                if (game.player.getHp() < 0)
                {
                    game.playerHP.setText("HP: 0");
                }
                
                
            }

        }
        //Enemy uses a magic attack (2/6 odds)
        else if (enemyChoice >= 4 && enemyChoice < 6)
        {
            System.out.println("The " + game.enemy.getName() + " casts a Spell!");
            for (int i = 0; i < 5; ++i)
            {
                System.out.print("=");
                
            }
            System.out.println("\n");

            //Calculates the strength of the Magic attack
            int attackOutput = this.calculateEnemyMagic(game.player, game.enemy);

            //Checks if the Enemy is out of MP
            if (game.enemy.getMp() <= 0)
            {
                System.out.println("\nThe" + game.enemy.getName() + " has run out of MP");
                attackOutput = 0;
            }

            //Rolls to see if the attack misses.
            super.rollMiss();
            if (super.getMiss() == 1 || attackOutput <= 0)//Enemy misses if their attack power is 0 or they roll a miss
            {
                System.out.println(game.enemy.getName() + " misses!!!\n");
                
            }
            else
            {
                if (attackOutput > 0)
                {
                    System.out.println(game.enemy.magicCry()); //Enemy does their battle cry
                    
                    System.out.println("The " + game.enemy.getName() + " hit for " + attackOutput + "!\n");
                    
                    game.player.setHp(game.player.getHp() - attackOutput);
                    //Checks to see if your HP is below 0
                    if (game.player.getHp() < 0)
                    {
                        game.player.setHp(0);
                    }
                   
                    
                }
            }

        }
        // Enemy does nothing (1/6 odds)
        else
        {
            System.out.println("The " + game.enemy.getName() + " stands there.\n");
            
        }
    }
}
