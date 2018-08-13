var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http) {
  
  $http({
    method: 'GET',
    url: 'StudentProfileServlet'
    
  }).then(function mySuccess(response) {
      // a string, or an object, carrying the response from the server.
      $scope.myRes = response.data
      $scope.statuscode = response.status;
    }, function myError(response) {
      $scope.myRes = response.myArrayList;
  });
});