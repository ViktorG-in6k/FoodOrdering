var app = angular.module('foodOrdering', ["ngRoute"]);

app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.when('/AllEvents', {
            templateUrl: '/partials/eventList',
            controller: 'eventController'
        }).when('/Delete', {
            templateUrl: '/partials/eventList',
            controller: 'eventController'
        }).when('/commonOrder/:eventId/', {
            templateUrl: '/partials/commonOrder',
            controller: 'commonOrderCtrl'
        }).otherwise({
            redirectTo: '/AllEvents'
        });
    }]);

app.factory('eventService',function($http){
    var events = {};
    events.getEvents = function () {
         $http.get('/eventsJson/').success(function (data) {
             return data;
         });
    };
    return events;
});

app.controller('commonOrderCtrl',function ($routeParams, $http, $rootScope, $scope) {
    $rootScope.id = $routeParams.eventId;

    $http.get('/CommonOrderJson_' + $routeParams.eventId ).success(function (data) {
        $scope.eventOrderList = data;
    });

});


app.controller('eventController',function ($scope, eventService, $http) {
    $http.get('/eventsJson/').success(function (data) {
        $scope.events = data;
    });
});

app.factory('orderService',function($http){
    var orders = {};
    orders.getOrders = function () {
        $http.get('/ordersJson/*').success(function (data) {
            return data;
        });
    };
    return orders ;
});

app.controller('orderController',function ($scope, orderService, $http) {
    $http.get('/ordersJson/*').success(function (data) {
        $scope.orders = data;
    });
});