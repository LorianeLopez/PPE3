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
public class PersonneTest {
    
    public PersonneTest() {
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
     * Test of getPermis method, of class Personne.
     */
    @Test
    public void testGetPermis() {
        System.out.println("getPermis");
        Personne instance = new Personne();
        Integer expResult = instance.getPermis();
        Integer result = instance.getPermis();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setPermis method, of class Personne.
     */
    @Test
    public void testSetPermis() {
        System.out.println("setPermis");
        Integer permis = null;
        Personne instance = new Personne();
        instance.setPermis(permis);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of getNom method, of class Personne.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Personne instance = new Personne();
        String expResult = instance.getNom();
        String result = instance.getNom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of setNom method, of class Personne.
     */
    @Test
    public void testSetNom() {
        System.out.println("setNom");
        String nom = "";
        Personne instance = new Personne();
        instance.setNom(nom);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of getPrenom method, of class Personne.
     */
    @Test
    public void testGetPrenom() {
        System.out.println("getPrenom");
        Personne instance = new Personne();
        String expResult = instance.getPrenom();
        String result = instance.getPrenom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setPrenom method, of class Personne.
     */
    @Test
    public void testSetPrenom() {
        System.out.println("setPrenom");
        String prenom = "";
        Personne instance = new Personne();
        instance.setPrenom(prenom);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getId method, of class Personne.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Personne instance = new Personne();
        Integer expResult = instance.getId();
        Integer result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setId method, of class Personne.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Personne instance = new Personne();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getAdresse_rue method, of class Personne.
     */
    @Test
    public void testGetAdresse_rue() {
        System.out.println("getAdresse_rue");
        Personne instance = new Personne();
        String expResult = instance.getAdresse_rue();
        String result = instance.getAdresse_rue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setAdresse_rue method, of class Personne.
     */
    @Test
    public void testSetAdresse_rue() {
        System.out.println("setAdresse_rue");
        String adresse_rue = "";
        Personne instance = new Personne();
        instance.setAdresse_rue(adresse_rue);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getAdresse_CP method, of class Personne.
     */
    @Test
    public void testGetAdresse_CP() {
        System.out.println("getAdresse_CP");
        Personne instance = new Personne();
        String expResult = instance.getAdresse_CP();
        String result = instance.getAdresse_CP();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setAdresse_CP method, of class Personne.
     */
    @Test
    public void testSetAdresse_CP() {
        System.out.println("setAdresse_CP");
        String adresse_CP = "";
        Personne instance = new Personne();
        instance.setAdresse_CP(adresse_CP);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getAdresse_ville method, of class Personne.
     */
    @Test
    public void testGetAdresse_ville() {
        System.out.println("getAdresse_ville");
        Personne instance = new Personne();
        String expResult = instance.getAdresse_ville();
        String result = instance.getAdresse_ville();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setAdresse_ville method, of class Personne.
     */
    @Test
    public void testSetAdresse_ville() {
        System.out.println("setAdresse_ville");
        String adresse_ville = "";
        Personne instance = new Personne();
        instance.setAdresse_ville(adresse_ville);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getSalaire method, of class Personne.
     */
    @Test
    public void testGetSalaire() {
        System.out.println("getSalaire");
        Personne instance = new Personne();
        Float expResult = instance.getSalaire();
        Float result = instance.getSalaire();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setSalaire method, of class Personne.
     */
    @Test
    public void testSetSalaire() {
        System.out.println("setSalaire");
        Float salaire = null;
        Personne instance = new Personne();
        instance.setSalaire(salaire);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getTelPerso method, of class Personne.
     */
    @Test
    public void testGetTelPerso() {
        System.out.println("getTelPerso");
        Personne instance = new Personne();
        String expResult = instance.getTelPerso();
        String result = instance.getTelPerso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setTelPerso method, of class Personne.
     */
    @Test
    public void testSetTelPerso() {
        System.out.println("setTelPerso");
        String telPerso = "";
        Personne instance = new Personne();
        instance.setTelPerso(telPerso);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getTelPro method, of class Personne.
     */
    @Test
    public void testGetTelPro() {
        System.out.println("getTelPro");
        Personne instance = new Personne();
        String expResult = instance.getTelPro();
        String result = instance.getTelPro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setTelPro method, of class Personne.
     */
    @Test
    public void testSetTelPro() {
        System.out.println("setTelPro");
        String telPro = "";
        Personne instance = new Personne();
        instance.setTelPro(telPro);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getSite method, of class Personne.
     */
    @Test
    public void testGetSite() {
        System.out.println("getSite");
        Personne instance = new Personne();
        String expResult = instance.getSite();
        String result = instance.getSite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setSite method, of class Personne.
     */
    @Test
    public void testSetSite() {
        System.out.println("setSite");
        String site = "";
        Personne instance = new Personne();
        instance.setSite(site);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getPosition method, of class Personne.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Personne instance = new Personne();
        String expResult = instance.getPosition();
        String result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setPosition method, of class Personne.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        String position = "";
        Personne instance = new Personne();
        instance.setPosition(position);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCadre method, of class Personne.
     */
    @Test
    public void testGetCadre() {
        System.out.println("getCadre");
        Personne instance = new Personne();
        Integer expResult = instance.getCadre();
        Integer result = instance.getCadre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setCadre method, of class Personne.
     */
    @Test
    public void testSetCadre() {
        System.out.println("setCadre");
        Integer cadre = null;
        Personne instance = new Personne();
        instance.setCadre(cadre);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
