define(['app'], function(app){
  
app.factory('api/task/log/resources', function(WrappedRestApi, RestApi, $log) {
    var tasks = WrappedRestApi.all('tasks').all('log');
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
      
      
    };
  });
});