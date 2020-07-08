
if (typeof (EventSource) !== "undefined") {
    var source = new EventSource("http://localhost:8080/event/api/v1/sse-path");

    source.addEventListener("customer", function (event) {
        document.getElementById("customer").innerText += event.data + "\n"

    });
} else {
    document.getElementById("message").innerText = "Sorry! Your browser doesn't support SSE";

}