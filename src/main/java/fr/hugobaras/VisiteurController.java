package fr.hugobaras;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class VisiteurController {
    @FXML
    private TextField date_visiteur1;

    @FXML
    private TextField date_visiteur2;

    @FXML
    private TextField date_visiteur3;

    @FXML
    private TextField libelle_visiteur1;

    @FXML
    private TextField libelle_visiteur2;

    @FXML
    private TextField libelle_visiteur3;

    @FXML
    private TextField montant_visiteur1;

    @FXML
    private TextField montant_visiteur2;

    @FXML
    private TextField montant_visiteur3;

    @FXML
    private Label total_Repas;

    @FXML
    private Label total_km;

    @FXML
    private Label total_nuitee;

    @FXML
    private TextField txt_Qu_Nuitee;

    @FXML
    private TextField txt_Repas;

    @FXML
    private TextField txt_km;

    @FXML
    private Label txt_mu_Repas;

    @FXML
    private Label txt_mu_km;

    @FXML
    private Label txt_mu_nuit;

    @FXML
    private Label txt_nom;

    @FXML
    void deconnect(ActionEvent event) throws IOException {
        App.setRoot("authentification");
    }

    @FXML
    void consulter(ActionEvent event) throws IOException {
        App.setRoot("visiteur _consult");
    }

    public void initialize() {
        
        String date = new SimpleDateFormat("yyyy/MM").format(Calendar.getInstance().getTime());
        String date_jour = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
        int date_jour_int = Integer.parseInt(date_jour);
        if (date_jour_int >= 10) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Vous ne pouvez plus modifier votre saisie");
            alert.showAndWait();
            System.out.println("La saisie est cloturée");
            txt_Qu_Nuitee.setEditable(false);
            txt_Repas.setEditable(false);
            txt_km.setEditable(false);
            Common.etatfiche = 1;

        } else {
            txt_Qu_Nuitee.setEditable(true);
            txt_Repas.setEditable(true);
            txt_km.setEditable(true);
            Common.etatfiche = 0;

        }
        if (date_jour_int == 9) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Saisie bientôt cloturée");
            alert.setContentText("Dernier jour pour modifier votre saisie");
            alert.showAndWait();
        }
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";
        {
            try {

                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                ResultSet resultat = instruction
                        .executeQuery("SELECT date ,fk_matricule FROM fiche WHERE fk_matricule = '" + Common.matricule
                                + "' and date = '" + date + "'");
                while (resultat.next()) {
                    String recupdate = resultat.getString("date");
                    Common.date = recupdate;

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (!date.equals(Common.date)) {
                try {
                    Connection con = DriverManager.getConnection(dbURL, username, password);
                    Statement instruction = con.createStatement();
                    String st = "INSERT INTO fiche (fk_matricule, qu_nuitee, qu_repas, qu_km, date) VALUES ('"
                            + Common.matricule + "' , '0' , '0' , '0' , '" + date + "')";
                    instruction.executeUpdate(st);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("la fiche existe déjà");
            }
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
        try

        {

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
            ResultSet resultat = instruction.executeQuery("SELECT id_fiche, fk_etat FROM fiche WHERE fk_matricule = '"
                    + Common.matricule + "' and date = '" + date + "'");
            while (resultat.next()) {
                int id_fiche = resultat.getInt("id_fiche");
                int etat = resultat.getInt("fk_etat");
                Common.id_fiche = id_fiche;
                Common.etat = etat;
                System.out.println(id_fiche);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        txt_nom.setText(Common.nom + " " + Common.prenom);
        if (Common.etat < 2) {
            try {

                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                instruction.executeUpdate("UPDATE fiche SET fk_etat = '" + Common.etatfiche + "' where id_fiche = '"
                        + Common.id_fiche + "'");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    void txt_Qu_Nuitee(KeyEvent event) {
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
                    String montant_nuitee = txt_Qu_Nuitee.getText();
                    Common.nuit = montant_nuitee;
                    int montant_nuitee2 = Integer.parseInt(montant_nuitee);
                    montant_nuitee2 = montant_nuitee2 * total_montant;
                    String montant_nuitee3 = Integer.toString(montant_nuitee2);
                    total_nuitee.setText(montant_nuitee3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    void txt_Repas(KeyEvent event) {
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";
        {
            try {

                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                ResultSet resultat = instruction.executeQuery("SELECT * FROM fraisforfait WHERE id = 'REP'");
                while (resultat.next()) {
                    int total_montant = resultat.getInt("ff_montant");
                    String montant_repas = txt_Repas.getText();
                    Common.repas = montant_repas;
                    int montant_repas2 = Integer.parseInt(montant_repas);
                    montant_repas2 = montant_repas2 * total_montant;
                    String montant_repas3 = Integer.toString(montant_repas2);
                    total_Repas.setText(montant_repas3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    void txt_KM(KeyEvent event) {
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";
        {
            try {

                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                ResultSet resultat = instruction.executeQuery("SELECT * FROM fraisforfait WHERE id = 'KM'");
                while (resultat.next()) {
                    int total_montant = resultat.getInt("ff_montant");
                    String montant_km = txt_km.getText();
                    Common.km = montant_km;
                    int montant_km2 = Integer.parseInt(montant_km);
                    montant_km2 = montant_km2 * total_montant;
                    String montant_km3 = Integer.toString(montant_km2);
                    total_km.setText(montant_km3);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    void soumettre(ActionEvent event) {
        String date1 = date_visiteur1.getText();
        String date2 = date_visiteur2.getText();
        String date3 = date_visiteur3.getText();
        String date = new SimpleDateFormat("yyyy/MM").format(Calendar.getInstance().getTime());
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Votre fiche a été envoyée");
            alert.showAndWait();
            if (!Common.nuit.equals(null)) {
                try {
                    Connection con = DriverManager.getConnection(dbURL, username, password);
                    Statement instruction = con.createStatement();
                    // String requete = "SELECT date FROM fiche WHERE fk_nom = '" + Common.nom + "'
                    // and fk_prenom = '" + Common.prenom + "'";
                    String requete = "SELECT date FROM fiche  WHERE fk_matricule = '" + Common.matricule + "' ";
                    ResultSet resultat = instruction.executeQuery(requete);
                    while (resultat.next()) {
                        String recupdate = resultat.getString("date");
                        Common.recupdate = recupdate;
                    }
                    resultat.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    Connection con = DriverManager.getConnection(dbURL, username, password);
                    Statement instruction = con.createStatement();
                    String st = "UPDATE fiche SET qu_nuitee = '" + Common.nuit
                            + "', qu_repas = '" + Common.repas
                            + "', qu_km = '" + Common.km
                            + "', fk_etat = 1 WHERE fk_matricule = '" + Common.matricule
                            + "'and date = '" + date + "'";
                    // System.out.println(st);
                    instruction.executeUpdate(st);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
            if (!date1.equals(null)) {
                try {
                    Connection con = DriverManager.getConnection(dbURL, username, password);
                    Statement instruction = con.createStatement();
                    String st = "INSERT INTO autresfrais (fk_fiche, af_date, af_libellé, af_montant, date_ajout, fk_eaf) VALUES ('"
                            +
                            Common.id_fiche + "','" +
                            date1 + "','" +
                            libelle_visiteur1.getText() + "','" +
                            montant_visiteur1.getText() + "','" +
                            date + "','" +
                            0 + "')";
                    instruction.executeUpdate(st);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (!date2.equals(null)) {
                try {
                    Connection con = DriverManager.getConnection(dbURL, username, password);
                    Statement instruction = con.createStatement();
                    String st = "INSERT INTO autresfrais (fk_fiche, af_date, af_libellé, af_montant, date_ajout, fk_eaf) VALUES ('"
                            +
                            Common.id_fiche + "','" +
                            date2 + "','" +
                            libelle_visiteur2.getText() + "','" +
                            montant_visiteur2.getText() + "','" +
                            date + "','" +
                            0 + "')";
                    instruction.executeUpdate(st);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (!date3.equals(null)) {
                try {
                    Connection con = DriverManager.getConnection(dbURL, username, password);
                    Statement instruction = con.createStatement();
                    String st = "INSERT INTO autresfrais (fk_fiche, af_date, af_libellé, af_montant, date_ajout, fk_eaf) VALUES ('"
                            +
                            Common.id_fiche + "','" +
                            date3 + "','" +
                            libelle_visiteur3.getText() + "','" +
                            montant_visiteur3.getText() + "','" +
                            date + "','" +
                            0 + "')";
                    instruction.executeUpdate(st);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
