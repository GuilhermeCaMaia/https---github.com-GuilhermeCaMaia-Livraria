package br.edu.femass.gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoLeitor;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Leitor;
import br.edu.femass.model.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CadastrarLeitorController implements Initializable {
    @FXML
    private TextField TxtNome;

    @FXML
    private TextField TxtEndereco;

    @FXML
    private TextField TxtTelefone;

    @FXML
    private TextField TxtMatricula;

    @FXML
    private TextField TxtDisciplina;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnDeletar;

    @FXML
    private Button btnGravar;

    @FXML
    private Button btnIncerirAluno;

    @FXML
    private Button btnIncerirProfessor;

    @FXML
    private ListView<Leitor> ListLeitor;

    private Leitor leitor;
    private Aluno aluno;
    private Professor professor;
    private DaoLeitor daoLeitor = new DaoLeitor();
    private DaoAluno daoAluno = new DaoAluno();
    private DaoProfessor daoProfessor = new DaoProfessor();
    private Boolean incluindo;
    private Boolean cadastrarAluno;

    @FXML
    private void IncerirAluno_Click(ActionEvent event) {
        aluno = new Aluno();
        Editar(true);
        TxtMatricula.setDisable(false);
        incluindo = true;
        cadastrarAluno = true;

        TxtNome.setText("");
        TxtNome.requestFocus();
    }

    @FXML
    private void IncerirProfessor_Click(ActionEvent event) {
        professor = new Professor();
        Editar(true);
        TxtDisciplina.setDisable(false);
        incluindo = true;
        cadastrarAluno = false;

        TxtNome.setText("");
        TxtNome.requestFocus();
    }

    @FXML
    private void Gravar_Click(ActionEvent event) {

        if (cadastrarAluno == true) {
            System.out.println("Cadastrando aluno");
            aluno.setNome(TxtNome.getText());
            aluno.setEndereco(TxtEndereco.getText());
            aluno.setTelefone(TxtTelefone.getText());
            aluno.setMatricula(TxtMatricula.getText());
            aluno.setPrazoMaximoDevolucao(15);

            if (incluindo) {
                daoAluno.inserir(aluno);
            } else {
                daoAluno.alterar(aluno);
            }
        } else {
            System.out.println("Cadastrando professor");
            professor.setNome(TxtNome.getText());
            professor.setEndereco(TxtEndereco.getText());
            professor.setTelefone(TxtTelefone.getText());
            professor.setDisciplina(TxtDisciplina.getText());
            professor.setPrazoMaximoDevolucao(30);
            if (incluindo) {
                daoProfessor.inserir(professor);
            } else {
                daoProfessor.alterar(professor);
            }
        }
        Editar(false);
        TxtMatricula.setDisable(true);
        TxtDisciplina.setDisable(true);
        preencherLista();
    }

    @FXML
    private void Alterar_Click(ActionEvent event) {
        Editar(true);
        incluindo = false;
    }

    @FXML
    private void Deletar_Click(ActionEvent event) {
        leitor = new Leitor();
        daoLeitor.apagar(leitor);
        // daoAluno.alterar(aluno);
        // daoProfessor.apagar(professor);
        preencherLista();
    }

    private void Editar(Boolean habilitar) {
        ListLeitor.setDisable(habilitar);
        TxtNome.setDisable(!habilitar);
        TxtEndereco.setDisable(!habilitar);
        TxtTelefone.setDisable(!habilitar);
        btnGravar.setDisable(!habilitar);
    }

    private void preencherLista() {
        List<Aluno> Alunos = daoAluno.buscarTodos();
        List<Professor> professores = daoProfessor.buscarTodos();
        List<Leitor> Leitores = new ArrayList<>();
        Leitores.addAll(Alunos);
        Leitores.addAll(professores);

        ObservableList<Leitor> data = FXCollections.observableArrayList(Leitores);
        ListLeitor.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        preencherLista();
    }

}
