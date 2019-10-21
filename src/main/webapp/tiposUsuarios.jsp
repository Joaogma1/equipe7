<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Tipos de usuarios no sistema</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://kit.fontawesome.com/9c0fa98e72.js" crossorigin="anonymous"></script>
    </head>
    <body>


        <%@include file="/PaginaBase/navUsuarioLogado.jsp" %>
        <div style="margin-top: 1em;" class="d-flex justify-content-center form-inline">

            <div class="form-group mb-2">
                <div class="col-auto">
                    <label class="sr-only" for="nome">nome</label>
                    <input type="text" class="form-control mb-2" id="nome" name="nome" placeholder="Nome do cargo">

                </div>
                <div class="form-group mx-sm-3 mb-2">
                    <select  name="nivelacesso" class="form-control" id="nivelAcesso">
                        <option selected="selected" disabled="true"> nivel de acesso</option>
                        <option value="1" >1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>
                </div>

                <div class="col-auto">
                    <button onclick="Enviar()" type="submit" class="btn btn-success mb-2">Cadastrar</button>
                </div>
            </div>
        </div>
        <div class=" d-flex justify-content-around">
            <table class="text-center table table-hover col-md-6">
                <thead>
                    <tr>
                        <th scope="col">Cargo</th>
                        <th scope="col">Nivel de acesso</th>
                        <th scope="col">Opcoes</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${lista}" var="tipousuario">
                        <tr>
                            <th><c:out value="${tipousuario.nome}" /></th>
                            <th><c:out value="${tipousuario.nivel}" /> </th>
                            <th><input type="button" value="Deletar" onclick="Deletar(${tipousuario.id})"class="btn btn-outline-danger"> 
                                <button type="button" class="btn btn-outline-warning" data-toggle="modal" data-target="#modal${tipousuario.id}">Editar</button> 
                            </th>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>
        </div>


        <c:forEach items="${lista}" var="tipousuario">

            <div class="modal fade" id="modal${tipousuario.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel"><c:out value="${tipousuario.nome}"/></h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div>
                                <input type="hidden" value="atualizar" name="acao">
                                <input type="hidden" value=${tipousuario.id} name="id">

                                <div class="form-group">
                                    <label for="nomeEditado${tipousuario.id}" class="col-form-label">Nome do Cargo:</label>
                                    <input type="text" value="${tipousuario.nome}" name="nome" class="form-control" id="nomeEditado${tipousuario.id}">
                                </div>

                                <div class="form-group">
                                    <label for="nivelAcesso${tipousuario.id}">Nivel de acesso</label>
                                    <select required="required" name="nivelacesso" class="form-control" id="nivelAcesso${tipousuario.id}">
                                        <option selected="selected" value="${tipousuario.nivel} disabled="true"> nivel de acesso atual <c:out value="${tipousuario.nivel}"/></option>
                                        <option value="1" >1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                        <option value="10">10</option>
                                    </select>
                                </div>
                                <button onclick="Atualizar(${tipousuario.id})" class="btn btn-primary btn-default">Salvar Mudancas</button>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                        </div>
                    </div>
                </div>
            </div>

        </c:forEach>

    </body>
    <script>
                async function Atualizar(id){
                await $.ajax({
                url: 'http://localhost:8084${pageContext.request.contextPath}/tipousuario',
                        type: 'POST',
                        data: {
                        'nivelacesso': $('#nivelAcesso' + id).val(),
                                'nome': $('#nomeEditado' + id).val(),
                                'id': id
                        }
                })
                        .then(window.location.reload())
                }

        async function Deletar(id) {

        await  $.ajax({
        url: "http://localhost:8084${pageContext.request.contextPath}/tipousuario?id=" + id + "&acao=deletar",
                type: 'GET',
                complete: function (jqXHR, textStatus) {
                window.location.reload()
                }
        })
        }
        async  function Enviar() {
        let val = 0;
        await $.ajax({
        url: 'http://localhost:8084${pageContext.request.contextPath}/tipousuario',
                type: 'POST',
                data: {
                nivelacesso: $('#nivelAcesso').val(),
                        nome:$('#nome').val(),
                        id: val
                },
                success: function (data, textStatus, jqXHR) {
                window.location.reload()
                }
        })

        }
    </script>
</html>
