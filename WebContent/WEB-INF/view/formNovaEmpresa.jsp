<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada" var="linkEntradaServelet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Nova Empresa</title>
</head>
<body>
       <c:import url="logout-parcial.jsp"></c:import> <br>
	   <form action="${linkEntradaServelet }" method="post">
		    Nome: <input type="text" name="nome"  />
		    Data Abertura: <input type="text" name="data"  />
		    <input type="hidden" name="acao" value="NovaEmpresa">
		    <input type="submit" />
	  </form>

</body>
</html>