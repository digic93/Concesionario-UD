<%-- 
    Document   : Head
    Created on : 04-jun-2017, 8:44:49
    Author     : Diego Castro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grupo Seleccion S.A</title>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/Web/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Web/css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Web/DataTables/media/css/jquery.dataTables.css">

        <!--JavaScripts -->
        <script src="${pageContext.request.contextPath}/Web/js/jquery-3.2.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/Web/js/bootstrap.min.js"></script>
        <script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath}/Web/DataTables/media/js/jquery.dataTables.js"></script>
    </head>
    <body>
        <nav class="navbar-inverse navbar-default navbar-static-top">
            <div class="container">
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <%if (request.getRequestURI().equals("/Grupo_Seleccion_S.A/Web/LoginView.jsp")) {%>        
                            <p class="navbar-text">Grupo Seleccion S.A</p>
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="#"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> Login</a></li>
                            </ul>
                    <%} else if (session.getAttribute("personal") == null) {%>        
                            <script>
                                window.location.href = "${pageContext.request.contextPath}/login";
                            </script>   
                    <%} else {%>        
                        <p class="navbar-text">
                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                            ${sessionScope.personal.nombre}, Fecha: ${sessionScope.personal.fechaUltimoIngreso}
                        </p>
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="${pageContext.request.contextPath}/gestion/perfil">Gestion Perfil</a></li>
                                <li><a href="${pageContext.request.contextPath}/gestion/programacion">Gestion Programacion</a></li>
                                <li><a href="${pageContext.request.contextPath}/gestion/proceso">Gestion Procesos</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> Logout</a></li>
                            </ul>

                    <%}
                    %>
                </div>
            </div>
        </nav> 
        <div class="container-fluid">
	<div class="row">
		<div class="col-md-1">
		</div>
		<div class="col-md-10">
                    <div class="starter text-center">
                        <h1>Grupo Seleccion S.A</h1>
                        <p class="lead">Especicalistas en la consecucion de talentos para <br>diferentes organizaciones, con 16 años de experiencia</p>
                    </div>
                    <hr>