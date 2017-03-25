/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.praticas.model.dao;

import br.com.praticas.connection.ConnectionFactory;
import br.com.praticas.model.bean.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author VAAR
 */
public class EnderecoDAO {
    
    public boolean create(Endereco endereco) {
        
        Connection connection = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;
        
        try {
            st = connection.prepareStatement("INSERT INTO endereco (rua,numero,cidade) VALUES (?,?,?)");
            st.setString(1, endereco.getRua());
            st.setString(2, endereco.getNumero());
            st.setString(3, endereco.getCidade());
            
            st.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO ao cadastrar o endereco: " + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

}
