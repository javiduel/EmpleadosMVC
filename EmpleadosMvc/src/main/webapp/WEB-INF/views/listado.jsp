<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src ='<c:url value="/resources/js/jquery-1.11.1.min.js"/>'></script>
<title>Insert title here</title>
</head>

<body>
Buscar:<input type="text" id="txtBuscar" placeholder="pon tu busqueda">
<input type="button" id="btnBuscar" value="buscar">
<table id="tblDatos">
<c:forEach items="${empleados}" var="empleado">
 <tr>
   <td>${empleado.nombre }</td>
   <td>${empleado.salario }</td>
    <td><a href="detalle.html?id=${empleado.idEmpleado }"> Ver detalle</a></td>
  
    <td><a href="#" id="lnkDetalle" onclick="evento(${empleado.idEmpleado})"> detalle Ajas</a></td>
  </tr>
   </c:forEach>
</table>
<div id="divDetalle"></div>
<script type="text/javascript">
function buscar(){

	var tx=$("#txtBuscar").val();
	var url="empleado/buscar/"+txt;
	$.get(url,function(res)){
            var  tabla=$("#tblDatos");
            $("tr").each(function()){
                 $(this).remove();
                });
             
           
                   for(var i=0;i<res.length;i++){
                       var h="<tr>";
                        h+="<td>"+res[i].nombre+"</td>";
                        h+="<td>"+res[i].salario+"</td>";
                        h+="<td><a href='detalle.html?id="+res[i].idEmpleado+"'>Detalle</a>";
                        h+="<a href='#' onclick='evento("+res[i].idEmpleado+")'>Detalle ajax</a></td>";
                        h+="</tr>";
                        tabla.append(h);
	         } 
                        

      		});
	
}




function evento(id){
  	var url="empleado/"+id;
  	$.get(url,function(res){
var resultado="<ul>";
   resultado+="<li>"+ res.nombre+"<li>";
   resultado+="<li>"+ res.salario+"<li>";
   resultado+="<li>"+ res.puesto.nombre+"<li>";
   resultado+="<li>"+ res.departamento.nombre+"<li>";
   $("#divDetalle").html(resultado);
  	});
	
}

</script>

</body>
</html>