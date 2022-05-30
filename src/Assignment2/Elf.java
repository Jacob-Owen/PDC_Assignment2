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
public class Elf extends Enemy
{
    
  
    
    public Elf()
    {
        super.setName("Wood Elf"); //Sets the name
    }

    
     @Override
    public String magicCry()
    {
        return ("Wooooosh!\n"); //The Cry when Magic is used
    }
    
    @Override
    public String battleCry()
    {
        return ("Hu Yah!\n"); //The Cry when Attack is used
    }
}
