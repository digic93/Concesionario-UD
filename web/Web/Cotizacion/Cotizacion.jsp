<%-- 
    Document   : Cotizacion
    Created on : 3/12/2017, 11:45:32 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne"> 
        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseCotizacion" aria-expanded="true" aria-controls="collapseCotizacion">
            <span class="glyphicon glyphicon-tags" aria-hidden="true"></span> Cotizacion 
        </a>
    </div>
    <div id="collapseCotizacion" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
        <div class="panel-body">
            <div class="row">
                <div class="col-md-4 col-lg-offset-1">
                    <div class="thumbnail">
                        <div class="caption">
                            <h2 id="nombreCliente"></h2>
                            <h4>info Cliente:</h4>
                            <p>
                                <strong>Cedula: </strong><span id="cedulaCliente"></span><br>
                                <strong>Direccion: </strong><span id="diereccionCliente"></span><br>
                                <strong>Fecha Nacimiento: </strong><span id="fechaNacimientoCliente"></span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <h2>
                        Cotizacion <span id="idcotizacion"></span>
                    </h2>
                    <div class="col-md-6">
                        <div class="thumbnail">
                            <div class="caption">
                                <h4>info Vendedor:</h4>
                                <p>
                                    <strong>Nombre: </strong><span id="nombreVendedor"></span><br>
                                    <strong>Apellido: </strong><span id="apellidoVendedor"></span><br>
                                    <strong>Area: </strong><span>Ventas</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="thumbnail">
                            <div class="caption">
                                <h4>info Cotizacion:</h4>
                                <p>
                                    <strong>Estado: </strong><span id="estadoCotizacion"></span><br>
                                    <strong>Fecha Expedicion: </strong><span id="fechaExpedicionCotizacion"></span><br>
                                    <strong>Total: $</strong><span id="totalCotizacion"></span>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-5 col-md-offset-1">
                    <h3>Especificaciones Vehiculo</h3>
                    <hr>
                    <table class="table table-striped" cellspacing="0" width="100%">
                        <thead>
                        </thead>
                        <tbody id="caracteristcas1">
                        </tbody>
                    </table>
                </div>
                <div class="col-md-5">
                    <hr>
                    <table class="table table-striped" cellspacing="0" width="100%">
                        <thead>
                        </thead>
                        <tbody id="caracteristcas2">
                        </tbody>
                    </table>
                    <button id="butonEspecificaciones" onclick="butonEspecificacionesOnclick();" type="button" class="btn btn-primary btn-block"></button>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var butonEspecificacionesOnclick;
    function CargarCotizacionPorId(idcotizacion)
    {
        $.ajax({
            type: "GET",
            url: '${pageContext.request.contextPath}/venta/cotizacion?idcotizacion=' + idcotizacion,
            success: function (cotizacion) {
                cotizacionSuper = cotizacion.cotizacion;
                $("#nombreCliente").empty();
                $("#cedulaCliente").empty();
                $("#diereccionCliente").empty();
                $("#fechaNacimientoCliente").empty();

                $("#nombreCliente").html(cotizacion.cliente.nombre + " " + cotizacion.cliente.apellido);
                $("#cedulaCliente").html(cotizacion.cliente.cedula);
                $("#diereccionCliente").html(cotizacion.cliente.direccionResidencia);
                $("#fechaNacimientoCliente").html(cotizacion.cliente.fechaNacimiento);

                $("#idcotizacion").empty();
                $("#nombreVendedor").empty();
                $("#apellidoVendedor").empty();

                $("#idcotizacion").html(cotizacion.cotizacion.idCotizacion);
                $("#nombreVendedor").html(cotizacion.empleados.nombre);
                $("#apellidoVendedor").html(cotizacion.empleados.apellido);


                $("#estadoCotizacion").empty();
                $("#estadoCotizacion").empty();
                $("#totalCotizacion").empty();

                $("#estadoCotizacion").html("cotizacion");
                $("#fechaExpedicionCotizacion").html(cotizacion.cotizacion.fechaExpedicion);
                $("#totalCotizacion").html(cotizacion.cotizacion.total);

                $("#caracteristcas1").empty();
                $("#caracteristcas2").empty();
                cargarCaracteristicas(cotizacion.caracteristcas, cotizacion.tipoCaracteristicas);
                
                $('#collapseCotizacion').collapse('show');

            },
            error: function (error) {
                alert(error);
            }
        });

        function cargarCaracteristicas(caracteristcas, tipoCaracteristicas) {
            var variable = 1
            for (var caracteristca in caracteristcas) {
                if (variable === 1) {
                    variable++;
                    $("#caracteristcas1").append("<tr><td><strong>" + getTipoCaracteristica(caracteristcas[caracteristca].idTipoCaracteristica, tipoCaracteristicas) + "</strong></td><td>" + caracteristcas[caracteristca].nombre + "</td></tr>");
                } else {
                    variable--;
                    $("#caracteristcas2").append("<tr><td><strong>" + getTipoCaracteristica(caracteristcas[caracteristca].idTipoCaracteristica, tipoCaracteristicas) + "</strong></td><td>" + caracteristcas[caracteristca].nombre + "</td></tr>");

                }
            }
        }

        function getTipoCaracteristica(idTipoCaracteristica, tipoCaracteristicas) {
            for (var tipo in tipoCaracteristicas) {
                if (tipoCaracteristicas[tipo].idTipoCaracteristica === idTipoCaracteristica) {
                    return tipoCaracteristicas[tipo].nombre;
                }
            }

            return "";
        }
    }
</script>