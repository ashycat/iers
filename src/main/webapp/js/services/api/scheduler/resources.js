define(['app'], function(app){
  
app.factory('api/scheduler/resources', function(WrappedRestApi, RestApi, $log) {
    var lists = WrappedRestApi.all('schedulers');
    return {
      // 스케줄러 목록 조회
      getLists : function(param, ok, fail) {
        lists.one('all').get(param).then(function(data) {
          $log.debug('data', data);
          ok(data);
        }, function(response) {
          $log.debug('response', response);
          if (angular.isFunction(fail)) {
            fail(response);
          }
        });
      },
      
      changeStatus : function (param, ok, fail) {
        lists.one(param.schedulerName+'').all('changeStatus').post(param).then(function(data) {
          $log.debug('data', data);
          ok(data);
        }, function(response) {
          $log.debug('response', response);
          if (angular.isFunction(fail)) {
            fail(response);
          }
        });
      }
      
    };
  });
});