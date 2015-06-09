'use strict';

/* Filters */

var twitterMiningFilters = angular.module('twitterMiningFilters', []);

twitterMiningFilters.filter('checkWhoWin', function() {
    return function(input) {
        return input ? 'Radiant victory' : 'Dire victory';
    };
});
