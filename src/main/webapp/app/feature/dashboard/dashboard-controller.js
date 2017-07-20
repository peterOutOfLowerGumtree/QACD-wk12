(function() {

    var DashBoardController =  function()
    {
        var vm = this;

        vm.test = "test";
    };
    angular.module('cinema').controller('dashboardController', [DashBoardController]);
}());