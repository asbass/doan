var app = angular.module("myapp", ["firebase"]);
app.config(function() {
  var config = {
        apiKey: "AIzaSyDLbs7zIXAJYHTic85G8z1DwVFLRUQjzMY",
        authDomain: "ps18735-cf548.firebaseapp.com",
        databaseURL: "https://ps18735-cf548-default-rtdb.firebaseio.com/",
        projectId: "ps18735-cf548",
        storageBucket: "ps18735-cf548.appspot.com",
        messagingSenderId: "75478200117",
        appId: "1:75478200117:web:42458a6b76e93c8d37267c",
        measurementId: "G-W226RCVPGK"
  };
  firebase.initializeApp(config);
});