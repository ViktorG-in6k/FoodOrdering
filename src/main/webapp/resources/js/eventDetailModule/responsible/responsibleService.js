var responsibleService = angular.module('responsibleService', []);

responsibleService.factory("TakeResponsibilityService", function ($http) {
    var service = {};

    service.takeResponsibility = function (orderId) {
        return $http.post("/orders/" + orderId + "/responsibility");
    };
    
    return service;
});