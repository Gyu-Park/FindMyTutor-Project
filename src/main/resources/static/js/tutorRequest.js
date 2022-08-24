// sign-up
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

// post form
function openPostForm() {
    document.body.classList.add("showPostForm");
}
function closePostForm() {
    document.body.classList.remove("showPostForm");
}