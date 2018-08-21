var app = angular.module("jsbin", ['ngMaterial']);

app.filter('secondsToDateTime', function() {
    return function(seconds) {
        return new Date(1970, 0, 1).setSeconds(seconds);
    };
})

app.controller("DemoCtrl", function($scope,$http,$interval) {
	var intervalId;
	$scope.Answers = {};
	$scope.counter = 0;
	$scope.initialCountdown = 10;
	$scope.countdown = $scope.initialCountdown;
	
	$scope.getData = function(){
		$http({
			url: 'getQuestions',
			method: 'GET'
		}).then(function(resp){
			
			$scope.questions = resp.data;
			$scope.index = 0;
	    	
	    	$scope.complaints = $scope.questions[0];
	    	
	    	$scope.getNext = function (){
		  	    $scope.index = $scope.index + 1;
		  	    $scope.complaints = $scope.questions[$scope.index];
	  	    }

	  	  	$scope.getPrevious = function (){
		  	    $scope.index = $scope.index - 1;
		  	    $scope.complaints = $scope.questions[$scope.index];
	  	    }
		}, function(resp){
			alert("Error Occoured.");
		});
	};
	
	$scope.getUserResponse = function(){
		console.log($scope.Answers)
	};
		
	$scope.timer = function(){
	    var startTime = new Date();
	    intervalId = $interval(function(){
	        var actualTime = new Date();
	        $scope.counter = Math.floor((actualTime - startTime) / 1000);
	        $scope.countdown = $scope.initialCountdown - $scope.counter;
	    }, 1000);
	 };
	 
	 $scope.$watch('countdown', function(countdown){
		    if (countdown === 0){
		        $scope.stop();
		    }
	 });

	$scope.start = function(){
		    $scope.timer();
	};

	$scope.stop = function(){
		    $interval.cancel(intervalId);
	};
	
	
	
	
	
});