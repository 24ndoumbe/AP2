package fr.hugobaras;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Common {
    public static String nom;
    public static String prenom;
    public static int matricule;
    public static String mat_visiteur;

    public static String nuit;
    public static String repas;
    public static String km;

    public static int autresfrais1;
    public static int autresfrais2;
    public static int autresfrais3;
    public static int mu_nuit;
    public static int mu_repas;
    public static int mu_km;
    public static int id_fiche;
    public static int etat_af1;
    public static int etat_af2;
    public static int etat_af3;
    public static int etatfiche;
    public static int etat;

    public static String date;
    public static String valeur;
    public static String valeur1;
    public static String recupdate;

    public static void connexion_Bdd(String select, String from) {
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";

        try {
            Connection con = getConnexion(dbURL, username, password);
            Statement instruction = con.createStatement();
            ResultSet resultat = instruction
                    .executeQuery("SELECT " + select + " FROM " + from + "");
            while (resultat.next()) {

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static Connection getConnexion(String dbURL, String username, String password) throws SQLException {
        return DriverManager.getConnection(dbURL, username, password);
    }

    public static void connexion_Bdd_Where(String select, String from, String ID, String valeur) {
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";

        try {
            Connection con = getConnexion(dbURL, username, password);
            Statement instruction = con.createStatement();
            ResultSet resultat = instruction
                    .executeQuery("SELECT " + select + " FROM " + from + " WHERE " + ID + " = '" + valeur + "' ");
            while (resultat.next()) {

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
