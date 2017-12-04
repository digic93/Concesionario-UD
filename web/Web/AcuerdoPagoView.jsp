<%-- 
    Document   : AcuerdoPago
    Created on : 30/11/2017, 01:14:18 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="secciones/Head.jsp" />
<jsp:include page="Cotizacion/BuscsarCotizacion.jsp" />

<jsp:include page="Cotizacion/Cotizacion.jsp" />
<script>
    var porcentajeAdd;
    var cotizacionSuper;

    var acuerdos = {
        acuerdos30: [],
        acuerdos70: []
    };

    var totalAcuerdo30 = 0;
    var totalAcuerdo70 = 0;
    var totalPorcentajeAcuerdo30 = 0;
    var totalPorcentajeAcuerdo70 = 0;

    $(document).ready(function () {
        ModoBusquedaCotizacion = "cotizacionPorCCCliente";
        $("#butonEspecificaciones").html('<span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span>  Acuerdo De Pago!');
    });

    clickOnCotizacion = function (idCotizacion) {
        CargarCotizacionPorId(idCotizacion);
    }

    butonEspecificacionesOnclick = function () {
        var total = parseInt(cotizacionSuper.total);
        $("#total30").html("$" + (total * 0.3));
        $("#total70").html("$" + (total * 0.7));
        $("#collapseAcuerdoPago").collapse('show');
    }

    function setPorcentaje(porcentanje) {

        porcentajeAdd = porcentanje;
        if (porcentajeAdd === 30) {
            $("#porcentajeAcuerdo").val(100 - totalPorcentajeAcuerdo30);
        } else {
            $("#porcentajeAcuerdo").val(100 - totalPorcentajeAcuerdo70);
        }
    }

    function agregarAcuerdopago() {
        if (porcentajeAdd === 30) {
            if (totalPorcentajeAcuerdo30 == 100) {
                alert("Porcentaje ya completado");
            } else {
                var total = parseInt(cotizacionSuper.total) * 0.3 * parseInt($("#porcentajeAcuerdo").val()) / 100;
                $("#acuerdos30").append("<tr><td>" + $("#porcentajeAcuerdo").val() + "%</td><td></td><td></td><td>$" + total + "</td></tr>");
                totalAcuerdo30 += total;
                totalPorcentajeAcuerdo30 += parseInt($("#porcentajeAcuerdo").val());
                $("#totalAcuerdo30").html("$" + totalAcuerdo30);
                $("#totalPorcentajeAcuerdo30").html(totalPorcentajeAcuerdo30 + "%");
            }
        } else {
            if (totalPorcentajeAcuerdo70 == 100) {
                alert("Porcentaje ya completado");
            } else {
                var total = parseInt(cotizacionSuper.total) * 0.7 * parseInt($("#porcentajeAcuerdo").val()) / 100;
                $("#acuerdos70").append("<tr><td>" + $("#porcentajeAcuerdo").val() + "%</td><td></td><td></td><td>$" + total + "</td></tr>");
                totalAcuerdo70 += total;
                totalPorcentajeAcuerdo70 += parseInt($("#porcentajeAcuerdo").val());
                $("#totalAcuerdo70").html("$" + totalAcuerdo70);
                $("#totalPorcentajeAcuerdo70").html(totalPorcentajeAcuerdo70 + "%");
            }
        }

        $("#porcentajeAcuerdo").val("");
        $("#valorPagar").val("");
    }

    function valorPagarChange() {
        var valor = parseInt($("#porcentajeAcuerdo").val());
        var total = 0;

        if (porcentajeAdd === 30) {
            total = parseInt(cotizacionSuper.total) * 0.3;
            if (totalPorcentajeAcuerdo30 + valor > 100)
                valor = 100 - totalPorcentajeAcuerdo30;
        } else {
            total = parseInt(cotizacionSuper.total) * 0.7;
            if (totalPorcentajeAcuerdo70 + valor > 100)
                valor = 100 - totalPorcentajeAcuerdo70;
        }
        $("#porcentajeAcuerdo").val(valor);
        total = total * valor / 100;

        $("#valorPagar").val("$" + total);
    }
</script>
<div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne"> 
        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseAcuerdoPago" aria-expanded="true" aria-controls="collapseAcuerdoPago">
            <span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span> Acuerdo Pago
        </a>
    </div>
    <div id="collapseAcuerdoPago" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
        <div class="panel-body">
            <div class="col-md-5 col-md-offset-1">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>Acuerdo 30% <small id="total30"></small></h3>
                        <table class="table table-striped" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>porcentaje</th>
                                    <th>Metodo</th>
                                    <th></th>
                                    <th>valor</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th id="totalPorcentajeAcuerdo30">0%</th>
                                    <th></th>
                                    <th>total</th>
                                    <th id="totalAcuerdo30">$0</th>
                                </tr>
                            </tfoot>
                            <tbody id="acuerdos30">
                            </tbody>
                        </table>
                        <button type="button" onclick="setPorcentaje(30);" class="btn btn-success btn-sm" data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Agregar 
                        </button>
                    </div>
                </div>
            </div>
            <div class="col-md-5">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>Acuerdo 70% <small id="total70"></small></h3>
                        <table class="table table-striped" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>porcentaje</th>
                                    <th>Metodo</th>
                                    <th></th>
                                    <th>valor</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th id="totalPorcentajeAcuerdo70">0%</th>
                                    <th></th>
                                    <th>total</th>
                                    <th id="totalAcuerdo70">$1020202</th>
                                </tr>
                            </tfoot>
                            <tbody id="acuerdos70">
                            </tbody>
                        </table>

                        <button type="button" onclick="setPorcentaje(70);" class="btn btn-success btn-sm" data-toggle="modal" data-target="#myModal">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Agregar 
                        </button>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <button type="button" class="btn btn-primary btn-ls">
                        <span class="glyphicon glyphicon-check" aria-hidden="true"></span> Separar Auto 
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Agregar Acuerdo Pago</h4>
            </div>
            <div class="modal-body">

                <div class="form-horizontal">
                    <fieldset>
                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="textinput">Porcentaje</label>  
                            <div class="col-md-4">
                                <input id="porcentajeAcuerdo" onchange="valorPagarChange();" min="1" max="100" type="number" placeholder="100%" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="selectbasic">Metodo Pago</label>
                            <div class="col-md-4">
                                <select id="metodoAcuerdo" name="selectbasic" class="form-control">
                                    <option value="1">Efectivo</option>
                                    <option value="2">Tarjeta Debito</option>
                                    <option value="3">Tarjeta Credito</option>
                                    <option value="4">Credito Bancario</option>
                                </select>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="selectbasic">Banco Aliado</label>
                            <div class="col-md-4">
                                <select id="selectbasic" name="selectbasic" class="form-control">
                                    <option value="1">Banco Bogota</option>
                                    <option value="2">BanColombia</option>
                                </select>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="textinput">Valor a pagar</label>  
                            <div class="col-md-4">
                                <input id="valorPagar" name="textinput" type="text" placeholder="placeholder" class="form-control input-md" disabled="true">
                            </div>
                        </div>
                    </fieldset>
                </div> 
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button onclick="agregarAcuerdopago();" type="button" class="btn btn-primary">Agregar</button>
            </div>
        </div>
    </div>
</div>

<jsp:include page="secciones/Foot.jsp" />


