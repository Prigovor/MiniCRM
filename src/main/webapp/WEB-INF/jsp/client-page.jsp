<%--
  Created by IntelliJ IDEA.
  User: Bohdan
  Date: 19.03.2017
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Client page</title>
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="../../resources/css/style.css">
</head>
<body>

<div class="form">

    <ul class="tab-group">
        <li class="tab active"><a href="#mainPage">Main Page</a></li>
        <li class="tab"><a href="#anotherPage">Another Page</a></li>
    </ul>

    <div class="tab-content">

        <div id="mainPage">
            <h1>Main Page</h1>

            <form:form action="/call-me" method="get">
                <button type="submit" class="button button-block"/>
                Manager, call me</button>
            </form:form>
        </div>

        <div id="anotherPage">
            <h1>Another Page</h1>

            <form:form action="/exit" method="get">
                <button type="submit" class="button button-block"/>
                Exit</button>
            </form:form>

        </div>

    </div><!-- tab-content -->

</div>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script src="../../resources/js/index.js"></script>

</body>
</html>
