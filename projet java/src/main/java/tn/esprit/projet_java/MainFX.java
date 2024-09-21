package tn.esprit.projet_java;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MainFX extends Application  {
    public static void main(String[] args) {
        launch(args);
    }




    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/viewadmin.fxml"));
        try {
            Parent root;
            root = loader.load();
            Scene sc = new Scene(root);
            stage.setScene(sc);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
