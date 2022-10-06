angular.module('app', []).controller('productController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189';
    $scope.loadProducts = function () {
        $http.get(contextPath + '/allProducts')
            .then(function (response) {
                $scope.productList = response.data;});
    };
    $scope.loadProducts();
});