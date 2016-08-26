define(['app'], function(app){
  
app.factory('api/sample/resources', function(WrappedRestApi, RestApi, $log) {
    var lists = WrappedRestApi.all('samples');
    return {
      // 유저 목록 조회 
      getLists : function(param, ok, fail) {
        lists.one('get').get().then(function(data) {
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