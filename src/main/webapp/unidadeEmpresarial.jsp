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
        <title>Unidades</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://kit.fontawesome.com/9c0fa98e72.js" crossorigin="anonymous"></script>
    </head>
    <body>


        <%@include file="/PaginaBase/navUsuarioLogado.jsp" %>
        <h1 class="text-uppercase text-center">Unidades</h1>
        
        <div style="margin-top: 1em;" class="container">
            <div class=" d-flex justify-content-around">
                <table class="text-center table table-hover col-md-6">
                    <thead>
                        <tr>

                            <th scope="col">Nome Unidade</th>
                            <th scope="col">Opcoes</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${lista}" var="unidadeEmp">
                            <tr>

                                <th><c:out value="${unidadeEmp.nomeUnidade}" /> </th>
                                <th>
                                    <button type="button" class="btn btn-outline-warning" data-toggle="modal" data-target="#modal${unidadeEmp.id}">Editar</button> 
                                </th>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
            </div>


            <c:forEach items="${lista}" var="unidadeEmp">

                <div class="modal fade" id="modal${unidadeEmp.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel"><c:out value="${unidadeEmp.nomeUnidade}"/></h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div>
                                    <input type="hidden" value="atualizar" name="acao">
                                    <input type="hidden" value=${unidadeEmp.id} name="id">

                                    <div class="form-group">
                                        <label for="nomeEditado${unidadeEmp.id}" class="col-form-label">Nome do Cargo:</label>
                                        <input type="text" value="${unidadeEmp.nomeUnidade}" name="nome" class="form-control" id="nomeEditado${unidadeEmp.id}">
                                    </div>
                                    <button onclick="Atualizar(${unidadeEmp.id})" class="btn btn-primary btn-default">Salvar Mudancas</button>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </c:forEach>

    </body>
    <script>
                async function Atualizar(id){
                await $.ajax({
                url: '${pageContext.request.contextPath}/unidadeempresarial',
                        type: 'POST',
                        data: {
                        'nome': $('#nomeEditado' + id).val(),
                                'id': id
                        }
                })
                        .then(window.location.reload())
                }
    </script>
</html>