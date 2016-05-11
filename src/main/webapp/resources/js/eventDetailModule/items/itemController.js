var itemController = angular.module('itemController', []);

itemController.controller("createItem", function ($scope, ItemService, $filter, $http, $rootScope) {
    $scope.createItem = function (name, price, restaurantId) {
        console.log(restaurantId);

        ItemService.addNewItem(name, price, $rootScope.currentRestaurant, $rootScope.eventId).success(function (data) {
            $rootScope.restaurant = data;
            $scope.name = '';
            $scope.price = '';
        });
    };
});