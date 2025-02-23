/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.photel;

import ConexaoBD.Conexao;
import Hotel.DAO.UsuarioDAO;
import Hotel.DTO.UsuarioDTO;
import Hotel.gui.TelaLogin;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author luizg
 */
public class LoginController {
    
    
    
    
public void logarUsuario(TelaLogin telaL) throws SQLException {
    Connection conexao = new Conexao().getConnection();
   
    // Cria um objeto UsuarioDTO com os dados fornecidos pela tela
    UsuarioDAO usuario = new UsuarioDAO();
    usuario.validarlogin(telaL.getTxtNome().getText(), telaL.getTxtSenha().getText());
    
    // Passa o objeto usuario para o método autenticacaoUsuario
   
}

}
