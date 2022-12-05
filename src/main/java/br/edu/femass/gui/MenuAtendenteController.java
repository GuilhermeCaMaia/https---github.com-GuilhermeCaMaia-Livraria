package br.edu.femass.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuAtendenteController {
    @FXML
    private void CadastrarLeitor_Click(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/CadastrarLeitor.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");

            Stage stage = new Stage();
            stage.setTitle("Cadastrar Leitor");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    private void DevolverEmpréstimo_Click(ActionEvent event) {

    }
    @FXML
    private void RealizarEmpréstomo_Click(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/RealizarEmprestimo.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");

            Stage stage = new Stage();
            stage.setTitle("Realizar Emprestimo");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
