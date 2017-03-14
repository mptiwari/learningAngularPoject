var myApp = angular.module("myApp", ["ngRoute"])

myApp.controller("myController", function($scope, $http) {
	
	 var urlBase="http://localhost:8080/myrepo/resources"
		 
		//get all the cards
		 $http.get(urlBase+'/viewCard').
		     success(function(data) {
		    	 $scope.cards = data;
		    });
		 
		//add a new card
	 var card = new Object();  
		$scope.addCard = function addCard() {
		card.name=$scope.name;
		card.age=$scope.age;
		card.cardno=$scope.cardno;
		card.gender=$scope.gender;
			$http.post(urlBase+'/addCard', card).
			success(function(data, status, headers){
				alert("Card Added");
			});
		
	};
	
	// edit card
	/*$scope.editCard = function editCard(cardno){
		alert(cardno);
		
		$http.get(urlBase +'/editCard/'+cardno).
			success(function (status){
			alert(status);
		});
	}*/
	
	// save card
	 var card = new Object(); 
	$scope.saveCard = function saveCard(card) {
		alert(card.cardno);
		alert($scope.cardno);
		//card.name=$scope.name;
		//card.age=$scope.age;
		//card.cardno=$scope.cardno;
		//card.gender=$scope.gender;
		$http.post(urlBase +'/saveCard', card).
			success(function (status){
			alert("save card");
		});
	}
	
	// delete card
	$scope.deleteCard = function deleteCard(cardno){
		alert(cardno);
		$http.delete(urlBase +'/deleteCard/'+cardno).
			success(function (status){
			alert(status);
		});
	}
	
	$scope.flag=true;
	$scope.editCard = function(){
		$scope.flag= !$scope.flag;
	}
	
});
