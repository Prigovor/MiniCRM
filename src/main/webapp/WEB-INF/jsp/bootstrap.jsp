<%--
  Created by IntelliJ IDEA.
  User: Prigovor
  Date: 17.03.2017
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/font-awesome-4.7.0/css/font-awesome.min.css"
          rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/bootstrapLast/css/bootstrap.min.css" rel="stylesheet"
          type="text/css"/>
    <title>Store</title>
</head>

<body>

<div class="container-fluid">

    <div class="row" id="header">

        <nav id="navBar" class="navbar navbar-default" role="navigation" style="height: 8%">
            <div class="container-fluid">

                <!-- Бренд и переключатель сгруппированы для лучшего показа на мобильных устройствах -->
                <div class="navbar-header">

                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <a class="navbar-brand" href="#">Notebook Store</a>
                </div>

                <!-- Группируйте навигационные ссылки, формы, выпадающие меню и другие элементы для переключения -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <div style="margin-top: 4%">
                                <a href="/">
                                    <span style="text-decoration: none" class="fa fa-shopping-cart fa-3x"
                                          aria-grabbed="true"> 0</span>
                                </a>
                            </div>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <strong>Authorisation</strong>
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#"></a></li>
                                <li><a href="#"></a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </li>
                    </ul>

                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

    </div>

    <div id="main" class="row">

        <div class="col-xs-4">

            <div id="image1" class="thumbnail">
                <img src="/resources/images/apple.jpg" alt="...">
                <div class="caption">
                    <h3>Заголовок...</h3>
                    <p>Контент...</p>
                    <p>
                        <a href="#" class="btn btn-primary" role="button" data-toggle="modal"
                           data-target="#myModal">Info</a>
                        <a id="btnBuy3" href="#" class="btn btn-default" role="button">Buy</a>
                    </p>
                </div>
            </div>
        </div>

        <div class="col-xs-4">

            <div id="image2" class="thumbnail">
                <img src="/resources/images/apple.jpg" alt="...">
                <div class="caption">
                    <h3>Заголовок...</h3>
                    <p>Контент...</p>
                    <p>
                        <a href="#" class="btn btn-primary" role="button" data-toggle="modal"
                           data-target="#myModal">Info</a>
                        <a id="btnBuy2" href="#" class="btn btn-default" role="button">Buy</a>
                    </p>
                </div>
            </div>
        </div>

        <div class="col-xs-4">
            <div id="image3" class="thumbnail">
                <img class="image" src="/resources/images/apple.jpg" alt="...">
                <div class="caption">
                    <h3>Заголовок...</h3>
                    <p>Контент...</p>
                    <p>
                        <a href="#" class="btn btn-primary" role="button" data-toggle="modal"
                           data-target="#myModal">
                            Info
                        </a>
                        <a id="btnBuy1" href="#" class="btn btn-default" role="button">Buy</a>
                    </p>
                </div>
            </div>
        </div>

    </div>

    <div class="row">

        <div class="col-xs-12">

            <div class="center-block" align="center">

                <ul class="pagination">
                    <li><a href="#">«</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">»</a></li>
                </ul>

            </div>

        </div>

    </div>


    <div class="row">
        <div id="footer" class="col-xs-12" style="height: 5%">
        </div>
    </div>

</div>

<%--Модальное окно (разбить в случае необходимости)--%>
<div id="myModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">×</button>
                <h4 class="modal-title">Заголовок окна</h4>
            </div>
            <div class="modal-body">
                <img src="/resources/images/apple.jpg" height="330"/>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" type="button" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    </div>
</div>

<%--<script src="/resources/js/pagination_boot.js"></script>--%>
<script src="${pageContext.request.contextPath}/resources/jQuery/jquery-3.1.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrapLast/js/bootstrap.js"></script>
<%--<script src="/resources/pagination/pagination.js"></script>--%>

</body>

</html>
