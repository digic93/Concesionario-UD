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
        <title>Concecionario UD</title>

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
                    <p class="navbar-text"><span class="glyphicon glyphicon-road" aria-hidden="true"></span> Concecionario UD</p>
                    <p id="horaSistema" class="navbar-text"></p>
                    <%if (request.getRequestURI().equals("/Concesionario_UD/Web/LoginView.jsp")) {%>        
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#" onclick="modal();"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> Login</a></li>
                    </ul>
                    <%} else if (session.getAttribute("personal") == null) {%>        
                    <script>
                        window.location.href = "${pageContext.request.contextPath}/login";
                    </script>   
                    <%} else {%>        
                    <p class="navbar-text"><span class="glyphicon glyphicon-road" aria-hidden="true"></span> Concecionario UD</p>
                    <p id="horaSistema" class="navbar-text"></p>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <p class="navbar-text"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Nombre Fulano</p>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/cotizar"><span class="glyphicon glyphicon glyphicon-paperclip" aria-hidden="true"></span> Cotizar</a></li>
                        <li role="presentation" class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Modulo Ventas <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/venta/acuerdoPago">Acuerdo Pago</a></li>
                                <li><a href="${pageContext.request.contextPath}/venta/separaAuto">Separar Auto</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="${pageContext.request.contextPath}/venta/estudioCredito">Estudio Credito</a></li>
                                <li><a href="${pageContext.request.contextPath}/venta/abonarPago">Abonar Pago</a></li>
                            </ul>
                        </li>
                        <li><a href="#"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> Logout</a></li>
                    </ul>
                    <%}
                    %>
                </div>
            </div>
        </nav> 
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="starter text-center">
                        <h1><span class="glyphicon glyphicon-road" aria-hidden="true"></span> Concecionario UD</h1>
                        <%if (session.getAttribute("personal") == null) {%>
                        <p class="lead">Especicalistas en la venta de Vehiculos nuevos.</p>
                        <%}%>
                    </div>
                    <hr>
                    <!--____________________________________________________________________________________-->
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingOne"> 
                            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                <span class="glyphicon glyphicon-search" aria-hidden="true"></span> Buscar Cotizacion 
                            </a>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                            <div class="panel-body">
                                <div class="col-md-10 col-md-offset-1">

                                    <div class="well well-sm">
                                        <div class="input-group">
                                            <span class="input-group-addon" id="sizing-addon2">C.C</span>
                                            <input type="number" min="0" class="form-control" placeholder="Cedula Cliente" aria-describedby="sizing-addon2">
                                            <span class="input-group-btn">
                                                <button class="btn btn-default" type="button">Bucar</button>
                                            </span>
                                        </div>
                                    </div>

                                    <table id="buquedaCotizacion" class="table" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th>Cliente</th>
                                                <th>Cotizacion</th>
                                                <th>Valor</th>
                                                <th>Vehiculo</th>
                                                <th>Fecha</th>
                                                <th>Estado</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        </tbody>
                                    </table>

                                </div>
                            </div>
                        </div>
                    </div>
                    <script>
                        $(document).ready(function () {
//                            $('#buquedaCotizacion').DataTable();
                        });
                    </script>
