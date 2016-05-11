var app = angular.module("events.controllers",[]);

app.controller('eventController', function ($scope, EventService,$rootScope) {
    EventService.getEvents().success(function (data) {
        $rootScope.events = data;
    });
});

app.controller("createEventController", function ($scope, $rootScope,EventService, DateTimePicker) {
    $scope.createEvent = function (name, date) {
        EventService.saveEvent(name,date).then(function (response) {
            $rootScope.events = response.data;
            $scope.date = new Date();
            $scope.name = '';
        });
    };
    $scope.dateTimePickerConfig = DateTimePicker.getConfig();
});

app.controller("navbarCtrl", function ($http, $scope, $rootScope) {
    $http.get('/eventsJson/').success(function (data) {
        $scope.events = data;
    });

    $http.get("/getCurrentUser").then(function (data) {
        $rootScope.user = data;
    })
});


