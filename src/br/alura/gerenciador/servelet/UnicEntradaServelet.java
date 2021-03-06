package br.alura.gerenciador.servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.carnauba.gerenciador.acao.Acao;

@WebServlet("/entrada")
public class UnicEntradaServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String paramAcao = request.getParameter("acao");
			
			String nomeDaClasse = "br.com.carnauba.gerenciador.acao." + paramAcao;
			
			String nome;
			try {
				@SuppressWarnings("rawtypes")
				Class classe = Class.forName(nomeDaClasse);
				Acao acao = (Acao) classe.newInstance();
				nome = acao.executa(request,response);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {

				throw new ServletException(e);
			}
			
			String[] tipoEndereco = nome.split(":");
			
			if(tipoEndereco[0].equals("forward")){
				
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
				rd.forward(request, response);
				
			} else {
				
				response.sendRedirect(tipoEndereco[1]);
				
			}
		
			
//			String nome = null;
//			
//			if(paramAcao.equals("ListaEmpresas")){
//				
//		      ListaEmpresas acao = new ListaEmpresas();
//		      nome = acao.executa(request,response);
//		      
//			} else if(paramAcao.equals("RemoveEmpresas")){
//		
//			   RemoveEmpresas acao = new RemoveEmpresas();
//			   nome = acao.executa(request, response);
//			}
//			else if(paramAcao.equals("MostraEmpresas")){
//				
//			   MostraEmpresas acao  = new MostraEmpresas();
//			   nome = acao.executa(request, response);
//			}
//			else if(paramAcao.equals("AlteraEmpresas")){
//				
//				AlteraEmpresas acao = new AlteraEmpresas();
//				nome = acao.executa(request, response);
//			}
//		    else if(paramAcao.equals("NovaEmpresa")){
//				
//				NovaEmpresa acao = new NovaEmpresa();
//				nome = acao.executa(request, response);
//			}
//            else if(paramAcao.equals("NovaEmpresaForm")){
//				
//            	NovaEmpresaForm acao = new NovaEmpresaForm();
//				nome = acao.executa(request, response);
//			}
			

		
		}

}
