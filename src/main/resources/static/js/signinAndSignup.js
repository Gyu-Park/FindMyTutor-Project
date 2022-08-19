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