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
var method = document.getElementById('method');
function getMethod(element) {
    method.value = element.value;

}
var subject = document.getElementById('subject');
function getSubject(element) {
    subject.value = element.value;
}
var price = document.getElementById('price');
function getPrice(element) {
    price.value = element.value;
}