$(document ).ready(function(){
    
	var i;
	var nbCards = 1;
	$.get("/getCardPerso", function(data){
		fillCurrentCard(data[0]);
		
		for(i=1; i<=nbCards; i++){
			addCardToList(data[i]);
		}
		
		//ajout listeners
		$(".sell").click(function(){
			  $.post("/sell", {id: $(this).attr("data-cardid")}, function(result){
				  alert("Carte Vendue!");
			  });
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
    $('#cardPriceId')[0].innerText=data.price+" $";
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
    <td>"+data.price+"$</td>\
    <td>\
        <div class='sell' tabindex='0' data-cardid="+data.id+">\
        	<div class='ui vertical animated button' >\
        		<div class='hidden content'>Sell</div>\
        		<div class='visible content'>\
        			<i class='shop icon'></i>\
        		</div>\
        	</div>\
       </div>\
    </td>";
    
    $('#cardListId tr:last').after('<tr>'+content+'</tr>');
    
    
};