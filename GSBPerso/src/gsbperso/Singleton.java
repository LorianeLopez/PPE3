/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsbperso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Loriane
 */

public class Singleton {

    private static String url = "jdbc:mysql://localhost:3333/gsbperso";
    private static String user = "gsbperso";
    private static String passwd = "ppe3";
    private static Connection connect;
    private static volatile Singleton instance = null;

    /**
     * Permet d'obtenir la chaine de connexion entière
     * @return 
     */
    public static Connection getInstance() {
        synchronized (Singleton.class) {
            if (connect == null) {
                try {
                    connect = DriverManager.getConnection(url, user, passwd);
                } catch (SQLException e) {
                    System.out.println("Erreur lors de la connexion ");
                    Singleton.connect = null;
                }
            }
        }
        return connect;
    }

    /**
     * Permet d'effectuer une requête d'action de type insert into, ou update
     * @param req
     * @return 
     */
    public static Integer requeteAction(String req) {
        try {
            return Singleton.getInstance().createStatement().executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println("Requête selection impossible");
            Logger.getLogger(Singleton.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Permet d'effectuer une requête de selection de type Select
     * @param req
     * @return 
     */
    public static ResultSet requeteSelection(String req) {
        try {
            return Singleton.getInstance().createStatement().executeQuery(req);
        } catch (SQLException ex) {
            System.out.println("Requête action impossible");
            Logger.getLogger(Singleton.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
