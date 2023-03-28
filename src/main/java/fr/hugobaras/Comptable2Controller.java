package fr.hugobaras;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class Comptable2Controller {
    @FXML
    private Label etat1;

    @FXML
    private Label etat2;

    @FXML
    private Label etat3;

    @FXML
    private ComboBox<String> comb;

    @FXML
    private ComboBox<String> comb1;

    @FXML
    private Label date1;

    @FXML
    private Label date2;

    @FXML
    private Label date3;

    @FXML
    private Label libelle1;

    @FXML
    private Label libelle2;

    @FXML
    private Label libelle3;

    @FXML
    private Label montant1;

    @FXML
    private Label montant2;
    @FXML
    private Label nom_visiteur;

    @FXML
    private Label montant3;

    @FXML
    private Label qteNuitee;

    @FXML
    private Label qteRepas;

    @FXML
    private Label qteVehicule;

    @FXML
    private Label total_Repas;

    @FXML
    private Label total_km;

    @FXML
    private Label total_nuitee;

    @FXML
    private Label txt_mu_Repas;

    @FXML
    private Label txt_mu_km;

    @FXML
    private Label txt_mu_nuit;

    @FXML
    private Label txt_nom;

    public void initialize() {
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";
        {

            try {

                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                ResultSet resultat = instruction.executeQuery("SELECT * FROM fraisforfait WHERE id = 'NUI'");
                while (resultat.next()) {
                    int total_montant = resultat.getInt("ff_montant");
                    String total_montant2 = Integer.toString(total_montant);
                    txt_mu_nuit.setText(total_montant2);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        try {

            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement instruction = con.createStatement();
            ResultSet resultat = instruction.executeQuery("SELECT * FROM fraisforfait WHERE id = 'REP'");
            while (resultat.next()) {
                int total_montant = resultat.getInt("ff_montant");
                String total_montant2 = Integer.toString(total_montant);
                txt_mu_Repas.setText(total_montant2);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {

            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement instruction = con.createStatement();
            ResultSet resultat = instruction.executeQuery("SELECT * FROM fraisforfait WHERE id = 'KM'");
            while (resultat.next()) {
                int total_montant = resultat.getInt("ff_montant");
                String total_montant2 = Integer.toString(total_montant);
                txt_mu_km.setText(total_montant2);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {

            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement instruction = con.createStatement();
            ResultSet resultat = instruction.executeQuery("SELECT * FROM fraisforfait WHERE id = 'NUI'");
            while (resultat.next()) {
                int total_montant = resultat.getInt("ff_montant");
                String total_montant2 = Integer.toString(total_montant);
                txt_mu_nuit.setText(total_montant2);
                Common.mu_nuit = total_montant;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {

            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement instruction = con.createStatement();
            ResultSet resultat = instruction.executeQuery("SELECT * FROM fraisforfait WHERE id = 'REP'");
            while (resultat.next()) {
                int total_montant = resultat.getInt("ff_montant");
                String total_montant2 = Integer.toString(total_montant);
                txt_mu_Repas.setText(total_montant2);
                Common.mu_repas = total_montant;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {

            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement instruction = con.createStatement();
            ResultSet resultat = instruction.executeQuery("SELECT * FROM fraisforfait WHERE id = 'KM'");
            while (resultat.next()) {
                int total_montant = resultat.getInt("ff_montant");
                String total_montant2 = Integer.toString(total_montant);
                txt_mu_km.setText(total_montant2);
                Common.mu_km = total_montant;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement instruction = con.createStatement();
            // String requete = "SELECT date FROM fiche WHERE fk_nom = '" + Common.nom + "'
            // and fk_prenom = '" + Common.prenom + "'";
            String requete = "SELECT ag_MATRICULE FROM agents WHERE ta_fk = '1'";
            ResultSet resultat = instruction.executeQuery(requete);
            while (resultat.next()) {
                String recup_mat = resultat.getString("ag_MATRICULE");
                comb.getItems().add(recup_mat);

            }
            resultat.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        try {
            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement instruction = con.createStatement();
            ResultSet resultat = instruction.executeQuery(
                    "SELECT id_autresfrais, af_date, af_libellé, af_montant FROM autresfrais WHERE fk_fiche = '"
                            + Common.id_fiche
                            + "' ");
            if (resultat.next()) {
                Common.autresfrais1 = resultat.getInt("id_autresfrais");
                montant1.setText(resultat.getString("af_montant"));
                date1.setText(resultat.getString("af_date"));
                libelle1.setText(resultat.getString("af_libellé"));
            }
            if (resultat.next()) {
                Common.autresfrais2 = resultat.getInt("id_autresfrais");
                montant2.setText(resultat.getString("af_montant"));
                date2.setText(resultat.getString("af_date"));
                libelle2.setText(resultat.getString("af_libellé"));
            }
            if (resultat.next()) {
                Common.autresfrais3 = resultat.getInt("id_autresfrais");
                montant3.setText(resultat.getString("af_montant"));
                date3.setText(resultat.getString("af_date"));
                libelle3.setText(resultat.getString("af_libellé"));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // txt_nom.setText(Common.nom + " " + Common.prenom);

    @FXML
    void combobox(ActionEvent event) {
        String mat_visiteur = comb.getSelectionModel().getSelectedItem();
        Common.mat_visiteur = mat_visiteur;
        System.out.println(mat_visiteur);

        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";
        {
            try {
                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                ResultSet resultat = instruction.executeQuery(
                        "SELECT ag_nom, ag_prenom FROM agents WHERE ag_matricule = '" + mat_visiteur + "'");
                while (resultat.next()) {
                    String nom = resultat.getString("ag_nom");
                    String prenom = resultat.getString("ag_prenom");
                    String nom_prenom = nom + " " + prenom;
                    nom_visiteur.setText(nom_prenom);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                String requete = "SELECT date FROM fiche  WHERE fk_matricule = '" + mat_visiteur + "' ";
                ResultSet resultat = instruction.executeQuery(requete);
                comb1.getItems().clear();
                while (resultat.next()) {
                    String recupdate = resultat.getString("date");
                    comb1.getItems().add(recupdate);
                    System.out.println(recupdate);
                }
                resultat.close();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }

    @FXML
    void combobox1(ActionEvent event) {
        String valeur = comb1.getSelectionModel().getSelectedItem();

        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";
        {
            try {
                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                ResultSet resultat = instruction.executeQuery(
                        "SELECT id_fiche, qu_nuitee, qu_repas, qu_km FROM fiche WHERE date = '" + valeur
                                + "' and fk_matricule = '" + Common.mat_visiteur + "'");
                while (resultat.next()) {
                    int id_fiche = resultat.getInt("id_fiche");
                    Common.id_fiche = id_fiche;
                    String qu_nuitee = resultat.getString("qu_nuitee");
                    String qu_repas = resultat.getString("qu_repas");
                    String qu_km = resultat.getString("qu_km");
                    qteNuitee.setText(qu_nuitee);
                    qteRepas.setText(qu_repas);
                    qteVehicule.setText(qu_km);
                    int qu_nuitee2 = Integer.parseInt(qu_nuitee);
                    int qu_repas2 = Integer.parseInt(qu_repas);
                    int qu_km2 = Integer.parseInt(qu_km);
                    qu_nuitee2 = qu_nuitee2 * Common.mu_nuit;
                    qu_repas2 = qu_repas2 * Common.mu_repas;
                    qu_km2 = qu_km2 * Common.mu_km;
                    String qu_nuitee3 = Integer.toString(qu_nuitee2);
                    String qu_repas3 = Integer.toString(qu_repas2);
                    String qu_km3 = Integer.toString(qu_km2);
                    total_nuitee.setText(qu_nuitee3);
                    total_Repas.setText(qu_repas3);
                    total_km.setText(qu_km3);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                ResultSet resultat = instruction.executeQuery(
                        "SELECT id_autresfrais, af_date, af_libellé, af_montant, fk_eaf FROM autresfrais WHERE fk_fiche = '"
                                + Common.id_fiche
                                + "' and date_ajout = '" + valeur + "' ");
                montant1.setText("");
                montant2.setText("");
                montant3.setText("");
                date1.setText("");
                date2.setText("");
                date3.setText("");
                libelle1.setText("");
                libelle2.setText("");
                libelle3.setText("");
                etat1.setText(" ");
                etat2.setText(" ");
                etat3.setText(" ");
                if (resultat.next()) {
                    Common.autresfrais1 = resultat.getInt("id_autresfrais");
                    int etat = resultat.getInt("fk_eaf");
                    montant1.setText(resultat.getString("af_montant"));
                    date1.setText(resultat.getString("af_date"));
                    libelle1.setText(resultat.getString("af_libellé"));
                    if (etat == 1) {
                        etat1.setText("Validé");
                    }
                    if (etat == 2) {
                        etat1.setText("Refusé");
                    }
                    if (etat == 0) {
                        etat1.setText("En attente");
                    }
                }
                if (resultat.next()) {
                    Common.autresfrais2 = resultat.getInt("id_autresfrais");
                    int etat = resultat.getInt("fk_eaf");
                    montant2.setText(resultat.getString("af_montant"));
                    date2.setText(resultat.getString("af_date"));
                    libelle2.setText(resultat.getString("af_libellé"));
                    if (etat == 1) {
                        etat2.setText("Validé");
                    }
                    if (etat == 2) {
                        etat2.setText("Refusé");
                    }
                    if (etat == 0) {
                        etat2.setText("En attente");
                    }
                }
                if (resultat.next()) {
                    Common.autresfrais3 = resultat.getInt("id_autresfrais");
                    int etat = resultat.getInt("fk_eaf");
                    montant3.setText(resultat.getString("af_montant"));
                    date3.setText(resultat.getString("af_date"));
                    libelle3.setText(resultat.getString("af_libellé"));
                    if (etat == 1) {
                        etat3.setText("Validé");
                    }
                    if (etat == 2) {
                        etat3.setText("Refusé");
                    }
                    if (etat == 0) {
                        etat3.setText("En attente");
                    }

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    @FXML
    void deconnect(ActionEvent event) throws IOException {
        App.setRoot("authentification");
    }

    @FXML
    void verifier(ActionEvent event) throws IOException {
        App.setRoot("comptable");
    }

    @FXML
    void valider(ActionEvent event) {

    }

}
