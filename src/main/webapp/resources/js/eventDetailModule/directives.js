var direcitves = angular.module('eventApp.directives', []);

direcitves.directive('slideToggle', function() {
    return {
        restrict: 'A',
        scope:{},
        controller: function ($scope) {},
        link: function(scope, element, attr) {
            element.bind('click', function() {
                var $slideBox = angular.element(attr.slideToggle);
                var slideDuration = parseInt(attr.slideToggleDuration, 10) || 200;
                $slideBox.stop().slideToggle(slideDuration);
            });
        }
    };
});

direcitves.directive('myD',function () {
    return {
        link: function($scope){

        }
    }
})