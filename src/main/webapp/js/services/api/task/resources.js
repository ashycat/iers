define(['app'], function(app){
  
app.factory('api/task/resources', function(WrappedRestApi, RestApi, $log) {
    var tasks = WrappedRestApi.all('tasks');
    return {
      // 태스크 목록 조회 
      getList : function(param, ok, fail) {
        tasks.one('all').get(param).then(function(data) {
          $log.debug('data', data);
          ok(data);
        }, function(response) {
          $log.debug('response', response);
          if (angular.isFunction(fail)) {
            fail(response);
          }
        });
      },
      // 한개 태스크 정보 조회
      getOne : function(param, ok, fail) {
        tasks.one(param.id+"").get(param).then(function(data) {
          $log.debug('data', data);
          ok(data);
        }, function(response) {
          $log.debug('response', response);
          if (angular.isFunction(fail)) {
            fail(response);
          }
        });
      },
      // 태스크 Status 수정
      updateStatus : function(param, ok, fail) {
        tasks.one(param.id+"").one("status", param.status).put().then(function(data) {
          $log.debug('data', data);
          ok(data);
        }, function(response) {
          $log.debug('response', response);
          if (angular.isFunction(fail)) {
            fail(response);
          }
        });
      },
      //task_type으로 담당자 검색 
      selectAssigneeByTaskType : function(param, ok, fail) {
        tasks.one("types",param.task_type+"").one("assignee").get().then(function(data) {
          $log.debug('data', data);
          ok(data);
        }, function(response) {
          $log.debug('response', response);
          if (angular.isFunction(fail)) {
            fail(response);
          }
        });
      },
      //task_type으로 담당 부서 인원 전체 조회 
      selectDptMemberByTaskType : function(param, ok, fail) {
        tasks.one("types",param.task_type+"").one("dpt_member").get().then(function(data) {
          $log.debug('data', data);
          ok(data);
        }, function(response) {
          $log.debug('response', response);
          if (angular.isFunction(fail)) {
            fail(response);
          }
        });
      },
      //담당자 변경 키값은 code 
      changeAssignee : function(param, ok, fail) {
        tasks.one("types",param.task_type+"").all("changeAssignee").post(param).then(function(data) {
          $log.debug('data', data);
          ok(data);
        }, function(response) {
          $log.debug('response', response);
          if (angular.isFunction(fail)) {
            fail(response);
          }
        });
      },
      
    };
  });
});