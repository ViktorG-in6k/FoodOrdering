var orderService = angular.module('orderService', []);

orderService.factory("Order",['$resource', function ($resource) {
    return $resource('/order_items/', {
        orderId: '@orderId'
    });
}]);