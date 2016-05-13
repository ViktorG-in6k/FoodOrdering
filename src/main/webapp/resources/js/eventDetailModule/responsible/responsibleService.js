var responsibleService = angular.module('responsibleService', []);

responsibleService.factory("TakeResponsibilityService", function ($http) {
    var service = {};

    service.takeResponsibility = function (orderId) {
        return $http.post("/orders/" + orderId + "/responsibility");
    };
    
    return service;
});

responsibleService.factory("RemoveResponsibilityService", function ($http) {
    var service = {};

    service.removeResponsibility = function (orderId) {
        return $http.delete("/orders/" + orderId + "/responsibility");
    };

    return service;
});