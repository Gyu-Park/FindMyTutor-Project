let index = {
    init: function() {
        $("#btn-signin").on("click", () => {
            this.signin();
        });
    },

    signin: function() {
        let data = {
            email: $("#email").val(),
            password: $("#password").val()
        };

        $.ajax({
            type: "POST",
            url: "/signin",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            location.href = "/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
}