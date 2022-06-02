/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jcobm
 */
public class Load
{

    private Connection conn;
    private Statement statement;
    private boolean load;

    public Load()
    {
        load = false;
    }

    public boolean loadGame(String name, Player p, Database db) throws SQLException
    {
        conn = db.getConnection();
        this.statement = conn.createStatement();
        ResultSet rs = null;
        try
        {
            rs = this.statement.executeQuery("SELECT * FROM PLAYER WHERE NAME = '" + name + "'");
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        if (rs.next())
        {
            p.setName(rs.getString("NAME"));
            p.setHp(rs.getInt("HP"));
            p.setMp(rs.getInt("MP"));
            p.setAtk(rs.getInt("ATTACK"));
            p.setDef(rs.getInt("DEFENCE"));
            p.setExp(rs.getInt("EXP"));
            p.setLvl(rs.getInt("LEVEL"));
            p.setMaxHp(rs.getInt("MAXHP"));

            JOptionPane.showMessageDialog(null, "Load Successful", "Load", JOptionPane.INFORMATION_MESSAGE);
            load = true;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Player does not exist.\nTry Again", "SAVE", JOptionPane.WARNING_MESSAGE);
            load = false;
        }
        return load;
    }
}
