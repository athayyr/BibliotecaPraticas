/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.interfaces;

import br.com.praticas.model.bean.Funcionario;
import java.util.List;

/**
 *
 * @author José Higor
 */
public interface IFuncionarioDao {
    boolean create(Funcionario funcionario) throws Exception;

    boolean delete(Funcionario funcionario) throws Exception;

    List<Funcionario> list() throws Exception;

    Funcionario search(int id) throws Exception;

    void update(Funcionario funcionario) throws Exception;
}
