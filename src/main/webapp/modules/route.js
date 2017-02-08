var myRouteApp = angular.module("Demo", ["ngRoute"])
					.config(function($routeProvider) {
						$routeProvider
							.when("/home" ,{
								templateUrl: "html/home.html"
							})
							.when("/students" ,{
								templateUrl: "html/students.html"
							})
							.when("/courses" ,{
								templateUrl: "html/courses.html"
							})
					})