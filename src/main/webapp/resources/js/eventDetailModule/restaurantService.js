var restaurantService = angular.module('restaurantService', []);

restaurantService.factory("Restaurant", ['$resource', function ($resource) {
    return $resource('/events/:eventId/restaurants/:restaurantId', {
        eventId: '@eventId',
        restaurantId: '@restaurantId'
    });
}]);

