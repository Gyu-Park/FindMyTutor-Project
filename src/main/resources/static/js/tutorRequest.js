// sign-up
$("#btn-post").on('click', function(e) {
    e.preventDefault();
    var role;
    if (document.getElementById("role-tutor").checked)
        role = document.getElementById("role-tutor").value;
    else
        role = document.getElementById("role-student").value;
    var signupRequest = {
                    role: role,
                    firstName: $("#signup-firstName").val(),
                    lastName: $("#signup-lastName").val(),
                    email: $("#signup-email").val(),
                    password: $("#signup-password").val()
                };

    $.ajax({
           type: "POST",
           url: "/api/auth/signup",
           data: JSON.stringify(signupRequest),
           contentType : "application/json; charset=utf-8",
           success: function(data)
           {
                alert("Now you're a member!");
                closeRegistrationForm();
                openLoginForm();
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