app.controller("shopping-cart-ctrl", function($scope, $http, $location) {
	/*
	* QUẢN LÝ GIỎ HÀNG
	*/
	 $scope.items = [];
	 $scope.details = [];
	     $scope.form = {};
	 $scope.initialize = function(){
        //load cart
        $http.get("/rest/orders").then(resp=>{
            $scope.items = resp.data;
        })
       
    }
      $scope.edit = function(item){
	console.log(item)
		$scope.form = angular.copy(item);
		$('#pills-home-tab').tab('show');
		 $http.get(`/rest/orders/detail/${item.id}`).then(resp=>{
            $scope.details = resp.data;
        })
    }
    $scope.update = function(){
		var item = angular.copy($scope.form);
		$http.put(`/rest/orders/${item.id}`,item).then(resp=>{
			var index = $scope.items.findIndex(p=>p.id == item.id);
			$scope.items[index] = item;
			alert('Cập nhật sản phẩm thành công!');
			console.log(resp.data);
		}).catch(err=>{
			alert('Lỗi cập nhật sản phẩm!')
			console.log("Error ",err);
		})
	}
    $scope.initialize();
	    
})