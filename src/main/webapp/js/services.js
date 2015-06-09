'use strict';

/* Services */

var twitterMiningServices = angular.module('twitterMiningServices', ['ngResource']);

twitterMiningServices.factory('Data', ['$resource',
    function($resource){


        return $resource('rest/tweets/load', {}, {
            query: {
                method: 'GET',
                params: {},
                isArray: true
            }
        });
    }]);

twitterMiningServices.factory('DataFetched', ['$resource',
    function($resource){


        return $resource('rest/tweets/fetch', {}, {
            query: {
                method: 'GET',
                params: {},
                isArray: true
            }
        });
    }]);

twitterMiningServices.factory('sharedData',
    function(){
        var tweets;

        return {
            getTweets: function(){
                return tweets;
            },
            setTweets: function(val){
                tweets = val;
            }
        }
    });