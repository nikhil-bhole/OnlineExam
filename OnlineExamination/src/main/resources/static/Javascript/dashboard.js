var app = angular.module("myApp", ['ngMaterial', 'ngMessages']);

app.controller("AppCtrl", function($scope,$http,$interval,$location,$mdSidenav, $mdPanel) {
	
$scope.toggleSidenav = buildToggler('closeEventsDisabled');

	

	function buildToggler(componentId) {

      return function() {

        $mdSidenav(componentId).toggle();

      };

    }
	
	  
	 
});