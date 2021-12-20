$(document).ready(mainFunction());

function mainFunction() {

}

function onClickCreateAccount() {
 $("#main_button_registration").click(function () {
     $.ajax({
         type : 'GET',
         dataType : 'json',
         contentType : 'application/json',
         url : 'ajax',
         success : function(response) {
             alert(response.message);
         },
         error : function() {
             alert("opps error");
         }
     });
 });
}

function ajax() {
    $.ajax({
        type : 'GET',
        dataType : 'json',
        contentType : 'application/json',
        url : 'ajax',
        success : function(response) {
            alert(response.message);
        },
        error : function() {
            alert("opps error");
        }
    });
}