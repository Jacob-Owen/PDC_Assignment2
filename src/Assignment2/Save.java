/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author Jacob
 * Student Id: 20125914
 */
public class Save
{

    public Save()
    {
      
    }
    
    public void saveGame(Player player)
    {
        FileOutputStream fs;
        try
        {
            //Creates a new file to save to
            fs = new FileOutputStream("./"+player.getName()+".txt");
            PrintWriter pw = new PrintWriter(fs);
            String output = "";
            
            //Writes all of the Players stats to a text string
            output += player.getName();
            output += "\n";
            output += player.getHp();
            output += "\n";
            output += player.getMp();
            output += "\n";
            output += player.getAtk();
            output += "\n";
            output += player.getDef();
            output += "\n";
            output += player.getExp();
            output += "\n";
            output += player.getLvl();
            
            //Prints that text to a file
            pw.print(output);
            
            //Confirms saving was sucessful
            System.out.println("Save complete!");
            
            pw.close();
        }
        catch (FileNotFoundException ex)
        {
            //Displays if saving the file failed
            System.out.println("Save Failed");
            System.out.println(ex.getMessage());
        }
    }
}
