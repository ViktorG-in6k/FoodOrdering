<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default top-banner-title-font">
    <div class="container-fluid">
        <div class="navbar-header">
            <c:if test="${not empty userMail}">
                <a class="navbar-brand" href="/events">Food ordering</a>
                <a class="navbar-brand" href="${backPage}">Back</a>
            </c:if>
            <c:if test="${empty userMail}">
                <a class="navbar-brand" href="/sing_out">Food ordering</a>
            </c:if>
        </div>
        <form role="form">

            <div>
                <div>
                    <br>
                    <a href="#/AllEvents">AllEvents</a> |
                    <a href="#/Book/Delete">Delete</a> |
                    <a href="#/Book/Add">Add</a> |
                    <a href="#/Book/Show">Show</a> |
                    <a href="#/Book/Other">Other</a>
                </div>



            </div>

            <ul class="nav navbar-nav navbar-right">
                <li>

                    <a class="navbar-brand" href="/sing_out">

                        <c:if test="${not empty userMail}">
                            Hello  ${userMail}
                        </c:if>
                    </a>
                    <label class="navbar-brand" ng-model="todo.done">
                        <c:if test="${empty userMail}">
                            Welcome!
                        </c:if>
                    </label>
                </li>
            </ul>
        </form>
    </div>
</nav>