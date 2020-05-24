package br.com.carnauba.gerenciador.acao;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebFilter("/entrada")
public class ControladorFilter implements Filter {


    public ControladorFilter() {
    }


	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse , FilterChain chain) throws IOException, ServletException {

	
		System.out.println("->ControladorFilter");
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
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

	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
