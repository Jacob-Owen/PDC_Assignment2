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
public class Orc extends Enemy
{

    public Orc()
    {
        super.setName("Orc"); //Sets the name
        super.setMp(0); //Sets the MP to 0
        super.setAtk(super.getAtk() + 10); //Incresses the base Attack
    }
    
    @Override
    public String battleCry()
    {
        return ("ARRRRRRGGGGGH!\n"); //The Cry when Attack is used
    }

}
