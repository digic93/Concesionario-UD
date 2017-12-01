<%-- 
    Document   : Foot
    Created on : 04-jun-2017, 9:59:05
    Author     : Diego Castro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
</div>
<div class="col-md-1">
</div>
</div>
</div>
</body>

<script type="text/javascript">
    Reloj();
    function Reloj() {
        var tiempo = new Date();
        var hora = tiempo.getHours();
        var minuto = tiempo.getMinutes();
        var segundo = tiempo.getSeconds();
        var horaFecha = tiempo.getFullYear() + "/" + (tiempo.getMonth()+1) + "/" + tiempo.getDate()+ " " + hora + ":" + minuto + ":" + segundo;
        
        $("#horaSistema").html(horaFecha);
        
        setTimeout('Reloj()', 1000);

    }
</script>
</html>
