package br.com.carnauba.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.alura.gerenciador.modelo.Banco;
import br.alura.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		request.setAttribute("empresas", lista);
		
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
//		rd.forward(request, response);
		
		return "forward:listaEmpresas.jsp";
	}

}
