$(document ).ready(function(){
    let idUser = localStorage.getItem('idUser');

    $.ajax({
        url: 'http://localhost:8080/rooms?idUser=' + idUser,
        type: 'GET',
        success: function(data)
        {
        	//On vérifie si l'utilisateur n'est pas déjà en train de jouer
        	if(data[0].idHote == -1)
        	{
        		//TODO faire les bonnes vérifications
                $(location).attr('href', 'playRoom.html');
        	}
        	
            for(i=0; i<data.length; i++)
            {
            	room = data[i];
            	addRoomToList(room.idHote, room.nom, room.idHote, room.bet);
            }
        },
    	failure: function()
    	{
    		alert('hello world');
    	}
    });

    
     $("#createRoomButtonId").click(function(){
        alert("Create Card button clicked ");
        //TO DO
    }); 
    
});


function addRoomToList(id,name, user, bet){
    
    content="<td> "+name+" </td> \
                            <td> "+user+" </td> \
                            <td> "+bet+" $</td> \
                            <td> \
                                <div class='center aligned'> \
                                    <div class='ui  vertical animated button' tabindex='0' onClick='onRoomSelected("+id+", \"" + name + "\")'> \
                                        <div class='hidden content'>Play</div> \
                                        <div class='visible content'> \
                                            <i class='play circle icon'></i> \
                                        </div> \
                                    </div> \
                                </div> \
                            </td>";
    
    $('#roomListId tr:last').after('<tr>'+content+'</tr>');
    
    
};

function onRoomSelected(id, name){
    localStorage.setItem('roomName', name);
    $(location).attr('href', 'selectCardForPlay.html');
}