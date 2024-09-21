package tn.esprit.projet_java.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import tn.esprit.projet_java.utils.SharedContext;


import java.net.URL;
import java.util.ResourceBundle;

public class viewadmincontroller implements Initializable {
    @FXML
    void catebtn(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/affichagecategorie.fxml"));
        Parent adminRoot = loader.load();
        tfBorder.setCenter(adminRoot);

    }

    @FXML
    private BorderPane tfBorder;
    @FXML
    void evenetbtn(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/affichageevenement.fxml"));
        Parent adminRoot = loader.load();
tfBorder.setCenter(adminRoot);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SharedContext.getInstance().setChangeCenterCallback(this::setContent);
    }
    public void setContent(Parent content) {
        tfBorder.setCenter(content);
    }
}
