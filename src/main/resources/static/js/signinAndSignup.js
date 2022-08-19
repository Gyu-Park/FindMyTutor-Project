// let index = {
//     init: function() {
//         $("#btn-signin").on("click", () => {
//             this.signin();
//         });

//         $("#btn-signup").on("click", () => {
//             this.signup();
//         });
//     },

//     signin: function() {
//         let data = {
//             email: $("#email").val(),
//             password: $("#password").val()
//         };

//         $.ajax({
//             type: "POST",
//             url: "/api/auth/signin",
//             data: JSON.stringify(data),
//             // contentType: "application/json; charset=utf-8",
//             contentType: "application/json",
//             dataType: "json"
//         }).done(function(resp){
//             location.href = "/";
//         }).fail(function(error){
//             alert(JSON.stringify(error));
//         });
//     },

//     signup: function() {
//         let signupRequest = {
//             firstName: $("#signup-firstName").val(),
//             lastName: $("#signup-lastName").val(),
//             email: $("#signup-email").val(),
//             password: $("#signup-password").val()
//         };

//         $.ajax({
//             type: "POST",
//             url: "/api/auth/signup",
//             data: JSON.stringify(signupRequest),
//             // contentType: "application/json; charset=utf-8",
//             contentType: "application/json",
//             dataType: "json"
//         }).done(function(resp){
//             location.href = "/";
//         }).fail(function(error){
//             alert(JSON.stringify(error));
//         });
//     }
// }

// index.init();

// var form = document.getElementById('signup-form');

function signup(){
   
    fetch("http://localhost:8080/api/auth/signup", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            firstName: $("#signup-firstName").val(),
            lastName: $("#signup-lastName").val(),
            email: $("#signup-email").val(),
            password: $("#signup-password").val()
        }),
    })
    .then((response) => response.json())
    .then((data) => console.log(data)).catch(error => console.error('Error:', error)); 
}