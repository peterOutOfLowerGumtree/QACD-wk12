"use strict";

(function () {

    angular.module('cinema').config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/dashboard");

        $stateProvider.state("dashboard", {
            url: "/dashboard",
            templateUrl: "app/feature/dashboard/dashboard.html"
        }).state("getmovie", {
            url: "/getmovie",
            templateUrl: "app/feature/movie/get-movie/get-movie.html"
        }).state("addmovie", {
            url: "/addmovie",
            templateUrl: "app/feature/movie/add-movie/add-movie.html"
        })
    });
}());