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

public class detailcategoriecontroller implements Initializable {
    @FXML
    private TextField tyoetxt;
    @FXML
    private TextField idtxt;
    @FXML
    void returnbtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/affichagecategorie.fxml"));
        Parent signInRoot = loader.load();
        Scene signInScene = new Scene(signInRoot);


        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(signInScene);
        window.show();

    }

    @FXML
    void supprbtn(ActionEvent event) throws Exception {
        categorieService ca= new categorieService();
        categorie cat=new categorie(Integer.parseInt(idtxt.getText()),tyoetxt.getText());
        ca.delete(cat);
returnbtn(event);
    }

    @FXML
    void updatebtn(ActionEvent event)throws Exception {
        categorieService ca= new categorieService();
        categorie cat=new categorie(Integer.parseInt(idtxt.getText()),tyoetxt.getText());
        ca.update(cat);
        returnbtn(event);
    }
    public void setData(int id ,String type){
        tyoetxt.setText( type );
        idtxt.setText(String.valueOf(id));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
