$(document ).ready(function(){
    //récupération des cartes possèdées par l'utilisateur
	var idUser='1';
    var xhr = new XMLHttpRequest();
    xhr.open("GET", '/possession/'+idUser,true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
        	var data = JSON.parse(xhr.responseText);
        	for(i=0;i<data.length;i++){
                addCardToList(data[i].id,data[i].familyUrl,data[i].family,data[i].imgUrl,data[i].name,data[i].description,data[i].hp,data[i].energy,data[i].attack,data[i].defence,data[i].price);
            }
        }
    };
    xhr.send(null);
});

//modifie le contenu de l'affichage de la carte sélectionnée
function fillCurrentCard(id,imgUrlFamily,familyName,imgUrl,name,description,hp,energy,attack,defence,price){
    $('#cardFamilyImgId')[0].src=imgUrlFamily;
    $('#cardFamilyNameId')[0].innerHTML=familyName;
    $('#cardImgId')[0].src=imgUrl;
    $('#cardNameId')[0].innerHTML=name;
    $('#cardDescriptionId')[0].innerHTML=description;
    $('#cardHPId')[0].innerHTML=hp+" HP";
    $('#cardEnergyId')[0].innerHTML=energy+" Energy";
    $('#cardAttackId')[0].innerHTML=attack+" Attack";
    $('#cardDefenceId')[0].innerHTML=defence+" Defence";
    $('#cardPriceId')[0].innerHTML=price+" $";
    document.getElementsByClassName("ui bottom attached button")[0].setAttribute("onclick","findCard("+id+")");
};

//vend la carte de l'utilisateur
function sell(card){
	var xhr = new XMLHttpRequest();
    xhr.open("DELETE", '/cards/user/'+card.id,true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(JSON.stringify(card));
    alert("Carte vendue !");
}

//récupère la carte à partir de son id
function findCard(id){
	var xhr = new XMLHttpRequest();
    xhr.open("GET", '/cards/'+id,true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
        	var data = JSON.parse(xhr.responseText);
        	sell(data);
        }
    };
    xhr.send(null);
}

//ajoute une ligne au tableau affichant toutes les cartes disponibles
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
        <div class='ui vertical animated button' tabindex='0' "+script+">\
            <div class='hidden content'>Sell</div>\
    <div class='visible content'>\
        <i class='shop icon'></i>\
    </div>\
    </div>\
    </td>";
    script="onclick=fillCurrentCard("+id+",'"+imgUrlFamily+"','"+familyName+"','"+imgUrl+"','"+name+"','"+description+"',"+hp+","+energy+","+attack+","+defence+","+price+")";
    $('#cardListId tr:last').after('<tr '+script+'>'+content+'</tr>');   
    
};