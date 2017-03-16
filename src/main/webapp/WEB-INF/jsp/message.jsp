<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Bohdan
  Date: 12.03.2017
  Time: 5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign-Up/Login Form</title>
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="../../resources/css/style.css">

</head>

<body>

<div class="form">
    <form:form action="/confirm" modelAttribute="message">
        <br>
        <form:input disabled="true" path="text"/>
        <br>

        <button type="submit" class="button button-block"/>
        OK</button>
    </form:form>
</div>

</div> <!-- /form -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script src="../../resources/js/index.js"></script>

</body>
</html>