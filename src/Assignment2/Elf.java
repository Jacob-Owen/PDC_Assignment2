/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment2;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 * Student Id: 20125914
 */
public class Elf extends Enemy
{
    
    public Elf(Database db)
    {        
        super.setName("Wood Elf"); //Sets the name
        try
        {
            super.writeEnemy(db);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Elf.class.getName()).log(Level.SEVERE, null, ex);
        }
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
