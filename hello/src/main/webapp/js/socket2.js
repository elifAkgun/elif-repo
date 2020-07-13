var uri = "ws://" + document.location.host + '/event/' + "chat";
var websocket = new WebSocket(uri);
var messageArea = document.getElementById("div_messages");


websocket.onopen = function(evt) {
	console.log('connection established');
};
websocket.onmessage = function(evt) {
	var time = new Date().toTimeString();
	printIncomming(evt.data);
};
websocket.onerror = function(evt) {
	console.log('an error occurred')
};

$("#button").click(function() {
	var time = new Date().toTimeString();
	websocket.send(message.value);
	print("Sent at " + time + ': ' + message.value);
	message.value = '';

});

function printIncomming(message) {
	var messageArea = document.getElementById("div_messages");

	var incoming_msg_div = document.createElement('div');
	incoming_msg_div.classList.add('incoming_msg');

	var incoming_msg_img_div = document.createElement('div');
	incoming_msg_img_div.classList.add('incoming_msg_img');

	
	var image = document.createElement('img');
	image.src ="https://ptetutorials.com/images/user-profile.png";
	
	incoming_msg_img_div.appendChild(image);
	
	var received_msg_div = document.createElement('div');
	received_msg_div.classList.add('received_msg');
	
	var received_withd_msg_div = document.createElement('div');
	received_withd_msg_div.classList.add('received_withd_msg');
	
	var message_p = document.createElement('p');
	message_p.style.wordWrap = "break-word";
	message_p.innerHTML = message;
	
	received_withd_msg_div.appendChild(message_p);
	received_msg_div.appendChild(received_withd_msg_div);

	


	
	
	incoming_msg_div.appendChild(incoming_msg_img_div);
	incoming_msg_div.appendChild(received_msg_div);

	messageArea.appendChild(incoming_msg_div);
	
	
	
//	var message = document.createElement('p');
//	incoming_msg_div.innerHTML = message;
}
