/**
 * Created by employee on 5/3/16.
 */
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
