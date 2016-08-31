
/**
 *
 * dashboardController
 *
 */

define(['app', 'services/api/scheduler/resources'], function(app){
  'use strict';
  app.controller('admin/scheduler/schedulerController',
      ['$scope','api/scheduler/resources',
        function ($scope,resources) {
          console.log('admin schedulerController');
          
//          $scope.getList = function() {
//            var param={};
//            resources.getLists(param, function(result){
//              console.log('result : ',result);
//              $scope.sampleList = result.list;
//            });
//          };
//          
//          
//          $scope.getList();


  }]);
});
