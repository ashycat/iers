
/**
 *
 * taskController
 *
 */

define(['angular','app', 'services/api/task/resources'], function(angular, app){
  'use strict';
  app.controller('admin/task/taskController',
      ['$scope','api/task/resources','$modal', '$location', '$cookies','$filter', 
        function ($scope,$taskResources, $modal, $location, $cookies,$filter) {
          console.log('task sampleController');
          
          var initdataTables = function() {
            $scope.maxSize = 5; //Number of pager buttons to show
            $scope.page_row = {id: '1', page_row: 10};
            $scope.currentPageNo = 1
            $scope.dataTables = {
              availableOptions: [
                 {id: '1', page_row: 10},
                 {id: '2', page_row: 25},
                 {id: '3', page_row: 50}
               ]
            };
          }();
          
          $scope.changePageRow = function(page_row) {
//            console.log('currentNo : ', $scope.dataTables.currentPageNo);
//            console.log('page_row : ', $scope.page_row.page_row);
            $scope.getTaskList();
          };

          $scope.changePage = function() {
            $scope.dataTables.currentPageNo = $scope.currentPageNo;
//            console.log('currentNo : ', $scope.dataTables.currentPageNo);
//            console.log('page_row : ', $scope.page_row.page_row);
            $scope.getTaskList();
          };
          
          
          //dataTables.pagination
            $scope.setPage = function (pageNo) {
              $scope.currentPage = pageNo;
            };

            $scope.pageChanged = function() {
              console.log('Page changed to: ' + $scope.currentPage);
            };

          $scope.setItemsPerPage = function(num) {
//            $scope.itemsPerPage = num;
            $scope.currentPage = 1; //reset to first page
          }
          
          //date time picker
          //
          $scope.getTaskList = function() {
            //dataTables.selector
//            if( angular.isUndefined($scope.dataTables) ||
//                angular.isUndefined($scope.dataTables.page_row) || 
//                angular.isUndefined($scope.dataTables.currentPageNo) ) {
//              console.log('asdf');
//            };
            console.log($scope.page_row.page_row);
            
            var param={
                page_row : $scope.page_row.page_row,
                currentPageNo : $scope.dataTables.currentPageNo
            };
            $taskResources.getList(param, function(result){
              $scope.taskList = result.contents;
              
              $scope.totalItems = result.total_count;
//              $scope.currentPageNo = ;
              $scope.itemsPerPage = $scope.page_row.page_row;
              console.log('adf',$scope.page_row.page_row);
            });
            
          };
          
          $scope.taskInfoOk = function(row) {
//            var date = new Date($scope.data.date);
//            console.log('date',$scope.data.date.getTime());
            $cookies.put('taskId',$scope.taskList[row].TASK_ID);
            $cookies.put('taskType',$scope.taskList[row].TASK_TYPE);
            $cookies.put('tableName',$scope.taskList[row].TABLE_NAME);
            $location.path('/admin/task/taskInfo');
          };
          
//          initdataTables();
          $scope.getTaskList();

  }]);
});
