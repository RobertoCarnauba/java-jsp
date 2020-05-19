package br.com.carnauba.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.alura.gerenciador.modelo.Banco;
import br.alura.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Banco banco = new Banco();
		Usuario usiario = banco.existeUsuario(login, senha);
		
		if(usiario != null){
			System.out.println("Logado "+ login);
			return "redirect:entrada?acao=ListaEmpresas";
		} else {
			System.out.println("Deu Ruim "+ login);
			return "redirect:entrada?acao=LoginForm";
		}
		
	}

}
