<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Libary online</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="resources/css/book/allBooks-page.css" rel="stylesheet" type="text/css " />
</head>

<body style="background: url(resources/images/books/back-fon-libary.jpg) no-repeat fixed center;">

<div class="jumbotron" >
    <img src="">
    <div class="container text-center" id="">
        <h1>Online Libary</h1>
        <p>Read & Load Books</p>
        <div class="collapse text-center" id="divSearch"><form action="#">
            <select name="searchBy" id="searchBy" style="background-color: black;color: goldenrod;width: 130px">
                <c:forEach items="${findBy}" var="search">
                    <option value="${search}">${search}</option>
                </c:forEach>
            </select>
            <span class="glyphicon glyphicon-search">
            <input type="search" id="searchValue" style="background-color: black;color: goldenrod;width: 200px"></span>
            <input type="submit" value="Search" id="btnSearch" style="background-color: black;color: goldenrod">

        </form></div>
    </div>
</div>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="mybooks?${userEmail}">My Books</a></li>
                <li><a href="allBooksList">All Books</a></li>
                <li><a href="admin/allUsers" >All Users</a></li>
                <li><a href="admin/addBook">Add Book</a></li>
                <li><a href="#divSearch" data-toggle="collapse">Search</a></li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> My Account</a></li>
                <li><a href="/j_spring_security_logout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container text-center">

</div>
<br><br>

<footer class="container-fluid text-center">
    <p>Online Store Copyright</p>
    <form class="form-inline">Get deals:
        <input type="email" class="form-control" size="50" placeholder="Email Address">
        <button type="button" class="btn btn-danger">Sign Up</button>
    </form>
</footer>

</body>
</html>

