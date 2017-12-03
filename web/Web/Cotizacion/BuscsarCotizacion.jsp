<%-- 
    Document   : BuscsarCotizacion
    Created on : 30/11/2017, 01:15:48 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <input id="cedulaBusqueda" type="number" min="0" class="form-control" placeholder="Cedula Cliente" aria-describedby="sizing-addon2" >
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button"  onclick="buscar();">Bucar</button>
                        </span>
                    </div>
                </div>

                <table id="buquedaCotizacion" class="table table-striped" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>Cliente</th>
                            <th>Cotizacion</th>
                            <th>Valor</th>
                            <th>Vehiculo</th>
                            <th>Fecha</th>
                            <th>Estado</th>
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
    var ModoBusquedaCotizacion;
    $(document).ready(function () {
        //$('#buquedaCotizacion').DataTable();    
    });
    
    function buscar() {
        $.ajax({
            type: "GET",
            url: '${pageContext.request.contextPath}/venta/busar?busqueda=' + ModoBusquedaCotizacion + '&valor=' + $("#cedulaBusqueda").val(),
            success: function (cotizaciones) {
                var cotizacionesobj = JSON.parse(cotizaciones);
                
                $("#buquedaCotizacionBody").empty();
                
                for(var cotizacion in cotizacionesobj.result){
                    $("#buquedaCotizacionBody").append(getRow(cotizacionesobj.result[cotizacion]));
                }
                //add(cotizaciones);
            },
            error: function (error) {
                alert(error);
            }
        });
    }
    
    function getRow(cotizacion){
        return "<tr>\
                <td>" + cotizacion.clietne.nombre + "</td>\
                <td>" + cotizacion.cotizacion.idCotizacion + "</td>\
                <td>$" + cotizacion.cotizacion.valor + "</td>\
                <td>" + cotizacion.auto.marca + " " + cotizacion.auto.linea + "</td>\
                <td>" + cotizacion.cotizacion.fechaExpedicion + "</td>\
                <td>" + cotizacion.cotizacion.estado + "</td>\
                <td><button class=\"btn btn-success\" type=\"button\" onclick=\"verCotizacion(this);\" data-idcotizacion=\"" + cotizacion.cotizacion.idCotizacion + "\">Ver</button></td>\
            </tr>"
    }    
    
    function verCotizacion(idCotizacion){
        alert($(idCotizacion).data("idcotizacion"));
    }
</script>