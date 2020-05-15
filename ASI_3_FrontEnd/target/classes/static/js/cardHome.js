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
    
    function getCookie(sName) {
        var cookContent = document.cookie, cookEnd, i, j;
        var sName = sName + "=";
 
        for (i=0, c=cookContent.length; i<c; i++) {
                j = i + sName.length;
                if (cookContent.substring(i, j) == sName) {
                        cookEnd = cookContent.indexOf(";", j);
                        if (cookEnd == -1) {
                                cookEnd = cookContent.length;
                        }
                        return decodeURIComponent(cookContent.substring(j, cookEnd));
                }
        }       
        return null;
    }
    
	$("#userNameId").html(getCookie("namecookie"));
	
	$.get("http://localhost:8081/...", function(data){
		$("#userCashId").html(data.cash);

	});
});

