angular.module('sneakers.sneakers', ['ngRoute']).
config(['$routeProvider', function($routeProvider) {
  //$locationProvider.hashPrefix('!');

  $routeProvider.
  when('/sneakers',{
  	templateUrl: 'sneakers/sneakers.html',
  	controller: 'SneakersCtrl'
  }).
  when('/sneakers/:id',{
  	templateUrl: 'sneakers/sneakers-details.html',
  	controller: 'SneakersDetailsCtrl'
  })
}])

.controller('SneakersCtrl', ['$scope', '$http', function($scope, $http){
	$http.get('http://10.22.184.204:8080/api/sneakers').then(function(response){
	$scope.sneakers = response.data;
	console.log($scope.sneakers);
	});
}])
.controller('SneakersDetailsCtrl', ['$scope', '$routeParams', '$http', function($scope, $routeParams, $http){
	var sneakerId = $routeParams.id;
	console.log(sneakerId);
	$http.get('http://10.22.184.204:8080/api/sneaker/' + sneakerId).then(function(response){
	$scope.sneaker = response.data;
	console.log($scope.sneaker);
	});
}]);
