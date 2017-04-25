/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.praticas.model.dao;

import br.com.praticas.factory.ConnectionFactory;
import br.com.praticas.model.bean.Endereco;
import br.com.praticas.model.bean.Pessoa;
import br.com.praticas.factory.DAOFactory;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author VAAR
 */
public class PessoaDAO implements IPessoaDAO {

    private Connection connection;
    
    @Override
    public boolean create(Pessoa pessoa) {
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("INSERT INTO pessoa (nome,nascimento,endereco) VALUES(?,?,?)");
            st.setString(1, pessoa.getNome());
            st.setDate(2, new java.sql.Date(pessoa.getNascimento().getTime()));
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

    @Override
    public Pessoa search(int id) {
        Pessoa pessoa = null;
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("SELECT id, nome, nascimento, endereco FROM public.pessoa WHERE id=?");
            
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();

            if(rs.next()) {
                pessoa = new Pessoa();
                Endereco endereco = new Endereco();
                
                pessoa.setId(id);
                pessoa.setNome(rs.getString("nome"));
                pessoa.setNascimento(rs.getDate("nascimento"));
                pessoa.setEndereco(DAOFactory.createEnderecoDAO().search(rs.getInt("endereco")));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao pegar pessoa no banco!");
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

        return pessoa;
    }
    
    @Override
    public void update(Pessoa pessoa) {
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("UPDATE pessoa SET nome = ?, nascimento = ?, endereco = ? WHERE id = ? ");

            st.setString(1, pessoa.getNome());
            st.setDate(2,new java.sql.Date(pessoa.getNascimento().getTime()));
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

    @Override
    public boolean delete(Pessoa pessoa){
        connection = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;
        
        try {
            st = connection.prepareStatement("DELETE FROM pessoa WHERE id = ?");
            
            st.setInt(1, pessoa.getId());
            
            st.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(null, "ERRO ao Excluir!");
            
            return false;
        }finally{
            ConnectionFactory.closeConnection(connection, st);
        }
        
    }
    
    @Override
    public List<Pessoa> list() {
        List<Pessoa> lista = new ArrayList<Pessoa>();
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("SELECT id, nome, nascimento, endereco FROM public.pessoa WHERE id=?");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                Endereco endereco = new Endereco();
                
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setNascimento(rs.getDate("nascimento"));
                pessoa.setEndereco(new EnderecoDAO().search(rs.getInt("enderreco")));
                
                lista.add(pessoa);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao listar!");
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

        return lista;
    }

}