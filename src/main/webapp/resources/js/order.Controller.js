(function () {
    'use strict';

    angular
        .module('order').controller('OrdersController', OrdersController);

    OrdersController.$inject = ['$q', 'OrdersUtils'];

    function OrdersController($q, OrderUtils) {

        var orders = this;

        orders.ordersNameRegExp = '[A-Z]{2}-[0-9]{2,3}';

        init();

        function init() {
            orders.loading = true;
            loadOrders()
        }

        function loadOrders() {
            OrdersUtils.getAllOrders()
                .then(function (result) {
                    orders.ordersList = result;
                    orders.loading = false;
                }, function (err) {
                    orders.loading = false;
                });
        }

        orders.rememberOldOrdersName = function (name) {
            orders.oldOrdersName = name;
        }

        orders.checkOrderName = function (name) {
            if (orders.oldOrderName != name) {
                var d = $q.defer();
                OrdersUtils.checkOrderName(name)
                    .then(function (result) {
                        switch (result) {
                            case true:
                                OrdersUtils.updateOrderName(orders.oldOrderpName, name);
                                d.resolve();
                                break
                            case false:
                                d.resolve('Order name already exist');
                                break;
                        }
                    });
                return d.promise;
            }

        }

        orders.addNewOrder = function (order) {
            OrdersUtils.create(order)
                .then(function (ok) {
                    orders.order.name = "";
                    orders.orderForm.$setPristine();
                    orders.orderForm.$setValidity();
                    orders.nameExist = false;
                    loadOrders();
                }, function (err) {
                    orders.nameExist = true;
                    orders.orderForm.name.$pristine = false;
                    orders.orderForm.name.$invalid = true;
                });
        }
    }
})();