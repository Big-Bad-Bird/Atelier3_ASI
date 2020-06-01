$(document ).ready(function(){
    
	
	//TODO plus tard: changer pour mettre que rooms valables
	nbRooms=5;
	
	$.get("http://localhost:8084/GetAllRooms", function(data){
		
		for (const room in data){
			/*
			//TODO Version qui récupère le pseudo du crateur, à tester quand je saurais que le user fonctionne
			$.get("http://localhost:8081/user-info/"+data[room].idUser1, function(user){
			
				addRoomToList(data[room].id ,"room "+ data[room].name,"user" +user.username, data[room].mise);
			});
			*/
			addRoomToList(data[room].id ,"room "+ data[room].name,"user: username", data[room].mise);
		}
		
		//listeners
		$(".select").click(function(){
			//TODO Ajout de l'id room dans un cookie
			
			window.location.href = "/selectCardForPlay.html";
		});
	});
    
    
     $("#createRoomButtonId").click(function(){
    	 window.location.href = "/createRoom.html";
    }); 
    
});


function addRoomToList(id,name, user, bet){
    
    content="<td> "+name+" </td> \
                            <td> "+user+" </td> \
                            <td> "+bet+" $</td> \
                            <td> \
                            	<div class='select' tabindex='0' data-cardid="+id+">\
                                	<div class='center aligned'> \
                                    	<div class='ui  vertical animated button' tabindex='0'> \
                                        	<div class='hidden content'>Play</div> \
                                        	<div class='visible content'> \
                                            	<i class='play circle icon'></i> \
                                    		</div> \
                                    	</div> \
                                    </div> \
                                 </div/ \
                            </td>";
    
    $('#roomListId tr:last').after('<tr>'+content+'</tr>');
    
    
};