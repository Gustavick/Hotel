/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexaoBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    // Configurações do banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/Hotel";
    private static final String USUARIO = "root"; // Substitua pelo seu usuário do MySQL
    private static final String SENHA = "gustavo123"; // Substitua pela sua senha do MySQL

    public static Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conexao;       
                } 
}
