function sendCard(json)
{
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			alert(this.responseText);
		}
	};
	xhttp.open("POST", "../rest/servicescard/add", true);
	xhttp.setRequestHeader('Content-Type', 'application/json');
	xhttp.send(json);
}

window.onload = function()
{
	document.getElementById('submitButton').addEventListener('click', function(event)
			{
				event.preventDefault();
				
				var card = '{';
				
				card += '"id":"' + document.getElementById("id").value + '",';
				
				card += '"name":"' + document.getElementById("name").value + '",';
				
				card += '"description":"' + document.getElementById("description").value + '",';
				
				card += '"family":"' + document.getElementById("family").value + '",';
				
				card += '"hp":"' + document.getElementById("hp").value + '",';
				
				card += '"energy":"' + document.getElementById("energy").value + '",';
				
				card += '"attack":"' + document.getElementById("attack").value + '",';
				
				card += '"defence":"' + document.getElementById("defence").value + '",';
				
				card += '"imgUrl":"' + document.getElementById("imgUrl").value + '"';
				
				card += '}';

				sendCard(card);
			});
}