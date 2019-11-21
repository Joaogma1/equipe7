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
        <title>Clientes</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://kit.fontawesome.com/9c0fa98e72.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
    </head>
    <body>
        <c:choose>
            <%@include file="/PaginaBase/navUsuarioLogado.jsp" %>
            <c:when test="${sessionScope.usuario != null}">
                <div class="container">
                    <form>
                        <div class="form-group">
                            <label></label> 
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <i class="fa fa-envelope"></i>
                                    </div>
                                </div> 
                                <input id="email" name="email" placeholder="E-mail" type="text" required="required" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label></label> 
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <i class="fa fa-id-card-o"></i>
                                    </div>
                                </div> 
                                <input id="cnpj" name="cnpj" placeholder="CNPJ" type="text" required="required" class="form-control" onkeypress="$(this).mask('00.000.000/0000-00')">
                            </div>
                        </div>
                        <div class="form-group">
                            <label></label> 
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <i class="fa fa-phone-square"></i>
                                    </div>
                                </div> 
                                <input id="telefone" name="Telefone" placeholder="Telefone" type="text" required="required" class="form-control" onkeypress="$(this).mask('(00) 0000-00009')">
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
                                <input id="logradouro" name="logradouro" placeholder="Logradouro" type="text" class="form-control" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label></label> 
                            <select id="estado" name="estado" required="required" class="form-control">
                                <option value="AC">Acre</option>
                                <option value="AL">Alagoas</option>
                                <option value="AP">Amapá</option>
                                <option value="AM">Amazonas</option>
                                <option value="BA">Bahia</option>
                                <option value="CE">Ceará</option>
                                <option value="DF">Distrito Federal</option>
                                <option value="ES">Espírito Santo</option>
                                <option value="GO">Goiás</option>
                                <option value="MA">Maranhão</option>
                                <option value="MT">Mato Grosso</option>
                                <option value="MS">Mato Grosso do Sul</option>
                                <option value="MG">Minas Gerais</option>
                                <option value="PA">Pará</option>
                                <option value="PB">Paraíba</option>
                                <option value="PR">Paraná</option>
                                <option value="PE">Pernambuco</option>
                                <option value="PI">Piauí</option>
                                <option value="RJ">Rio de Janeiro</option>
                                <option value="RN">Rio Grande do Norte</option>
                                <option value="RS">Rio Grande do Sul</option>
                                <option value="RO">Rondônia</option>
                                <option value="RR">Roraima</option>
                                <option value="SC">Santa Catarina</option>
                                <option value="SP">São Paulo</option>
                                <option value="SE">Sergipe</option>
                                <option value="TO">Tocantins</option>
                            </select>
                        </div> 

                        <div class="container">
                            <div class="row">
                                <div class="col text-center">
                                    <button name="submit" type="button" onclick="Enviar()" class="btn btn-primary">Enviar</button>
                                </div>
                            </div>
                        </div>
                    </form>

                    <div style="margin-top: 2em" class=" d-flex justify-content-around">
                        <table class="text-center table table-hover col-md-6">
                            <thead>
                                <tr>
                                    <th scope="col">CNPJ</th>
                                    <th scope="col">E-mail</th>
                                    <th scope="col">Telefone</th>
                                    <th scope="col">Estado</th>
                                    <th scope="col">Opcoes</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${lista}" var="cliente">
                                    <tr>
                                        <th><c:out value="${cliente.cnpj}" /> </th>
                                        <th><c:out value="${cliente.email}" /></th>
                                        <th><c:out value="${cliente.telefone}" /></th>
                                        <th><c:out value="${cliente.estado}" /></th>
                                        <th> 
                                            <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#modal${cliente.id}">Detalhes</button> 
                                        </th>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <c:forEach items="${lista}" var="cliente">

                    <div class="modal fade" id="modal${cliente.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Editar Cliente</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form>
                                        <div class="form-group">
                                            <label></label> 
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fa fa-envelope"></i>
                                                    </div>
                                                </div> 
                                                <input id="email${cliente.id}"  value="${cliente.email}" name="email" placeholder="E-mail" type="text" required="required" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label></label> 
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fa fa-id-card-o"></i>
                                                    </div>
                                                </div> 
                                                <input id="cnpj${cliente.id}" value="${cliente.cnpj}" name="cnpj" placeholder="CNPJ" type="text" required="required" class="form-control" onkeypress="$(this).mask('00.000.000/0000-00')">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label></label> 
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fa fa-phone-square"></i>
                                                    </div>
                                                </div> 
                                                <input id="telefone${cliente.id}" value="${cliente.telefone}" name="Telefone" placeholder="Telefone" type="text" required="required" class="form-control" onkeypress="$(this).mask('(00) 0000-00009')">
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
                                                <input id="logradouro${cliente.id}" value="${cliente.logradouro}" name="logradouro" placeholder="Logradouro" type="text" class="form-control" required="required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label></label> 
                                            <select id="estado${cliente.id}" name="estado" required="required" class="form-control">
                                                <option value="${cliente.estado}" selected="selected" disabled="disabled">Estado atual <c:out value="${cliente.estado}"/></option>
                                                <option value="AC">Acre</option>
                                                <option value="AL">Alagoas</option>
                                                <option value="AP">Amapá</option>
                                                <option value="AM">Amazonas</option>
                                                <option value="BA">Bahia</option>
                                                <option value="CE">Ceará</option>
                                                <option value="DF">Distrito Federal</option>
                                                <option value="ES">Espírito Santo</option>
                                                <option value="GO">Goiás</option>
                                                <option value="MA">Maranhão</option>
                                                <option value="MT">Mato Grosso</option>
                                                <option value="MS">Mato Grosso do Sul</option>
                                                <option value="MG">Minas Gerais</option>
                                                <option value="PA">Pará</option>
                                                <option value="PB">Paraíba</option>
                                                <option value="PR">Paraná</option>
                                                <option value="PE">Pernambuco</option>
                                                <option value="PI">Piauí</option>
                                                <option value="RJ">Rio de Janeiro</option>
                                                <option value="RN">Rio Grande do Norte</option>
                                                <option value="RS">Rio Grande do Sul</option>
                                                <option value="RO">Rondônia</option>
                                                <option value="RR">Roraima</option>
                                                <option value="SC">Santa Catarina</option>
                                                <option value="SP">São Paulo</option>
                                                <option value="SE">Sergipe</option>
                                                <option value="TO">Tocantins</option>
                                            </select>
                                        </div> 
                                        <button onclick="Atualizar(${cliente.id})" class="btn btn-primary btn-default">Salvar Mudancas</button>

                                    </form>

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
                async  function Enviar() {
                let val = 0;
                        await $.ajax({
                        url: '${pageContext.request.contextPath}/cliente',
                                type: 'POST',
                                data: {
                                email: $('#email').val(),
                                        cnpj:$('#cnpj').val(),
                                        telefone:$('#telefone').val(),
                                        logradouro:$('#logradouro').val(),
                                        estado:$('#estado').val(),
                                        id: val
                                },
                                success: function (data, textStatus, jqXHR) {
                                window.location.reload()
                                }
                        })}

        async function Atualizar(id){
        await $.ajax({
        url: '${pageContext.request.contextPath}/cliente',
                type: 'POST',
                data: {
                email:  document.getElementById('email' + id).value,
                        cnpj: document.getElementById('cnpj' + id).value,
                        telefone: document.getElementById('telefone' + id).value,
                        logradouro: document.getElementById('logradouro' + id).value,
                        estado: document.getElementById('estado' + id).value,
                        id: id
                }
        })


        }

    </script>

</html>
