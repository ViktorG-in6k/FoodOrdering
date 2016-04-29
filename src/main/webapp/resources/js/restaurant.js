var app = angular.module("restaurant", ["xeditable"]);
app.controller("main", function ($location, $scope, $http) {
    var i = $location.$$absUrl.lastIndexOf("_");
    $scope.restaurantId = $location.$$absUrl.substring(i + 1, $location.$$absUrl.length);
    $http.get("/restaurant_" + $scope.restaurantId).then(function (data) {
        $scope.restaurant = data.data;
    });

    $scope.updateRestaurantName = function (name, id) {
        var dataForRequest = {"id":id, "name":name};
        $http.post('/update_restaurant_name',dataForRequest).success(function (data) {
            return data;
        });
    };

    $scope.updateRestaurantDescription = function (phone, id) {
        var dataForRequest = {"id":id, "phone":phone};
        $http.post('/update_restaurant_description',dataForRequest).success(function (data) {
            return data;
        });
    };

    $scope.updateItemName = function (name, id) {
        var dataForRequest = {"id":id, "name":name};
        $http.post('/update_name_of_item',dataForRequest).success(function (data) {
            return data;
        });
    };

    $scope.updateItemPrice = function (price, id) {
        var dataForRequest = {"id":id, "price":price};
        $http.post('/update_price_of_item',dataForRequest).success(function (data) {
            return data;
        });
    };

    $scope.updateItemDescription = function (phone, id) {
        var dataForRequest = {"id":id, "phone":phone};
        $http.post('/update_description_of_item',dataForRequest).success(function (data) {
            return data;
        });
    };
})

