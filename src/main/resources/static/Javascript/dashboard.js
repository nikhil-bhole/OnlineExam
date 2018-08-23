var app = angular.module("myApp", ['ngMaterial', 'ngMessages']);

app.controller("AppCtrl", function($scope,$http,$interval,$location) {
	$scope.clearValue = function() {
	    $scope.quest = undefined;
	    $scope.favoriteColor = undefined;
	    $scope.myForm.$setPristine();
	  };
	  
	  $scope.startTest = function() {
	    /*if ($scope.myForm.$valid) {
	      $scope.myForm.$setSubmitted();
	      alert('Form was valid.');
	    } else {
	      alert('Form was invalid!');
	    }*/
		
		  window.location = "home";
		  
	  };
});