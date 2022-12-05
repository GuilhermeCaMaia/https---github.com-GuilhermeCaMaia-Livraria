package br.edu.femass.model;

import javax.persistence.Entity;


@Entity
public class Aluno extends Leitor {
    private String matricula;

    public Aluno(String nome, String endereco, String telefone, Integer prazoMaximoDevolucao,
            String matricula) {
        super(nome, endereco, telefone, prazoMaximoDevolucao);
        this.matricula = matricula;
    }

    public Aluno() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
