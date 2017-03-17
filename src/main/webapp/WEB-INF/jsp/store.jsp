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
    <div id="menuHead">
        <a href="${pageContext.request.contextPath}/">
            <div style="margin-right: 5%">Text</div>
        </a>
        <a href="${pageContext.request.contextPath}/">
            <div>Text</div>
        </a>
    </div>
    <div >
        <label>
            <select id="regAuth">
                <option href="${pageContext.request.contextPath}/"><a>Registry </a></option>
                <option href="${pageContext.request.contextPath}/"><a> Authorisation</a></option>
            </select>
        </label>
    </div>
</header>

<div id="wrapper">

    <div id="top">
        <a href="/">
            <img id="image1" src="${pageContext.request.contextPath}/resources/images/apple_macbook_pro_retina_13_-mf839uaa.jpg"
            width="575" height="300" class="image">
        </a>
        <a href="/">
            <img id="image2" class="image" src="${pageContext.request.contextPath}/resources/images/images.jpg"
                 width="575" height="300">
        </a>
    </div>
    <div id="bottom">
        <a href="${pageContext.request.contextPath}/resources/images/images%20(1).jpg"></a>
        <a href="${pageContext.request.contextPath}/resources/images/images%20(2).jpg"></a>
    </div>

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
