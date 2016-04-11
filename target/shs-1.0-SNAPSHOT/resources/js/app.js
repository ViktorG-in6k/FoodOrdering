var app = angular.module('myApp', []);
app.controller('myCtrl', function () {
    $http({method: 'GET', url: '/my_order'}).success(
        function (data, status, headers, config) {
            console.log(data)
    }).error(function (response) {
        console.log(response)
    })  

});