<%-- 
    Document   : Cotizacion
    Created on : 3/12/2017, 11:45:32 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="panel panel-primary">
    <div class="panel-heading ">
        <span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Cotizacion 
    </div>
    <div class="panel-body">
        <div class="row">
            <div class="col-md-4 col-lg-offset-1">
                <div class="thumbnail">
                    <div class="caption">
                        <h2>Diego Alejandro Castro</h2>
                        <p>
                            <strong>Cedula: </strong><span>12312312</span>
                        <h4>Contactos:</h4>
                        <ul>
                            <li>123412</li>
                            <li>321100932</li>
                            <li>DiegoAlejandro@gmail.com</li>
                        </ul>
                        </p>

                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <h2>
                    Cotizacion 12
                </h2>
                <div class="col-md-6">
                    <table class="table table-striped" cellspacing="0" width="100%">
                        <thead>
                        </thead>
                        <tbody id="rowCaracteristica1">
                        </tbody>
                    </table>
                </div>
                <div class="col-md-6">
                    <table class="table table-striped" cellspacing="0" width="100%">
                        <thead>
                        </thead>
                        <tbody id="rowCaracteristica2">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function CargarCotizacionPorId(idcotizacion)
    {
              $.ajax({
            type: "GET",
            url: '${pageContext.request.contextPath}/venta/cotizacion?idcotizacion=' + idcotizacion,
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
</script>