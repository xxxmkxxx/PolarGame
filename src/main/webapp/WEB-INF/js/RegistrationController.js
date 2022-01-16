$(document).ready(mainFunction);

function mainFunction() {
    checkLogin();
    checkMail();
    checkPassword();
    checkEqualsPasswords();

    sendData();
}

function validateLogin(login) {
    var isCorrectLength = login.length > 5;

    return isCorrectLength;
}

function validateMail(mail) {
    var isCorrectLength = mail.length > 9;

    return isCorrectLength;
}

function validatePassword(password) {
    var isCorrectLength = password.length > 8;

    return isCorrectLength;
}

function validateEqualsPasswords(password, passwordConfirm) {
    var isPasswordsEquals = password == passwordConfirm;

    return isPasswordsEquals;
}

function checkLogin() {
    $("#reg_form_login").on('input', function () {
        if(!validateLogin($("#reg_form_login").val()))
            displayErrorMessage("You entered an incorrect login!");
        else
            displayErrorMessage("");
    });
}

function checkMail() {
    $("#reg_form_mail").on('input', function () {
        if(!validateMail($("#reg_form_mail").val()))
            displayErrorMessage("You entered an incorrect mail!");
        else
            displayErrorMessage("");
    });
}

function checkPassword() {
    $("#reg_form_password").on('input', function () {
        if(!validatePassword($("#reg_form_password").val()))
            displayErrorMessage("You entered an incorrect password!");
        else
            displayErrorMessage("");
    });
}

function checkEqualsPasswords() {
    $("#reg_form_password2").on('input', function () {
        if(!validateEqualsPasswords($("#reg_form_password2").val(), $("#reg_form_password").val()))
            displayErrorMessage("Your passwords are not identical!");
        else
            displayErrorMessage("");
    });
}

function sendData() {
    $("#registration").submit(function (event) {
        event.preventDefault();

        var UserData = {
            login: $("#reg_form_login").val(),
            reg_form_mail: $("#reg_form_mail").val(),
            reg_form_password: $("#reg_form_password").val(),
            reg_form_password2: $("#reg_form_password2").val()
        };

        $.ajax({
            type : 'POST',
            data: UserData,
            url : '/PolarGame/ajax/user/validateRegistrationData',
            success : function(message) {
                if(message.text === "success")
                    isCorrectData();
                else
                    displayErrorMessage(message.text);
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
            'src' : '/PolarGame/images/error.png'
        });
        $("#error_icon").append(errorImg);
    }

    $("#Error_message").text(message);
}

function isCorrectData() {
    $.ajax({
        type : 'POST',
        url : '/PolarGame/user/successfulRegistration',
        success: function () {
            window.location.href = '/PolarGame/catalog';
        }
    });
}