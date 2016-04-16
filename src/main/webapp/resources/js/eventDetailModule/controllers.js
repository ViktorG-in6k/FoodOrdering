var controllers = angular.module('eventApp.controllers', []);

controllers.controller("eventController", function ($http, $scope, $routeParams, $rootScope) {
    $rootScope.eventId = $routeParams.id;

    $scope.addToOrder = function (eventId, ItemId) {
        console.log("hello");
        $http({
            method: 'POST',
            url: '/add_to_order',
            headers: {
                'Content-Type': undefined
            },
            params: {
                event_id: eventId,
                item_id: ItemId
            }
        }).success(function (data) {
        })
    };
    $http.get("/restaurants").success(function (data) {
        $scope.restaurants = data;
    })
});

controllers.controller("orderList", function ($rootScope, $interval, $http, $scope) {
    $interval(function () {
        $http.get("/MyOrderJson_" + $rootScope.eventId).success(function (data) {
            console.log(data);
            $scope.myOrders = data;
        })
    }, 1000);

});
/*
 <input type="hidden" value="1" name="event_id">
 <input type="hidden" value="11" name="item_id">*/
