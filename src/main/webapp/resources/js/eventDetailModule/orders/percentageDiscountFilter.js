var filter = angular.module("discountFilters", []);

filter.filter("percentageFilter", function () {
    return function (price, percentage) {
        var discount = price * percentage / 100;
        return price - discount;
    }
});


