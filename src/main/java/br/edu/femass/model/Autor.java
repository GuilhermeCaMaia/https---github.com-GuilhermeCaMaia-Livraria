package br.edu.femass.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Autor {

    @Id
    private String nome;
    private String sobreNome;
    private String nacionalidade;

    public Autor(String nome, String sobreNome, String nacionalidade) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.nacionalidade = nacionalidade;
    }

    public Autor() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.sobreNome;
    }
}
