var discount = angular.module("discountService", []);

discount.service("DiscountService", function ($http) {
    var discountService = {};

    discountService.changePercentageDiscount = function (orderId, percentage) {
        return $http({
            url: "api/orders/" + orderId + "/percentageDiscount",
            method: "PUT",
            params: {percentage: percentage}
        })
    };

    discountService.changeAmountDiscount = function (orderId, amount) {
        return $http({
            url: "api/orders/" + orderId + "/amountDiscount",
            method: "PUT",
            params: {amount: amount}
        })
    };
    
    return discountService;
});