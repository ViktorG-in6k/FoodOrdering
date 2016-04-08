<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.min.js"></script>--%>
<%--<script src="/resources/js/singin.js"></script>--%>
<%--<div ng-app="FoodOrdering" class="container" style="margin-top: 250px">--%>
    <%--<div class="row">--%>
        <%--<div class="col-md-6 col-md-offset-3">--%>
            <%--<div ng-controller="singin as text"> class="well">--%>
                <%--<form ng-submit="text.addTodo()"  method="post">--%>
                    <%--<div class="input-group col-md-12">--%>
                        <%--<input ng-model="text.text" class="btn btn-lg col-md-8  " style="text-align: left" name="email" id="email"--%>

                               <%--placeholder="Your Email"--%>
                               <%--required>--%>
                        <%--<span >{{text.todoList.text}}</span>--%>
                        <%--<button class="btn btn-success col-md-offset-1 col-md-3 btn-lg" type="hidden"--%>
                                <%--name="${_csrf.parameterName}"--%>
                                <%--value="${_csrf.token}">Sing in--%>
                        <%--</button>--%>
                    <%--</div>--%>
                <%--</form>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<!doctype html>
<html ng-app="FoodOrdering">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.min.js"></script>
    <script src="/resources/js/singin.js"></script>
    <link rel="stylesheet" href="/resources/core/css/todo.css">
</head>
<div class="col-md-offset-4 col-md-4">
    <body>
    <h2>Todo</h2>
    <div ng-controller="singin as todoList">
        <span>{{todoList.remaining()}} of {{todoList.todos.length}} remaining</span>
        [ <a href="" ng-click="todoList.archive()">archive</a> ]
        <ul class="unstyled">
            <li ng-repeat="todo in todoList.todos">
                <label class="checkbox">
                    <input type="checkbox" ng-model="todo.done">
                    <span class="done-{{todo.done}}">{{todo.text}}</span>
                </label>
            </li>
        </ul>
        <form ng-submit="todoList.addTodo()">
            <input type="text" ng-model="todoList.todoText" size="30"
                   placeholder="add new todo here">
            <input class="btn-primary" type="submit" value="add">
        </form>
    </div>
    </body>
</div>
</html>