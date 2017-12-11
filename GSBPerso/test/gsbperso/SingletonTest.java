/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsbperso;

import java.sql.Connection;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Loriane
 */
public class SingletonTest {
    
    public SingletonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class Singleton.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Connection expResult = Singleton.getInstance();
        Connection result = Singleton.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of requeteAction method, of class Singleton.
     */
    @Test
    public void testRequeteAction() {
        System.out.println("requeteAction");
        String req = "";
        Integer expResult = null;
        Integer result = Singleton.requeteAction(req);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of requeteSelection method, of class Singleton.
     */
    @Test
    public void testRequeteSelection() {
        System.out.println("requeteSelection");
        String req = "";
        ResultSet expResult = null;
        ResultSet result = Singleton.requeteSelection(req);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
