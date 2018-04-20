$(document ).ready(function(){
    
  $('#roomNameId')[0].innerText=" A ";
    
    fillCard("user1","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png","DC comics","http://www.guinnessworldrecords.com/images/superlative/superheroes/GWR-Superheroes-SUPERMAN.svg","SUPERMAN","The origin story of Superman relates that he was born Kal-El on the planet Krypton, before being rocketed to Earth as an infant by his scientist father Jor-El, moments before Krypton's destruction. Discovered and adopted by a farm couple from Kansas, the child is raised as Clark Kent and imbued with a strong moral compass. Early in his childhood, he displays various superhuman abilities, which, upon reaching maturity, he resolves to use for the benefit of humanity through a 'Superman' identity.",50,100,17,80,100);

    fillCard("user2","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png","DC comics","https://upload.wikimedia.org/wikipedia/en/9/98/Joker_%28DC_Comics_character%29.jpg","Jocker","The Joker is a fictional supervillain created by Bill Finger, Bob Kane, and Jerry Robinson who first appeared in the debut issue of the comic book Batman (April 25, 1940), published by DC Comics. Credit for the Joker's creation is disputed; Kane and Robinson claimed responsibility for the Joker's design, while acknowledging Finger's writing contribution. Although the Joker was planned to be killed off during his initial appearance, he was spared by editorial intervention, allowing the character to endure as the archenemy of the superhero Batman.",50,50,170,30);

$('#actionTextId')[0].innerText="jocker attack for 5 \n Superman attack for 41, \n Jocker miss attack";


});



function fillCard(prefix,imgUrlFamily,familyName,imgUrl,name,description,hp,energy,attack,defence,price){
    //FILL THE CURRENT CARD
    $('#'+prefix+'cardFamilyImgId')[0].src=imgUrlFamily;
    $('#'+prefix+'cardFamilyNameId')[0].innerText=familyName;
    $('#'+prefix+'cardImgId')[0].src=imgUrl;
    $('#'+prefix+'cardNameId')[0].innerText=name;
    $('#'+prefix+'cardDescriptionId')[0].innerText=description;
    $('#'+prefix+'cardHPId')[0].innerText=hp+" HP";
    $('#'+prefix+'cardEnergyId')[0].innerText=energy+" Energy";
    $('#'+prefix+'cardAttackId')[0].innerText=attack+" Attack";
    $('#'+prefix+'cardDefenceId')[0].innerText=defence+" Defence";
  
};


