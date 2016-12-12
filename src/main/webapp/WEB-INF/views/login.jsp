<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lembergIP
  Date: 06.10.2016
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Majestic Login Form Widget Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- font files -->
    <link href='//fonts.googleapis.com/css?family=Muli:400,300,300italic,400italic' rel='stylesheet' type='text/css'>
    <link href='//fonts.googleapis.com/css?family=Comfortaa:400,300,700' rel='stylesheet' type='text/css'>
    <!-- /font files -->
    <!-- css files -->
    <link href="resources/css/login/animate-custom.css" rel="stylesheet" type="text/css" media="all" />
    <link href="resources/css/login/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- /css files -->
</head>
<body style="background: url(resources/images/login/library.jpg) no-repeat fixed center;">
<h1 class="w3ls">WELLCOME</h1>
<div id="container_demo" >
    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
    <a class="hiddenanchor" id="toregister"></a>
    <a class="hiddenanchor" id="tologin"></a>
    <div id="wrapper">
        <div id="login" class="animate form">
            <form  action="j_spring_security_check" method="post" autocomplete="on">
                <h2>Log in</h2>
                <p>
                    <label for="username" class="uname" data-icon="u" ><span>Your email</span></label>
                    <input id="username" name="j_username" required="required" type="email" placeholder="EMAIL"/>
                </p>
                <p>
                    <label for="password" class="youpasswd" data-icon="p"><span>Your password</span></label>
                    <input id="password" name="j_password" required="required" type="password" placeholder="password" />
                </p>
             <p>  <c:if test="${not empty error}">
                    <div class="error" style="text-align: right;">${error}</div>
                </c:if>
</p>
                <p class="keeplogin">

                </p>
                <p class="login button">
                    <input type="submit" value="Login" />
                </p>
                <p class="change_link">
                    <span>Not a member yet ?</span>
                    <a href="#toregister" class="to_register">Register Now</a>
                </p>
            </form>
        </div>
        <div id="register" class="animate form">
            <form  action="registration" method="post" autocomplete="on">
                <h2> Sign up </h2>
                <p>
                    <label for="namesignup" class="uname" data-icon="u"><span>Your name</span></label>
                    <input id="namesignup" name="firstName" required="required" type="text" placeholder="FIRST_NAME" />
                </p>
                <p>
                    <label for="surnamesignup" class="uname" data-icon="u"><span>Your surname</span></label>
                    <input id="surnamesignup" name="lastName" required="required" type="text" placeholder="SECOND_NAME" />
                </p>

                <p>
                    <label for="emailsignup" class="youmail" data-icon="e" ><span>Your email</span></label>
                    <input id="emailsignup" name="mail" required="required" type="email" placeholder="EXAMPLE@MAIL.COM"/>
                </p>
                <p>
                    <label for="passwordsignup" class="youpasswd" data-icon="p"><span>Your password</span></label>
                    <input id="passwordsignup" name="password" required="required" type="password" placeholder="eg. X8df!90EO"/>
                </p>

                <p class="signin button">
                    <input type="submit" value="Sign up"/>
                </p>
                <p class="change_link">
                    <span>Already a member ?</span>
                    <a href="#tologin" class="to_register">Log In</a>
                </p>
            </form>
        </div>
    </div>
</div>
<p class="agileits">© 2016 Online libary by Pasternak Ivan </p>
</body>
</html>
