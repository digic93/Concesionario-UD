<%-- 
    Document   : BuscsarCotizacion
    Created on : 30/11/2017, 01:15:48 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--____________________________________________________________________________________-->
<div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne"> 
        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseBuscarCotizacion" aria-expanded="true" aria-controls="collapseBuscarCotizacion">
            <span class="glyphicon glyphicon-search" aria-hidden="true"></span> Buscar Cotizacion 
        </a>
    </div>
    <div id="collapseBuscarCotizacion" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
        <div class="panel-body">
            <div class="col-md-10 col-md-offset-1">

                <div class="well well-sm">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon2">C.C</span>
                        <input id="cedulaBusqueda" type="number" min="0" class="form-control" placeholder="Cédula Cliente" aria-describedby="sizing-addon2" >
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button"  onclick="buscar();">Buscar</button>
                        </span>
                    </div>
                </div>

                <table id="buquedaCotizacion" class="table table-striped" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>Cotizacion</th>
                            <th>Total</th>
                            <th>Fecha</th>
                            <th>Cliente</th>
                            <th>Vendedor</th>
                            <th>Vehiculo</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody id="buquedaCotizacionBody">
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</div>
<script>
    var clickOnCotizacion;
    var ModoBusquedaCotizacion;
    
    function buscar() {
        $.ajax({
            type: "GET",
            url: '${pageContext.request.contextPath}/venta/busar?busqueda=' + ModoBusquedaCotizacion + '&valor=' + $("#cedulaBusqueda").val(),
            success: function (cotizaciones) {
                $("#buquedaCotizacionBody").empty();
                
                for(var cotizacion in cotizaciones){
                    $("#buquedaCotizacionBody").append(getRow(cotizaciones[cotizacion]));
                }
            },
            error: function (error) {
                alert(error);
            }
        });
    }
    
    function getRow(cotizacion){
        return "<tr>\
                <td>" + cotizacion.cotizacion.idCotizacion + "</td>\
                <td>$" + cotizacion.cotizacion.total + "</td>\
                <td>" + cotizacion.cotizacion.fechaExpedicion + "</td>\
                <td>" + cotizacion.cliente.nombre + " " + cotizacion.cliente.apellido + "</td>\
                <td>" + cotizacion.empleado.nombre + " " + cotizacion.empleado.apellido + "</td>\
                <td>" + cotizacion.caracteristca.nombre + "</td>\
                <td><button class=\"btn btn-success\" type=\"button\" onclick=\"verCotizacion(this);\" data-idcotizacion=\"" + cotizacion.cotizacion.idCotizacion + "\">Ver</button></td>\
            </tr>"
    }    
    
    function verCotizacion(btncotiazacion){
        var idCotizacion = $(btncotiazacion).data("idcotizacion"); 
        clickOnCotizacion(idCotizacion);
        $('#collapseBuscarCotizacion').collapse('toggle');
    }
    
</script>