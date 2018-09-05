var app = angular.module("myApp", ['ngMaterial']);

app.controller("CtrlTwo", function($scope,$http,$interval,$location,$mdSidenav) {
	
	$scope.toggleSidenav = buildToggler('closeEventsDisabled');
	
	function buildToggler(componentId) {
      return function() {
        $mdSidenav(componentId).toggle();
      };
    }
	
	$scope.logout = function() {
        $http.get('/logout').then(function() {
        	$location.url('login');
        })
    }
	
});

