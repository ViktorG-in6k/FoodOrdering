var responsibleService = angular.module('responsibleService', []);

responsibleService.factory("ResponsibilityService", function ($http) {
    var service = {};

    service.takeResponsibility = function (orderId) {
        return $http.post("/orders/" + orderId + "/responsibility");
    };
    
    service.removeResponsibility = function (orderId) {
        return $http.delete("/orders/" + orderId + "/responsibility");
    };
    
    return service;
});
