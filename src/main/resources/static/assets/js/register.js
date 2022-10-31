const app= angular.module("app",["ngRoute"]);
app.controller("register",function($scope,$http,$location){
    $scope.authorities = [];
    $scope.items = [];
    $scope.form = {};
    $scope.roles = [];
    $scope.selection =[];
	
  
	//Thêm account
    $scope.create = function(){
		var item = angular.copy($scope.form);
		$http.post(`/rest/register`,item).then(resp=>{
			$scope.items.push(resp.data);
			console.log(resp.data);
			$scope.reset();
			alert("Thêm tài khoản thành công!");
		}).catch(err=>{
			console.log("Error ",err);
			alert("Thêm tài khoản thất bại!!!  Vui lòng điền đầy đủ thông tin");
		})
    }

    //Update account
/*    $scope.update = function(){
		var item = angular.copy($scope.form);
		$http.put(`/rest/accounts/${item.username}`,item).then(resp=>{
			var index = $scope.items.findIndex(p=>p.username == item.username);
			$scope.items[index] = item;
			
			//xoá toàn bộ roles của user hiện tại
			$http.delete(`/rest/authoritiesOne/${item.username}`).then(resp=>{
			//sau khi xoá thì thêm mới lại role đã chọn
				$scope.selection.forEach(r=>{
					var authority = {account:item,role:r};
					$http.post(`/rest/authorities`,authority).then(resp=>{
						$scope.items.push(resp.data);
					}).catch(err=>{
						console.log("Error ",err);
					})
				})
			})
			alert('Cập nhật tài khoản thành công!');
			console.log(resp.data);
		}).catch(err=>{
			alert('Lỗi cập nhật tài khoản!')
			console.log("Error ",err);
		})
	}*/

    //Remove account
/*    $scope.delete = function(item){
		$http.delete(`/rest/products/${item.id}`).then(resp=>{
			var index = $scope.items.findIndex(p=>p.id == item.id);
			$scope.items.splice(index,1);
			$scope.reset();
			alert('Xoá sản phẩm thành công!');
			console.log(resp.data);
		}).catch(err=>{
			alert('Lỗi xoá sản phẩm!')
			console.log("Error ",err);
		})
	}*/

	//reset form
	$scope.reset = function(){
		$scope.form = {
			photo:'logo.png',
		}
    }
    //Upload Hình
    $scope.imageChanged = function(files){
		var data = new FormData();
		data.append('file',files[0]);
		$http.post('/rest/upload/avatar',data,{
			transformRequest:angular.identity,
			headers:{'Content-Type':undefined}
		}).then(resp=>{
			$scope.form.photo = resp.data.name;
		}).catch(err=>{
			alert('Lỗi upload Ảnh');
			console.log("Error ",err)
		})
    }
	
})