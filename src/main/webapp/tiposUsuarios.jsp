<%-- 
    Document   : tiposUsuarios
    Created on : 18/10/2019, 10:42:34
    Author     : Administrador
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Tipos de usuarios no sistema</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet">
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://kit.fontawesome.com/9c0fa98e72.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">

            <a class="navbar-brand" href="${pageContext.request.contextPath}">
                <img src="${pageContext.request.contextPath}/images/logo.png" height="50" width="50" alt="logo empresa"/>
                Distribuidora
            </a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

        </nav>
        <form class="d-flex justify-content-center" action="${pageContext.request.contextPath}/tipoUsuario" method="post">
            <div class="form-row align-items-center">
                <div class="col-auto">
                    <label class="sr-only" for="nome">nome</label>
                    <input type="text" class="form-control mb-2" id="nome" name="nome" placeholder="Nome do cargo">
                    <small id="nomeHelper" class="form-text text-muted">Cadastrar um novo cargo dara acesso minimo ao sistema.</small>
                </div>

                <div class="col-auto">
                    <button type="submit" class="btn btn-primary mb-2">Cadastrar</button>
                    <small style="visibility: hidden" id="nomeHelper" class="form-text text-muted">Gambiarra</small>
                </div>
            </div>
        </form>

        <table class=" table table-hover col-md-6">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Cargo</th>
                    <th scope="col">Opcoes</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${lista}" var="tipoUsuario">
                    <tr>
                        <th scope="row"><c:out value="${tipoUsuario.id}" /></th>
                        <th><c:out value="${tipoUsuario.nome}" /></th>
                        <td><a style="color: black"><i class="fas fa-pencil-alt"></i></a> | <a style="color: red"><i  class="fas fa-trash-alt"></i></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
