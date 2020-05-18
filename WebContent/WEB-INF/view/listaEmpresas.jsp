<%@page import="br.com.carnauba.gerenciador.acao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Contatos - Java Standard TagLib</title>
</head>
<body>
   <c:if test="${ not empty empresa}">
     Contato ${empresa.nome} cadastrada com sucesso!
   </c:if>
  Lista de contatos: <br>
  <ul>
	  <c:forEach items="${empresas}" var="empresa">
	    <li> ${empresa.nome}
	     <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/YY"/>
	     <a href="/gerenciador/entrada?acao=MostraEmpresas&id=${empresa.id}"> editar </a>
	     <a href="/gerenciador/entrada?acao=RemoveEmpresas&id=${empresa.id}"> remove </a>
	     </li>
	  </c:forEach>
  </ul>

</body>
</html>