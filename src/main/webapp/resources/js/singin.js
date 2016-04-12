(function () {
    'use strict';
    $rootScope.user = 'user';
    angular.module('FoodOrdering', [])
        .controller('singin', function ($rootScope) {
                     $rootScope.user = 'user';
        });
})();