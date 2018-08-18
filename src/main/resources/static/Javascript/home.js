var app = angular.module("jsbin", ['ngMaterial']);

app.controller("DemoCtrl", function($scope,$http) {
	  
	  var vm = this;
	  var URL = 'getQuestions';
	  var request = {
		  method: 'GET',
		  url: URL,
	  };
	  
	  
	  $http(request).then(function(response) {
	    	$scope.vm.data = response.data;
	    	$scope.index = 0;
	    	
	    	$scope.complaints = vm.data[0];
	    	
	    	$scope.getNext = function (){
	  	    $scope.index = $scope.index + 1;
	  	    $scope.complaints = $scope.vm.data[$scope.index];
	  	    }

	  	  	$scope.getPrevious = function (){
	  	    $scope.index = $scope.index - 1;
	  	    $scope.complaints = $scope.vm.data[$scope.index];
	  	    }
	   }).
	  catch(function(response) {
	    	vm.data = response.data;
	  });
	  
	 
	  
});