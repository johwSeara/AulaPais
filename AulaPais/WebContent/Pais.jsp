<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Pais"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pais</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<%
		Pais pais = (Pais) request.getAttribute("pais");
	%>
	<div id="main" class="container">
		<h3 class="page-header">
			Visualizar País #<%=pais.getId()%></h3>
		<div class="row">
			<div class="col-md-12">
				<p>
					<strong><%=pais.getNome()%></strong>
				</p>
			</div>
			<div class="col-md-12">
				<p>
					<strong><%=pais.getPopulacao()%></strong>
				</p>
			</div>
			<div class="col-md-12">
				<p>
					<strong><%=pais.getArea()%></strong>
				</p>
			</div>
		</div>
		<hr>
		<div id="actions" class="row">
			<a href="index.html" class="btn btn-default">Voltar</a>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>