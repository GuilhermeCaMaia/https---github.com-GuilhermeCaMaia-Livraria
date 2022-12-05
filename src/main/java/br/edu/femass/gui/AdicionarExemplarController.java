package br.edu.femass.gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class AdicionarExemplarController implements Initializable {

    @FXML
    private ListView<Livro> ListLivro;
    @FXML
    private ListView<Exemplar> ListExemplar;

    @FXML
    private Button btnAdicionarExemplar;
    @FXML
    private Button btnDeletarExemplar;

    private DaoLivro daoLivro = new DaoLivro();
    private DaoExemplar daoExemplar = new DaoExemplar();
    private Livro livro;
    private Exemplar exemplar;

    @FXML
    private void AdicionarExemplar_Click(ActionEvent event) {
        exemplar = new Exemplar();
        exemplar.setLivro(ListLivro.getSelectionModel().getSelectedItem());
        exemplar.setDataAquisicao(LocalDate.now());
        daoExemplar.inserir(exemplar);
        preencherListaExemplar();
    }

    @FXML
    private void DeletarExemplar_Click(ActionEvent event) {
        daoExemplar.apagar(exemplar);
        preencherListaExemplar();
    }
    
    private void preencherListaLivro() {
        List<Livro> livros = daoLivro.buscarTodos();

        ObservableList<Livro> data = FXCollections.observableArrayList(livros);
        ListLivro.setItems(data);
    }

    private void preencherListaExemplar() {
        List<Exemplar> exemplares = daoExemplar.buscarTodos();

        ObservableList<Exemplar> data = FXCollections.observableArrayList(exemplares);
        ListExemplar.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        preencherListaLivro();
        preencherListaExemplar();
    }
    
}
