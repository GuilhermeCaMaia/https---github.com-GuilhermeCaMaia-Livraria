package br.edu.femass.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CadastrarLivroController implements Initializable {
    @FXML
    private TextField TxtLivro;

    @FXML
    private TextField TxtCodigo;

    @FXML
    private ListView<Livro> ListLivro;

    @FXML
    private Button btnGravar;
    @FXML
    private Button btnDeletar;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnIncerir;

    // Incerir_Click
    // Gravar_Click
    // Deletar_Click
    // Alterar_Click
    
    private DaoLivro dao = new DaoLivro();
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

        if (incluindo) {
            dao.inserir(livro);
        } else {
            dao.alterar(livro);
        }

        Editar(false);
        preencherLista();
    }

    @FXML
    private void Deletar_Click(ActionEvent event) {
        dao.apagar(livro);
        preencherLista();
    }

    @FXML
    private void Alterar_Click(ActionEvent event) {
        Editar(true);

        incluindo = false;
    }
    
    private void Editar(boolean habilitar) {
        ListLivro.setDisable(habilitar);
        TxtLivro.setDisable(!habilitar);
        btnGravar.setDisable(!habilitar);
    }

    private void preencherLista() {
        List<Livro> livros = dao.buscarTodos();

        ObservableList<Livro> data = FXCollections.observableArrayList(livros);
        ListLivro.setItems(data);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }
    
    
}
