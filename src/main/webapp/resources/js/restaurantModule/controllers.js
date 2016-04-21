var controllers = angular.module('restaurantManageApp.controllers', []);

controllers.controller("update", function ($routeParams,$scope, $http, editableThemes, editableOptions) {

    editableThemes.bs3.inputClass = 'form-control';
    editableOptions.theme = 'bs3';

    $scope.updateName = function(name, id){
        console.log(id);
        var dataForRequest = {"id":id, "name":name};
        $http.post('/update_restaurant_name',dataForRequest).success(function (data) {
            return data;
        });
    };

    $scope.updateDescription = function(description, id){
        console.log(id);
        var dataForRequest = {"id":id, "description":description};
        $http.post('/update_item_name',dataForRequest).success(function (data) {
            return data;
        });
    };
});

