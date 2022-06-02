/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jacob Student Id: 20125914
 */
public class Enemy
{

    private String name;
    private int hp;
    private int mp;
    private int atk;
    private int def;
    private int expGain;
    private Random rand;
    private Connection conn;
    private Statement statement;

    public Enemy()
    {
        createEnemy();
    }

    //Sets the Enemy stats at random values.
    public void createEnemy()
    {
        this.name = name;
        this.rand = new Random();
        this.hp = rand.nextInt(30) + 30;
        this.mp = rand.nextInt(2) + 2;
        this.atk = rand.nextInt(10) + 10;
        this.def = rand.nextInt(10) + 1;
        this.expGain = this.hp; //Amount of EXP given to the player      
    }

    public void writeEnemy(Database db) throws SQLException
    {

        conn = db.getConnection();
        ResultSet rs = null;
        this.statement = conn.createStatement();
        rs = this.statement.executeQuery("SELECT * FROM ENEMY WHERE NAME = '" + this.name + "'");
        if (rs.next())
        {
            this.statement.addBatch("UPDATE ENEMY SET NAME = '" + this.name + "', HP = " + this.hp + ", MP = " + this.mp + ", ATTACK = " + this.atk + ", DEFENCE = " + this.def + ", EXPGAIN = " + this.expGain+" WHERE NAME = '" + this.name + "'");

        }
        else
        {
            this.statement.addBatch("INSERT INTO ENEMY VALUES ('" + this.name + "', " + this.hp + ", " + this.mp + ", " + this.atk + ", " + this.def + ", " + this.expGain + ")");
        }
        this.statement.executeBatch();

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getHp()
    {
        return hp;
    }

    public void setHp(int hp)
    {
        this.hp = hp;
    }

    public int getMp()
    {
        return mp;
    }

    public void setMp(int mp)
    {
        this.mp = mp;
    }

    public int getAtk()
    {
        return atk;
    }

    public void setAtk(int atk)
    {
        this.atk = atk;
    }

    public int getDef()
    {
        return def;
    }

    public void setDef(int def)
    {
        this.def = def;
    }

    public int getExpGain()
    {
        return expGain;
    }

    public void setExpGain(int expGain)
    {
        this.expGain = expGain;
    }

    //Cry that is used when using a Attack
    public String battleCry()
    {
        return "";
    }

    //Cry that is used when using a Magic spell
    public String magicCry()
    {
        return "";
    }
}
