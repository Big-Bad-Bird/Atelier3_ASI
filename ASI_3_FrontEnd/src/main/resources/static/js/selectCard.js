$(document ).ready(function(){
    
	//TODO Récupérer room id et name par cookie
	var roomId = "41543de7-93c6-4e2a-8bcc-a5abda257655";
	var roomName = "room A";
    $('#roomNameId')[0].innerText=roomName;
    

    var i;
	var id;
	var nbCards = 5;
	//A remplacer avec CardUser quand fonctionnel
	$.get("http://localhost:8083/Card/getAllCards", function(data){
		fillCurrentCard(data[0]);
		for(i=0; i<nbCards; i++){
		    addCardToList(data[i]);
		}
		
		//Ajout listeners
		$(".select").click(function(){
			
			//Récupérer idUser avec cookie
			//var idUser = 
			var idUser = "JDoe";
			var url = "http://localhost:8084/AddCardRoom/"+roomId+"/"+idUser+"/"+$(this).attr("data-cardid");
			$.get(url, function(result){
				console.log(result);
				window.location.href = "/waitPlayer.html";
			});
			console.log(url);
		});
	});
    

});




function fillCurrentCard(data){
    //FILL THE CURRENT CARD
    $('#cardFamilyImgId')[0].src=data.imgUrlFamily;
    $('#cardFamilyNameId')[0].innerText=data.family;
    $('#cardImgId')[0].src=data.imgUrl;
    $('#cardNameId')[0].innerText=data.name;
    $('#cardDescriptionId')[0].innerText=data.description;
    $('#cardHPId')[0].innerText=data.hp+" HP";
    $('#cardEnergyId')[0].innerText=data.energy+" Energy";
    $('#cardAttackId')[0].innerText=data.attack+" Attack";
    $('#cardDefenceId')[0].innerText=data.defence+" Defence";
};


function addCardToList(data){
    
    content="\
    <td> \
    <img  class='ui avatar image' src='"+data.imgUrl+"'> <span>"+data.name+" </span> \
   </td> \
    <td>"+data.description+"</td> \
    <td>"+data.family+"</td> \
    <td>"+data.hp+"</td> \
    <td>"+data.energy+"</td> \
    <td>"+data.attack+"</td> \
    <td>"+data.defence+"</td> \
    <td>\
    	<div class='select' tabindex='0' data-cardid="+data.id+">\
        	<div class='ui vertical animated button' tabindex='0'>\
            	<div class='hidden content'>Select</div>\
        		<div class='visible content'>\
        			<i class='checkmark icon'></i>\
        		</div>\
        	</div>\
        </div>\
    </td>";
    
    $('#cardListId tr:last').after('<tr>'+content+'</tr>');
    
    
};

