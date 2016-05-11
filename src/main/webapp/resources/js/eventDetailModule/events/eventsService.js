var eventService = angular.module('eventService', []);

eventService.factory('CreateEventService', function ($http, $filter) {
    var events = {};
    events.saveEvent = function (name, date) {
        var sentDate = $filter("date")(date, "yyyy-MM-dd HH:mm");
        return $http({
            url: '/events',
            method: "POST",
            params: {"name": name, "date": sentDate}
        })
    };
    return events;
});

eventService.factory('Event', ['$resource', function ($resource) {
    return $resource('/events/:id');
}]);

