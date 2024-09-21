package tn.esprit.projet_java.controllers;

import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tn.esprit.projet_java.models.evenement;
import tn.esprit.projet_java.services.EvenementService;
import tn.esprit.projet_java.utils.SharedContext;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class affichageevenementcontroller implements Initializable {
    @FXML
    private TableView<evenement> eventable;
    @FXML
    private TableColumn<evenement, String> colcat;

    @FXML
    private TableColumn<evenement, Date> coldate;

    @FXML
    private TableColumn<evenement, Integer> colid;

    @FXML
    private TableColumn<evenement, String> colnom;



    @FXML
    void btnajouteeve(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ajoutevenement.fxml"));
        Parent signInRoot = loader.load();
        SharedContext.getInstance().changeCenterContent(signInRoot);
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

    public void showevent() throws SQLException {
        EvenementService eve = new EvenementService();
        List<evenement> list = eve.recupere();
        ObservableList<evenement> evelist = FXCollections.observableArrayList(list);
        colid.setCellValueFactory(new PropertyValueFactory<>("id_event"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colcat.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCate().getType()));
        eventable.setItems(evelist);

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        eventable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("/detailevenement.fxml"));
                try {
                    Loader.load();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(detailcategoriecontroller.class.getName()).log(Level.SEVERE, null, ex);
                }
                detailevenementcontroller d = Loader.getController();
                d.setData(eventable.getSelectionModel().getSelectedItem().getId_event(), "" + eventable.getSelectionModel().getSelectedItem().getNom(), eventable.getSelectionModel().getSelectedItem().getDate(), eventable.getSelectionModel().getSelectedItem().getcategorie());
                Parent p = Loader.getRoot();
                SharedContext.getInstance().changeCenterContent(p);
            }
        });
        try {
            showevent();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
