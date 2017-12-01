<%-- 
    Document   : CotizacionView
    Created on : 30/11/2017, 05:44:29 PM
    Author     : Santiag
--%>


<%@page import="com.udistrital.ConcesionarioUD.modelo.bean.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="secciones/Head.jsp" />
<h1>Gestión de Cotización</h1>


<p>Agente de Ventas: </p>

<strong><p>Seleccionar Cliente</p></strong>
<!--Formulario para consultar el cliente y traerlo...-->
<form role="form" action="" method="POST" class="registration-form">
    <div class="form-group">
        <label class="sr-only" for="cedula">Cédula Cliente</label>
        <input type="text" id="cedula" name="cedula" placeholder="Cédula Cliente..." class="form-control">
    </div>
    <button id="buscar" type="submit" class="btn">Buscar</button>
</form>

<!--Se muestra en tabla los datos del cliente-->
<strong><p>Datos Cliente</p></strong>

<table class="table" class="display" cellspacing="0" width="100%">
    <thead>
        <tr>
            <th>Nombre</th>
            <th>Cédula</th>
            <th>Datos de Contacto</th>        
        </tr>
    </thead>
    <tbody>
        
        <!--Imprimir los datos del cliente-->
    </tbody>
    
</table>
<strong><p>Seleccionar Vehículo</p></strong>


<form role="form" action="" method="POST" class="registration-form">
    <div class="form-group">
        <label class="sr-only" for="vehiculo">Seleccionar Vehículo</label>        
        <input id="vehiculo" list="vehiculos" name="vehiculo" class="form-control">
        <datalist id="vehiculos">  
        <!-- Traer y generar dinamicamente todos los vehiculos existentes
              Ej:
                  <option value="Skoda">      
        -->
        </datalist>
    </div>
    <button id="seleccionar" type="submit" class="btn">Seleccionar</button>
</form>


<script>
$(document).ready(function() {    
    $("#buscar").click(function(e) {        
        $.ajax({
          type: "POST",
          url: "${pageContext.request.contextPath}/buscarCliente",
          data: {
            cedula: $("#cedula").val()           
          },
          success: function(result) {
            alert('Usuario Encontrado');
          },
          error: function(result) {
            alert('Usuario No Encontrado');
          }
        });
    });
    
    $("#seleccionar").click(function(e) {        
        $.ajax({
          type: "POST",
          url: "${pageContext.request.contextPath}/buscarVehiculo",
          data: {
            nombre: $("#vehiculo").val()           
          },
          success: function(result) {
            alert('Se inicia la cotización');
          },
          error: function(result) {
            alert('No se puede iniciar la cotización');
          }
        });
    });
}   
    
</script>


<jsp:include page="secciones/Foot.jsp" />
