var projectName = '/' + window.location.pathname.split('/')[1];
var studentUrl = {
    // 'addUrl' : projectName + '/user/add',
    // 'deleteUrl' : projectName + '/user/delete',
    'updateUrl' : projectName + '/rest/update',
    'queryUrl' : projectName + '/rest/students'
};
var student = angular.module('studentService', [ 'ngResource' ], angular.noop);

student.controller('studentController', function($scope, $resource) {
    var actions = {
        // 'add' : {
            // method : 'PUT',
            // isArray : true,
            // headers : {
                // 'Content-Type' : 'application/json'
            // }
        // },
        // 'delete' : {
            // method : 'DELETE',
            // isArray : true
        // },
        'query' : {
            method : 'GET',
            isArray : true
        },
        'update' : {
            method : 'POST',
            isArray : true,
            headers : {
                'Content-Type' : 'application/json'
            }
        }
    };
    var getUserList = $resource(studentUrl.queryUrl, {
        page : 1,
        pageSize : 20
    }, actions);
    getUserList.query({}, function(data) {
        subobj = data;
        $scope.mydata = data;
    });
    // var userAdd = $resource(userUrl.addUrl, {
        // page : 1,
        // pageSize : 20
    // }, actions);
    // $scope.addUserClick = function() {
        // userAdd.add($scope.saveUser, function(data) {
            // subobj = data;
            // $scope.mydata = data;
        // });
    // };
    var studentUpdate = $resource(studentUrl.updateUrl, {
        page : 1,
        pageSize : 20
    }, actions);
    $scope.updateStudentClick = function() {
        studentUpdate.update($scope.modifyStudent, function(data) {
            subobj = data;
            $scope.mydata = data;
        });
    };
    // var userDelete = $resource(userUrl.deleteUrl, {
        // page : 1,
        // pageSize : 20,
        // id : ':id'
    // }, actions);
    // $scope.deleteUser = function(user) {
        // userDelete['delete']({
            // id : user.id
        // }, {}, function(data) {
            // subobj = data;
            // $scope.mydata = data;
        // });
    // };
    $scope.updateStudent = function(student) {
        $scope.modifyStudent = student;
    };
});