var app = angular.module('myApp', ['ngMaterial']);



app.controller('AppCtrl', function ($scope, $mdSidenav, $mdPanel) {

	

	$scope.toggleSidenav = buildToggler('closeEventsDisabled');

	

	function buildToggler(componentId) {

      return function() {

        $mdSidenav(componentId).toggle();

      };

    }




});