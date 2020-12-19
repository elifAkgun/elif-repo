var websocket;

function setupWebSocket() {
	var uri = "ws://" + document.location.host + '/event/' + "connect/"
			+ $("#userName").val();

	websocket = new WebSocket(uri);

	websocket.onmessage = function(evt) {
		printRecieveMsg(evt.data);
	};

	websocket.onopen = function(evt) {
		console.log(evt)
	};

	websocket.onerror = function(evt) {
		console.log('an error occurred')
	};
}

$("#userName").blur(function() {
		setupWebSocket()
});

$("#button").click(function() {
	console.log($("#userName").val());
	var time = new Date().toTimeString();
	websocket.send(message.value);
	print("Sent at " + time + ': ' + message.value);
	message.value = '';

});

function printRecieveMsg(message) {
	
//	<div class="incoming_msg">
//	<div class="incoming_msg_img">
//		<img src="https://ptetutorials.com/images/user-profile.png"
//			alt="sunil">
//	</div>
//	<div class="received_msg">
//		<div class="received_withd_msg">
//			<p>Test, which is a new approach to have</p>
//			<span class="time_date"> 11:01 AM | Yesterday</span>
//		</div>
//	</div>
//</div>
	
	var messageArea = document.getElementById("div_messages");

	var label = document.createElement('div');
	label.class ="incoming_msg";
	
	var sublable = document.createElement('div');
	sublable.class = "incoming_msg_img";
	
	
	var image = document.createElement('img');
	image.src ="https://ptetutorials.com/images/user-profile.png";
	
	label.style.wordWrap = "break-word";
	label.innerHTML = message;

	sublable.appendChild(image);
	label.appendChild(sublable);
	messageArea.appendChild(label);
}

function printSentMsg(message) {
	var messageArea = document.getElementById("messages");

	var label = document.createElement('p');
	label.style.wordWrap = "break-word";
	label.innerHTML = message;
	messageArea.appendChild(label);
}