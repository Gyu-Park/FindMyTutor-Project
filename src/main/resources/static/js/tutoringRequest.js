$("#btn-request").on('click', function(e) {
    e.preventDefault();
    var lessonId = document.getElementById('lessonId').value;
    var message = document.getElementById('message').value;
    var sender = document.getElementById('sender').value;
    var requestCardRequest = {
        sender: sender,
        message: message,
        lessonId: lessonId
        };

    $.ajax({
           type: "POST",
           url: "/api/requestCard/sendRequestCard",
           data: JSON.stringify(requestCardRequest),
           contentType : "application/json; charset=utf-8",
           success: function(data)
           {
                alert("Send your request successfully!");
                closeRequestForm();
           },
           error: function(data) {
               alert(data);
               console.log("error");
           }
         });
});