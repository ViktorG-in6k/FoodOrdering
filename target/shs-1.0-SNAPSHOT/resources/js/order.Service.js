(function () {
    'use strict';

    angular.module('order').factory('OrdersUtils', OrdersUtils);

    OrdersUtils.$inject = ['$q', '$http'];

    function OrdersUtils($q, $http) {

        function create(order) {
            var defer = $q.defer();

            $http.post('/admin/api/orders', order)
                .success(function (ok, status, headers, config) {
                    defer.resolve(ok);
                })
                .error(function (err, status, headers, config) {
                    defer.reject(err);
                });

            return defer.promise;
        }

        function getAllOrders() {
            var defer = $q.defer();

            $http.get('/app/orders')
                .success(function (ok, status, headers, config) {
                    defer.resolve(ok);
                })
                .error(function (err, status, headers, config) {
                    defer.reject(err);
                });

            return defer.promise;
        }

        function checkName(name) {
            var defer = $q.defer();

            $http.get('/admin/api/orders/' + name + '/check')
                .success(function (ok, status, headers, config) {
                    defer.resolve(ok);
                })
                .error(function (err, status, headers, config) {
                    defer.reject(err);
                });

            return defer.promise;
        }

        function updateOrderName(oldName, newName) {
            var defer = $q.defer();

            var updateOrderNameRequestData = {
                oldName: oldName,
                newName: newName
            };

            $http.post('/admin/api/orders/update-name', updateOrderNameRequestData)
                .success(function (ok, status, headers, config) {
                    defer.resolve(ok);
                })
                .error(function (err, status, headers, config) {
                    defer.reject(err);
                });

            return defer.promise;
        }

        return {
            create: create,
            getAllOrders: getAllOrders,
            checkOrderName: checkName,
            updateOrderName: updateOrderName,
        };
    }
})();