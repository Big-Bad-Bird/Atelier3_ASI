$(document ).ready(function(){
	
    $("#playButtonId").click(function(){
        window.location.href = "http://demineur.hugames.fr/#level-3";
    });    
    $("#buyButtonId").click(function(){
        //TO DO
        window.location.href = "http://localhost:8080/cardBuy.html";
    });    
    $("#sellButtonId").click(function(){
        //TO DO
        window.location.href = "http://localhost:8080/cardSell.html";
    });
    
    $.get("/getUser", function(data){
			$("#userNameId").html(data.userName);
			$("#userCashId").html(data.Cash);
	});
});

