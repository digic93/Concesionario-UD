<%-- 
    Document   : GestionPerfil
    Created on : 04-jun-2017, 14:19:08
    Author     : Diego Castro
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.udistrital.grupo_seleccion_sa.modelo.bean.Requerimiento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="secciones/Head.jsp" />
<h2>Gestion de Perfiles</h2>
<p>
    En esta página encontrara los Requerimientos de los clientes que no cuentan con un perfil asociado y puedes asignarlo.
</p>
<hr>
<div class="row">
    <div class="col-md-6">
        <div class="panel panel-primary">
            <div class="panel-heading">Requrimientos sin Perfiles</div>
            <div class="panel-body">
                <table id="tablaRequerimientos" class="display" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>SALARIO</th>
                            <th>VACANTES</th>

                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Requerimiento> requerimientos = (ArrayList<Requerimiento>) session.getAttribute("Requerimientos");

                            for (Requerimiento requerimiento : requerimientos) {
                                out.print("<tr><td>" + requerimiento.getId() + "</td>");
                                out.print("<td>" + requerimiento.getRazon() + "</td>");
                                out.print("<td>" + requerimiento.getSalario() + "</td>");
                                out.print("<td>" + requerimiento.getVacantes() + "</td></tr>");
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <div class="panel panel-primary">
            <div class="panel-heading">Asignar Perfil<button type="button" class="btn btn-success btn-xs" style="float: right">Crear Perfil</button></div>
            <div class="panel-body">
                <table id="tablaPerfil" class="display" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOMBRE</th>
                            <th>DESCRIPCION</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>                
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-primary">
            <div class="panel-heading" id="caracterisitcasTitle">Caracteristicas</div>
            <div class="panel-body">
                <table id="tablaCaracteristcas" class="display" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOMBRE</th>
                            <th>DESCRIPCION</th>
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
    var requerimientoId;
    function getCaracteristicas(nombre, tablaCaracteristicas) {
        tablaCaracteristicas.clear().draw();
        $('#caracterisitcasTitle').html("Caracteristicas para " + nombre);
        
        $.ajax({
            type: "GET",
            url: '${pageContext.request.contextPath}/caracteristica',
            data: {requerimientoId: requerimientoId},
            success: function(caracteristicas){
                for(var caracterisitca in caracteristicas){
                    tablaCaracteristicas.row.add([
                            caracteristicas[caracterisitca].id, 
                            caracteristicas[caracterisitca].nombre,
                            caracteristicas[caracterisitca].descripcion
                    ]).draw( false );
                }
            },
            error: function (error){
            }
        });
    }
    
    function getPerfiles(nombre, tablaPerfil) {
        tablaPerfil.clear().draw();
        $('#perfilesTitle').html("probables Perfiles" + nombre);
        
        $.ajax({
            type: "GET",
            url: '${pageContext.request.contextPath}/perfil',
            data: {requerimientoId: requerimientoId},
            success: function(perfiles){
                for(var perfil in perfiles){
                    tablaPerfil.row.add([
                            perfiles[perfil].id, 
                            perfiles[perfil].nombre,
                            perfiles[perfil].descripcion
                    ]).draw( false );
                }
            },
            error: function (error){
            }
        });
    }
    
    function asignarPerfil(requerimientoId, perfilId){
        $.ajax({
            type: "POST",
            url: '${pageContext.request.contextPath}/requerimiento',
            data: {
                perfilId: perfilId,
                requerimientoId: requerimientoId
            },
            success: function(){
                location.reload();
            },
            error: function (error){
            }
        });
    }
    
    $(document).ready(function () {
        var tablaPerfil = $('#tablaPerfil').DataTable();
        var tablaCaracteristcas = $('#tablaCaracteristcas').DataTable();
        var tablaRequerimientos = $('#tablaRequerimientos').DataTable();

        $('#tablaRequerimientos tbody').on('click', 'tr', function () {
            var data = tablaRequerimientos.row(this).data();
            requerimientoId = data[0];
            getPerfiles(data[1], tablaPerfil);
            getCaracteristicas(data[1], tablaCaracteristcas);
        });
        
        $('#tablaPerfil tbody').on('click', 'tr', function () {
            var data = tablaPerfil.row(this).data();
            asignarPerfil(requerimientoId,data[0]);
        });
    });
</script>
<jsp:include page="secciones/Foot.jsp" />