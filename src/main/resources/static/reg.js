angular.module('app', []).controller('regController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/api/v1';
    $scope.registration = function () {
        $http(
            {
                method: "POST",
                url: contextPath + "/registration",
                dataType: 'json',
                data: {
                    name: $scope.name,
                    plainTextPassword: $scope.password
                }
            })
    };
});