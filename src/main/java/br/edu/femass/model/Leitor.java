package br.edu.femass.model;

public class Leitor {
    private Long Codigo;
    private String nome;
    private String endereco;
    private String telefone;
    private Integer PrazoMaximoDevolucao;
    public Leitor(Long codigo, String nome, String endereco, String telefone, Integer prazoMaximoDevolucao) {
        Codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        PrazoMaximoDevolucao = prazoMaximoDevolucao;
    }
    public Leitor() {
    }
    public Long getCodigo() {
        return Codigo;
    }
    public void setCodigo(Long codigo) {
        Codigo = codigo;
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
    
}
