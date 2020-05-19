package br.com.carnauba.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.alura.gerenciador.modelo.Banco;

public class RemoveEmpresas implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco =  new Banco();
		banco.removeEmpresa(id);
		System.out.println(" --> Removendo id:" +id);
		
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
