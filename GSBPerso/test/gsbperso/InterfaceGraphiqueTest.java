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
public class InterfaceGraphiqueTest {
    
    public InterfaceGraphiqueTest() {
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
     * Test of connecte method, of class InterfaceGraphique.
     */
    @Test
    public void testConnecte() {
        System.out.println("connecte");
        String leNom = "Jacques";
        String laPosition = "0";
        InterfaceGraphique instance = new InterfaceGraphique();
        instance.connecte(leNom, laPosition);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of deconnecte method, of class InterfaceGraphique.
     */
    @Test
    public void testDeconnecte() {
        System.out.println("deconnecte");
        InterfaceGraphique instance = new InterfaceGraphique();
        instance.deconnecte();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of majConnexion method, of class InterfaceGraphique.
     */
    @Test
    public void testMajConnexion() {
        System.out.println("majConnexion");
        InterfaceGraphique instance = new InterfaceGraphique();
        instance.majConnexion();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class InterfaceGraphique.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        InterfaceGraphique.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
