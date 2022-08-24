// post lessons
$("#btn-post").on('click', function(e) {
    e.preventDefault();

    var method = document.querySelector('.method:checked').value;
    var subject = document.querySelector('.subject:checked').value;
    
    var lessonPostRequest = {
                    method: method,
                    subject: subject,
                    price: $("#post-price").val(),
                    member: null
                };

    $.ajax({
           type: "POST",
           url: "/api/lesson/post",
           data: JSON.stringify(lessonPostRequest),
           contentType : "application/json; charset=utf-8",
           success: function(data)
           {
                alert("Successfully posted!");
                closePostForm();
           },
           error: function(data) {
               alert(data);
               console.log("error");
           }
         });
});

// search lessons
var method;
function getMethod(element) {
    method = element.value;
}
var subject;
function getSubject(element) {
    subject = element.value;
}
var price;
function getPrice(element) {
    price = element.value;
}

$(".submitBtn").on('click', function(e) {
    e.preventDefault();
    var lessonSearchRequest = {
                    method: method,
                    subject: subject,
                    price: price,
                };

    $.ajax({
           type: "POST",
           url: "/api/lesson/search",
           data: JSON.stringify(lessonSearchRequest),
           contentType : "application/json; charset=utf-8",
           success: function(data)
           {
                // show results
                window.location.href = "/result";
           },
           error: function(data) {
               alert(data);
               console.log("error");
           }
         });
});