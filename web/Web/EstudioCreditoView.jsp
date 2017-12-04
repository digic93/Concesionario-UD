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
    var flagCreditoBanco = false;

    $(document).ready(function () {
        ModoBusquedaCotizacion = "cotizacionAprobarCreditoPorCCCliente";
        $("#butonEspecificaciones").html('<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>  Credito Aprobado!');
    });

    clickOnCotizacion = function (idCotizacion) {
        CargarCotizacionPorId(idCotizacion);
    }

    butonEspecificacionesOnclick = function () {
    }

</script>
<jsp:include page="secciones/Foot.jsp" />


