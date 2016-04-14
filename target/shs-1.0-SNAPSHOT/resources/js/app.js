var app = angular.module('foodOrdering', ["ngRoute"]);

app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.when('/AllEvents', {
            templateUrl: '/partials/eventList',
            controller: 'eventController'
        }).when('/Delete', {
            templateUrl: '/partials/eventList',
            controller: 'eventController'
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

app.controller('eventController',function ($scope, eventService, $http) {
    $http.get('/eventsJson/').success(function (data) {
        $scope.events = data;
    });

});