var app = angular.module("myApp", ['ngMaterial','ngMessages']);

app.controller("myCtrl", function($scope) {
    $scope.firstName = "John";
    $scope.lastName = "Doe";
});