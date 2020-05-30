$(document ).ready(function(){

    $("#cancelButtonId").click(function(){
    	window.location.href = "/roomList.html";
    });  
    
    $("#createButtonId").click(function(){
        //TODO Récupérer id user par cookie
        //var userId=
    	var userId = "JDoe";
        $.post("http://localhost:8084/CreateRoom/"+$("#roomNameId")+"/"+userId+"/"+$("#roomBetId"), function(result){
        	window.location.href = "/waitPlayer.html";
          });
    }); 
    
    
});