/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsbperso;

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
public class OutilsTest {
    
    public OutilsTest() {
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
     * Test of md5 method, of class Outils.
     */
    @Test
    public void testMd5() throws Exception {
        System.out.println("md5");
        String mot = "";
        String expResult = Outils.md5(mot);
        String result = Outils.md5(mot);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of estUnEntier method, of class Outils.
     */
    @Test
    public void testEstUnEntier() {
        System.out.println("estUnEntier");
        String chaine = "";
        boolean expResult = false;
        boolean result = Outils.estUnEntier(chaine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
