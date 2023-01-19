angular.module('app', []).controller('basketController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/api/v1/basket';
    $scope.loadProducts = function () {
        $http.get(contextPath)
            .then(function (response) {
                $scope.productList = response.data;
            });
    };
    $scope.deleteProduct = function (productId) {
        $http.delete(contextPath + '/' + productId)
        .then(function () {
            $scope.loadProducts();
        });
    };
    $scope.addProduct = function () {
       $http.post(contextPath, $scope.newProductJson)
        .then(function () {
        $scope.loadProducts();
        });
    };

    $scope.updateProduct = function (){
        $http.put(contextPath, $scope.updateProduct)
            .then(function (){
                $scope.loadProducts();
            })
    }

    $scope.loadProducts();
});