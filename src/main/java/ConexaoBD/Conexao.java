/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexaoBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        public static boolean executarComandoSQL(String sql, Object... parametros) {
        try (Connection conn = new Conexao().getConnection(); // Obtém a conexão
             PreparedStatement pst = conn.prepareStatement(sql)) {

            // Preenche os parâmetros da query
            for (int i = 0; i < parametros.length; i++) {
                pst.setObject(i + 1, parametros[i]); // i + 1 porque PreparedStatement começa em 1
            }

            // Executa a query
            int linhasAfetadas = pst.executeUpdate();
            return linhasAfetadas > 0; // Retorna true se pelo menos uma linha foi afetada
        } catch (SQLException e) {
            // Log do erro (pode ser melhorado com um sistema de logs)
            System.err.println("Erro ao executar comando SQL: " + e.getMessage());
            e.printStackTrace(); // Mostra o stack trace completo para depuração
            return false;
        }
    }
}
