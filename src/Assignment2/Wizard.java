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
public class Wizard extends Enemy
{
    
    public Wizard()
    {
        
        super.setName("Wizard"); //Sets the name
        super.setHp(super.getHp()-10); //Decresses the base HP
        super.setMp(super.getMp()+10); //Incresses the base MP
    }
    
    @Override
    public String magicCry()
    {
        return("Wuzzzzzrt!\n"); //The Cry when Magic is used
    }

    @Override
    public String battleCry()
    {
        return("Zip Zap!\n"); //The Cry when Attack is used
    }
    
}
