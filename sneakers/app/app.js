'use strict';

// Declare app level module which depends on views, and core components
angular.module('sneakers', [
  'ngRoute',
  'sneakers.view1',
  'sneakers.view2',
  'sneakers.sneakers'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/view1'});
}]);
