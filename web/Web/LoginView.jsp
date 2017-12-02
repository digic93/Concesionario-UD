<%-- 
    Document   : Login
    Created on : 04-jun-2017, 9:04:03
    Author     : Diego Castro
--%>

<%@page import="com.udistrital.ConcesionarioUD.modelo.bean.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="secciones/Head.jsp" />
<div id="loginModal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="Login">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <form class="form-horizontal" method="POST" action="./login">
                <fieldset>
                    <div class="modal-header">
                        <h4 class="modal-title">Concecionario UD <span class="label label-default">Login</span></h4>
                    </div>
                    <div class="modal-body">
                        <%if(request.getAttribute("error") != null){%>
                        <div class="alert alert-danger" role="alert">${requestScope.error}</div>
                        <%}%>
                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="usuario">Usuario</label>  
                            <div class="col-md-5">
                                <input id="usuario" name="usuario" type="text" placeholder="Usuario" class="form-control input-md" required="">
                            </div>
                        </div>

                        <!-- Password input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="password">Contraseña</label>
                            <div class="col-md-5">
                                <input id="password" name="password" type="password" placeholder="Password" class="form-control input-md" required="">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> Ingresar</button>
                    </div>
                </fieldset>
            </form>
        </div>
                        

    </div>
</div>
<script>
    $(document).ready(function () {
        modal();
    });
    
    function modal(){
        
        $('#loginModal').modal('show');
        
    }
</script>
<jsp:include page="secciones/Foot.jsp" />
