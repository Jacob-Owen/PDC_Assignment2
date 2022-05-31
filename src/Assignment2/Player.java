/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Jacob
 * Student Id: 20125914
 */
public class Player
{

    private String name;
    private int hp;
    private int mp;
    private int atk;
    private int def;
    private Random rand;
    private int exp;
    private int lvl;
    private int maxHp;
    private int maxMp;

    public Player(String name)
    {
        createPlayer(name);
    }
    
    public void createPlayer(String name)
    {
        //Creates a new player with random stats
        this.rand = new Random();
        this.name = name;
        this.hp = rand.nextInt(30) + 50;
        this.mp = rand.nextInt(5) + 5;
        this.atk = rand.nextInt(10) + 10;
        this.def = rand.nextInt(10) + 5;
        this.exp = 0;
        this.lvl = 1;
        this.maxHp = this.hp;
    }

    public void levelUp() 
    {
        System.out.println("LEVEL UP!!!!\n");
        
        //Incresses the level
        ++this.lvl;

        //Sets your HP back to the max HP again
        this.hp = this.maxHp;

        //Incresses all of your stats
        this.hp += 20;
        this.mp += 1;
        this.atk += rand.nextInt(4) + 1;
        this.def += rand.nextInt(4) + 1;

        //Sets EXP back to 0
        this.exp = 0;

        //Sets new HP to max HP
        this.maxHp = this.hp;

        //Displays the players new level
        System.out.println("You are now level " + (this.lvl) + "!!\n");
        
    }

    public void loadPlayer(String name) throws InterruptedException
    {
        FileReader fr = null;
        File file = new File("./" + name + ".txt");
        
        //Checks if the file exists to load
        if (!file.exists())
        {
            //If the file isn't there it lets you know it doen't exist
            JOptionPane.showMessageDialog(null, "Hero does not exist.\n Try again.", "Error", JOptionPane.WARNING_MESSAGE);
            
            //Takes you back to the new game/load screen
            
        }
        else
        {
            try
            {
                //Loads the file in to read the data
                fr = new FileReader("./" + name + ".txt");
            }
            catch (FileNotFoundException ex)
            {
                System.out.println(ex.getMessage());
            }

            BufferedReader br = new BufferedReader(fr);

            try
            {
                //Reads all of the starts from the file and loads them onto the character
                this.name = br.readLine();
                this.hp = Integer.parseInt(br.readLine());
                this.mp = Integer.parseInt(br.readLine());
                this.atk = Integer.parseInt(br.readLine());
                this.def = Integer.parseInt(br.readLine());
                this.exp = Integer.parseInt(br.readLine());
                this.lvl = Integer.parseInt(br.readLine());
                System.out.println("Load Successful!");
                
            }
            catch (IOException ex)
            {
                System.out.println("Load failed");
                System.out.println(ex.getMessage());
            }
            try
            {
                br.close();
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
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

    public int getLvl()
    {
        return lvl;
    }

    public void setLvl(int lvl)
    {
        this.lvl = lvl;
    }

    public int getExp()
    {
        return exp;
    }

    public void setExp(int exp)
    {
        this.exp = exp;
    }
}
