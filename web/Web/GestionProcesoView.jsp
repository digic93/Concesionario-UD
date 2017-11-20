<%-- 
    Document   : GestionPerfil
    Created on : 04-jun-2017, 14:19:08
    Author     : Diego Castro
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.udistrital.grupo_seleccion_sa.modelo.bean.Requerimiento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="secciones/Head.jsp" />
<h2>Gestion de Proceso</h2>
<p>
    En esta pgina puede ver los requerimeitno sque ya estan en proceso y asociar los aspirantes que pasan a cada face.
</p>
<hr>
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-primary">
            <div class="panel-heading">Requrimientos en Proceso</div>
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
//                            ArrayList<Requerimiento> requerimientos = (ArrayList<Requerimiento>) session.getAttribute("Requerimientos");
//
//                            for (Requerimiento requerimiento : requerimientos) {
//                                out.print("<tr><td>" + requerimiento.getId() + "</td>");
//                                out.print("<td>" + requerimiento.getRazon() + "</td>");
//                                out.print("<td>" + requerimiento.getSalario() + "</td>");
//                                out.print("<td>" + requerimiento.getVacantes() + "</td></tr>");
//                            }
%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <h3>Faces</h3>
    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
        <div class="panel panel-primary">
            <div class="panel-heading" role="tab" id="headingOne">
                <h4 class="panel-title">
                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        Reclutamiento
                    </a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                <div class="panel-body">
                    
                </div>
            </div>
        </div>
        <div class="panel panel-primary">
            <div class="panel-heading" role="tab" id="headingTwo">
                <h4 class="panel-title">
                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        Preceleccion
                    </a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                <div class="panel-body">
                    
                </div>
            </div>
        </div>
        <div class="panel panel-primary">
            <div class="panel-heading" role="tab" id="headingThree">
                <h4 class="panel-title">
                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        Pruebas
                    </a>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                <div class="panel-body">
                </div>
            </div>
        <div class="panel panel-primary">
            <div class="panel-heading" role="tab" id="headingThree">
                <h4 class="panel-title">
                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        Entrevista 
                    </a>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                <div class="panel-body">
                </div>
            </div>
        <div class="panel panel-primary">
            <div class="panel-heading" role="tab" id="headingThree">
                <h4 class="panel-title">
                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        Fase Final
                    </a>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                <div class="panel-body">
                </div>
            </div>
        </div>
    </div>
</div>


<script>
//    var requerimientoId;
//    function getCaracteristicas(nombre, tablaCaracteristicas) {
//        tablaCaracteristicas.clear().draw();
//        $('#caracterisitcasTitle').html("Caracteristicas para " + nombre);
//        
//        $.ajax({
//            type: "GET",
//            url: '${pageContext.request.contextPath}/caracteristica',
//            data: {requerimientoId: requerimientoId},
//            success: function(caracteristicas){
//                for(var caracterisitca in caracteristicas){
//                    tablaCaracteristicas.row.add([
//                            caracteristicas[caracterisitca].id, 
//                            caracteristicas[caracterisitca].nombre,
//                            caracteristicas[caracterisitca].descripcion
//                    ]).draw( false );
//                }
//            },
//            error: function (error){
//            }
//        });
//    }
//    
//    function getPerfiles(nombre, tablaPerfil) {
//        tablaPerfil.clear().draw();
//        $('#perfilesTitle').html("probables Perfiles" + nombre);
//        
//        $.ajax({
//            type: "GET",
//            url: '${pageContext.request.contextPath}/perfil',
//            data: {requerimientoId: requerimientoId},
//            success: function(perfiles){
//                for(var perfil in perfiles){
//                    tablaPerfil.row.add([
//                            perfiles[perfil].id, 
//                            perfiles[perfil].nombre,
//                            perfiles[perfil].descripcion
//                    ]).draw( false );
//                }
//            },
//            error: function (error){
//            }
//        });
//    }
//    
//    function asignarPerfil(requerimientoId, perfilId){
//        $.ajax({
//            type: "POST",
//            url: '${pageContext.request.contextPath}/requerimiento',
//            data: {
//                perfilId: perfilId,
//                requerimientoId: requerimientoId
//            },
//            success: function(){
//                location.reload();
//            },
//            error: function (error){
//            }
//        });
//    }
//    
    $(document).ready(function () {
//        var tablaPerfil = $('#tablaPerfil').DataTable();
//        var tablaCaracteristcas = $('#tablaCaracteristcas').DataTable();
        var tablaRequerimientos = $('#tablaRequerimientos').DataTable();

//        $('#tablaRequerimientos tbody').on('click', 'tr', function () {
//            var data = tablaRequerimientos.row(this).data();
//            requerimientoId = data[0];
//            getPerfiles(data[1], tablaPerfil);
//            getCaracteristicas(data[1], tablaCaracteristcas);
//        });
//        
//        $('#tablaPerfil tbody').on('click', 'tr', function () {
//            var data = tablaPerfil.row(this).data();
//            asignarPerfil(requerimientoId,data[0]);
//        });
    });
</script>
<jsp:include page="secciones/Foot.jsp" />