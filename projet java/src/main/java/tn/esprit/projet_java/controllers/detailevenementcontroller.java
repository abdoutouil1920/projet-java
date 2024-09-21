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

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class detailevenementcontroller implements Initializable {
    @FXML
    private ComboBox<ajoutevenementcontroller.catecombo> cateid;

    @FXML
    private DatePicker datetxt;

    @FXML
    private TextField idcal;

    @FXML
    private TextField nomtxt;

    @FXML
    void returnbtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/affichageevenement.fxml"));
        Parent signInRoot = loader.load();
        Scene signInScene = new Scene(signInRoot);


        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(signInScene);
        window.show();
    }
    @FXML
    void updatebtn(ActionEvent event) throws Exception {
        EvenementService ev= new EvenementService();
        Date date = Date.valueOf(datetxt.getValue());
        evenement evt=new evenement(Integer.parseInt(idcal.getText()),nomtxt.getText(),date,cateid.getValue().getId());
        ev.update(evt);

        returnbtn(event);

    }
    @FXML
    void suppbtn(ActionEvent event) throws Exception {
        EvenementService ca= new EvenementService();
        Date date = Date.valueOf(datetxt.getValue());
        evenement cat=new evenement(Integer.parseInt(idcal.getText()),nomtxt.getText(),date, cateid.getValue().getId());
        ca.delete(cat);

            returnbtn(event);


    }


    public void setData(int id , String nom, Date date,int catid) {

        idcal.setText(String.valueOf(id));
        nomtxt.setText(nom);
        datetxt.setValue(date.toLocalDate());
        cateid.setVisibleRowCount(catid);



    }
    private categorieService cs= new categorieService();
    void fillcateComboBox()
    {

        List<categorie> list = cs.recupere();
        ObservableList<ajoutevenementcontroller.catecombo> list2 = FXCollections.observableArrayList();
        for (categorie c : list)
        {
            list2.add(new ajoutevenementcontroller.catecombo(c.getId_cate(),c.getType()));
        }
        cateid.setItems(list2);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillcateComboBox();
    }
}
