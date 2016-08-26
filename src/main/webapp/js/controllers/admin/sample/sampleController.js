
/**
 *
 * dashboardController
 *
 */

define(['app', 'services/api/sample/resources'], function(app){
  'use strict';
  app.controller('admin/sample/sampleController',
      ['$scope','api/sample/resources',
        function ($scope,resources) {
          console.log('admin sampleController');
          
          $scope.getList = function() {
            var param={};
            resources.getLists(param, function(result){
              console.log('result : ',result);
              $scope.sampleList = result.list;
            });
          };
          
          
          $scope.getList();


  }]);
});
