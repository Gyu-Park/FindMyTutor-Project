// sign-up
$("#btn-signup").on('click', function(e) {
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

// login form
function openLoginForm() {
    document.body.classList.add("showLoginForm");
}
function closeLoginForm() {
    document.body.classList.remove("showLoginForm");
}

// registration form
function openRegistrationForm() {
    document.body.classList.add("showRegistrationForm");
}
function closeRegistrationForm() {
    document.body.classList.remove("showRegistrationForm");
}

// request form
function openRequestForm() {
    document.body.classList.add("showRequestForm");
}
function closeRequestForm() {
    document.body.classList.remove("showRequestForm");
}

function signUpLinkFunction() {
    document.body.classList.remove("showLoginForm");
    document.body.classList.add("showRegistrationForm");
}

function signInLinkFunction() {
    document.body.classList.remove("showRegistrationForm");
    document.body.classList.add("showLoginForm");
}