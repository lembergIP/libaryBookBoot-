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
                <li><a href="home"><span class="glyphicon glyphicon-user"></span> My Account</a></li>
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

<div class="container">
    <div class="row">
        <c:forEach items="${letterBookList}" var="book">
            <div class="col-sm-3">
                <div class="panel panel-success">

                        <%--- - -- - - - -- - - -- - - -- - -- - --%>
                    <div class="panel-heading">
                        <button type="button" class="close" id="deleteBook" data-toggle="modal" data-target="#deleteBook${book.id_book}">&times;</button>

                        <strong>${book.author.fio} : </strong>
                            ${book.name} <p>${book.genre}</p>
                        <!-- Modal delete book content-->
                        <div class="modal fade" id="deleteBook${book.id_book}" role="dialog">
                            <div class="modal-dialog">

                                <!-- Modal delete book content-->
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <p>Are you sure you want to remove : </p><strong> ${book.name}</strong>?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Back</button>
                                        <a href="adm-deleteBook${book.id_book}"><button type="button" class="btn btn-danger">Delete</button></a>
                                    </div>
                                </div>

                            </div>
                        </div>  <!--End Modal delete book content-->
                            <%--more info div--%>
                        <div id="MoreInfo${book.id_book}" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog"  >
                            <div class="modal-dialog modal-lg" role="document">

                                <div class="modal-content">
                                    <div class="modal-header" style="background-color: lightblue">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title" ><strong>${book.name}</strong></h4>
                                    </div>
                                    <div class="modal-body">

                                        <div id="Photo" class="container" >
                                            <img class="img-thumbnail" id="BookPicture" alt="Book picture" src="imageBook/${book.id_book}" style="max-width: 100%; max-height: 100%" />
                                        </div>
                                        <div id="BookInfo" class="container" >
                                            <ul>
                                                <li><h4>Book Name : <strong>${book.name}</strong></h4></li>
                                                <li><h4>Author : <strong>${book.author.fio}</strong></h4></li>
                                                <li><h4>Genre :<strong> ${book.genre}</strong></h4></li>
                                                <li> <h4>Publisher :<strong> ${book.publisher.name }</strong></h4></li>
                                                <li><h4>Pages : <strong>${book.pageCount }</strong></h4></li>
                                                <li><h4>Year Public : <strong>${book.yearPublish }</strong></h4></li>
                                                <li><h4>Size :<strong>${book.content}  MB</strong></h4></li>

                                            </ul>

                                        </div>
                                        <hr>
                                        <div class="btn-group btn-group-justified" id="btnMenu">
                                            <a href="actionReadBook${book.id_book}" class="btn btn-primary">Read Book</a>
                                            <a href="actionLoadBook${book.id_book}" class="btn btn-danger">Load Book</a>
                                        </div>
                                    </div>
                                    <div class="modal-footer" style="clear: both">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </div>

                            </div>
                        </div>
                            <%-- end more info div--%>
                    </div>
                    <div class="panel-body" id="panelBody" style="width: 250px; height:200px"><img src="imageBook/${book.id_book}" class="img-responsive" style="max-width: 100%; max-height: 100%" alt="Image"></div>
                    <div class="panel-footer">
                        <button class="btn btn-primary" data-toggle="modal" data-target="#MoreInfo${book.id_book}" style="font-family: cursive;">More Info</button>
                        <a href="adm-editBook${book.id_book}"><button class="btn btn-primary" id="btnEditBook" style="font-family: cursive;">Edit Book</button></a>


                    </div>

                </div>

            </div>

        </c:forEach>
    </div>
</div>








<br><br>



</body>
</html>