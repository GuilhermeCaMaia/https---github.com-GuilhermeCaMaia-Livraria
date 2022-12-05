package br.edu.femass.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Exemplar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class DevolverEmprestimoController implements Initializable {

    @FXML
    private ListView<Emprestimo> ListExemplares;

    Emprestimo emprestimo;
    DaoEmprestimo daoEmprestimo = new DaoEmprestimo();

    @FXML
    private void DevolverExemplar_Click(ActionEvent event) {
        daoEmprestimo.apagar(emprestimo);
        preencherLista();
    }
    
    private void preencherLista() {
        List<Emprestimo> emprestimos = daoEmprestimo.buscarTodos();

        ObservableList<Emprestimo> data = FXCollections.observableArrayList(emprestimos);
        ListExemplares.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        preencherLista();
    }
    
}
