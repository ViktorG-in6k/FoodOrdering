var services = angular.module('restaurantManageApp.services',[]);

services.factory("RestaurantService",function ($http, $rootScope) {
    var restaurantService = {};
    
    restaurantService.updateRestaurant = function () {
        $http.get("/MyOrderJson_" + $rootScope.eventId).success(function (data) {
            $rootScope.myOrders = data;
        })
    };
});
