package tn.esprit.projet_java.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.projet_java.models.categorie;
import tn.esprit.projet_java.models.evenement;
import tn.esprit.projet_java.services.EvenementService;
import tn.esprit.projet_java.services.categorieService;
import tn.esprit.projet_java.utils.MyDatabase;

import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;


public class ajoutevenementcontroller implements Initializable {
    Connection cnx= MyDatabase.getInstance().getCnx();
    @FXML
    private ComboBox<catecombo> cateid;
    EvenementService eve =new EvenementService();
    @FXML
    private DatePicker datetxt;

    @FXML
    private TextField nomtxt;

private categorieService cs= new categorieService();
    @FXML
    void ajoutereventbtn(ActionEvent event) throws Exception {
        Date date = Date.valueOf(datetxt.getValue());
        evenement newEvent = new evenement(nomtxt.getText(), date, cateid.getValue().getId());
        eve.add(newEvent);
        returnbtn(event);
    }

    @FXML
    void returnbtn(ActionEvent event) throws Exception {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/viewadmin.fxml"));
        Parent signInRoot = loader.load();
        Scene signInScene = new Scene(signInRoot);


        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(signInScene);
        window.show();
    }
    void fillcateComboBox()
    {

        List<categorie> list = cs.recupere();
        ObservableList<catecombo> list2 = FXCollections.observableArrayList();
        for (categorie c : list)
        {
            list2.add(new catecombo(c.getId_cate(),c.getType()));
        }
        cateid.setItems(list2);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillcateComboBox();
    }

    public static class catecombo {
        private final int id;
        private final String displayValue;

        public catecombo(int id, String displayValue) {
            this.id = id;
            this.displayValue = displayValue;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return displayValue;
        }
    }

}
