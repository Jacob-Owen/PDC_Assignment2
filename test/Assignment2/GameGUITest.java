/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Assignment2;

import java.awt.event.ActionEvent;
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
public class GameGUITest
{
    
    public GameGUITest()
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
     * Test of initWindow method, of class GameGUI.
     */
    @Test
    public void testInitWindow()
    {
        System.out.println("initWindow");
        GameGUI instance = new GameGUI();
        instance.initWindow();       
    }

    /**
     * Test of initButton method, of class GameGUI.
     */
    @Test
    public void testInitButton()
    {
        System.out.println("initButton");
        GameGUI instance = new GameGUI();
        instance.initButton();
    }

    /**
     * Test of initPanel method, of class GameGUI.
     */
    @Test
    public void testInitPanel()
    {
        System.out.println("initPanel");
        GameGUI instance = new GameGUI();
        instance.initPanel();
    }


    /**
     * Test of titleScreen method, of class GameGUI.
     */
    @Test
    public void testTitleScreen()
    {
        System.out.println("titleScreen");
        GameGUI instance = new GameGUI();
        instance.titleScreen();
    }

    /**
     * Test of battleScreen method, of class GameGUI.
     */
    @Test
    public void testBattleScreen()
    {
        System.out.println("battleScreen");
        GameGUI instance = new GameGUI();
        instance.battleScreen();
    }

    /**
     * Test of saveScreen method, of class GameGUI.
     */
    @Test
    public void testSaveScreen()
    {
        System.out.println("saveScreen");
        GameGUI instance = new GameGUI();
        instance.saveScreen();
    }

    /**
     * Test of quitScreen method, of class GameGUI.
     */
    @Test
    public void testQuitScreen()
    {
        System.out.println("quitScreen");
        GameGUI instance = new GameGUI();
        instance.quitScreen();
    }

    /**
     * Test of battleStart method, of class GameGUI.
     */
    @Test
    public void testBattleStart()
    {
        System.out.println("battleStart");
        GameGUI instance = new GameGUI();
        instance.battleStart();
    }

    /**
     * Test of setBattleButtonVisible method, of class GameGUI.
     */
    @Test
    public void testSetBattleButtonVisible()
    {
        System.out.println("setBattleButtonVisible");
        boolean set = true;
        GameGUI instance = new GameGUI();
        instance.setBattleButtonVisible(set);
    }

    /**
     * Test of generateEnemy method, of class GameGUI.
     */
    @Test
    public void testGenerateEnemy()
    {
        System.out.println("generateEnemy");
        GameGUI instance = new GameGUI();
        instance.generateEnemy();
    }

    /**
     * Test of checkPlayerHealth method, of class GameGUI.
     */
    @Test
    public void testCheckPlayerHealth()
    {
        System.out.println("checkPlayerHealth");
        GameGUI instance = new GameGUI();
        boolean expResult = true;
        boolean result = instance.checkPlayerHealth();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkEnemyHealth method, of class GameGUI.
     */
    @Test
    public void testCheckEnemyHealth()
    {
        System.out.println("checkEnemyHealth");
        GameGUI instance = new GameGUI();
        boolean expResult = true;
        boolean result = instance.checkEnemyHealth();
        assertEquals(expResult, result);
    }

    /**
     * Test of battleEnd method, of class GameGUI.
     */
    @Test
    public void testBattleEnd()
    {
        System.out.println("battleEnd");
        Database db = new Database();
        Player player = new Player("Jim");
        Enemy e = new Orc(db);
        GameGUI instance = new GameGUI();
        instance.battleEnd();
    }

    /**
     * Test of main method, of class GameGUI.
     */
    @Test
    public void testMain()
    {
        System.out.println("main");
        String[] args = null;
        GameGUI.main(args);
    }
    
}
