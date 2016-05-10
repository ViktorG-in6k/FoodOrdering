var controllers = angular.module('eventApp.controllers', []);

controllers.controller("eventController", function ($http, $scope, $routeParams, $rootScope, OrderListService) {
        $rootScope.eventId = $routeParams.id;
        $rootScope.restaurant = null;
        $scope.addToOrder = OrderListService.addToOrder;
        $scope.removeFromOrder = OrderListService.removeFromOrder;
        $scope.removeOneItemFromOrder = OrderListService.removeOneItemFromOrder;
        $scope.getTotal = OrderListService.getTotal;
        $http.get("/event_" + $rootScope.eventId +"/restaurants").success(function (data) {
            $scope.restaurants = data;
        });

        $http.get("/event_" + $rootScope.eventId).success(function (data) {
            $scope.event = data;
        });
    }
);

controllers.controller("restaurantController", function ($http, $scope, $routeParams, $rootScope, OrderListService) {
    $rootScope.currentRestaurant = $routeParams.restaurantId;
    $rootScope.eventId = $routeParams.id;
    $rootScope.orderId = $routeParams.order;

    $http.get("/CommonOrderJson_" + $rootScope.eventId + "/" + $rootScope.currentRestaurant).success(function (data) {
        $rootScope.responsible = data.userResponsibility;
    });
    $scope.addToOrder = OrderListService.addToOrder;
    $scope.removeFromOrder = OrderListService.removeFromOrder;
    $scope.removeOneItemFromOrder = OrderListService.removeOneItemFromOrder;
    $scope.getTotal = OrderListService.getTotal;
    
    $http.get("/event_" + $rootScope.eventId +"/restaurants").success(function (data) {
        $scope.restaurants = data;
    });

    $http.get("/event_" + $rootScope.eventId +"/restaurant_" + $rootScope.currentRestaurant).success(function (data) {
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

controllers.controller("orderList", function (OrderListService, $scope, $rootScope, $http) {
        $scope.addToOrder = OrderListService.addToOrder;
        $scope.removeFromOrder = OrderListService.removeFromOrder;

        $scope.updateNumberItemToOrder = OrderListService.updateNumberItemToOrder;
      
        $scope.updateOrderList =  OrderListService.updateOrderList();

        $scope.CommonOrder =  OrderListService.CommonOrder();
        $scope.changeItemNumber = OrderListService.changeItemNumber;
        $scope.addOneItemToOrder = OrderListService.addOneItemToOrder;
        $scope.removeOneItemFromOrder = OrderListService.removeOneItemFromOrder;
        $scope.myItems = 'active';

        $scope.getMyItems = function () {
            OrderListService.updateOrderList();
        };
        $scope.getAllItems = function () {
            $http.get("/CommonOrderJson_" + $rootScope.eventId + "/" + $rootScope.currentRestaurant).success(function (data) {
                $rootScope.myOrders = data;
                $rootScope.commonOrders = data;
            })
        }
        OrderListService.updateOrderList();
    }
);

controllers.controller("navbarCtrl", function ($http, $scope) {
    $http.get('/eventsJson/').success(function (data) {
        $scope.events = data;
    });
});

controllers.controller("commonOrderList", function ($scope, EventService, $routeParams, $rootScope, OrderListService, RestaurantService, $http) {
    $rootScope.eventId = $routeParams.id;
    $rootScope.currentRestaurant = $routeParams.restaurantId;
    EventService.getEventById($scope.eventId).success(function (data) {
        $scope.event = data;
    });
    RestaurantService.getRestaurantById($rootScope.currentRestaurant).success(function (data) {
        $rootScope.restaurant = data;
        
    });
    $rootScope.order = "Order";
    $rootScope.currentRestaurant = $routeParams.restaurantId;

    $scope.getTotal = OrderListService.getTotal;

    $http.get("/CommonOrderJson_" + $rootScope.eventId + "/" + $rootScope.currentRestaurant).success(function (data) {
        $rootScope.myOrders = data;
        $rootScope.commonOrders = data;
    })
});

controllers.controller("myCtrl",function ($scope, myService) {
    $scope.word = "lol";
})

