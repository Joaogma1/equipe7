<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home</h1>
        <c:choose>
            <c:when test="${sessionScope.usuario != null}">
                <div>
                    <h2>Bem vindo  <c:out value="${sessionScope.usuario.email}" /></h2>
                   
                    <p>Papeis</p>
                    <ul>
                        <c:forEach items="${sessionScope.usuario.tipous}" var="pap">
                            <li><c:out value="${pap.nome}" /></li>
                        </c:forEach>
                    </ul>
                     <h2>Links de acesso</h2>
                    <ul>
                        <c:if test="${sessionScope.usuario.verificarPapel('Administrativo')}">
                            <li><a href="${pageContext.request.contextPath}/protegido/administrativo-page">Entrar na página do setor administrativo</a></li>
                        </c:if>
                        <c:if test="${sessionScope.usuario.verificarPapel('Retaguarda')}">
                            <li><a href="${pageContext.request.contextPath}/protegido/retaguarda-page">Entrar na página do setor retaguarda</a></li>
                        </c:if>
                        <c:if test="${sessionScope.usuario.verificarPapel('TI')}">
                            <li><a href="${pageContext.request.contextPath}/protegido/ti-page">Entrar na página do setor TI</a></li>
                        </c:if>
                            <c:if test="${sessionScope.usuario.verificarPapel('Vendas')}">
                            <li><a href="${pageContext.request.contextPath}/protegido/vendas-page">Entrar na pagina do setor de Vendas</a></li>
                        </c:if>
                    </ul>

                    <a href="${pageContext.request.contextPath}/logout">SAIR</a>
                </div>
            </c:when>
            <c:otherwise>
                <div>
                    <p>Usuário não fez login</p>
                </div>
            </c:otherwise>
        </c:choose>
    </body>
</html>
