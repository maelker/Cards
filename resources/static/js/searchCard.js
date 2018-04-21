$(document ).ready(function(){
        fillCurrentCard("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/280px-DC_Comics_logo.png","DC comics","http://www.guinnessworldrecords.com/images/superlative/superheroes/GWR-Superheroes-SUPERMAN.svg","SUPERMAN","The origin story of Superman relates that he was born Kal-El on the planet Krypton, before being rocketed to Earth as an infant by his scientist father Jor-El, moments before Krypton's destruction. Discovered and adopted by a farm couple from Kansas, the child is raised as Clark Kent and imbued with a strong moral compass. Early in his childhood, he displays various superhuman abilities, which, upon reaching maturity, he resolves to use for the benefit of humanity through a 'Superman' identity.",50,100,17,8);

    
      $("#searchButtonId").click(function(){       
   //alert("Search button clicked :"+$("#searchId").val());

    var name = $("#searchId").val();

    
    var xhr = new XMLHttpRequest()
    xhr.open("GET", '/cards',true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
        	
        	console.log(xhr.responseText);
        	
        	var data = JSON.parse(xhr.responseText);
        	
        	for(i=0;i<data.length;i++){
                //console.log(data[i].name);
               if (data[i].name==$("#searchId").val()){
          fillCurrentCard(data[i].imgUrl,data[i].family,data[i].imgUrl,data[i].name,data[i].description,data[i].hp,data[i].energy,data[i].attack,data[i].defence);

            	                      //console.log("oui");

               }
            }
        }
    };
    xhr.send();
    alert(data);



        
    });  
    
});


function fillCurrentCard(imgUrlFamily,familyName,imgUrl,name,description,hp,energy,attack,defence){
    //FILL THE CURRENT CARD


    $('#cardFamilyImgId')[0].src=imgUrlFamily;
    $('#cardFamilyNameId')[0].textContent=familyName;
    $('#cardImgId')[0].src=imgUrl;
    $('#cardNameId')[0].textContent=name;
    $('#cardDescriptionId')[0].textContent=description;
    $('#cardHPId')[0].textContent=hp+" HP";
    $('#cardEnergyId')[0].textContent=energy+" Energy";
    $('#cardAttackId')[0].textContent=attack+" Attack";
    $('#cardDefenceId')[0].textContent=defence+" Defence";
    
};





