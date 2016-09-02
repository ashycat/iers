
/**
 *
 * dashboardController
 *
 */

define(['app', 'services/api/scheduler/resources'
        ], function(app){
  'use strict';
  app.controller('admin/scheduler/schedulerController',
      ['$scope', 'api/scheduler/resources',
        function ($scope,resources) {
          console.log('admin schedulerController');
          
          $scope.getschedulerList = function() {
            var param={};
            resources.getLists(param, function(result){
              console.log('result : ',result);
              $scope.schedulerList = result.contents;
            });
          };
          
          
          $scope.getschedulerList();
          
          
          $scope.jobChangeStatus = function(row_num) {
            console.log("ddd", $scope.schedulerList[row_num].schedulerName);
            var param = $scope.schedulerList[row_num];
            resources.changeStatus(param, function(result){
              console.log('result : ',result);
//              $scope.schedulerList = result.contents;
              $scope.getschedulerList();
             
            });
            
          };


  }]);
});
