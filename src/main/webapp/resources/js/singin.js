(function () {
    'use strict';

    angular.module('authorization', [])
        .controller('singin', function ($scope) {
            var todoList = this;
            todoList.t = 'hello';

            todoList.addTodo = function () {
                todoList.t = '';
            };

          
        });
})();