$(document ).ready(function(){
	
	//Récupérer avec cookie l'id user
	//var userId =
	var userId = "Jdoe";
	
	setInterval(function(){ update(); }, 5000);
}

function update(){
	
	$.get("http://localhost:8084/RoomByUserId/"+userId, function(room){
		if(room.state != "init" || room.state != "In Progress"){
			window.location.href = "/resultGame.html";
		}
	});
	
}