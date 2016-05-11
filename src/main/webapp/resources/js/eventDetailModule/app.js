var app = angular.module('eventApp', [
    'eventApp.services',
    'eventApp.controllers',
    'eventApp.directives',
    'events.filter',
    "kendo.directives",
    "ngRoute",
    'ngResource',
    'eventController',
    'eventService',
    
    'restaurantController',
    'restaurantService',

    'orderController',
    'orderService',

    'itemController',
    'itemService'
]);

app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.when('/events', {
            templateUrl: '/resources/templates/eventsList.html',
            controller: 'eventListController'
        }).when('/events/:id', {
            templateUrl: '/resources/templates/eventDetails.html',
            controller: 'eventController'
        }).when('/:id/:restaurantId', {
            templateUrl: '/resources/templates/restaurantDetails.html',
            controller: 'restaurantController'
        }).when('/:id/:restaurantId/order', {
            templateUrl: '/resources/templates/commonOrderList.html',
            controller: 'commonOrderList'
        }).otherwise({
            redirectTo: '/events'
        });
    }]);

