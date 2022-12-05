package br.edu.femass.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLeitor;
import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Leitor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class RealizarEmprestimoController implements Initializable{
    @FXML
    private ListView<Exemplar> ListExemplares;
    
    @FXML
    private ComboBox<Leitor> cmbLeitor;

    @FXML
    private ListView<Emprestimo> ListEmprestimos;

    Exemplar exemplar;
    DaoExemplar daoExemplar = new DaoExemplar();
    Leitor leitor;
    DaoLeitor daoLeitor = new DaoLeitor();
    
    @FXML
    private void RealizarEmprestimo_Click(ActionEvent event) {

    }
    
    private void preencherLista() {
        List<Exemplar> exemplares = daoExemplar.buscarTodos();

        ObservableList<Exemplar> date = FXCollections.observableArrayList(exemplares);
        ListExemplares.setItems(date);
    }

    private void preencherCombo() {
        List<Leitor> leitores = daoLeitor.buscarTodos();

        ObservableList<Leitor> data = FXCollections.observableArrayList(leitores);
        cmbLeitor.setItems(data);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        preencherCombo();
        preencherLista();
    }
    
}
