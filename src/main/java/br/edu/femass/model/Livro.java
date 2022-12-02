package br.edu.femass.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Id
    private String titulo;


    public Livro(long codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public Livro() {

    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    @Override
    public String toString() {
        return this.titulo + this.codigo;
    }
}
