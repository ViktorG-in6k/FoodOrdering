var eventController = angular.module('eventController', []);

eventController.controller('eventListController', function ($rootScope, EventList, Event) {
    $rootScope.events = Event.query();
    EventList.events = Event.query();
    EventList;
     delete $rootScope.eventName;
});

controllers.controller("createEventController", function ($scope, $rootScope, CreateEventService, EventList, DateTimePicker) {
    $scope.createEvent = function (name, date) {
        CreateEventService.saveEvent(name, date).then(function (response) {
            EventList.set(response.data);
            EventList;
            $rootScope.events = response.data;
            $scope.date = '';
            $scope.name = '';
        });
    };
    $scope.dateTimePickerConfig = DateTimePicker.getConfig();
});