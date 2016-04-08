angular.module('Food', [])
    .controller('sing', function() {
        var todo = this;
        todo.todos ={text:'learn angular'};

        todo.addTodo = function() {
            todo.text = {text:todo.todoText};
        };

    });