<%-- 
    Document   : AcuerdoPago
    Created on : 30/11/2017, 01:14:18 PM
    Author     : Dell
--%>

<%@page import="com.udistrital.ConcesionarioUD.modelo.bean.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="secciones/Head.jsp" />
<jsp:include page="Cotizacion/BuscsarCotizacion.jsp" />

<jsp:include page="Cotizacion/Cotizacion.jsp" />

<% 
    HttpSession sesion = request.getSession();            
    Empleado e = (Empleado)sesion.getAttribute("empleado");
    
    
%>
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
        //ModoBusquedaCotizacion = "cotizacionAprobarCreditoPorCCCliente";
        ModoBusquedaCotizacion ="cotizacionEstudioCreditoPorCCCliente"
        $("#butonEspecificaciones").html('<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>  Credito Aprobado!');
    });

    clickOnCotizacion = function (idCotizacion) {
        CargarCotizacionPorId(idCotizacion);
    }

    butonEspecificacionesOnclick = function () {
        console.log("Guardar Estudio Credito");
        console.log($('#idcotizacion').text());
        $.ajax({
            type: "POST",
            url: '${pageContext.request.contextPath}/venta/estudioCredito' ,
            data: {
                cotizacion: $('#idcotizacion').text(),
                empleado: <%out.print(e.getIdEmpelado());%>
            },
            success: function(result) {
                if(result!='n'){
                    console.log(result);
                    alert(result);
                }

            },
            error: function(result) {
              alert('No se puede iniciar la cotización');
            }
        });
    }

</script>
<jsp:include page="secciones/Foot.jsp" />


