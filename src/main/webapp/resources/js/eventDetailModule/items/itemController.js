var itemController = angular.module('itemController', []);

itemController.controller("createItem", function ($scope, ItemService, $filter, $http, $rootScope) {
    $scope.createItem = function (name, price) {
        ItemService.addNewItem(name, price, $rootScope.currentRestaurant, $rootScope.eventId).then(function () {
            ItemService.updateItemsList();
            $scope.name = '';
            $scope.price = '';
        });;
    };
});