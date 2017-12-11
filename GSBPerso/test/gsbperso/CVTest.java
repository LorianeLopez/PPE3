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
public class CVTest {
    
    public CVTest() {
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
     * Test of main method, of class CV.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        CV.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createPdf method, of class CV.
     */
    @Test
    public void testCreatePdf() throws Exception {
        System.out.println("createPdf");
        String dest = "results/chapter01/cv.pdf";
        Personne laPersonne = new Personne();
        laPersonne.setId(1);
        laPersonne.setNom("Delettre");
        laPersonne.setPrenom("Aymerich");
        laPersonne.setPermis(0);
        CV instance = new CV();
        instance.createPdf(dest, laPersonne);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
