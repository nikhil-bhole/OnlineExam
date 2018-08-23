var app = angular.module("jsbin", ['ngMaterial']);

app.filter('secondsToDateTime', function() {
    return function(seconds) {
        return new Date(1970, 0, 1).setSeconds(seconds);
    };
})

app.controller("DemoCtrl", function($scope,$http,$interval,$location) {
	var intervalId;
	$scope.Answers = {};
	$scope.counter = 0;
	$scope.initialCountdown = 100;
	$scope.countdown = $scope.initialCountdown;
	// be used to decide for showing PostResults   
	$scope.postDivAvailable = false;
	// be used for decide for showing GetResults 
	$scope.getDivAvailable = false;
	
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
		var url = "response";
		
		// prepare headers for posting
		var config = {
                headers : {
                	'Content-Type': 'application/json',
                    'Accept': 'application/json'
                }
        }
		var data = JSON.stringify($scope.Answers);
		
		console.log(data);
		// do posting
				$http.post(url, data, config).then(function (response) {
					$scope.postDivAvailable = true;
					$scope.postCust =  response.data;
				}, function error(response) {
					$scope.postResultMessage = "Error Status: " +  response.statusText;
				});
		
		 
		
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
		        	/*window.location = "finished";
		        	$scope.getUserResponse();*/
		    }
	 });

	$scope.start = function(){
		    $scope.timer();
	};

	$scope.stop = function(){
		    $interval.cancel(intervalId);
	};
	
	
	
	
	
});