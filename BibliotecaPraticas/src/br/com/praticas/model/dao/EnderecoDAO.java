package br.com.praticas.model.dao;

import br.com.praticas.factory.ConnectionFactory;
import br.com.praticas.model.bean.Endereco;
import br.com.praticas.model.bean.Pessoa;
import java.sql.Connection;
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
public class EnderecoDAO implements IEnderecoDAO {
    private Connection connection;
    
    @Override
    public int create(Endereco endereco) {
        
        connection = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;
        
        String sql = "INSERT INTO endereco (rua,numero,cidade) VALUES (?,?,?)";
        
        try {
            st = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, endereco.getRua());
            st.setString(2, endereco.getNumero());
            st.setString(3, endereco.getCidade());
            
            st.executeUpdate();
            
            int idEndereco = 0;
            
            ResultSet rs = st.getGeneratedKeys();
            
            if (rs.next()) {
                idEndereco = rs.getInt(1);
            }
            return idEndereco;
        } catch (SQLException e) {
            return -1;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }
    
    @Override
    public Endereco search(int id) {
        Endereco endereco = null;
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("SELECT id, rua, numero, cidade FROM public.endereco e WHERE id=?");
            
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();

            if(rs.next()) {
                endereco = new Endereco();
                
                endereco.setId(id);
                endereco.setRua(rs.getString("rua"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setNumero("numero");
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao pegar pessoa no banco!");
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

        return endereco;
    }
    
    @Override
    public void update(Endereco endereco) {
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("UPDATE endereco SET rua = ?, numero = ?, cidade = ? WHERE id = ? ");

            st.setString(1, endereco.getRua());
            st.setString(2, endereco.getNumero());
            st.setString(3, endereco.getCidade());
            st.setInt(4, endereco.getId());

            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao atualizar!");
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public boolean delete(Endereco endereco){
        connection = ConnectionFactory.getConnection();
        
        PreparedStatement st = null;
        
        try {
            st = connection.prepareStatement("DELETE FROM endereco WHERE id = ?");
            
            st.setInt(1, endereco.getId());
            
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
    public List<Endereco> list() {
        List<Endereco> lista = new ArrayList<Endereco>();
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("SELECT id , rua, numero, cidade FROM public.endereco");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Endereco endereco = new Endereco();
                
                endereco.setId(rs.getInt("id"));
                endereco.setRua(rs.getString("rua"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setNumero("numero");
                
                lista.add(endereco);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao listar!");
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

        return lista;
    }

}