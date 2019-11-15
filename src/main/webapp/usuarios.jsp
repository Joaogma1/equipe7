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
                    <input type="email" class="form-control mb-2" id="email" name="email" placeholder="E-mail">
                    <input type="password" class="form-control mb-2" id="senha" name="senha" placeholder="Senha">
                </div>

                <div class="form-group mx-sm-3 mb-2">
                    <select name="idcargo" class="form-control" id="idcargo">
                        <option selected="selected" disabled="disabled">Selecionar cargo</option>
                        <c:forEach items="${listatipousuario}" var="tipousuario">
                            <option value="${tipousuario.id}" ><c:out value="${tipousuario.nome}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group mx-sm-3 mb-2">

                    <select name="idunidade" class="form-control" id="idunidade">
                        <option selected="selected" disabled="disabled">Selecionar Unidade</option>
                        <c:forEach items="${listaunidade}" var="unidadeEmp">
                            <option value="${unidadeEmp.id}" ><c:out value="${unidadeEmp.nomeUnidade}"/></option>
                        </c:forEach>
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
                        <th scope="col">E-mail</th>
                        <th scope="col">Unidade</th>
                        <th scope="col">Cargo</th>
                        <th scope="col">Data de registro</th>
                        <th scope="col">Opcoes</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${lista}" var="usuario">
                        <tr>
                            <th><c:out value="${usuario.email}" /></th>
                            <th><c:out value="${usuario.idUnidade.nomeUnidade}" /> </th>
                            <th><c:out value="${usuario.idTipoUsuario.nome}" /></th>
                            <th><c:out value="${usuario.dataRegistro}" /></th>
                            <th><input type="button" value="Deletar" onclick="Deletar(${usuario.id})"class="btn btn-outline-danger"> 
                                <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#modal${usuario.id}">Editar</button> 
                            </th>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>


        <c:forEach items="${lista}" var="usuario">

            <div class="modal fade" id="modal${usuario.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel"><c:out value="${usuario.email}"/></h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div>
                                <input type="hidden" value="atualizar" name="acao">
                                <input type="hidden" value=${usuario.id} name="id">

                                <div class="form-group">
                                    <label for="email${usuario.id}" class="col-form-label">E-mail:</label>
                                    <input type="text" value="${usuario.email}" name="nome" class="form-control" id="email${usuario.id}">
                                </div>
                                <div class="form-group">
                                    <select name="idcargo${usuario.id}" class="form-control" id="idcargo${usuario.id}">
                                        <option value="${usuario.idTipoUsuario.id}" selected="selected" disabled="disabled">Cargo atual <c:out value="${usuario.idTipoUsuario.nome}"/></option>
                                        <c:forEach items="${listatipousuario}" var="tipousuario">
                                            <option value="${tipousuario.id}" ><c:out value="${tipousuario.nome}"/></option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <select name="idunidade" class="form-control" id="idunidade${usuario.id}">
                                        <option value="${usuario.idUnidade.id}" selected="selected" disabled="disabled">Unidade atual <c:out value="${usuario.idUnidade.nomeUnidade}"/></option>
                                        <c:forEach items="${listaunidade}" var="unidadeEmp">
                                            <option value="${unidadeEmp.id}" ><c:out value="${unidadeEmp.nomeUnidade}"/></option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <button onclick="Atualizar(${usuario.id})" class="btn btn-primary btn-default">Salvar Mudancas</button>
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
                url: 'http://localhost:8084${pageContext.request.contextPath}/usuario',
                        type: 'POST',
                        data: {
                        email: $('#email' + id).val(),
                                id: id,
                                idunidade: document.getElementById("idunidade"+id).value,
                                idcargo: document.getElementById("idcargo" + id).value
                        }
                })
                        //   .then(window.location.reload())
                }

        async function Deletar(id) {
        await  $.ajax({
        url: "http://localhost:8084${pageContext.request.contextPath}/usuario?id=" + id + "&acao=deletar",
                type: 'GET',
                complete: function (jqXHR, textStatus) {
                window.location.reload()
                }
        })
        }
        async  function Enviar() {
        let val = 0;
                await $.ajax({
                url: 'http://localhost:8084${pageContext.request.contextPath}/usuario',
                        type: 'POST',
                        data: {
                        email: $('#email').val(),
                                id: val,
                                senha: $('#senha').val(),
                                idunidade: $('#idunidade').val(),
                                idcargo:$('#idcargo').val()

                        },
                        success: function (data, textStatus, jqXHR) {
                        window.location.reload()
                        }
                })
        }
    </script>
</html>