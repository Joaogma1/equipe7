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
        <title>Produtos</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://kit.fontawesome.com/9c0fa98e72.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
    </head>
    <body>
        <%@include file="/PaginaBase/navUsuarioLogado.jsp" %>
        <c:choose>
            <c:when test="${sessionScope.usuario != null}">
                <div style="margin-top: 1em;" class="container">
                    <form>
                        <div class="form-group">
                            <label></label> 
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <i class="fa fa-shopping-bag"></i>
                                    </div>
                                </div> 
                                <input id="nome" name="nome" placeholder="Nome do Produto" type="text" required="required" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label></label> 
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <i class="fa fa-money"></i>
                                    </div>
                                </div> 
                                <input id="preco" name="preco" placeholder="Preco" type="number"  min="1" step="any" required="required" class="form-control">
                            </div>
                        </div> 
                        <div class="container">
                            <div class="row">
                                <div class="col text-center">
                                    <button name="submit" type="button" onclick="Enviar()" class="btn btn-success">Cadastrar</button>
                                </div>
                            </div>
                        </div>
                    </form>
                    <div style="margin-top: 2em" class=" d-flex justify-content-center">

                        <table class="text-center table table-hover col-md-6">
                            <thead>
                                <tr>
                                    <th scope="col">Nome Produto</th>
                                    <th scope="col">Preco</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${lista}" var="Produto">
                                    <tr>
                                        <th><c:out value="${Produto.nomeProduto}"/></th>>
                                        <th>R$<c:out value="${Produto.preco}"/></th>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div>
                    <p>Usuário não fez login</p>
                </div>
            </c:otherwise>
        </c:choose>


    </body>
    <script>
                async  function Enviar() {
                let val = 0;
                        await $.ajax({
                        url: '${pageContext.request.contextPath}/produto',
                                type: 'POST',
                                data: {
                                id: val,
                                        nome: $('#nome').val(),
                                        preco: $('#preco').val()
                                },
                                success: function (data, textStatus, jqXHR) {
                                alert("Cadastrado com sucesso !")
                                }
                        }).then(window.location.reload())
                }
    </script>
</html>
