/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel.DAO;

import Hotel.DTO.HospedesDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class HospedesDAO {
    private Connection connection;

    public HospedesDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrar(HospedesDTO hospede) throws SQLException {
        String sql = "INSERT INTO hospedes (cpf, nome, dataNascimento, telefone, email, sexo) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, hospede.getCpf());
            stmt.setString(2, hospede.getNome());
            stmt.setString(3, hospede.getDataNascimento());
            stmt.setString(4, hospede.getTelefone());
            stmt.setString(5, hospede.getEmail());
            stmt.setString(6, hospede.getSexo());
            stmt.executeUpdate();
        }
    }

    public void atualizar(HospedesDTO hospede) throws SQLException {
        String sql = "UPDATE hospedes SET nome=?, dataNascimento=?, telefone=?, email=?, sexo=? WHERE cpf=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, hospede.getNome());
            stmt.setString(2, hospede.getDataNascimento());
            stmt.setString(3, hospede.getTelefone());
            stmt.setString(4, hospede.getEmail());
            stmt.setString(5, hospede.getSexo());
            stmt.setString(6, hospede.getCpf()); // Usando cpf como chave primária
            stmt.executeUpdate();
        }
    }

public boolean excluir(String cpf) throws SQLException {
    String sql = "DELETE FROM hospedes WHERE cpf=?";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, cpf);
        int linhasAfetadas = stmt.executeUpdate();
        return linhasAfetadas > 0; // Retorna true se pelo menos uma linha foi excluída
    }
}

    public HospedesDTO buscarPorCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM hospedes WHERE cpf=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new HospedesDTO(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("dataNascimento"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("sexo")
                );
            }
        }
        return null;
    }

    public List<HospedesDTO> listarTodos() {
        List<HospedesDTO> hospedes = new ArrayList<>();
        String sql = "SELECT * FROM hospedes";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                hospedes.add(new HospedesDTO(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("dataNascimento"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("sexo")
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar hóspedes: " + e.getMessage());
        }

        return hospedes;
    }
}


