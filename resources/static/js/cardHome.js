$(document ).ready(function(){
    $("#playButtonId").click(function(){
        //Pour le débbug on suppose que l'id de l'hote est 1
        let idUser = 1;
        localStorage.setItem('idUser', idUser);
        $(location).attr('href', 'roomList.html');
    });    
    $("#buyButtonId").click(function(){
        alert("Buy button clicked ");
        //TO DO
    });    
    $("#sellButtonId").click(function(){
        alert("Sell button clicked ");
        //TO DO
    });    
});

