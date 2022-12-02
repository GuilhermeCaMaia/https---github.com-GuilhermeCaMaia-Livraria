package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Aluno;

public class daoAluno extends Dao<Aluno>{
    public List<Aluno> buscarTodos() {
        return em.createQuery("select c from Aluno c order by c.Codigo").getResultList();
    }
}
