package br.edu.femass.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {
    
    @FXML
    private void MenuBibliotecaria_Click(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/MenuBibliotecaria.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");

            Stage stage = new Stage();
            stage.setTitle("Menu Bibliotecaria");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void MenuAtendente_Click(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/MenuAtendente.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");

            Stage stage = new Stage();
            stage.setTitle("Menu Atendente");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
