var filter = angular.module("events.filter", []);

filter.filter('capitalize', function() {
    return function(token) {
        if(token){
            return token.charAt(0).toUpperCase() + token.slice(1);
        }return token;
    }
});

filter.filter('toMinute', function() {
    return function(minute) {
        var str = '' + minute;
        if(str.length == 1){
            return '0' + minute;
        }
        return minute
    }
});

