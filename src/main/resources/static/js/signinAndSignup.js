// sign-up
$("#btn-signup").on('click', function(e) {
    e.preventDefault();
    var signupRequest = {
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

// sign-in
$("#btn-signin").on('click', function(e) {
    e.preventDefault();
    var signinRequest = {
                    email: $("#signin-email").val(),
                    password: $("#signin-password").val()
                };
    $.ajax({
           type: "POST",
           url: "/api/auth/signin",
           data: JSON.stringify(signinRequest),
           contentType : "application/json; charset=utf-8",
           success: function(data)
           {
                alert("signin");
                closeLoginForm();
                window.location.reload();
           },
           error: function(data) {
               alert(data);
               console.log("error");
           }
         });
});