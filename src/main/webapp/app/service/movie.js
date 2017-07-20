"use strict";

(function () {

    angular.module("cinema").service("movieDal", ["dal", MovieDal]);

    function MovieDal (dal) {

        this.getMovies = function () {
            return dal.http.GET("rest/cinema/json");
        };

        this.saveMovie = function (movieToSave) {
            return dal.http.POST("rest/cinema/json", movieToSave);
        };

        this.updateMovie = function (movieToUpdate) {
            return dal.http.PUT("rest/cinema/json/", movieToUpdate);
        };

        this.deleteMovie = function (movieToDelete) {
            return dal.http.DELETE("rest/cinema/json/", movieToDelete);
        };

    }
}());
