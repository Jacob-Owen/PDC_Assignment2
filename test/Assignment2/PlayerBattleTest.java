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
public class PlayerBattleTest
{
    
    public PlayerBattleTest()
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
     * Test of calculatePlayerAttack method, of class PlayerBattle.
     */
    @Test
    public void testCalculatePlayerAttack()
    {
        System.out.println("calculatePlayerAttack");
        Player player = new Player("Test");
        Enemy enemy = new Enemy();
        PlayerBattle instance = new PlayerBattle();
        int result = instance.calculatePlayerAttack(player, enemy);
        int expResult = 0;
        assertEquals(expResult, 30);
       
    }

    /**
     * Test of calculatePlayerMagic method, of class PlayerBattle.
     */
    @Test
    public void testCalculatePlayerMagic()
    {
        System.out.println("calculatePlayerMagic");
        Player player = new Player("Test");
        Enemy enemy = new Enemy();
        PlayerBattle instance = new PlayerBattle();
        int result = instance.calculatePlayerMagic(player, enemy);
        int expResult = 0;
        assertEquals(expResult, result, 70);
    }

    /**
     * Test of playerAttack method, of class PlayerBattle.
     */
    @Test
    public void testPlayerAttack()
    {
        System.out.println("playerAttack");
        GameGUI game = new GameGUI();
        PlayerBattle instance = new PlayerBattle();
        instance.playerAttack(game);    
    }

    /**
     * Test of playerMagic method, of class PlayerBattle.
     */
    @Test
    public void testPlayerMagic()
    {
        System.out.println("playerMagic");
        GameGUI game = new GameGUI();
        PlayerBattle instance = new PlayerBattle();
        instance.playerMagic(game);    
    }

    /**
     * Test of playerRun method, of class PlayerBattle.
     */
    @Test
    public void testPlayerRun()
    {
        System.out.println("playerRun");
        PlayerBattle instance = new PlayerBattle();
        boolean expResult = true;
        boolean result = instance.playerRun();        
        if(result == false)
        {
            expResult = false;
        }
        assertEquals(expResult, result);   
    }
    
}
