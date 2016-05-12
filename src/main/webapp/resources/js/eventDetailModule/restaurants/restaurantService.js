var restaurantService = angular.module('restaurantService', []);

restaurantService.factory("Restaurants", ['$resource', function ($resource) {
    return $resource('/events/:eventId/restaurants');
}]);

restaurantService.factory("RestaurantService", function ($http, $rootScope) {
    var restaurantService = {};
    restaurantService.getRestaurantById = function (id) {
        return $http.get("/events/" + $rootScope.eventId + "/restaurants/" + id)
    };
    return restaurantService;
});

restaurantService.factory("Restaurant", ['$resource', function ($resource) {
    return $resource('/events/:eventId/restaurants/:restaurantId');
}]);

restaurantService.factory("newRestaurant",  function ($http) {
    var restaurantService = {};

    restaurantService.createRestaurant = function (restaurant, eventId) {
        $http({
            url: "/new_restaurant",
            method: "POST",
            params: {
                name: restaurant.title,
                link: restaurant.link,
                phone: restaurant.phone,
                eventId: eventId
            }
        }).success(function () {
            $scope.restaurant = {};
            $scope.restaurant.link = '';
            $http.get("/events/" + eventId + "/restaurants").success(function (data) {
                $scope.restaurants = data;
            });
        })
    };
    return restaurantService;
});

