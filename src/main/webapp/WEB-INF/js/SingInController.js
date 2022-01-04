$(document).ready(mainFunction());

function mainFunction() {
    checkSingInData();
}

function checkSingInData() {
    $("#sing_in").submit(function (event) {
        event.preventDefault();

        var UserData = {
            login : $("#sign_form_login").val(),
            password : $("#sign_form_password").val()
        };

        if(isFieldsNotNull())
            $.ajax({
                type : 'POST',
                data: UserData,
                url : '/PolarGame/ajax/user/validateSingInData',
                success : function(errInfo) {
                    if(errInfo === "success")
                        isCorrectData();
                    else
                        displayErrorMessage(errInfo);

                },
                error: function (message) {
                    console.log(message);
                }
            });
    });
}

function displayErrorMessage(message) {
    if($("#icon").length && message === "") {
        $("#icon").remove();
    } else if($("#icon").length) {

    } else {
        var errorImg = $('<img>', {
            'id' : 'icon',
            'src' : '/PolarGame/images/images/error.png'
        });
        $("#error_icon").append(errorImg);
    }

    $("#Error_message").text(message);
}

function isFieldsNotNull() {
    if($("#sign_form_login").val() == "") {
        displayErrorMessage("Поле Логин не может быть пустым!");
        return false;
    }else if($("#sign_form_password").val() == "") {
        displayErrorMessage("Поле Пароль не может быть пустым!");
        return false;
    } else {
        return true;
    }

}

function isCorrectData() {
    $.ajax({
        type : 'POST',
        url : '/PolarGame/user/successfulAuthentication',
        success: function () {
            window.location.href = '/PolarGame/catalog';
        }
    });
}