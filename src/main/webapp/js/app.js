'use strict';

/* App Module */

var twitterMining = angular.module('twitterMining', [
    'ngRoute',
    'ngResource',
    'twitterMiningControllers',
    'twitterMiningServices',
    'twitterMiningFilters',
    'twitterMiningDirectives',
    'chart.js'
]);

twitterMining.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/tweets', {
                templateUrl: 'partials/tweetsList.html',
                controller: 'tweetsListCtrl'
            })
            .when('/charts',{
                templateUrl: 'partials/charts.html',
                controller: 'chartCtrl'
            })
            .otherwise({
                redirectTo: '/tweets'
            });
}]);
