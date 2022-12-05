package br.edu.femass.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import br.edu.femass.dao.Dao;
import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadastrarAutorController implements Initializable{
    
    @FXML
    private TextField TxtNome;
    @FXML
    private TextField TxtSobreNome;
    @FXML
    private TextField TxtNacionalidade;
    @FXML
    private ListView<Autor> ListAutor;
    @FXML
    private Button btnIncerir;
    @FXML
    private Button btnGravar;
    @FXML
    private Button btnDeletar;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnCadastrarLivros;

    private DaoAutor dao = new DaoAutor();

    private Autor autor;

    private Boolean incluindo;
    
    @FXML
    private void Gravar_Click(ActionEvent event) {
        autor.setNome(TxtNome.getText());
        autor.setSobreNome(TxtSobreNome.getText());
        autor.setNacionalidade(TxtNacionalidade.getText());

        if (incluindo) {
            dao.inserir(autor);
        } else {
            dao.alterar(autor);
        }
        preencherLista();
        Editar(false);
        System.out.println(autor.getNome());
    }
    
    @FXML
    private void Incerir_Click(ActionEvent event) {
        Editar(true);

        incluindo = true;

        autor = new Autor();
        TxtNome.setText("");
        TxtSobreNome.setText("");
        TxtNacionalidade.setText("");
        TxtNome.requestFocus();
    }
    
    @FXML
    private void Deletar_Click(ActionEvent event) {
        dao.apagar(autor);
        preencherLista();
    }
    
    @FXML
    private void Alterar_Click(ActionEvent event) {
        Editar(true);

        incluindo = false;
    }

    @FXML
    private void ListAutor_MouseClicked(MouseEvent event) {
        exibirDados();
    }

    @FXML
    private void ListAutor_KeyPressed(KeyEvent event) {
        exibirDados();
    }
    
    private void exibirDados() {
        this.autor = ListAutor.getSelectionModel().getSelectedItem();
        if (autor == null)
            return;
        
        TxtNome.setText(autor.getNome());
        TxtSobreNome.setText(autor.getSobreNome());
        TxtNacionalidade.setText(autor.getNacionalidade());
    }

    private void preencherLista() {
        List<Autor> autors = dao.buscarTodos();

        ObservableList<Autor> data = FXCollections.observableArrayList(autors);
        ListAutor.setItems(data);
    }

    private void Editar(boolean habilitar) {
        ListAutor.setDisable(habilitar);
        TxtNome.setDisable(!habilitar);
        TxtSobreNome.setDisable(!habilitar);
        TxtNacionalidade.setDisable(!habilitar);
        btnGravar.setDisable(!habilitar);
    }

    @FXML
    private void CadastrarLivros_Click(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/CadastrarLivro.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");

            Stage stage = new Stage();
            stage.setTitle("Cadastro de Livros");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        preencherLista();
    }
}
