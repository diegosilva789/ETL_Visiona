package testes;

import java.util.List;

import beans.Usuario;
import jdbc.UsuarioDAO;

public class TesteDAO {
	public static void main(String[] args) {
		// testCadastro();
		// testAlterar();
		// testDeletar();
		testBuscarTodos();
	}
	
	public static void testCadastro() {
		Usuario usu = new Usuario();
		usu.setNome("Feliciana");
		usu.setEmail("feliciana.mmnt@gmail.com");
		usu.setSenha("1234");
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.cadastro(usu);
	}
	
	public static void testAlterar() {
		Usuario usu = new Usuario();
		usu.setNome("Rodolfo Rolim");
		usu.setEmail("rodolfo.r@gmail.com");
		usu.setSenha("12345");
		usu.setId(5);
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.Alterar(usu);
	}
	
	public static void testDeletar() {
		Usuario usu = new Usuario();
		usu.setId(4);
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.Deletar(usu);
	}
	
	public static void testBuscarTodos() {
		Usuario usu = new Usuario();
		UsuarioDAO usuDAO = new UsuarioDAO();
		List<Usuario> listaResultado = usuDAO.buscarTodos(usu);
		
		for (Usuario u : listaResultado) {
			System.out.println("Id: " + u.getId() + " Nome: " + u.getNome() + " Email: " + u.getEmail() + " Senha: " + u.getSenha());		
		}
	}
}
