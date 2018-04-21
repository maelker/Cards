$(document ).ready(function(){


    

    var xhr = new XMLHttpRequest()
    xhr.open("GET", '/cards',true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
        	
        	console.log(xhr.responseText);
        	
        	var data = JSON.parse(xhr.responseText);
        	
        	for(i=0;i<data.length;i++){
        	// si la carte est à vendre	
         
          addCardToList(data[i].id,data[i].imgUrl,data[i].family,data[i].imgUrl,data[i].name,data[i].description,data[i].hp,data[i].energy,data[i].attack,data[i].defence,data[i].price);

            	      //         console.log(data[i].id);
          
               
            }
        }
    };
    xhr.send(null);

});




function fillCurrentCard(id,imgUrlFamily,familyName,imgUrl,name,description,hp,energy,attack,defence,price){
    //FILL THE CURRENT CARD
	//console.log(id);
    $('#cardFamilyImgId')[0].src=imgUrlFamily;
    $('#cardFamilyNameId')[0].textContent=familyName;
    $('#cardImgId')[0].src=imgUrl;
    $('#cardNameId')[0].textContent=name;
    $('#cardDescriptionId')[0].textContent=description;
    $('#cardHPId')[0].innerText=hp+" HP";
    $('#cardEnergyId')[0].innerText=energy+" Energy";
    $('#cardAttackId')[0].innerText=attack+" Attack";
    $('#cardDefenceId')[0].innerText=defence+" Defence";
    $('#cardPriceId')[0].innerText=price+" $";
    document.getElementsByClassName("ui bottom attached button")[0].setAttribute("onclick","findCard("+id+")");

};


//ajoute la carte à l'utilisateur
function buy(card){
	var userId="1";
	var xhr = new XMLHttpRequest();
    xhr.open("POST", '/cards/user/'+userId,true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(JSON.stringify({"name":String(card.name),"description":String(card.description),"family":String(card.family),"familyUrl":String(card.familyUrl),"price":Number(card.price),"hp":Number(card.hp),"energy":Number(card.energy),"defence":Number(card.defence),"attack":Number(card.attack),"imgUrl":String(card.imgUrl)}));
    alert("Carte achetée !");
}

//récupère la carte à partir de son id
function findCard(id){
	var xhr = new XMLHttpRequest();
    xhr.open("GET", '/cards/'+id,true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
        	var data = JSON.parse(xhr.responseText);
        	buy(data);
        }
    };
    xhr.send(null);
}
function addCardToList(id,imgUrlFamily,familyName,imgUrl,name,description,hp,energy,attack,defence,price){
   script="onclick=findCard('"+id+"')";

    content="\
    <td> \
    <img  class='ui avatar image' src='"+imgUrl+"'> <span>"+name+" </span> \
   </td> \
    <td>"+description+"</td> \
    <td>"+familyName+"</td> \
    <td>"+hp+"</td> \
    <td>"+energy+"</td> \
    <td>"+attack+"</td> \
    <td>"+defence+"</td> \
    <td>"+price+"$</td>\
    <td>\
        <div class='ui vertical animated button' tabindex='0'>\
            <div class='hidden content'>Sell</div>\
    <div class='visible content'>\
        <i class='shop icon'></i>\
    </div>\
    </div>\
    </td>";
    
    script="onclick=fillCurrentCard("+id+",'"+imgUrlFamily+"','"+familyName+"','"+imgUrl+"','"+name+"','"+description+"',"+hp+","+energy+","+attack+","+defence+","+price+")";
    $('#cardListId tr:last').after('<tr '+script+'>'+content+'</tr>');
    
};