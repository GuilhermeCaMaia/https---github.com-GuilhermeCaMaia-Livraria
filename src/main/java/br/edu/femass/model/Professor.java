package br.edu.femass.model;

import javax.persistence.Entity;

@Entity
public class Professor extends Leitor{
    private String disciplina;

    public Professor(String nome, String endereco, String telefone, Integer prazoMaximoDevolucao,
            String disciplina) {
        super(nome, endereco, telefone, prazoMaximoDevolucao);
        this.disciplina = disciplina;
    }

    public Professor() {

    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    
}
