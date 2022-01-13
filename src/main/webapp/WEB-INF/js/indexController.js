$(document).ready(mainFunction());

function mainFunction() {
    createAccountEvent(indexConfig.get("sender_mail_form_id"));
}

function createAccountEvent(senderForm) {
    $(senderForm).submit(() => {
         let mail = $(indexConfig.get("mail_field_id")).val()

         if(mail === "")
             mail = "none";

         $.ajax({
             type : "GET",
             url : "/PolarGame/user/new/" + mail,
             success : function() {
                 window.location.href = "/PolarGame/user/new/" + mail;
             },
             error : function(message) {
                 console.log(message);
             }
         });
    });
}