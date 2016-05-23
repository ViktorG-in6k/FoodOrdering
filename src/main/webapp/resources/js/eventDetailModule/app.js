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
    'itemService',

    'responsibleService',
    'orderPlacementStatusController',
    'orderPlacementStatusService',
    'ngAnimate',
    'ui.bootstrap',
    'orderItemAmount',
    'commonOrder',
    'xeditable',
    'discountFilters'
]);

app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.when('/events', {
            templateUrl: '/resources/templates/eventsList.html',
            controller: 'eventListController'
        }).when('/events/:id', {
            templateUrl: '/resources/templates/eventDetails.html',
            controller: 'eventController'
        }).when('/:id/:restaurantId/:orderId', {
            templateUrl: '/resources/templates/restaurantDetails.html',
            controller: 'restaurantController'
        }).when('/:id/restaurant/:restaurantId/menu', {
            templateUrl: '/resources/templates/restaurantDetailsMenu.html',
            controller: 'restaurantMenu'
        }).when('/:id/:restaurantId/:orderId/order', {
            templateUrl: '/resources/templates/commonOrderList.html',
            controller:'commonOrderList'
        }).otherwise({
            redirectTo: '/events'
        });
    }]);

