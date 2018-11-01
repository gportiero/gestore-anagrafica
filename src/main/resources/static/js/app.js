var stompClient = null;

function connect() {
   var socket = new SockJS('/registry-websocket');
   stompClient = Stomp.over(socket);
   stompClient.connect({}, function (frame) {
      stompClient.subscribe('/topics/import/status', function (status) {
    	  var success = JSON.parse(status.body);
    	  if (success) {
    		  $('#success').show();
    	  } else {
    		  $('#error').show();
    	  }
      });
   });
}

$(function () {
	connect();
});