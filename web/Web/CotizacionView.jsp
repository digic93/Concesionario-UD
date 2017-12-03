<%-- 
    Document   : CotizacionView
    Created on : 30/11/2017, 05:44:29 PM
    Author     : Santiag
--%>


<%@page import="com.udistrital.ConcesionarioUD.modelo.bean.TipoCaracteristica"%>
<%@page import="com.udistrital.ConcesionarioUD.modelo.bean.Auto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.udistrital.ConcesionarioUD.modelo.bean.Cliente"%>
<%@page import="com.udistrital.ConcesionarioUD.modelo.bean.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="secciones/Head.jsp" />

<% 
    HttpSession sesion = request.getSession();            
    Empleado e = (Empleado)sesion.getAttribute("empleado");
    Cliente c = (Cliente)sesion.getAttribute("cliente");
    
    ArrayList<Auto> vehiculos = (ArrayList)sesion.getAttribute("vehiculos");
    
%>
            
<h1>Gestión de Cotización</h1>


<p>Agente de Ventas: <strong>
    <%out.println(e.getNombre()+" "+e.getApellido()); %>               
    </strong>
</p>

<strong><p>Seleccionar Cliente</p></strong>
<!--Formulario para consultar el cliente y traerlo...-->
<form role="form" class="registration-form">
    <div class="form-group">
        <label class="sr-only" for="cedula">Cédula Cliente</label>
        <input type="text" id="cedula" name="cedula" placeholder="Cédula Cliente..." class="form-control">
    </div>
    <input id="buscar" type="button" class="btn btn-success btn-xs" value="Buscar" />
</form>

<!--Se muestra en tabla los datos del cliente-->
<center>
    <strong><p>Datos Cliente</p></strong>

    <table id="table" class="table" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Cédula</th>
                <th>Datos de Contacto</th>        
            </tr>
        </thead>
        <tbody id="bodyTable">
            <tr>
                <%if(sesion.getAttribute("cliente")!= null){%>
                    <th></th>
                    <th></th>
                    <th></th>                      
                <%}else {%>   
                    <th></th>
                    <th></th>
                    <th></th>
                <%}%>
                
            </tr>
            

            <!--Imprimir los datos del cliente-->
        </tbody>

    </table>
</center>
<strong><p>Seleccionar Vehículo</p></strong>


<form role="form" class="registration-form">
    <div class="form-group">
        <label class="sr-only" for="vehiculo">Seleccionar Vehículo</label>        
        <input id="vehiculo" placeholder="Seleccione VIN vehículo" list="vehiculos" name="vehiculo" class="form-control">
        <datalist id="vehiculos">  

        <% 
            for (Auto vehiculo : vehiculos) {
                out.print("<option value='" + vehiculo.getVin() + "'>");
            }
        %>
        <!--<option value="Skoda">  -->
        </datalist>
    </div>
    <input id="seleccionar" type="button" class="btn btn-success btn-xs" value="Seleccionar"/>
</form>
    
        
<center>
    <strong><p>Datos Vehículo</p></strong>

    <table id="table" class="table" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Tipo Caracteristica</th>
                <th>Nombre</th>
                <th>Descripcion Caracteristica </th>        
            </tr>
        </thead>
        <tbody id="bodyTableCaracteristica">
            
            
            

            <!--Imprimir los datos del cliente-->
        </tbody>

    </table>
</center> 
        <center>
            <br>
            <br>
            <input id="buscarParte" type="button" class="btn btn-success btn-xs" value="Consultar Partes"/>
            <br>
            <br>
        </center>    
        
        
<center>
    <strong><p>Datos Partes</p></strong>
    
    <form role="form" class="registration-form">

        <table id="table" class="table" class="display" cellspacing="0" width="100%">
            <thead>
                <tr>
                    
                    <th>Número</th>
                    <th>Tipo Parte</th>
                    <th>Nombre Parte</th>
                    <th>Precio </th>                    
                    <th>Adicionar a la cotización </th> 
                    
                </tr>
            </thead>

            <tbody id="bodyTablePartes">
     



            </tbody>

        </table>
        <input id="cotizar" type="button" class="btn btn-success btn-xs" value="Generar Cotización"/>
    </form>
</center>   
        
        <center id="total">
                        
        </center>
        
        <br>
        <br>
        <br>

<script>

$(document).ready(function() { 

    $("#buscar").click(function() { 
        

        
         $.ajax({
           type: "POST",
           url: "${pageContext.request.contextPath}/buscarCliente",
           data: {
             cedula: $("#cedula").val()           
           },
           success: function(result) {
               
               console.log(result);
               if(result=='n')  {
                   alert('Usuario No Encontrado');                      
                   $("#bodyTable").html("");
               }
               else{
                   alert('Usuario Encontrado');
                   $("#bodyTable").html(result);
               }                 
             
           },
           error: function(result) {
             alert('Error');
           }
         });
         //$("#cedula").val("");
     }); 

    $("#seleccionar").click(function() {        
        $.ajax({
          type: "POST",
          url: "${pageContext.request.contextPath}/buscarVehiculo",
          data: {
            vin: $("#vehiculo").val()           
          },
          success: function(result) {
               console.log(result);
               if(result=='n'){
                   alert("No se encontro el vehículo");
               }else{
                   alert("Se encontro el vehículo, se describen caracteristicas");
                   $("#bodyTableCaracteristica").html(result);
               }    
               
          },
          error: function(result) {
            alert('No se puede iniciar la cotización');
          }
        });
    }); 
    
    $("#buscarParte").click(function() {        
        $.ajax({
          type: "POST",
          url: "${pageContext.request.contextPath}/buscarParte",
          
          success: function(result) {
               console.log(result);
               if(result=='n'){
                   alert("No se encontro partes");
               }else{
                   $("#bodyTablePartes").html(result);
               }    
               
          },
          error: function(result) {
            alert('No se puede iniciar la cotización');
          }
        });
    });
    
    $("#cotizar").click(function() {     
    
        var checkbox_value = [];
        $(":checkbox").each(function () {
            var ischecked = $(this).is(":checked");
            if (ischecked) {
                checkbox_value.push($(this).val());
            }
        });
        //alert(checkbox_value);
        
        $.ajax({
          type: "POST",
          url: "${pageContext.request.contextPath}/cotizacion",
          data: {
            vin: $("#vehiculo").val(),
            cedula: $("#cedula").val(),
            partes: checkbox_value
    
          },
          success: function(result) {
               console.log(result);
               if(result=='n'){
                   alert("No se completo la cotizacion");
               }else{
                   alert("Se ha realizado la cotización");
                   $("#total").html(result);
               }    
               
          },
          error: function(result) {
            alert('No se puede realizar la cotización');
          }
        });
    }); 



});
    
</script>


<jsp:include page="secciones/Foot.jsp" />
