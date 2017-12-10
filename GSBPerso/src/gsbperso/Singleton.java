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
//CTRL + SHIFT + O pour générer les imports
public class Singleton {

    private static String url = "jdbc:mysql://localhost:3333/gsbperso";
    private static String user = "gsbperso";
    private static String passwd = "ppe3";
    private static Connection connect;
    private static volatile Singleton instance = null;

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

    public static Integer requeteAction(String req) {
        try {
            return Singleton.getInstance().createStatement().executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println("Requête selection impossible");
            Logger.getLogger(Singleton.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ResultSet requeteSelection(String req) {
        try {
            return Singleton.getInstance().createStatement().executeQuery(req);
        } catch (SQLException ex) {
            System.out.println("Requête actionuser impossible");
            Logger.getLogger(Singleton.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
