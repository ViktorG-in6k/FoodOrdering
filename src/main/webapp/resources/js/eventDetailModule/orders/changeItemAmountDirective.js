var directive = angular.module('orderItemAmount', []);

directive.directive('changeItemAmountDirective', function() {
    return {
        templateUrl:'/resources/js/eventDetailModule/orders/changeItemTemplate.html',
        restrict: 'E',
        scope: {
            amount: '=',
            itemId: '@',
            orderId: '@'
        },
        controller:function($scope){
          console.log($scope.amount)
        }
    };
});


