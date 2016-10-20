var app = angular.module('prostolife', []);
app.controller('HeaderCtrl',function($scope){
   $scope.appDetails = {
        title: "ProstoLife",
        tagline: "Профессиональная йога-студия",
   };
});

app.controller('BlogCtrl', function($scope){
     $scope.entries = [
            {
                text: "Представляем вашему вниманию новое видео — «Йога упражнения после родов. Гимнастика для восстановления организма после родов» — на нашем канале с объяснениями инструктора Центра YogaLife ",
                topic: "НОВОЕ ВИДЕО НА НАШЕМ КАНАЛЕ!!!"
            },
            {
                text: "Активизируйтесь и подключайтесь! Йога утром- залог радостного, ресурсного успешного дня!!! Всем смелым и отважным",
                topic: "Всем кто приведет с собой друга"
            }
       ]
})
