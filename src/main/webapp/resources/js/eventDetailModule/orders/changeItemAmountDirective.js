var directive = angular.module('orderItemAmount', []);

directive.directive('changeItemAmountDirective', function () {
    return {
        templateUrl: '/resources/js/eventDetailModule/orders/changeItemTemplate.html',
        restrict: 'E',
        scope: {
            amount: '=',
            itemId: '@',
            orderId: '@',
            itemName:'@'
        },
        controller: function (OrderListService, $http, $scope, CommonOrderService) {

            function updateUsersItemList() {
                CommonOrderService.getItemList($scope.orderId, $scope.itemId).success(function (data) {
                    $scope.itemList = data;
                });
            }

            updateUsersItemList();

            $scope.addOneItemToUserOrder = function (userId) {
                OrderListService.addOneItemToUserOrder($scope.itemId, $scope.orderId, userId).success(function () {
                    updateUsersItemList();
                    $scope.amount = $scope.amount + 1;
                })
            };

            $scope.removeOneItemFromUserOrder = function (userId) {
                OrderListService.removeOneItemFromUserOrder($scope.itemId, $scope.orderId, userId).success(function () {
                    updateUsersItemList();
                    $scope.amount = $scope.amount - 1;
                    if($scope.amount == 0){
                        OrderListService.updateCommonOrder();
                    }
                })
            };


            $scope.removeItemFromUserOrder = function (userId, itemAmount) {
                OrderListService.removeItemFromUserOrder($scope.orderId, $scope.itemId, userId).success(function(){
                    updateUsersItemList();
                    $scope.amount = $scope.amount - itemAmount;
                    if($scope.amount == 0){
                        OrderListService.updateCommonOrder();
                    }
                });
            }


        }
    };
});