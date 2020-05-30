  $(document ).ready(function(){
    
	//Récupérer avec cookie l'id user
	//var userId =
	var userId = "Jdoe";
	
	$.get("http://localhost:8084/RoomByUserId/"+userId, function(room){
		 $('#roomNameId')[0].innerText=room.name;
		 	
		 if(room.state == userId){
			 $('#resultTitleId')[0].innerText=" YOU WIN ! ";
		 }else{
			 $('#resultTitleId')[0].innerText=" You Loose... ";
		 }
		 
		 //TODO à vérifier
		 var idCard;
		 if(room.idUser1 == userId){
			 idCard = room.idCard1;
		 }else{
			 idCard = room.idCard2;
		 }
		 $.get("http://localhost:808?/Card/ById/"+idCard, function(card){
			 $('#cardNameId')[0].innerText=card.name;
		 });
		 
	});
	
	
    
    $('#actionNameId')[0].innerText="LOSE";
    $('#energyId')[0].innerText=" 100 energy ... ";
    $('#imgResultId')[0].src="https://fjva.files.wordpress.com/2017/09/anim_win-pokemon-evoli-pikachu.gif?w=584";
       
      
      
});
