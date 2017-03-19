<%--
  Created by IntelliJ IDEA.
  User: Prigovor
  Date: 16.03.2017
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <title>Store</title>
    <link href="${pageContext.request.contextPath}/resources/css/store_style.css"
          rel="stylesheet" type="text/css">
</head>

<body>

<header>

    <div id="logo">
        <a href="${pageContext.request.contextPath}/" title="Перейти на главную"><span>N</span>otebook store</a>
    </div>

    <div id="menu">
        <a href="${pageContext.request.contextPath}/">
            <img src="${pageContext.request.contextPath}/resources/images/1489777436_cart.png"
                 height="50">
        </a>
    </div>

    <div id="regAuth">
        <select>
            <option href="${pageContext.request.contextPath}/">Registry </option>
            <option href="${pageContext.request.contextPath}/">Authorisation</option>
        </select>
    </div>
</header>

<div id="wrapper" class="images">
    <a href="${pageContext.request.contextPath}/">
        <img id="notebook1"
             src="${pageContext.request.contextPath}/resources/images/apple.jpg"
             width="400" height="230" class="image"/>
    </a>
    <a href="${pageContext.request.contextPath}/">
        <img id="notebook2" src="${pageContext.request.contextPath}/resources/images/images.jpg"
             width="400" height="230" class="image"/>
    </a>
    <a href="${pageContext.request.contextPath}/">
        <img id="notebook3" src="${pageContext.request.contextPath}/resources/images/images%20(1).jpg"
             width="400" height="230" class="image"/>
    </a>
    <a href="${pageContext.request.contextPath}/">
        <img id="notebook4" src="${pageContext.request.contextPath}/resources/images/images%20(2).jpg"
             width="400" height="230" class="image"/>
    </a>
</div>

<footer>
    <div id="social">

    </div>
    <div id="rights">
        Все права защищены &copy; <?=date ('Y')?>
    </div>

</footer>
</body>

</html>
