var services = angular.module('eventApp.services', []);



services.factory("EventService", function ($http) {
    var eventService = {};

    eventService.getEventById = function (id) {
        return $http.get("/event_" + id);
    };

    return eventService;
});

services.factory("DateTimePicker", function () {
    var dateTimePicker = {};
    dateTimePicker.getConfig = function () {
        return {
            format: "dd-MM-yyyy HH:mm",
            timeFormat: "HH:mm",
            animation: {
                close: {
                    effects: "fadeOut zoom:out",
                    duration: 300
                },
                open: {
                    effects: "fadeIn zoom:in",
                    duration: 300
                }
            },
            disableDates: function (date) {
                var today = new Date();
                var tommorow = today.setDate(today.getDate() - 1);
                return date <= tommorow;
            }
        };
    };
    return dateTimePicker;
});


