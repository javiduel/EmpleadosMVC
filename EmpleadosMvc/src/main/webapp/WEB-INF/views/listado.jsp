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
<table>
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