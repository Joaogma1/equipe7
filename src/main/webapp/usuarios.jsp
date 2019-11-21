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
        <title>Tipos de usuarios no sistema</title>
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
                                        <i class="fa fa-user-circle-o"></i>
                                    </div>
                                </div> 
                                <input id="nome" name="nome" placeholder="Nome" type="text" required="required" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label></label> 
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <i class="fa fa-id-card"></i>
                                    </div>
                                </div> 
                                <input id="cpf" name="cpf" placeholder="CPF" type="text" required="required" class="form-control" onkeypress="$(this).mask('000.000.000-00');">
                            </div>
                        </div>
                        <div class="form-group">
                            <label></label> 
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <i class="fa fa-map-marker"></i>
                                    </div>
                                </div> 
                                <input id="endereco" name="endereco" maxlength="255" placeholder="Endereco" type="text" required="required" class="form-control">
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
                                <input id="salario" name="salario" placeholder="Salario" type="number"  min="1" step="any" required="required" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="telefone"></label> 
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <i class="fa fa-mobile-phone"></i>
                                    </div>
                                </div> 
                                <input id="telefone" name="telefone" placeholder="Contato" type="text" class="form-control"onkeypress="$(this).mask('(00)00000-0000');">
                            </div>
                        </div> 
                        <div class="form-group">
                            <label></label> 
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <i class="fa fa-envelope"></i>
                                    </div>
                                </div> 
                                <input id="email" name="email" placeholder="E-mail" type="email" class="form-control" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label></label> 
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <i class="fa fa-lock"></i>
                                    </div>
                                </div> 
                                <input id="senha" name="senha" placeholder="Senha" type="password" class="form-control" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label></label> 
                            <select id="idcargo" name="idcargo" required="required" class="form-control">
                                <option selected="selected" disabled="disabled">Selecionar cargo</option>
                                <c:forEach items="${listatipousuario}" var="tipousuario">
                                    <option value="${tipousuario.id}" ><c:out value="${tipousuario.nome}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label></label> 
                            <select id="idunidade" name="idunidade" class="form-control" required="required">
                                <option selected="selected" disabled="disabled">Selecionar Unidade</option>
                                <c:forEach items="${listaunidade}" var="unidadeEmp">
                                    <option value="${unidadeEmp.id}" ><c:out value="${unidadeEmp.nomeUnidade}"/></option>
                                </c:forEach>
                            </select>
                        </div> 

                        <div class="container">
                            <div class="row">
                                <div class="col text-center">
                                    <button name="submit" type="button" onclick="Enviar()" class="btn btn-success">Cadastrar</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div style="margin-top: 2em" class=" d-flex justify-content-around">
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
                                            <label for="senha${usuario.id}">Senha:</label>
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fa fa-lock"></i>
                                                    </div>
                                                </div> 
                                                <input id="senha${usuario.id}" name="senha${usuario.id}" value="${usuario.senha}" placeholder="Senha" type="password" class="form-control" required="required">
                                            </div>
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

            </c:when>
            <c:otherwise>
                <div>
                    <p>Usuário não fez login</p>
                </div>
            </c:otherwise>
        </c:choose>
    </body>
    <script>
                async function Atualizar(id){
                await $.ajax({
                url: '${pageContext.request.contextPath}/usuario',
                        type: 'POST',
                        data: {
                        email: $('#email' + id).val(),
                                id: id,
                                senha: $('#senha' + id).val(),
                                idunidade: document.getElementById('idunidade' + id).value,
                                idcargo: $('#idcargo' + id).val()
                        },
                        success: function (data, textStatus, jqXHR) {
                        alert("Atualizado com sucesso !")
                        }

                })
                        .then(window.location.reload())

                }

        async function Deletar(id) {
        await  $.ajax({
        url: "${pageContext.request.contextPath}/usuario?id=" + id + "&acao=deletar",
                type: 'GET',
                complete: function (jqXHR, textStatus) {
                alert("Excluído com sucesso!")
                }
        })
                .then(window.location.reload())
        }
        async  function Enviar() {
        let val = 0;
                await $.ajax({
                url: '${pageContext.request.contextPath}/usuario',
                        type: 'POST',
                        data: {
                        email: $('#email').val(),
                                id: val,
                                senha: $('#senha').val(),
                                idunidade: $('#idunidade').val(),
                                idcargo: $('#idcargo').val(),
                                cpf: document.getElementById("cpf").value,
                                nome: document.getElementById("nome").value,
                                salario: document.getElementById("salario").value,
                                telefone: document.getElementById("telefone").value,
                                endereco: document.getElementById("endereco").value
                        },
                        success: function (data, textStatus, jqXHR) {
                        alert("Cadastrado com sucesso !")
                        }
                }).then(window.location.reload())
        }
    </script>
</html>