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

if(document.URL.indexOf("tutoringRequest") >= 0){
    $.get("/api/requestCard/getAllrequestCards", function(data, status){
        for (let i = 0; i < data.length; i++) {
            const messageWrapper = document.querySelector(".message-wrapper");
            messageWrapper.innerHTML = "<div class=\"message-box\">"
                                +           "<div class=\"lesson-info\">"
                                +               "<div class=\"lesson-info-hashtag\" type=\"button\">#" + data[i].lesson.method + "</div>"
                                +               "<div class=\"lesson-info-hashtag\" type=\"button\">#" + data[i].lesson.subject + "</div>"
                                +               "<div class=\"lesson-info-hashtag\" type=\"button\">#" + data[i].lesson.price + "</div>"
                                +           "</div>"
                                +           "<div class=\"sender-info\">"
                                +               "<div class=\"col-30\">"
                                +                   "<span>Name: </span>"
                                +                   "<span>Email: </span>"
                                +                   "<span>Phone: </span>"
                                +                   "<span>Message: </span>"
                                +               "</div>"
                                +               "<div class=\"col-4\"></div>"
                                +               "<div class=\"col-66\">"
                                +                   "<span>" + data[i].senderName + "</span>"
                                +                   "<span>" + data[i].senderEmail + "</span>"
                                +                   "<span>" + data[i].senderPhone + "</span>"
                                +                   "<span>" + data[i].senderMessage + "</span>"
                                +               "</div>"
                                +           "</div>"
                                +           "<button class=\"check-btn\">Mark as read</button>"
                                +           "<button class=\"delete-btn\">Delete</button>"
                                +       "</div>";
        }
    });
}