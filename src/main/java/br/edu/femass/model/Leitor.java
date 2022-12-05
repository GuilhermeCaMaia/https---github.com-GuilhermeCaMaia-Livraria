package br.edu.femass.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Leitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long codigo;
    protected String nome;
    protected String endereco;
    protected String telefone;
    protected Integer PrazoMaximoDevolucao;

    public Leitor(String nome, String endereco, String telefone, Integer prazoMaximoDevolucao) {
        
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        PrazoMaximoDevolucao = prazoMaximoDevolucao;
    }
    public Leitor() {
    }
    public Long getcodigo() {
        return codigo;
    }
    public void setcodigo(Long codigo) {
        codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Integer getPrazoMaximoDevolucao() {
        return PrazoMaximoDevolucao;
    }
    public void setPrazoMaximoDevolucao(Integer prazoMaximoDevolucao) {
        PrazoMaximoDevolucao = prazoMaximoDevolucao;
    }
    @Override
    public String toString() {
        return this.nome + " " + this.telefone;
    }
}
