$(document ).ready(function(){

    $("#cancelButtonId").click(function(){
    	window.location.href = "/roomList.html";
    });  
    
    $("#createButtonId").click(function(){
        //TODO Récupérer id user par cookie
        //var userId=

    	var userId = "JDoe";
    	var url = "http://localhost:8084/CreateRoom/"+$("#roomNameId").val()+"/"+userId+"/"+$("#roomBetId").val();
        $.post(url, function(result){
        	window.location.href = "/selectCardForPlay.html";
          });
        console.log(url);
    }); 
    
    
});