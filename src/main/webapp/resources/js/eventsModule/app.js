var app = angular.module('events', ["events.controllers", "events.services", "events.filter", "ngRoute", "kendo.directives"]);

app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.when('/AllEvents', {
            templateUrl: '/partials/eventList',
            controller: 'eventController'
        }).otherwise({
            redirectTo: '/AllEvents'
        });
    }
]);



