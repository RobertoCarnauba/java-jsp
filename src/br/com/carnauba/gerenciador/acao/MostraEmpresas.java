package br.com.carnauba.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.alura.gerenciador.modelo.Banco;
import br.alura.gerenciador.modelo.Empresa;

public class MostraEmpresas implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
    	String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPelaId(id);
		request.setAttribute("empresa", empresa);

		return "forward:formAlteraEmpresa.jsp";
	}

}
