// sign-up
$("#btn-post").on('click', function(e) {
    e.preventDefault();

    var method = document.querySelector('.method:checked').value;
    var subject = document.querySelector('.subject:checked').value;
    
    var lessonRequest = {
                    method: method,
                    subject: subject,
                    price: $("#post-price").val()
                };

    $.ajax({
           type: "POST",
           url: "/api/auth/signup",
           data: JSON.stringify(lessonRequest),
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