/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel.DAO;

import Hotel.DTO.HospedesDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospedesDAO {
    private Connection connection;

    public HospedesDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(HospedesDTO hospede) throws SQLException {
        String sql = "INSERT INTO hospedes (nome, cpf, data_nascimento, telefone, email, sexo) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, hospede.getNome());
            stmt.setString(2, hospede.getCpf());
            stmt.setString(3, hospede.getDataNascimento());
            stmt.setString(4, hospede.getTelefone());
            stmt.setString(5, hospede.getEmail());
            stmt.setString(6, hospede.getSexo());
            stmt.executeUpdate();
        }
    }

    public void atualizar(HospedesDTO hospede) throws SQLException {
        String sql = "UPDATE hospedes SET nome=?, cpf=?, data_nascimento=?, telefone=?, email=?, sexo=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, hospede.getNome());
            stmt.setString(2, hospede.getCpf());
            stmt.setString(3, hospede.getDataNascimento());
            stmt.setString(4, hospede.getTelefone());
            stmt.setString(5, hospede.getEmail());
            stmt.setString(6, hospede.getSexo());
            stmt.setInt(7, hospede.getId());
            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM hospedes WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public HospedesDTO buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM hospedes WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new HospedesDTO(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("data_nascimento"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("sexo")
                );
            }
        }
        return null;
    }

    public List<HospedesDTO> listarTodos() throws SQLException {
        List<HospedesDTO> hospedes = new ArrayList<>();
        String sql = "SELECT * FROM hospedes";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                hospedes.add(new HospedesDTO(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("data_nascimento"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("sexo")
                ));
            }
        }
        return hospedes;
    }
}

