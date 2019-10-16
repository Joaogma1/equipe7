<%-- 
    Document   : testUsuario
    Created on : 16/10/2019, 03:21:36
    Author     : Administrador
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Teste</h1>
        <p>Data e hora de acesso: <fmt:formatDate value="${dtAcesso}" pattern="dd/MM/yyyy - HH:mm:ss"/></p>
</body>
</html>