/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfaces;

import br.com.praticas.model.bean.Emprestimo;
import java.util.List;

/**
 *
 * @author VAAR
 */
public interface IEmprestimoDAO {

    boolean create(Emprestimo emprestimo) throws Exception;

    boolean delete(Emprestimo emprestimo) throws Exception;

    List<Emprestimo> list() throws Exception;

    Emprestimo search(int id) throws Exception;

    boolean update(Emprestimo emprestimo) throws Exception;
    
}
