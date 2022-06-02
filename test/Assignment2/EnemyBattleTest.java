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
public class EnemyBattleTest
{
    
    public EnemyBattleTest()
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
     * Test of calculateEnemyAttack method, of class EnemyBattle.
     */
    @Test
    public void testCalculateEnemyAttack()
    {
        System.out.println("calculateEnemyAttack");
        Player player = new Player("Test");
        Enemy enemy = new Enemy();
        EnemyBattle instance = new EnemyBattle();
        int expResult = 0;
        int result = instance.calculateEnemyAttack(player, enemy);
        assertEquals(expResult, result, 30);
        
    }

    /**
     * Test of calculateEnemyMagic method, of class EnemyBattle.
     */
    @Test
    public void testCalculateEnemyMagic()
    {
        System.out.println("calculateEnemyMagic");
        Player player = new Player("Test");
        Enemy enemy = new Enemy();
        EnemyBattle instance = new EnemyBattle();
        int expResult = 0;
        int result = instance.calculateEnemyMagic(player, enemy);
        assertEquals(expResult, result, 30);
        
    }

    /**
     * Test of enemyBattle method, of class EnemyBattle.
     */
    @Test
    public void testEnemyBattle()
    {
        System.out.println("enemyBattle");
        GameGUI game = new GameGUI();
        EnemyBattle instance = new EnemyBattle();
        instance.enemyBattle(game);
        
    }
    
}
