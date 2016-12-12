<%--
  Created by IntelliJ IDEA.
  User: lembergIP
  Date: 07.11.2016
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create book form</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="resources/css/book/style.css" rel="stylesheet" type="text/css " />



</head>
<body style="background: url(resources/images/books/back-fon-libary.jpg) no-repeat fixed center;" >
<div id="AddBookForm" class="container" >
    <div class="header text-center">
        <h2 style="color:white;"><span class="glyphicon glyphicon-book"></span> Add Book Form</h2>
        </br>
    </div>
<div class="content">
    <form  action="adm-createBook" method="post">

        <label for="fname">Book name</label> <input type="text" id="fname"
                                                    name="nameBook">

        <label for="lname">Name and Surname Author</label> <input
            type="text" id="lname" name="fio">

        <label for="ganre">Genre</label>
        <select id="ganre" name="genre">
            <c:forEach items="${genreList}" var="genre">

                <option value="${genre}">${genre}</option>

            </c:forEach>

        </select>

        <label for="publisher">Publisher</label> <input type="text"
                                                        id="publisher" name="publisher">

        <label for="pageCount">Page
            Count</label> <input type="number" id="pageCount" name="pageCount">

        <label
                for="publishYear">Publish Year</label> <input type="number" min="900"
                                                              max="2100" id="publishYear" name="publishYear">




        <a href="allBooks">  <button type="reset" class="btn btn-danger">Cancel</button></a>
        <button type="submit" class="btn btn-success">Create</button>
</form>
</div>
</div>
</body>
</html>
