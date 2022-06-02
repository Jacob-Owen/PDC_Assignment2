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
public class LoadTest
{
    
    public LoadTest()
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
     * Test of loadGame method, of class Load.
     */
    @Test
    public void testLoadGameFail() throws Exception
    {
        System.out.println("loadGame");
        String name = "";
        Player p = new Player("");;
        Database db = new Database();
        Load instance = new Load();
        boolean expResult = false;
        boolean result = instance.loadGame(name, p, db);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testLoadGameSuccess() throws Exception
    {
        System.out.println("loadGame");
        String name = "TestSave";
        Player p = new Player("");;
        Database db = new Database();
        db.createTestSave();
        Load instance = new Load();
        boolean expResult = true;
        boolean result = instance.loadGame(name, p, db);
        assertEquals(expResult, result);
        
    }
    
}
