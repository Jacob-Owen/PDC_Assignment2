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
public class RandomEvent
{

    public RandomEvent()
    {
    }
    
    public void calculateRandomEvent(Player player) throws InterruptedException
    {
        Random rand = new Random();
        int choice = rand.nextInt(5);
        switch(choice)
        {
            case 0:
            {
                System.out.println("\nYou continue on your adventure...");
                Thread.sleep(1000);
                break;
            }
            case 1:
            {
                System.out.println("\nYou find A relaxing spot to rest.");
                Thread.sleep(1000);
                player.setHp(player.getHp()+20);
                System.out.println("You gained 20 HP!");
                Thread.sleep(1000);
                System.out.println("You continue on your adventure...");
                Thread.sleep(1000);
                break;
            }
            case 2:
            {
                System.out.println("\nYou decide to take time to meditate.");
                Thread.sleep(1000);
                player.setMp(player.getMp()+3);
                System.out.println("You gained 3 MP!");
                Thread.sleep(1000);
                System.out.println("You continue on your adventure...");
                Thread.sleep(1000);
                break;
            }
            case 3:
            {
                System.out.println("\nA Shiny new sword is laying on the ground. you pick it up.");
                Thread.sleep(1000);
                player.setAtk(player.getAtk()+1);
                System.out.println("You gained 1 Attack!");
                Thread.sleep(1000);
                System.out.println("You continue on your adventure...");
                Thread.sleep(1000);
                break;
            }
            case 4:
            {
                System.out.println("\nYou get a banquet hosted for you. you feel full and recharged.");
                Thread.sleep(1000);
                player.setHp(player.getHp()+50);
                System.out.println("You gained 50 HP!");
                Thread.sleep(1000);
                System.out.println("You continue on your adventure...");
                Thread.sleep(1000);
                break;
            }
        }
    }
}
