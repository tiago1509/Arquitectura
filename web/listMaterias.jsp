<%-- 
    Document   : listAccounts
    Created on : 27/01/2017, 08:52:24 PM
    Author     : brian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1>Lista de Materias</h1>
        
        <c:forEach var="a" items="${materia}">
          
           |${a.code}| |${a.name}| |${a.credits}| |${a.horary}| |${a.capacity}| 
           
           
           <button onclick="return confirm('Esta seguro?')" name="materia" id=${a.id}>Aceptar</button>  
             
           
           <hr/>
        </c:forEach>  
        
    </body>
</html>


