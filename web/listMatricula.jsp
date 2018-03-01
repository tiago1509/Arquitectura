<%-- 
    Document   : listMatricula
    Created on : 1/03/2018, 02:15:02 PM
    Author     : Personal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Materias</h1>
         <jsp:include page="menu.jsp"></jsp:include>
        <h1>Lista de Materias</h1>
        <c:forEach var="a" items="${materia}">
             <h1>Codigo</h1> ${a.code} <h1> Nombre</h1> ${a.name}  |${a.credits}| |${a.horary}| |${a.capacity}|            
            <a onclick="return confirm('Esta seguro?')" href="ServletLab?action=enrollment&id=${a.code}">Aceptar</a>
            
            <hr/>   
        </c:forEach>  
        
        
        
        
        
    </body>
</html>
