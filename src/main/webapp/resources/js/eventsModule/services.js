var services = angular.module('events.services', []);
services.factory('EventService', function ($http, $filter) {
    var events = {};
    events.getEvents = function () {
        return $http.get('/eventsJson/');
    };
    events.saveEvent = function (name, date) {
        var sentDate = $filter("date")(date, "yyyy-MM-dd HH:mm");
        return  $http({
            url: '/newEvent',
            method: "GET",
            params: {"name": name,"date":sentDate}
        })
    };
    return events;
});

app.factory("DateTimePicker",function () {
    var dateTimePicker= {};
    dateTimePicker.getConfig = function () {
        return {
            format: "dd-MM-yyyy HH:mm",
            timeFormat: "HH:mm",
            value: new Date(),
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


