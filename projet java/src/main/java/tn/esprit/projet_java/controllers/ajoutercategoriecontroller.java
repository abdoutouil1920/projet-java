package tn.esprit.projet_java.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.projet_java.models.categorie;
import tn.esprit.projet_java.services.categorieService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ajoutercategoriecontroller implements Initializable {
    categorieService cate =new categorieService();
    @FXML
    private TextField tyoetxt;

    @FXML
    void ajouterbtn(ActionEvent event) throws Exception{
        cate.add(new categorie(tyoetxt.getText()));

returnbtn(event);
    }
    @FXML
    void returnbtn(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/viewadmin.fxml"));
        Parent signInRoot = loader.load();
        Scene signInScene = new Scene(signInRoot);


        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(signInScene);
        window.show();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
