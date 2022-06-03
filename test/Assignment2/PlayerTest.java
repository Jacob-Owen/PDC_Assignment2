/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Assignment2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jcobm
 */
public class PlayerTest
{
    
    public PlayerTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of createPlayer method, of class Player.
     */
    @Test
    public void testCreatePlayer()
    {
        System.out.println("createPlayer");
        String name = "Test";
        Player instance = new Player(name);
        instance.createPlayer(name);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of levelUp method, of class Player.
     */
    @Test
    public void testLevelUp()
    {
        System.out.println("levelUp");
        Player instance = new Player("Test");
        instance.levelUp();
        
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName()
    {
        System.out.println("getName");
        Player instance = new Player("Test");
        String expResult = "Test";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Player.
     */
    @Test
    public void testSetName()
    {
        System.out.println("setName");
        String name = "Test";
        Player instance = new Player("");
        instance.setName(name);
    }

    /**
     * Test of getHp method, of class Player.
     */
    @Test
    public void testGetHp()
    {
        System.out.println("getHp");
        Player instance = new Player("Test");
        instance.setHp(50);
        int expResult = 50;
        int result = instance.getHp();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHp method, of class Player.
     */
    @Test
    public void testSetHp()
    {
        System.out.println("setHp");
        int hp = 0;
        Player instance = new Player("Test");
        instance.setHp(hp);
    }

    /**
     * Test of getMp method, of class Player.
     */
    @Test
    public void testGetMp()
    {
        System.out.println("getMp");
        Player instance = new Player("Test");
        instance.setMp(5);
        int expResult = 5;
        int result = instance.getMp();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMp method, of class Player.
     */
    @Test
    public void testSetMp()
    {
        System.out.println("setMp");
        int mp = 4;
        Player instance = new Player("Test");
        instance.setMp(mp);
        
    }

    /**
     * Test of getAtk method, of class Player.
     */
    @Test
    public void testGetAtk()
    {
        System.out.println("getAtk");
        Player instance = new Player("Test");
        instance.setAtk(12);
        int expResult = 12;
        int result = instance.getAtk();
        assertEquals(expResult, result);    
    }

    /**
     * Test of setAtk method, of class Player.
     */
    @Test
    public void testSetAtk()
    {
        System.out.println("setAtk");
        int atk = 7;
        Player instance = new Player("Test");
        instance.setAtk(atk);
    }

    /**
     * Test of getDef method, of class Player.
     */
    @Test
    public void testGetDef()
    {
        System.out.println("getDef");
        Player instance = new Player("Test");
        instance.setDef(2);
        int expResult = 2;
        int result = instance.getDef();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDef method, of class Player.
     */
    @Test
    public void testSetDef()
    {
        System.out.println("setDef");
        int def = 8;
        Player instance = new Player("Test");
        instance.setDef(def);
    }

    /**
     * Test of getLvl method, of class Player.
     */
    @Test
    public void testGetLvl()
    {
        System.out.println("getLvl");
        Player instance = new Player("Test");
        int expResult = 1;
        int result = instance.getLvl();
        assertEquals(expResult, result);

    }

    /**
     * Test of setLvl method, of class Player.
     */
    @Test
    public void testSetLvl()
    {
        System.out.println("setLvl");
        int lvl = 3;
        Player instance = new Player("Test");
        instance.setLvl(lvl);
    }

    /**
     * Test of getExp method, of class Player.
     */
    @Test
    public void testGetExp()
    {
        System.out.println("getExp");
        Player instance = new Player("Test");
        int expResult = 0;
        int result = instance.getExp();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setExp method, of class Player.
     */
    @Test
    public void testSetExp()
    {
        System.out.println("setExp");
        int exp = 74;
        Player instance = new Player("Test");
        instance.setExp(exp);
    }

    /**
     * Test of getMaxHp method, of class Player.
     */
    @Test
    public void testGetMaxHp()
    {
        System.out.println("getMaxHp");
        Player instance = new Player("Test");
        instance.setMaxHp(83);
        int expResult = 83;
        int result = instance.getMaxHp();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScore method, of class Player.
     */
    @Test
    public void testGetScore()
    {
        System.out.println("getScore");
        Player instance = new Player("Test");
        int expResult = 0;
        int result = instance.getScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxHp method, of class Player.
     */
    @Test
    public void testSetMaxHp()
    {
        System.out.println("setMaxHp");
        int maxHp = 65;
        Player instance = new Player("Test");
        instance.setMaxHp(maxHp);
    }


    /**
     * Test of setScore method, of class Player.
     */
    @Test
    public void testSetScore()
    {
        System.out.println("setScore");
        int score = 6;
        Player instance = new Player("Test");
        instance.setScore(score);
    }
    
}
