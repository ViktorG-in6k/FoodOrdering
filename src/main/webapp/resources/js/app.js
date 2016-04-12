var app = angular.module('foodOrdering', ["ngRoute"]);



app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.when('/AllEvents', {
            templateUrl: 'partials/eventList',
            controller: 'eventController'
        }).when('/rooms/:roomId', {
            templateUrl: 'partials/roomDescriptionPartials',
            controller: 'roomDescriptionCntr'
        }).otherwise({
            redirectTo: '/rooms'
        });
    }]);


app.factory('eventService',function($http){

    var event = {'name':'lol','description':'kek'};
    event.getEvents = function () {
         $http.get('/eventJson/').success(function (data) {         
            event = data;
         });
    };
    return event;
});

app.controller('eventController',function ($scope,eventService) {
    $scope.event = eventService;
    console.log(eventService);
})