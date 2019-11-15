<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Cliente</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>

        <!-- Bootstrap core CSS -->

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://kit.fontawesome.com/9c0fa98e72.js" crossorigin="anonymous"></script>
    </head>
    <body>


        <%@include file="/PaginaBase/navUsuarioLogado.jsp" %>
        <div style="margin-top: 1em;" class="d-flex justify-content-center form-inline">

            <div class="mb-2">

                <div class="form-group">
                    <label class="sr-only" for="cnpj">CNPJ</label>
                    <input type="text" class="form-control mb-2" id="cnpj" name="cnpj" placeholder="cnpj">
                </div>
                <div class="form-group">
                    <label class="sr-only" for="email">E-Mail</label>
                    <input type="email" class="form-control mb-2" id="email" name="email" placeholder="email">
                </div>
                <div class="form-group">
                    <label class="sr-only" for="telefone">Telefone</label>
                    <input type="text" class="form-control mb-2" id="telefone" name="telefone" placeholder="telefone">
                </div>
                <div class="form-group">
                    <label class="sr-only" for="logradouro">Logradouro</label>
                    <input type="text" class="form-control mb-2" id="logradouro" name="logradouro" placeholder="logradouro">
                </div>
                <div class="form-group">
                    <label class="sr-only" for="estado">Estado</label>
                    <select class="form-control" id="estado" name="estado" >
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
                
                <div class="col-auto">
                    <button onclick="Enviar()" type="submit" class="btn btn-success mb-2">Cadastrar</button>
                </div>
                
            </div>
        </div>

        <div class=" d-flex justify-content-around">
            <table class="text-center table table-hover col-md-6">
                <thead>
                    <tr>
                        <th scope="col">CNPJ</th>
                        <th scope="col">E-Mail</th>
                        <th scope="col">Telefone</th>
                        <th scope="col">Logradouro</th>
                        <th scope="col">Estado</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${lista}" var="Cliente">
                        <tr>

                            <th><c:out value="${Cliente.cnpj}" /> </th>
                            <th><c:out value="${Cliente.email}"/> </th>
                            <th><c:out value="${Cliente.telefone}" /> </th>
                            <th><c:out value="${Cliente.logradouro}" /> </th>
                            <th><c:out value="${Cliente.estado}" /> </th>
                            <th><input type="button" value="Deletar" onclick="Deletar(${Cliente.id})"class="btn btn-outline-danger"> 
                                <button type="button" class="btn btn-outline-warning" data-toggle="modal" data-target="#modal${Cliente.id}">Editar</button> 
                            </th>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>
        </div>


        <c:forEach items="${lista}" var="Cliente">

            <div class="modal fade" id="modal${Cliente.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel"><c:out value="${Cliente.email}"/></h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div>
                                <div class="form-group">
                                    <label class="sr-only" for="cnpj${usuario.id}">CNPJ</label>
                                    <input type="text" value="${Cliente.cnpj}" class="form-control mb-2" id="cnpj${usuario.id}" name="cnpj${usuario.id}" placeholder="cnpj">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="email${usuario.id}">E-Mail</label>
                                    <input type="email" value="${Cliente.email}" class="form-control mb-2" id="email${usuario.id}" name="email${usuario.id}" placeholder="email">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="telefone${usuario.id}">Telefone</label>
                                    <input type="text" value="${Cliente.telefone}" class="form-control mb-2" id="telefone${usuario.id}" name="telefone${usuario.id}" placeholder="telefone">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="logradouro${usuario.id}">Logradouro</label>
                                    <input type="text" value="${Cliente.logradouro}" class="form-control mb-2" id="logradouro${usuario.id}" name="logradouro${usuario.id}" placeholder="logradouro">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="estado${usuario.id}">Estado</label>
                                    <select class="form-control" id="estado${usuario.id}" name="estado${usuario.id}" >
                                        <option selected value="${Cliente.estado}">Estado atual <c:out value="${Cliente.estado}" /></option>
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
                                <button onclick="Atualizar(${Cliente.id})" class="btn btn-primary btn-default">Salvar Mudancas</button>
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
        async function Atualizar(id) {
            await $.ajax({

                url: 'http://localhost:8084${pageContext.request.contextPath}/clientes',
                type: 'POST',
                data: {
                    'id': id,
                    'email': $('#email' + id).val(),
                    'cnpj': $('#cnpj' + id).val(),
                    'telefone': $('#telefone' + id).val(),
                    'logradouro': $('#logradouro' + id).val(),
                    'estado': $('#estado' + id).val()
                }
            })
            //     .then(window.location.reload())
        }

        async function Deletar(id) {

            await  $.ajax({

                url: "http://localhost:8084${pageContext.request.contextPath}/clientes?id=" + id + "&acao=deletar",
                type: 'GET',
                complete: function (jqXHR, textStatus) {
                    // window.location.reload()
                }
            })
        }
        async  function Enviar() {                
        let val = 0;
        await $.ajax({
        url: 'http://localhost:8084${pageContext.request.contextPath}/clientes',
                type: 'POST',
                data: {
                    email: $('#email').val(),
                    cnpj: $('#cnpj').val(),
                    telefone: $('#telefone').val(),
                    logradouro: $('#logradouro').val(),
                    estado: $('#estado').val()
                },
                success: function (data, textStatus, jqXHR) {
                window.location.reload()
                }
        })

        }
    </script>
</html>
