var controllers = angular.module('eventApp.controllers', []);

controllers.controller("eventController", function ($http, $scope, $routeParams, $rootScope, OrderListService) {
    $rootScope.eventId = $routeParams.id;
    $rootScope.restaurant = null;
    $scope.addToOrder = OrderListService.addToOrder;
    $scope.removeFromOrder = OrderListService.removeFromOrder;
    $scope.removeOneItemFromOrder = OrderListService.removeOneItemFromOrder;

    $scope.getTotal = OrderListService.getTotal;

    $http.get("/restaurants").success(function (data) {
        $scope.restaurants = data;
    });

    $http.get("/event_" + $rootScope.eventId).success(function (data) {
        $scope.event = data;
    });
});

controllers.controller("restaurantController", function ($http, $scope, $routeParams, $rootScope, OrderListService) {
    $rootScope.currentRestaurant = $routeParams.restaurantId;
    $rootScope.eventId = $routeParams.id;
    console.log($rootScope.eventId);
    $scope.addToOrder = OrderListService.addToOrder;
    $scope.removeFromOrder = OrderListService.removeFromOrder;
    $scope.removeOneItemFromOrder = OrderListService.removeOneItemFromOrder;
    $scope.getTotal = OrderListService.getTotal;



    $http.get("/restaurants").success(function (data) {
        $scope.restaurants = data;
    });

    $http.get("/restaurant_" + $rootScope.currentRestaurant).success(function (data) {
        $rootScope.restaurant = data;
    });
});


controllers.controller("createItem", function ($scope, ItemService, $filter, $http, $rootScope) {
    $scope.createItem = function (name, price) {
        var dataForRequest = {"name": name, "price": price, "restaurantId": $rootScope.currentRestaurant};
        ItemService.addNewItem(dataForRequest).success(function (data) {
            $rootScope.restaurant = data;
            $scope.name = '';
            $scope.price = '';
        });
    };
});

controllers.controller("orderList", function (OrderListService, $scope) {
    $scope.addToOrder = OrderListService.addToOrder;
    $scope.removeFromOrder  = OrderListService.removeFromOrder;
    $scope.removeOneItemFromOrder = OrderListService.removeOneItemFromOrder;
    $scope.addToOrder = OrderListService.addToOrder;
    OrderListService.updateOrderList();
    
}
);

controllers.controller("navbarCtrl", function ($http, $scope) {

    $http.get('/eventsJson/').success(function (data) {
        $scope.events = data;
    });
});

