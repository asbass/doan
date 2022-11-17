app = angular.module("app",["ngRoute"]);

app.controller("register",function($scope,$http,$location){
    $scope.items = [];
  
	
	

	//Thêm account
    $scope.create = function(){
		var item = angular.copy($scope.form);
		$http.post(`/rest/register`,item).then(resp=>{
			$scope.items.push(resp.data);
			console.log(resp.data);
			alert("Thêm tài khoản thành công!");
		}).catch(err=>{
			console.log("Error ",err);
			alert("Thêm tài khoản thất bại!");
		})
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