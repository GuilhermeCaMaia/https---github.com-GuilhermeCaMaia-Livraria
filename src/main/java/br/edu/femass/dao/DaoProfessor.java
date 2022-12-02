package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Professor;

public class DaoProfessor extends Dao<Professor>{
    public List<Professor> buscarTodos() {
        return em.createQuery("select c from Professor c order by c.Codigo").getResultList();
    }
}
