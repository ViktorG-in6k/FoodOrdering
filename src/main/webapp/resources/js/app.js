var app = angular.module('foodOrdering', ["ngRoute", "xeditable", "kendo.directives"]);

app.run(function (editableOptions, editableThemes) {
    editableThemes.bs3.inputClass = 'form-control';
    editableOptions.theme = 'bs3';
});

app.controller('Ctrl', function ($routeParams, $scope, $http, editableThemes, editableOptions) {

    editableThemes.bs3.inputClass = 'form-control';
    editableOptions.theme = 'bs3';

    $scope.updatePrice = function (data, id, eventId) {
        console.log(id);
        var dataForRequest = {"id": id, "price": data, "eventId": eventId};
        $http.post('/update_item_price', dataForRequest).success(function (data) {
            return data;
        });
    };

    $scope.updateName = function (data, id, eventId) {
        console.log(id);
        var dataForRequest = {"id": id, "name": data, "eventId": eventId};
        $http.post('/update_item_name', dataForRequest).success(function (data) {
            return data;
        });
    }
});

app.controller('CreteTheEventController', function ($routeParams, $scope, $http, $filter) {
    $scope.createEvent = function (name, description, date) {
        console.log($filter('date')(date, "yyyy-MM-dd HH:mm"));
        var datetime = $filter('date')(date, "yyyy-MM-dd HH:mm");
        var dataForRequest = {"name": name, "description": description, 'date': datetime};
        $http.post('/new_event', dataForRequest).success(function (data) {
            return data;
        });
    }
});

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
        }).when('/commonOrderByUsers/:eventId/', {
            templateUrl: '/partials/comonOrderByEachUser',
            controller: 'commonOrderByEachUserCtrl'
        }).otherwise({
            redirectTo: '/AllEvents'
        });
    }
]);

app.factory('eventService', function ($http) {
    var events = {};
    events.getEvents = function () {
       return $http.get('/eventsJson/');
    };
    return events;
});


app.controller('commonOrderCtrl', function ($routeParams, $http, $rootScope, $scope) {
    $rootScope.id = $routeParams.eventId;
    $scope.restoraunt = "";

    $scope.changeOrderItemStatus = function (eventId, itemId, ordred) {
        $http.get("/update_ordered" + eventId + "_" + itemId + "_" + ordred).then(function () {
            $scope.updateCommonOrder();
        });
    };

    $scope.updateCommonOrder = function () {
        $http.get('/CommonOrderJson_' + $routeParams.eventId).success(function (data) {
            $scope.eventOrderList = data;
        });
    };
    $scope.updateCommonOrder();

    $scope.getTotal = function () {
        var total = 0;
        if ($scope.eventOrderList) {
            for (var i = 0; i < $scope.eventOrderList.myOrderList.length; i++) {
                total += $scope.eventOrderList.myOrderList[i].count * $scope.eventOrderList.myOrderList[i].item.price;
            }
        } else return 0;
        return total;
    };
});

app.controller('commonOrderByEachUserCtrl', function ($routeParams, $http, $rootScope, $scope) {
    $rootScope.id = $routeParams.eventId;

    $scope.changeOrderItemStatus = function (eventId, itemId, ordred) {
        $http.get("/update_ordered" + eventId + "_" + itemId + "_" + ordred).then(function () {
            $scope.updateCommonOrder();
        });
    };

    $scope.updateCommonOrder = function () {
        $http.get('/CommonOrder_' + $routeParams.eventId).success(function (data) {
            $scope.array = data;
        });
    };
    $scope.updateCommonOrder();
});

app.controller('eventController', function ($scope, eventService,$rootScope,$http) {
    eventService.getEvents().success(function (data) {
        $rootScope.events = data;
    });

});

app.factory('orderService', function ($http) {
    var orders = {};
    orders.getOrders = function () {
        $http.get('/ordersJson/*').success(function (data) {
            return data;
        });
    };
    return orders;
});

app.controller('orderController', function ($scope, orderService, $http) {
    $http.get('/ordersJson/*').success(function (data) {
        $scope.orders = data;
    });
});

app.controller("navbarCtrl", function ($http, $scope) {
    $http.get('/eventsJson/').success(function (data) {
        $scope.events = data;
    });
});
app.filter('capitalize', function() {
    return function(token) {
        return token.charAt(0).toUpperCase() + token.slice(1);
    }
});

app.controller("createEventController", function ($scope, $filter, $http, $rootScope) {
    $scope.createEvent = function (name, date) {
        var sentDate = $filter("date")(date, "yyyy-MM-dd HH:mm");
        $http({
            url: '/newEvent',
            method: "GET",
            params: {"name": name,"date":sentDate}
        }).then(function (response) {
            $rootScope.events = response.data;
            $scope.date = new Date();
            $scope.name = '';
        });
    };

    $scope.date = new Date();
    $scope.monthPickerConfig = {
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
        },
        change: function () {
            var value = this.value();
            console.log(value); //value is the selected date in the timepicker
        }
    };
});

app.factory("EventService", function ($filter, $scope) {

});