'use strict';

/* Controllers */

var twitterMiningControllers = angular.module('twitterMiningControllers', ['twitterMiningServices']);

twitterMiningControllers.controller('tweetsListCtrl', ['$scope', 'Data', 'DataFetched', 'sharedData',
    function($scope, Data, DataFetched, sharedData){

        $scope.fetching = true;
        $scope.loading = true;
        Data.query({}, function(tweets){
            $scope.tweets = tweets;
            sharedData.setTweets(tweets);
            console.log("loaded tweets");
            $scope.loading = false;
        });

        $scope.fetchTweets = function(){
            $scope.fetching = false;
            $scope.loading = true;
            DataFetched.query({}, function(tweets){
                $scope.tweets = tweets;
                sharedData.setTweets(tweets);
                console.log("fetched tweets");
                $scope.loading = false;
                $scope.fetching = true;
            });
        };


    }]);

twitterMiningControllers.controller('chartCtrl', ['$scope', 'sharedData',
    function($scope, sharedData){
        $scope.labels = ["Positive", "Negative"];
        var p = 0, n = 0;
        var tweets = sharedData.getTweets();
        tweets.forEach(function(t){
            if(t.positive === true){
                p++;
            }else{
                n++;
            }
        });

        $scope.data = [p, n];
    }]);