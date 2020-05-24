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
		
		//HttpSession sessao = request.getSession();
		String paramAcao = request.getParameter("acao");
		//verifica se existe ususario logado e atribui a variavel
//		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
//		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//		
//        if(ehUmaAcaoProtegida & usuarioNaoEstaLogado) {
//             response.sendRedirect("entrada?acao=LoginForm");
//             return;
//        }
//			
			
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
		
			
		
		}

}
