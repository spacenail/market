angular.module('app', []).controller('productController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189';
    $scope.loadProducts = function () {
        $http.get(contextPath + '/allProducts')
            .then(function (response) {
                $scope.productList = response.data;
            });
    };
    $scope.deleteProduct = function (productId) {
        $http({
            url: contextPath + '/deleteProduct',
            method: 'DELETE',
            params: {
                id: productId
            }
        }).then(function () {
            window.location.assign(contextPath);
        });
    };
    $scope.addProduct = function () {
       $http.post(contextPath + '/addProduct', $scope.newProductJson)
        .then(function () {
        $scope.loadProducts();
        });
    };
    $scope.loadProducts();
});