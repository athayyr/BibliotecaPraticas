/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfaces;

import br.com.praticas.model.bean.Aluno;
import java.util.List;

/**
 *
 * @author José Higor
 */
public interface IAlunoDAO {
    boolean create(Aluno aluno) throws Exception;

    boolean delete(Aluno aluno) throws Exception;

    List<Aluno> list() throws Exception;

    Aluno search(int id) throws Exception;

    void update(Aluno aluno) throws Exception;
}
