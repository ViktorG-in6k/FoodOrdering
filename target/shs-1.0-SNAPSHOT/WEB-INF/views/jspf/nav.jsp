<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar fixed-header navbar-default top-banner-title-font">

    <div class="container-fluid">
        <div class="navbar-header">


            <a class="navbar-brand" href="/events">Food ordering</a>
            <a class="navbar-brand" href="${backPage}">Back</a>
        </div>

            <form role="form">

                <div class="col-md-10">
                    <br/>
                    <a href="#/AllEvents">AllEvents</a> |
                    <a href="#/Book/Delete">Delete</a> |
                    <a href="#/Book/Add">Add</a> |
                    <a href="#/Book/Show">Show</a> |
                    <a href="#/Book/Other">Other</a>
                </div>

                <div class="nav navbar-nav navbar-right">
                    <label class="navbar-brand" ng-model="todo.done">
                        Welcome!
                    </label>
                </div>
            </form>

    </div>
</nav>