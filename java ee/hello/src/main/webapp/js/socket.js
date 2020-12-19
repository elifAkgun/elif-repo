var uri = "ws://" + document.location.host + '/event/' + "chat";
var websocket = new WebSocket(uri);
var messageArea = document.getElementById("messages");


websocket.onopen = function(evt) {
	console.log('connection established');
};
websocket.onmessage = function(evt) {
	var time = new Date().toTimeString();
	print("Recived at " + time + ': ' + evt.data);
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

function print(message) {
	var messageArea = document.getElementById("messages");

	var label = document.createElement('p');
	label.style.wordWrap = "break-word";
	label.innerHTML = message;
	messageArea.appendChild(label);
}
