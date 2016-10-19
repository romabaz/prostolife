var app = angular.module('prostolife', []);
app.controller('HeaderCtrl',function($scope){
   $scope.appDetails = {
   title: "ProstoLife",
   tagline: "Профессиональная йога-студия"
   };
});
