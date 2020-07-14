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
	printOutGoing(message.value);
	message.value = '';

});


function printOutGoing(message) {
	var messageArea = document.getElementById("div_messages");

	var outgoing_msg_div = document.createElement('div');
	outgoing_msg_div.classList.add('outgoing_msg');
	
	
	var sent_msg_div = document.createElement('div');
	sent_msg_div.classList.add('sent_msg');
	
	var message_p = document.createElement('p');
	message_p.style.wordWrap = "break-word";
	message_p.innerHTML = message;
	
	sent_msg_div.appendChild(message_p);
	outgoing_msg_div.appendChild(sent_msg_div);

	messageArea.appendChild(outgoing_msg_div);
}


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
	
}
