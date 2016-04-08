(function () {
    'use strict';

    angular.module('FoodOrdering', [])
        .controller('singin', function () {
            var todoList = this;
            todoList.t = 'hello';

            todoList.addTodo = function () {

                todoList.t = '';
            };

            // todoList.remaining = function () {
            //     var count = 0;
            //     angular.forEach(todoList.todos, function (todo) {
            //         count += todo.done ? 0 : 1;
            //     });
            //     return count;
            // };
            //
            // todoList.archive = function () {
            //     var oldTodos = todoList.todos;
            //     todoList.todos = [];
            //     angular.forEach(oldTodos, function (todo) {
            //         if (!todo.done) todoList.todos.push(todo);
            //     });
            // };
        });
})();