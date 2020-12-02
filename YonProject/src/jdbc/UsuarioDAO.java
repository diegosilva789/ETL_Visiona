package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Usuario;

public class UsuarioDAO {
	
	private Connection con = Conexao.getConnection();
	
	public Usuario buscarporID(Integer id) { // Objeto de retorno do método
		Usuario usuRetorno = null;
		String sql = "SELECT * FROM usuario WHERE id = ?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1,  id);
			// Retorno da consulta Resultset
			ResultSet resultado = preparador.executeQuery();
			// Se tem registro
			if(resultado.next()) {
				// instancia o objeto Usuario
				usuRetorno = new Usuario();
				usuRetorno.setId(resultado.getInt("id"));
				usuRetorno.setNome(resultado.getString("nome"));
				usuRetorno.setEmail(resultado.getString("email"));
				usuRetorno.setSenha(resultado.getString("senha"));
			}
			System.out.println("Encontrado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro de SQL: " + e.getMessage());
		}
		return usuRetorno;
	}
	
	public Usuario autenticacao(Usuario usuario) { // Objeto de retorno do método
		Usuario usuRetorno = null;
		String sql = "SELECT * FROM usuario WHERE email = ? and senha = ?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getEmail());
			preparador.setString(2, usuario.getSenha());
			// Retorno da consulta Resultset
			ResultSet resultado = preparador.executeQuery();
			// Se tem registro
			if(resultado.next()) {
				// instancia o objeto Usuario
				usuRetorno = new Usuario();
				usuRetorno.setId(resultado.getInt("id"));
				usuRetorno.setNome(resultado.getString("nome"));
				usuRetorno.setEmail(resultado.getString("email"));
				usuRetorno.setSenha(resultado.getString("senha"));
			}
			System.out.println("Encontrado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro de SQL: " + e.getMessage());
		}
		return usuRetorno;
	}
	
	public void cadastro(Usuario usuario) {
		
		String sql = "INSERT INTO usuario (nome,email,senha) VALUES (?,?,?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getEmail());
			preparador.setString(3, usuario.getSenha());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Cadastrado com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		
		
	}
	
	public void Alterar(Usuario usuario) {
		
		String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getEmail());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());
						
			preparador.execute();
			preparador.close();
			
			System.out.println("Alterado com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		
		
	}
	
	public void Deletar(Usuario usuario) {
		
		String sql = "DELETE FROM usuario WHERE id = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, usuario.getId());
						
			preparador.execute();
			preparador.close();
			
			System.out.println("Deletado com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		
		
	}
	
	public List<Usuario> buscarTodos(Usuario usuario) {
		String sql = "SELECT * FROM usuario";
		List<Usuario> lista = new ArrayList<>();
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			
			while(resultados.next()) {
				Usuario usu = new Usuario();
				usu.setId(resultados.getInt("id"));
				usu.setNome(resultados.getString("nome"));
				usu.setEmail(resultados.getString("email"));
				usu.setSenha(resultados.getString("senha"));
				lista.add(usu);
			}
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		
		return lista;
	}
	
}
