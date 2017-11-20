<%-- 
    Document   : GestionPerfil
    Created on : 04-jun-2017, 14:19:08
    Author     : Diego Castro
--%>

<%@page import="com.udistrital.grupo_seleccion_sa.modelo.bean.Perfil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.udistrital.grupo_seleccion_sa.modelo.bean.Requerimiento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="secciones/Head.jsp" />
<h2>Gestion Programacion</h2>
<p>
    En esta página encontrara los Requerimientos de los clientes que ya cuentan con un perfil asociado.
</p>
<hr>
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-primary">
            <div class="panel-heading">Requrimientos con Perfiles</div>
            <div class="panel-body">
                <table id="tablaRequerimientos" class="display" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>SALARIO</th>
                            <th>VACANTES</th>
                            <th>ID PERFIL</th>
                            <th>NOMBRE PERFIL</th>
                            <th>DESCRIPCION PERFIL</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Requerimiento> requerimientos = (ArrayList<Requerimiento>) session.getAttribute("Requerimientos");

                            for (Requerimiento requerimiento : requerimientos) {
                                Perfil perfil = requerimiento.getPerfil();
                                out.print("<tr><td>" + requerimiento.getId() + "</td>");
                                out.print("<td>" + requerimiento.getRazon() + "</td>");
                                out.print("<td>" + requerimiento.getSalario() + "</td>");
                                out.print("<td>" + requerimiento.getVacantes() + "</td>");
                                out.print("<td style=\"border-left: #3174af;border-left-style: dashed;\">" + perfil.getId() + "</td>");
                                out.print("<td>" + perfil.getNombre() + "</td>");
                                out.print("<td>" + perfil.getDescripcion() + "</td></tr>");
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <hr>
    <h3 id="Fases">Asignacion de Fases</h3>
    <hr>
    <div class="col-md-6">
        <p>
            Seleccione las fases a asignar al requerimiento.
        </p>
        <div class="panel panel-primary">
            <div id="facesTitle" class="panel-heading">Fases del Perfil</div>
            <div class="panel-body">
                <table id="tablaFasesPerfil" class="display" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>ID FASE</th>
                            <th>TIPO FASE</th>
                            <th>DESCRIPCION</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>                
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <p>
            Las siguientes son las faces que se asociaron al requerimiento.
        </p>
        <div class="panel panel-success">
            <div class="panel-heading" id="facesRequerimientoTitle">Faces Asoiadas al Requerimiento</div>
            <div class="panel-body">
                <table id="fasesRequerimientos" class="display" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>ID FASE</th>
                            <th>TIPO FASE</th>
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
    <hr>
        <h3 id="Pruebas">Asignacion de Pruebas</h3>
    <hr>

    <div class="col-md-6">
        <p>
            Seleccione las pruebas a asignar a la fase del requerimiento.
        </p>
        <div class="panel panel-primary">
            <div id="titlePruebasFase" class="panel-heading">Pruebas de la Fase</div>
            <div class="panel-body">
                <table id="tablaPruebasFase" class="display" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>ID PUEBA</th>
                            <th>NOMBRE</th>
                            <th>TIPO PRUEBA</th>
                            <th>DESCRIPCION</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>                
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <p>
        Las siguientes son las pruebas asignadas a la face seleccionada previamente.
        </p>
        <div class="panel panel-success">
            <div class="panel-heading" id="titlePruebasFaseRequerimientos">Pruebas de la Fase Para el Requerimiento</div>
            <div class="panel-body">
                <table id="tablaPruebasFaseRequerimientos" class="display" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>ID PUEBA</th>
                            <th>NOMBRE</th>
                            <th>TIPO PRUEBA</th>
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
    var perfilId;
    var perfilNombre;
    var requerimientoId;
    var requerimientoNombre;
    
    function getFaces(tablaFasesPerfil) {
        tablaFasesPerfil.clear().draw();
        $('#facesTitle').html("Fases del Perfil " + perfilNombre);
        
        $.ajax({
            type: "GET",
            url: '${pageContext.request.contextPath}/fase',
            data: {perfilId: perfilId,requerimientoId:requerimientoId},
            success: function(faces){
                
                for(var perfil in faces){
                    tablaFasesPerfil.row.add([
                            faces[perfil].id, 
                            faces[perfil].tipoPerfilNombre, 
                            faces[perfil].descripcion
                    ]).draw( false );
                }
                $(document).scrollTop( $("#Fases").offset().top );  
            },
            error: function (error){
            }
        });
    }
    
    function getFasesByRequerimientoId(tablaFasesRequerimientos, tablaPerfil) {
        tablaFasesRequerimientos.clear().draw();
        $('#facesRequerimientoTitle').html("Fases del requerimiento " + requerimientoNombre);
        
        $.ajax({
            type: "GET",
            url: '${pageContext.request.contextPath}/fase',
            data: {requerimientoId: requerimientoId},
            success: function(faces){
                
                for(var perfil in faces){
                    tablaFasesRequerimientos.row.add([
                            faces[perfil].id, 
                            faces[perfil].tipoPerfilNombre, 
                            faces[perfil].descripcion
                    ]).draw( false );
                }
                getFaces(tablaPerfil);
            },
            error: function (error){
            }
        });
    }
    
    function asignarFase(faseId, tablaFasesRequerimientos, tablaFasesPerfil){
        $.ajax({
            type: "POST",
            url: '${pageContext.request.contextPath}/requerimiento',
            data: {
                faseId: faseId,
                perfilId: perfilId,
                requerimientoId: requerimientoId
            },
            success: function(){
                getFasesByRequerimientoId(tablaFasesRequerimientos, tablaFasesPerfil);
            },
            error: function (error){
            }
        });
    }
    
    function getPruebasByFaceId(faseId,faseName, tablaPruebasFase) {
        tablaPruebasFase.clear().draw();
        $('#titlePruebasFase').html("Pruebas de la Fase " + faseName);
        
        $.ajax({
            type: "GET",
            url: '${pageContext.request.contextPath}/prueba',
            data: {faseId: faseId},
            success: function(pruebas){
                
                for(var prueba in pruebas){
                    tablaPruebasFase.row.add([
                            pruebas[prueba].id, 
                            pruebas[prueba].nombre, 
                            pruebas[prueba].tipoPruebaNombre,
                            pruebas[prueba].descripcion
                    ]).draw( false );
                }
                $(document).scrollTop( $("#Pruebas").offset().top );  
            },
            error: function (error){
            }
        });
    }
    
    function asingnarPruebaAFase(pruebaId, tablaPruebasFaseRequerimientos){
        $.ajax({
            type: "POST",
            url: '${pageContext.request.contextPath}/proceso',
            data: {
                pruebaId: pruebaId,
                requerimientoId: requerimientoId
            },
            success: function(){
                getFasesByRequerimientoId(tablaFasesRequerimientos, tablaFasesPerfil);
            },
            error: function (error){
            }
        });
    }
    
    $(document).ready(function () {
        var tablaFasesPerfil = $('#tablaFasesPerfil').DataTable();
        var tablaPruebasFase = $('#tablaPruebasFase').DataTable();
        var tablaRequerimientos = $('#tablaRequerimientos').DataTable();
        var tablaFasesRequerimientos = $('#fasesRequerimientos').DataTable();
        var tablaPruebasFaseRequerimientos = $('#tablaPruebasFaseRequerimientos').DataTable();

        $('#tablaRequerimientos tbody').on('click', 'tr', function () {
            var data = tablaRequerimientos.row(this).data();
            
            perfilId  = data[4];
            perfilNombre  = data[5];
            requerimientoId = data[0];
            requerimientoNombre = data[1];
            
            getFasesByRequerimientoId(tablaFasesRequerimientos, tablaFasesPerfil);
        });
        
        $('#tablaFasesPerfil tbody').on('click', 'tr', function () {
            var data = tablaFasesPerfil.row(this).data();
            asignarFase(data[0], tablaFasesRequerimientos, tablaFasesPerfil);
        });
        
        $('#fasesRequerimientos tbody').on('click', 'tr', function () {
            var data = tablaFasesRequerimientos.row(this).data();
            getPruebasByFaceId(data[0], data[1],tablaPruebasFase);
        });
        
        $('#tablaPruebasFase tbody').on('click', 'tr', function () {
            var data = tablaPruebasFase.row(this).data();
            
            asingnarPruebaAFase(data[0], tablaPruebasFaseRequerimientos);
//            getPruebasByFaceId(data[0], data[1],tablaPruebasFase);
        });
    });
</script>
<jsp:include page="secciones/Foot.jsp" />