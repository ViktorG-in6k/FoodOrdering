var restaurantService = angular.module('restaurantService', []);

restaurantService.factory("Restaurants", ['$resource', function ($resource) {
    return $resource('/events/:eventId/restaurants');
}]);

restaurantService.factory("RestaurantService", function ($http, $rootScope) {
    var restaurantService = {};
    restaurantService.getRestaurantById = function (id) {
        return $http.get("/events/" + $rootScope.eventId + "/restaurants/" + id)
    };

    restaurantService.createRestaurant = function (restaurant) {
        return $http({
            url: "api/restaurants",
            method: "POST",
            params: {
                name: restaurant.title,
                link: restaurant.link,
                phone: restaurant.phone
            }
        });
    };
    return restaurantService;
});

restaurantService.factory("Restaurant", ['$resource', function ($resource) {
    return $resource('/events/:eventId/restaurants/:restaurantId');
}]);



