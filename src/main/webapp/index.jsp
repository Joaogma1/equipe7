<%@ page session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>TADS index</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/9c0fa98e72.js" crossorigin="anonymous"></script>
    </head>
    <body>

        <%@include file="/PaginaBase/navIndex.jspf"  %>

        <div class="jumbotron text-center">
            <h1 class="text-white">Distribuidora TADS <span class="badge badge-primary text-white">Alpha <i class="fas fa-vial"></i></span></h1>
            <p class="text-white">Pedidos de forma rapida e inteligente!</p>
        </div>


        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <h3>Atendimento rapido <i style="color: #000" class="fas fa-bolt"></i></h3>
                    <p>Atendimento de forma rapida e eficiente dando sempre flexibilidade aos nossos clientes.</p>
                </div>
                <div class="col-sm-4">
                    <h3>As melhores Marcas <i style="color: #000" class="fas fa-glass-cheers"></i></h3>
                    <p>Nossa distribuidora possui os melhores produtos importados, nacionais e regionais</p>
                </div>
                <div class="col-sm-4">
                    <h3>Alta abrangencia <i style="color: #000" class="fas fa-globe-americas"></i> </h3>        
                    <p>Possuimos nossa matriz e outras tres unidades pelo Brasil </p>
                </div>
            </div>
        </div>

        <hr class="featurette-divider">

        <div id="Sobre" class="row featurette ">
            <div class="col-md-7">
                <h2 class="featurette-heading">Sobre n�s: </h2>
                <p class="lead">A empresa Tades Ltda. � uma empresa que atua no ramo de distribui��o de bebidas, fundada em 2009 pelos irm�os Antonio e Joana Tades, Possui sua matriz localizada em Sao Paulo e mais tr�s filiais espalhadas pelo pa�s.</p>
            </div>
            <div class="col-md-5">
                <img class="img-thumbnail" src="https://d1lc5plzz0mq74.cloudfront.net/wp-content/uploads/2017/05/29082400/black-belt-sao-paulo.jpg" width="500" height="500" alt="Cidade de Sao Paulo">
            </div>
        </div>
        <hr class="featurette-divider">
        
        <div id="Sobre2" class="row featurette">

            <div class="col-md-7 order-md-2">
                <h2 class="featurette-heading">Nosso diferencial: <span class="text-muted">N�s da TADS Ltda. realizamos vendas de bebidas para voc� comerciante.</span></h2>
                <p class="lead">N�s trazemos com�rcio de bebidas que o Brasil merece! </p>
            </div>
            <div class="col-md-5 order-md-1">
                <img class="img-thumbnail" src="https://static.docsity.com/documents_pages/notas/2012/11/06/7aeec7e59196d925b6b460d1753e1f35.png" width="500" height="500" alt="Cidade de Sao Paulo">

            </div>
        </div>
        <%@include file="/PaginaBase/rodape.jspf" %>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    
    <style>
        *{
            font-family: 'Roboto Condensed', sans-serif;
        }
        .jumbotron{
            background-color: #012340
        }

        #footer{
            background-color: #0D0D0D;
        }
        .row{
            margin: 4em auto;
        }
        #Sobre{
            margin-left: 5%;
        }
        #Sobre2{
            margin-left: 5%;
        }
    </style>
</html>