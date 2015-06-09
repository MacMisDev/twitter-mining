'use strict';

/* Directives */

var twitterMiningDirectives = angular.module('twitterMiningDirectives', []);

twitterMiningDirectives.directive('tableHead', function() {
    console.log('ta');
    return {
        //'E' - only matches element name

        restrict: 'A',
        templateUrl: 'partials/table.html'
    };
});