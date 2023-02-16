angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/api/v1/products';
    $scope.loadProducts = function () {
        $http.get(contextPath)
            .then(function (response) {
                $scope.productList = response.data;
            });
    };

    $scope.loadProducts();
});