var app = angular.module('eventApp', [
    'eventApp.services',
    'eventApp.controllers',
    'eventApp.directives',
    'events.filter',
    "kendo.directives",
    "ngRoute",
    'ngResource',
    'eventController',
    'eventService'
]);

app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.when('/events', {
            templateUrl: '/resources/templates/eventsList.html',
            controller: 'eventListController'
        }).when('/events/:id', {
            templateUrl: '/partials/eventDetails',
            controller: 'eventController'
        }).when('/:id/:restaurantId', {
            templateUrl: '/partials/restaurantDetails',
            controller: 'restaurantController'
        }).when('/:id/:restaurantId/order', {
            templateUrl: '/partials/commonOrderList',
            controller: 'commonOrderList'
        }).otherwise({
            redirectTo: '/events'
        });
    }]);

