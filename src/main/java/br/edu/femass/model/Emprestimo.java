package br.edu.femass.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Emprestimo {
    @Id
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;

    // @ManyToOne(cascade = CascadeType.ALL)
    // private Leitor leitor;
    // private Exemplar exemplar;

    public Emprestimo(LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, LocalDate dataDevolucao /* ,Leitor leitor,Exemplar exemplar*/) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataDevolucao = dataDevolucao;
        // this.leitor = leitor;
        // this.exemplar = exemplar;
    }
    public Emprestimo() {
    }
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }
    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    // public Leitor getLeitor() {
    //     return leitor;
    // }
    // public void setLeitor(Leitor leitor) {
    //     this.leitor = leitor;
    // }
    // public Exemplar getExemplar() {
    //     return exemplar;
    // }
    // public void setExemplar(Exemplar exemplar) {
    //     this.exemplar = exemplar;
    // }
    
}
