/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.praticas.model.dao;

import br.com.praticas.connection.ConnectionFactory;
import br.com.praticas.model.bean.Pessoa;
import br.com.praticas.util.Util;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author VAAR
 */
public class PessoaDAO {

    private Connection connection;
    
    public boolean create(Pessoa pessoa) {
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("INSERT INTO pessoa (nome,nascimento,endereco) VALUES(?,?,?)");
            st.setString(1, pessoa.getNome());
            st.setDate(2, new java.sql.Date(pessoa.getDataNascimento().getTime()));
            st.setInt(3, pessoa.getEndereco().getId());

            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao cadastrar!");
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    public void update(Pessoa pessoa) {
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("UPDATE pessoa SET nome = ?, nascimento = ?, endereco = ? WHERE id = ? ");

            st.setString(1, pessoa.getNome());
            st.setDate(2,new java.sql.Date(pessoa.getDataNascimento().getTime()));
            st.setInt(3, pessoa.getEndereco().getId());
            st.setInt(4, pessoa.getId());

            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao atualizar!");
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    public List<Pessoa> list() {
        List<Pessoa> lista = new ArrayList<Pessoa>();
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("SELECT * FROM Pessoa;");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();

                int id = rs.getInt("id");
                String nome = rs.getString("nome");

                lista.add(pessoa);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao listar!");
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

        return lista;
    }

    public Pessoa search(int id) {
        Pessoa pessoa = null;
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("SELECT * FROM pessoa WHERE id=?");
            
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();

            if(rs.next()) {
                pessoa = new Pessoa();

                String nome = rs.getString("nome");
                Date date = rs.getDate("nascimento");
                
                
                pessoa.setId(id);
                pessoa.setNome(nome);
                pessoa.setDataNascimento(date);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao listar!");
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

        return pessoa;
    }

}
