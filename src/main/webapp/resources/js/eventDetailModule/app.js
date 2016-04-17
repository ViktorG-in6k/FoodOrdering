var app = angular.module('eventApp', [
    'eventApp.services',
    'eventApp.controllers',
    'eventApp.directives',
    "ngRoute"
]);

app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.when('/:id', {
            templateUrl: '/partials/eventDetails',
            controller: 'eventController'
        }).otherwise({
            redirectTo: '/AllEvents'
        });
    }]);

