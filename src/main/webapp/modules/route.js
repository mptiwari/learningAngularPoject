myApp.config(function($routeProvider) {
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
							.when("/addCard" ,{
								templateUrl: "html/addCard.html"
							})
							.when("/viewCard" ,{
								templateUrl: "html/viewCard.html"
							})
							.when("/editCard" ,{
								templateUrl: "html/editCard.html"
							})
					})