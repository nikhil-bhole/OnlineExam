var app = angular.module("navBarDemoBasicUsage", ['ngMaterial','ngMessages']);

(function() {
	  'use strict';
	  	app.controller('AppCtrl', AppCtrl);
	  	function AppCtrl($scope) {
	    $scope.currentNavItem = 'page1';
	    $scope.goto = function(page) {
	      $scope.status = "Goto " + page;
	    };
	  }
	})();