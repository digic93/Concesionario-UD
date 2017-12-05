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
   

    $(document).ready(function () {
        ModoBusquedaCotizacion = "cotizacionSepararAutoPorCCCliente";
        //ModoBusquedaCotizacion ="cotizacionEstudioCreditoPorCCCliente"
        $("#butonEspecificaciones").html('<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>  Separar Auto!');
    });

    clickOnCotizacion = function (idCotizacion) {
        CargarCotizacionPorId(idCotizacion);
    }

    butonEspecificacionesOnclick = function () {
    }

</script>
<jsp:include page="secciones/Foot.jsp" />


