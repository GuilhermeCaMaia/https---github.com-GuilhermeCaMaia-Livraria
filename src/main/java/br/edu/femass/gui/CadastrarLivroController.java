package br.edu.femass.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadastrarLivroController implements Initializable {
    @FXML
    private Button btnIncerir;
    @FXML
    private ComboBox<Autor> cnbAutores;

    @FXML
    private TextField TxtLivro;

    @FXML
    private TextField TxtCodigo;

    @FXML
    private Button btnGravar;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnDeletar;
    @FXML
    private ListView<Livro> ListLivros;

    private DaoLivro daolivro = new DaoLivro();
    private DaoAutor daoautor = new DaoAutor();
    private Livro livro;
    private Boolean incluindo;

    @FXML
    private void Incerir_Click(ActionEvent event) {
        Editar(true);

        incluindo = true;

        livro = new Livro();
        TxtLivro.setText("");
        TxtLivro.requestFocus();
    }

    @FXML
    private void Gravar_Click(ActionEvent event) {
        livro.setTitulo(TxtLivro.getText());
        livro.setAutor(cnbAutores.getSelectionModel().getSelectedItem());

        if (incluindo) {
            daolivro.inserir(livro);
        } else {
            daolivro.alterar(livro);
        }
        preencherLista();
        Editar(false);
    }

    @FXML
    private void Alterar_Click(ActionEvent event) {
        Editar(true);
        incluindo = false;
    }

    @FXML
    private void Deletar_Click(ActionEvent event) {
        
        daolivro.apagar(livro);
        preencherLista();
    }

    @FXML
    private void ListLivros_mouseClicked(MouseEvent event) {
        exibirDados();
    }

    @FXML
    private void ListLivros_KeyPressed(KeyEvent event) {
        exibirDados();
    }

    private void Editar(boolean habilitar) {
        ListLivros.setDisable(habilitar);
        TxtLivro.setDisable(!habilitar);
        btnGravar.setDisable(!habilitar);
    }

    private void preencherLista() {
        List<Livro> Livros = daolivro.buscarTodos();

        ObservableList<Livro> data = FXCollections.observableArrayList(Livros);
        ListLivros.setItems(data);
    }

    private void preencherCombo() {
        List<Autor> autores = daoautor.buscarTodos();

        ObservableList<Autor> data = FXCollections.observableArrayList(autores);
        cnbAutores.setItems(data);
    }

    private void exibirDados() {
        this.livro = ListLivros.getSelectionModel().getSelectedItem();
        if (livro == null)
            return;

        TxtLivro.setText(livro.getTitulo());
        TxtCodigo.setText(livro.getCodigo().toString());
    }
    
    @FXML
    private void CadastrarExemplar_Click(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/AdicionarExemplar.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");

            Stage stage = new Stage();
            stage.setTitle("Adicionar Exemplar");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        preencherLista();
        preencherCombo();
    }
}
