
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Edit Book Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel='stylesheet' href='resources/css/book/editBook.css'>
    <script src='resources/js/profile.js'></script>
</head>
<body style="background: url(resources/images/books/back-fon-libary.jpg) no-repeat fixed center;">
<div class="container" id="menuConteiner">

<h1>${book.author.fio} : ${book.name}</h1>
    <hr>
<div class="row">
    <div class="col-sm-5" id="div1">
        <div id="Photo">
            <img class="img-thumbnail" id="BookPicture" alt="Book picture" src="imageBook/${book.id}" width="220" height="220" />
        </div>
        <form  method="POST" action="adm-editBook${book.id}/updateBookImage${book.id}" enctype="multipart/form-data" >
            <input type="file" name="file" accept=".png, .jpg, .jpeg">
            <input type="submit" class="btn btn-warning" value="CHANGE IMAGE" style="margin-top: 30px;margin-left: 100px">
            <form:errors path="file" cssClass="error" />
        </form>

        <hr>
        <div class="container">
            <c:if test="${not empty noContent}">
                <div class="error" style="text-align: right;">${noContent}</div>
            </c:if>
        </div>
<div>
<h4>LOAD OR UPDATE CONTENT(PDF ONLY) :</h4>
    <form id="contentBook" method="POST" action="adm-editBook${book.id}/updateBookContent${book.id }" enctype="multipart/form-data" >
        <input type="file" name="file" accept="application/pdf">
        <input type="submit" class="btn btn-danger" value="LOAD CONTENT" style="margin-top: 30px;margin-left: 100px">
        <form:errors path="file" cssClass="error" />
    </form>
<strong>Size book : ${bookSizeContent} MB</strong>
</div>

    </div>
    <div class="col-sm-7" id="div2" >

        <form  action="adm-editBook${book.id}/updateBookInfo${book.id}" method="post">
            <div class="form-group">
                <label for="name">BOOK NAME</label>
                <input class="form-control input-lg" type="text" id="name" name="name" value="${book.name}" required="required">
            </div>
            <div class="form-group">
                <label for="fio">AUTHOR</label>
                <input class="form-control input-lg" type="text" id="fio" name="fio" value=${book.author.fio} required="required">
            </div>
            <div class="form-group">
                <label for="name">PUBLISHER</label>
                <input class="form-control input-lg" type="text" id="publisher" name="publisher" value="${book.publisher.name}" required="required">
            </div>
            <div class="form-group">
                <label for="name">PAGE COUNT</label>
                <input class="form-control input-lg" type="number"  min="1" id="pageCount" name="pageCount" value="${book.pageCount}" required="required">
            </div>
            <div class="form-group">
                <label for="fio">PUBLISH YEAR</label>
                <input class="form-control input-lg" type="number" min="500" max="2100" id="publishYear" name="publishYear" value=${book.yearPublish} required="required">
            </div>
            <div class="form-group">
                <label for="ganre">SELECT GANRE BOOK</label>
                <select class="form-control" id="ganre" name="ganre">
                    <c:forEach items="${genreList}" var="ganre">

                        <option value="${ganre}">${ganre}</option>

                    </c:forEach>
                </select></div>
            <hr>
            <button type="submit" class="btn btn-success" style="margin-top: 30px;margin-left: 200px">Update</button>

        </form>
    </div>
</div>
    <hr>
<div class="container txt-center"><a href="allBooks"><button class="btn btn-primary"><span class="glyphicon glyphicon-chevron-left"></span>Back</button></a></div>
</div>


</body>
</html>
