<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Login</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/floating-labels/">
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet">
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/floating-labels.css" rel="stylesheet">
    </head>
    <body>
        <form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
            <div class="text-center mb-4">
                <a href="${pageContext.request.contextPath}/index.jsp"><img class="mb-4" src="${pageContext.request.contextPath}/images/logo.png" alt="logo empresa" width="72" height="72"></a>
                <h1 class="h3 mb-3 font-weight-normal">Login</h1>

            </div>
            <div class="form-label-group">
                <input type="email" id="email" name="email" class="form-control" placeholder="Endereco de Email" required autofocus>
                <label for="email">Endereco de email</label>
            </div>

            <div class="form-label-group">
                <input type="password" name="senha" id="senha" class="form-control" placeholder="Senha" required>
                <label for="senha">Senha</label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Logar</button>
            <p class="mt-5 mb-3 text-muted text-center">&copy; TADS Distribuidora 2019</p>
        </form>
    </body>
    <style>
        *{
            font-family: 'Roboto Condensed', sans-serif;
        }
    </style>
</html>
