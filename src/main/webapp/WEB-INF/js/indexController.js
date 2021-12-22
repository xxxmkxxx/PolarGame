$(document).ready(mainFunction());

function mainFunction() {
    onClickCreateAccount();
}

function onClickCreateAccount() {
 $("#create_account_with_mail").submit(function (event) {
     event.preventDefault();

     var mail = $("#registration_inputtype").val()

     if(mail === "")
         mail = "none";

     $.ajax({
         type : 'GET',
         url : '/PolarGame/user/new/' + mail,
         success : function() {
             window.location.href = '/PolarGame/user/new/' + mail;
         },
         error : function(message) {
             console.log(message);
         }
     });
 });
}