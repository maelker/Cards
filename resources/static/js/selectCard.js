var cardModels;

$(document ).ready(function(){
    
    $('#roomNameId')[0].innerText=localStorage.getItem('roomName');

    cardModels = {
        0: {
            id: 0,
            imgUrlFamily: "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png",
            familyName: "DC comics",
            imgUrl: "http://www.guinnessworldrecords.com/images/superlative/superheroes/GWR-Superheroes-SUPERMAN.svg",
            name: "SUPERMAN",
            description: "The origin story of Superman relates that he was born Kal-El on the planet Krypton, before being rocketed to Earth as an infant by his scientist father Jor-El," +
            "moments before Krypton's destruction. Discovered and adopted by a farm couple from Kansas, the child is raised as Clark Kent and imbued with a strong moral compass." +
            " Early in his childhood, he displays various superhuman abilities, which, upon reaching maturity, he resolves to use for the benefit of" +
            " humanity through a 'Superman' identity.",
            hp: 50,
            energy: 100,
            attack: 17,
            defence: 80
        },
        1: {
            id: 1,
            imgUrlFamily: "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png",
            familyName: "DC comics",
            imgUrl: "https://upload.wikimedia.org/wikipedia/en/9/98/Joker_%28DC_Comics_character%29.jpg",
            name: "Jocker",
            description: "The origin story of Superman relates that he was born Kal-El on the planet Krypton, before being rocketed to Earth as an infant by his scientist father Jor-El," +
            "moments before Krypton's destruction. Discovered and adopted by a farm couple from Kansas, the child is raised as Clark Kent and imbued with a strong moral compass." +
            " Early in his childhood, he displays various superhuman abilities, which, upon reaching maturity, he resolves to use for the benefit of" +
            " humanity through a 'Superman' identity.",
            hp: 50,
            energy: 50,
            attack: 170,
            defence: 30
        }
    };

    fillCurrentCard(cardModels[0]);

    for(let id in cardModels)
    {
        addCardToList(cardModels[id]);
    }
    
    
    $("#playButtonId").click(function(){
        alert("Play button clicked ");
        //TO DO
    });
    

});

function fillCurrentCard(cardModel){
    //FILL THE CURRENT CARD
    $('#cardFamilyImgId')[0].src=cardModel.imgUrlFamily;
    $('#cardFamilyNameId')[0].innerText=cardModel.familyName;
    $('#cardImgId')[0].src=cardModel.imgUrl;
    $('#cardNameId')[0].innerText=cardModel.name;
    $('#cardDescriptionId')[0].innerText=cardModel.description;
    $('#cardHPId')[0].innerText=cardModel.hp+" HP";
    $('#cardEnergyId')[0].innerText=cardModel.energy+" Energy";
    $('#cardAttackId')[0].innerText=cardModel.attack+" Attack";
    $('#cardDefenceId')[0].innerText=cardModel.defence+" Defence";
  
}


function addCardToList(cardModel){
    
    content="\
    <td> \
    <img  class='ui avatar image' src='"+cardModel.imgUrl+"'> <span>"+cardModel.name+" </span> \
   </td> \
    <td>"+cardModel.description+"</td> \
    <td>"+cardModel.familyName+"</td> \
    <td>"+cardModel.hp+"</td> \
    <td>"+cardModel.energy+"</td> \
    <td>"+cardModel.attack+"</td> \
    <td>"+cardModel.defence+"</td> \
    <td>\
        <div class='ui vertical animated button' tabindex='0' onClick='onCardSelected("+cardModel.id+")'>\
            <div class='hidden content'>Select</div>\
    <div class='visible content'>\
        <i class='checkmark icon'></i>\
    </div>\
    </div>\
    </td>";
    
    $('#cardListId tr:last').after('<tr>'+content+'</tr>');
    
    
}


function onCardSelected(id){

    fillCurrentCard(cardModels[id])
}