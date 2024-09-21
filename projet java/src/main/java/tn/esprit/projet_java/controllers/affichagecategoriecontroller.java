package tn.esprit.projet_java.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import tn.esprit.projet_java.models.categorie;
import tn.esprit.projet_java.services.categorieService;
import tn.esprit.projet_java.utils.SharedContext;


import java.util.logging.Level;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;


public class affichagecategoriecontroller implements Initializable {

    @FXML
    private TableView<categorie> catetable;

    @FXML
    private TableColumn<categorie, Integer> colid_cate;

    @FXML
    private TableColumn<categorie, String> coltype;

    public void showcate() throws SQLException {
        categorieService cate = new categorieService();
        List<categorie> list = cate.recupere();
        ObservableList<categorie> catelist = FXCollections.observableArrayList(list);
        colid_cate.setCellValueFactory(new PropertyValueFactory<>("id_cate"));
        coltype.setCellValueFactory(new PropertyValueFactory<>("type"));

catetable.setItems(catelist);
    }
    @FXML
    void ajoutbtn(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ajoutercategorie.fxml"));
        Parent adminRoot = loader.load();
        SharedContext.getInstance().changeCenterContent(adminRoot);

    }
   

    @FXML
    void returnbtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/viewadmin.fxml"));
        Parent signInRoot = loader.load();
        Scene signInScene = new Scene(signInRoot);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(signInScene);
        window.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        catetable.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("/detailcategorie.fxml"));

                try {
                    Loader.load();
                } catch (IOException ex) {
                    ex.printStackTrace();

                    Logger.getLogger(detailcategoriecontroller.class.getName()).log(Level.SEVERE, null, ex);
                }

                detailcategoriecontroller detail = Loader.getController();
                detail.setData(catetable.getSelectionModel().getSelectedItem().getId_cate(),""+catetable.getSelectionModel().getSelectedItem().getType());
                Parent p = Loader.getRoot();
                SharedContext.getInstance().changeCenterContent(p);
            }


        });
        try {
            showcate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
