var filter = angular.module("events.filter", []);

filter.filter('capitalize', function() {
    return function(token) {
        return token.charAt(0).toUpperCase() + token.slice(1);
    }
});
