
/**
 *
 * taskInfoController
 *
 */

define(['app', 'services/api/task/resources'], function(app){
  'use strict';
  app.controller('admin/task/taskInfoController',
      ['$scope','api/task/resources','$modal','$cookies','$filter',
        function ($scope,$taskResources, $modal, $cookies, $filter) {
          console.log('task Info Controller ');
          
          /*********************************************
           * 함수명 : getTaskInfo
           * 설명 : 선택된 Task의 상세정보를 가져온다
           * req param : taskId
           * res param : tb_iers_tasks테이블 모든컬럼
           * 
           ***********************************************/
          //쿠키에서 taskId 받아와서 조회해서 뿌려줌 
          $scope.getTaskInfo = function() {
            var param = {
                id:$cookies.get("taskId"),
                type:$cookies.get("taskType")
            };
            $taskResources.getOne(param, function(result) {
              console.log('t',result.contents);
              $scope.task = {
                taskId : result.contents[0].TASK_ID,   
                taskName : result.contents[0].TASK_NAME,   
                taskType : result.contents[0].TASK_TYPE,   
                assignee : result.contents[0].NAME,   
                group : result.contents[0].DEPARTMENT,   
                issue : result.contents[0].ISSUE,   
                status : result.contents[0].STATUS,   
                description : result.contents[0].DESCRIPTION,   
                comment : result.contents[0].COMMENT1,   
                create_date : $filter('date')(result.contents[0].CREATE_DATE, 'yyyy-MM-dd HH:mm:ss'),   
                start_date : $filter('date')(result.contents[0].START_DATE, 'yyyy-MM-dd HH:mm:ss'),  
                end_date : $filter('date')(result.contents[0].END_DATE, 'yyyy-MM-dd HH:mm:ss'),   
              };
              
              $scope.statusList.selected = $scope.task.status;
              $scope.description = $scope.task.description;
            });
          };
          
          //taskinfo view에 로드 
          $scope.getTaskInfo();
          
          

          $scope.statusList = {
              options: [
                'Ready',
                'TODO',
                'Assigned',
                'InProgress',
                'Resolve',
                'Terminated'
              ],
//              selected: result.contents[0].STATUS
          };
          
          
          
          /***********************************************
           * 함수명 : updateTask
           * 설명 : task 수정 (담당자, 상태, task 시작시간)
           * req param : tb_iers_tasks테이블 모든컬럼
           * res param : {code : 200}
           * 
           ***********************************************/
          // Task Info 수정 후 적용
          // 
          $scope.updateTask = function() {
            console.log('updateTask req param', $scope.task.taskName);
            
          };
          
          $scope.changeStatus = function() {
            var param = {
                id: $cookies.get("taskId"),
                status: $scope.statusList.selected
            };
            $taskResources.updateStatus(param, function(result){
              console.log("end");
              
            });
            
          }
          
          //담당자 변경
          $scope.changeAssignee = function() {
            //담당자 변경은 팝업을 띄워서 그 안에서 선택 하는 식으로 하자 
            //먼저 변경을 눌렀을때 현재 담당자들 목록을 받아온다. (task_type 기준)
            //그리고 변경가능한 직원들 목록 받아옴 
            //두 리스트 비교 후 일치하는 항목에만 체크
            //기존에 있던 담당자 전체 삭제 후 다시 삽입
//            console.log($scope.activeChangeAssignee);
//            if(angular.isUndefined($scope.activeChangeAssignee) ||  $scope.activeChangeAssignee == 0){
//              $scope.activeChangeAssignee = 1;
//            } else {
//              $scope.activeChangeAssignee = 0;
//            }
            // task_type으로 담당자 불러 오기 
            // task_type으로 department에 소속된 user 불러오기
           
            
            var modalInstance = $modal.open({
              templateUrl: 'views/admin/task/popup/changeAssignee.html',
              controller: changeAssigneeCtrl,
              resolve: {
                items: function () {
                  return $cookies.get("taskType");
                }, 
                reload : function() {
                  return $scope.getTaskInfo;
                }
              }
            });
          }
          var changeAssigneeCtrl = function ($scope, $modalInstance, items, reload) {

            var param = {
                task_type:items
            }
            $taskResources.selectAssigneeByTaskType(param, function(result) {
              $scope.assignees = result.contents.sort();
             console.log($scope.assignees);
            });
            $taskResources.selectDptMemberByTaskType(param, function(result) {
              console.log(result);
              $scope.department_member = result.contents.sort();

            });
            
            $scope.changeAssignee = function(){
              var param = {
                  task_type:items,
                  body:$scope.assignees
              }
              $taskResources.changeAssignee(param, function(result){
                console.log("changeAssignee result ", result);
                if(result.code==='200') {
                  $modalInstance.close();
                  reload();
                }
              });
              
            };

            $scope.cancel = function(){
              $modalInstance.close();
              reload();
            };
            
          };
          
  }]);
});
