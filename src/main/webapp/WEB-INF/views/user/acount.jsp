<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">


<head>
    <title>My acount</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="resources/css/user/acount.css" rel="stylesheet" type="text/css " />
    <link href="resources/css/book/allBooks-page.css" rel="stylesheet" type="text/css " />

</head>

<body style="background: url(resources/images/books/back-fon-libary.jpg) no-repeat fixed center;min-height: 800px">

<div class="jumbotron" >
    <img src="">
    <div class="container text-center" id="">
        <h1>Online Libary</h1>
        <p>Read & Load Books</p>
        <div class="collapse text-center" id="divSearch"><form action="bookFindBy">
            <select name="searchBy" id="searchBy" style="background-color: black;color: goldenrod;width: 130px">
                <c:forEach items="${findBy}" var="search">
                    <option value="${search}">${search}</option>
                </c:forEach>
            </select>
            <span class="glyphicon glyphicon-search">
            <input type="search" id="searchValue" name="searchCriteria" style="background-color: black;color: goldenrod;width: 200px"></span>
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
                <li class="active"><a href="#">Home</a></li>
                <li><a href="allBooks">All Books</a></li>
                <li><a href="#" >All Users</a></li>
                <li><a href="adm-createBook" ><span class="glyphicon glyphicon-plus"></span> Book</a></li>
                <li><a href="#colapseGenre" data-toggle="collapse">Genre</a></li>
                <li><a href="#colapseLetter" data-toggle="collapse">Letters</a></li>
                <li><a href="#divSearch" data-toggle="collapse">Search <span class="glyphicon glyphicon-search"></span></a></li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="myacount"><span class="glyphicon glyphicon-user"></span> My Account</a></li>
                <li><a href="j_spring_security_logout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="collapse text-center" id="colapseLetter">

    <c:forEach items="${letter}" var="letter">
        <a href="findBooksByLetter${letter}"> <button type="button" class="btn btn-warning" id="btnletter">${letter}</button></a>

    </c:forEach>

</div>


<br>

<div class="collapse collapse-styled" id="colapseGenre">
    <div>

        <c:forEach items="${genreList}" var="genre">
            <a href="findBooksByGenre${genre}">
                <button type="button" class="btn btn-warning" id="buttonGenre">${genre}</button>
            </a>
        </c:forEach>

    </div>
</div>


<br>



<div class="container" id="acount" style="background-color: #9799a7;padding: 2%;width: 35%;font-family: cursive;">
    <form  action="#" method="post">
        <div class="form-group">
            <h1> <span class="glyphicon glyphicon-user"></span> My Acount Info :</h1>
            <hr>
            <label for="name">First name :</label>
            <input class="form-control input-lg" type="text" id="name" name="name" value="${user.firstName }">
        </div>
        <div class="form-group">
            <label for="secondName">Second name :</label>
            <input class="form-control input-lg" type="text" id="secondName" name="secondName" value=${user.lastName}>
        </div>
        <div class="form-group">
            <label for="phone">Phone number :</label>
            <input class="form-control input-lg" type="text" id="phone" name="phone" value=${user.phone}>
        </div>
        <div class="form-group">
            <label >Email :</label><br>
            <label ><h3>${user.email}</h3></label>
        </div>
        <hr>


            <input type="submit" class="btn btn-primary" value="Update Your Info" style="float: right">
        </form>

</div>




<br><br>



</body>
</html>
