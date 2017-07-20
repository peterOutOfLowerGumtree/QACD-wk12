(function() {

    var GetMovieController =  function(movieDal)
    {
        var vm = this;
        vm.test = "test";

        function init() {
            movieDal.getMovies().then(function (results) {
                vm.movies  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        init();
    };
    angular.module('cinema').controller('getMovieController', ['movieDal', GetMovieController]);
}());