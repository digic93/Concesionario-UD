<%-- 
    Document   : AcuerdoPago
    Created on : 30/11/2017, 01:14:18 PM
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
