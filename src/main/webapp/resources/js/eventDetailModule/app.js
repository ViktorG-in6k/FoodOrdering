var app = angular.module('eventApp', [
    'eventApp.services',
    'eventApp.controllers',
    'eventApp.directives',
    'ngResource',
    'events.filter',
    "ngRoute"
]);

app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.when('/:id', {
            templateUrl: '/partials/eventDetails',
            controller: 'eventController'
        }).when('/:id/:restaurantId', {
            templateUrl: '/partials/restaurantDetails',
            controller: 'restaurantController'
        }).when('/:id/:restaurantId/order', {
            templateUrl: '/partials/commonOrderList',
            controller: 'commonOrderList'
        }).otherwise({
            redirectTo: '/AllEvents'
        });
    }]);

