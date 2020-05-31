$(document ).ready(function(){
	
	//Récupérer avec cookie l'id user
	//var userId =
	var userId = "JDoe";
	
	setInterval(function(){ update(userId); }, 5000);
});

function update(userId){

	$.get("http://localhost:8084/RoomByUserId/"+userId, function(room){
		if(room.roomState !== "init" && room.roomState !== "In Progress"){
			window.location.href = "/resultGame.html";
		}
	});
	
}