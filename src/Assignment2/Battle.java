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
public class Battle
{

    private int attack;
    private int run;
    private int miss;
    private Random rand;
    public static final int MAGIC = 20; //Set number that all magic attacks are incressed by

    public void battle()
    {
        generateBattle();
    }
    
    public void generateBattle()
    {
        this.rand = new Random();
        this.attack = rand.nextInt(10) + 5;//Gets a random number  to get the attack modifyer 
        this.run = rand.nextInt(5) + 1;//Gets a random number to decide if running was sucessful
        this.miss = rand.nextInt(5) + 1;//Gets a random number to see if the attack missed
    }

    public int getAttack()
    {
        return attack;
    }

    public int getRun()
    {
        return run;
    }

    public int getMiss()
    {
        return miss;
    }
    
    //Rolls run again so it is random each time
    public void rollRun()
    {
        this.rand = new Random();
        this.run = this.rand.nextInt(5)+1;
    }
    
    //Rolls miss again so it is random each time
    public void rollMiss()
    {
        this.rand = new Random();
        this.miss = this.rand.nextInt(5)+1;
    }

}
