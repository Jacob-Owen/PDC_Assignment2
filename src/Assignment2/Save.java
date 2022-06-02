/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jacob
 * Student Id: 20125914
 */
public class Save
{
    private Connection conn;
    private Statement statement;

    public Save()
    {
      
    }
    
    public void saveGame(Player player, Database db) throws SQLException
    {
        
        conn = db.getConnection();
        
        this.statement = conn.createStatement();
        this.statement.addBatch("INSERT INTO PLAYER VALUES ('"+player.getName()+"', "+player.getHp()+", "+player.getMp()+", "+player.getAtk()+", "+player.getDef()+", "+player.getExp()+", "+player.getLvl()+", "+player.getMaxHp()+", "+player.getMaxMp()+", "+player.getScore()+")");
        this.statement.executeBatch();
        JOptionPane.showMessageDialog(null, "Save Successful", "SAVE", JOptionPane.INFORMATION_MESSAGE);
          
    }
}
