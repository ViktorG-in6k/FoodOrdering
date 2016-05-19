var service = angular.module("commonOrder", []);

service.factory("CommonOrderService", function($http){
    var commonOrderService = {};

    commonOrderService.getItemList = function(orderId, itemId){
        return $http.get("api/orders/"+orderId+"/items/"+itemId);
    };

return commonOrderService;
});