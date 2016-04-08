(function () {
    'use strict';

    angular.module('FoodOrdering', [])
        .controller('singin', function () {
            var todoList = this;
            todoList.t = 'hello';

            todoList.addTodo = function () {

                todoList.t = '';
            };

          
        });
})();