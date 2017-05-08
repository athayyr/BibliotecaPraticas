/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.model.dao;

import br.com.praticas.model.bean.Emprestimo;
import java.util.List;

/**
 *
 * @author VAAR
 */
public interface IEmprestimoDAO {

    boolean create(Emprestimo emprestimo);

    boolean delete(Emprestimo emprestimo);

    List<Emprestimo> list();

    Emprestimo search(int id);

    boolean update(Emprestimo emprestimo);
    
}
