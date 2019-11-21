<%@ page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Areas de atuacoes</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://kit.fontawesome.com/9c0fa98e72.js" crossorigin="anonymous"></script>
    </head>
    <body>


        <%@include file="/PaginaBase/navUsuarioLogado.jsp" %>
        <h1 style="margin-top: 1em" class="text-center text-uppercase">Areas de atuacao</h1>
        <div class=" d-flex justify-content-around">
            <table class="text-center table table-hover col-md-6">
                <thead>
                    <tr>
                        <th scope="col">Cargo</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${lista}" var="tipousuario">
                        <tr>
                            <th>R$<c:out value="${tipousuario.cargo}"/></th>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>




    </body>
</html>
