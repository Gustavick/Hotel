/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel.DAO;

import ConexaoBD.Conexao;
import Hotel.DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {

    public boolean validarlogin(String nome, String senha) throws SQLException {
        Connection conexao = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            conexao = new Conexao().getConnection();
            String sql = "SELECT * from usuario where nome = ? and senha = ?";
            statement = conexao.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setString(2, senha);
            
            rs = statement.executeQuery();
            
            if (rs.next()) {
                return true;  // Login válido
            } else {
                return false; // Login inválido
            }
        } catch (SQLException e) {
            System.err.println("Erro ao validar login: " + e.getMessage());
            return false;
        } finally {
            // Fechar os recursos
            if (rs != null) rs.close();
            if (statement != null) statement.close();
            if (conexao != null) conexao.close();
        }
    }
}





