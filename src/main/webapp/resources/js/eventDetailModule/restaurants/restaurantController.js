var restaurantController = angular.module('restaurantController', []);

restaurantController.controller("restaurantController", function ($http, OrderListService, $scope, $routeParams, $rootScope,
                                                                  Restaurant, ResponsibilityService, $uibModal, ItemService) {
    $rootScope.currentRestaurant = $routeParams.restaurantId;
    $rootScope.eventId = $routeParams.id;
    $rootScope.orderId = $routeParams.orderId;

    $rootScope.restaurant = Restaurant.get({
        eventId: $rootScope.eventId,
        restaurantId: $rootScope.currentRestaurant
    });

    $http.get("api/orderPlacementStatus/" + $rootScope.orderId).success(function (orderPlacementStatus) {
        $scope.orderPlacementStatus = orderPlacementStatus;
    });

    $scope.takeResponsibility = function (orderId) {
        ResponsibilityService.takeResponsibility(orderId).success(function () {
            $http.get("api/orderPlacementStatus/" + $rootScope.orderId).success(function (orderPlacementStatus) {
                $scope.orderPlacementStatus = orderPlacementStatus;
            });
        })
    };

    $scope.openModal = function () {
        var modal = $uibModal.open({
            animation: true,
            templateUrl: 'myModalContent.html',
            controller: function ($scope, $uibModalInstance) {
                $scope.ok = function () {
                    $uibModalInstance.close('ok');
                };
                $scope.cancel = function () {
                    $uibModalInstance.dismiss('cancel');
                };
            }
        });
        modal.result.then(function () {
            $scope.removeResponsibility($scope.orderId);
        });
    };

    $scope.updateItemTitle = ItemService.updateItemTitle;

    $scope.getTotal = OrderListService.getTotal;
    $scope.removeResponsibility = function (orderId) {
        ResponsibilityService.removeResponsibility(orderId).success(function () {
            $http.get("api/orderPlacementStatus/" + $rootScope.orderId).success(function (orderPlacementStatus) {
                $scope.orderPlacementStatus = orderPlacementStatus;
            });
        })
    };
});

restaurantController.controller("restaurantMenu", function ($rootScope, Restaurant, $routeParams, $scope, Order, ItemService) {
    $rootScope.eventId = $routeParams.id;
    $rootScope.currentRestaurant = $routeParams.restaurantId;
    $rootScope.restaurant = Restaurant.get({
        eventId: $rootScope.eventId,
        restaurantId: $rootScope.currentRestaurant
    });
    $scope.updateItemTitle = ItemService.updateItemTitle;
    $scope.createOrder = function () {
        Order.createOrder($rootScope.eventId, $rootScope.currentRestaurant);
    }
});
