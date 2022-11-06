app.controller("myCtrl", ["$scope", "$firebaseAuth",'$location',  function($scope, $firebaseAuth, $location) {
  $scope.signIn = function (){
      var username = $scope.user.email;
      var password = $scope.user.password;
                
      var auth = $firebaseAuth();
      auth.$signInWithEmailAndPassword(username, password)
     .then (function(user){
          console.log(user.uid);            
          alert("Đăng nhập thành công");
          location.replace("./index.html");
      }) 
      .catch(function(error){
          console.log(error);
          location.replace("/checkout.html");
      });
  };

}
]);