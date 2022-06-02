/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jacob Student Id: 20125914
 */
public class Save
{

    private Connection conn;
    private Statement statement;

    public Save()
    {

    }

    public void saveGame(Player player, Database db)
    {

        conn = db.getConnection();
        ResultSet rs = null;
        try
        {
            this.statement = conn.createStatement();

        }
        catch (SQLException ex)
        {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }

        try
        {
            rs = this.statement.executeQuery("SELECT * FROM PLAYER WHERE NAME = '" + player.getName() + "'");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            if (rs.next())
            {
                this.statement.addBatch("UPDATE PLAYER SET NAME = '" + player.getName() + "', HP = " + player.getHp() + ", MP = " + player.getMp() + ", ATTACK = " + player.getAtk() + ", DEFENCE = " + player.getDef() + ", EXP = " + player.getExp() + ", LEVEL = " + player.getLvl() + ", MAXHP = " + player.getMaxHp() + ", SCORE = " + player.getScore()+" WHERE NAME = '"+player.getName()+"'");
            }
            else
            {
                this.statement.addBatch("INSERT INTO PLAYER VALUES ('" + player.getName() + "', " + player.getHp() + ", " + player.getMp() + ", " + player.getAtk() + ", " + player.getDef() + ", " + player.getExp() + ", " + player.getLvl() + ", " + player.getMaxHp() + ", " + player.getScore() + ")");

            }
        }
            catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Save Failed", "SAVE", JOptionPane.WARNING_MESSAGE);        
        }
            try
            {
                this.statement.executeBatch();
            }
            catch (SQLException ex)
            {
                Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Save Successful", "SAVE", JOptionPane.INFORMATION_MESSAGE);

        }
        
    }
