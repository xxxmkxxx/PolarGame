$(document).ready(mainFunction());

function mainFunction() {
    searchParty();
}

function searchParty() {
    $("#find_party").on('input', function () {
        var pattern = {
            searchPattern : $("#find_party").val(),
            gameId : gameId
        };

        $.ajax({
            type : 'POST',
            url : '/PolarGame/ajax/game/party/search',
            data: pattern,
            success: function (partyList) {
                console.log(partyList[0])
            },
            error : function () {
                console.log("error");
            }
        });
    });
}

function displayFoundParties() {

}