$(document).ready(mainFunction());

function mainFunction() {
    searchParty("#find_party");
    displayFilters();
    useFilters();
}

function searchParty(element) {
    $(element).on('input', function () {
        let pattern = {
            searchPattern : $("#find_party").val(),
            gameId : gameId
        };

        $.ajax({
            type : 'POST',
            url : '/PolarGame/ajax/game/party/search',
            data: pattern,
            success: function (partyList) {
                displayFoundParties(partyList)
            },
            error : function () {
                console.log("error");
            }
        });
    });
}

function comeInParty() {
    $(".come_in").on("click", function () {

    });
}

function createNewRow(id) {
    let rowDiv = $('<div>', {
        'class': 'row1',
        'id': 'rowParty' + id
    });

    $('#com_party_place').append(rowDiv);

    return $('#rowParty' + id);
}

function createPartyBlock(numberPartyOnRow, party) {
    let partyOwner = getPartyOwner(party.members);

    let partySpan = $('<span>', {
        'class': 'form' + numberPartyOnRow
    });

    let div_row2 = $('<div>', {
        'class': 'row2'
    });

    let span_participans = $('<span>', {
        'class': 'participans'
    }).text(party.members.length + ' из ' + party.usersAmount + ' игроков');

    let span_come_in = $('<span>', {
        'id': party.partyId,
        'class': 'come_in'
    });

    let img_come_in = $('<img>', {
        'src': '/PolarGame/images/images/come_in_icon.png'
    });

    let div_formsdata = $('<div>', {
        'class': 'formsdata'
    });

    let span_form_img = $('<span>', {
        'class': 'form_img'
    });

    let img_form_img = $('<img>', {
        'src': '/PolarGame/images/' + partyOwner.user.urlUserIcon
    });

    let span_party_creator = $('<span>', {
        'class': 'party_creator'
    }).text(partyOwner.user.login);

    span_come_in.append(img_come_in);
    div_row2.append(span_participans);
    div_row2.append(span_come_in);
    span_form_img.append(img_form_img);
    div_formsdata.append(span_form_img);
    div_formsdata.append(span_party_creator);
    partySpan.append(div_formsdata);
    partySpan.append(div_row2);

    return partySpan;
}

function displayFoundParties(partiesGroup) {
    $("#com_party_place").remove();

    let com_party_place = $('<div>', {
        'class' : 'com_party_place',
        'id' : 'com_party_place'
    });

    $("#section2").append(com_party_place);

    let partyRow;

    for(let i = 0; i < partiesGroup.length; i++) {
        partyRow = createNewRow(i + 1);

        for (let j = 0; j < partiesGroup[i].length; j++) {
            partyRow.append(createPartyBlock(j + 1, partiesGroup[i][j]));
        }

    }
}

function getPartyOwner(members) {
    let owner;

    for (let i = 0; i < members.length; i++) {
        if(members[i].role === "создатель") {
            owner = members[i];

            break;
        }
    }

    return owner;
}

function displayFilters(){
    $(document).on('click', '.filter_icon', function (event) {
        event.preventDefault();

        if($(".party_filters").css("display") == "none")
            $(".party_filters").slideDown(200);
        else
            $('.party_filters').slideUp(200);

        onFilterRangeChange();
    })
}

function onFilterRangeChange() {
    $("#filter_range").change(function() {
        $("#ouput_range").text($("#filter_range").val());
    });
}

function useFilters() {
    $("#apply_party_filt").submit(function (event) {
        event.preventDefault();

        let privateStatus = $('#privacy_filter1').prop('checked');
        let publicStatus = $('#privacy_filter2').prop('checked');

        let filterStatus;

        if(privateStatus == publicStatus)
            filterStatus = "all";
        else if(privateStatus)
            filterStatus = "private";
        else if(publicStatus)
            filterStatus = "public"

        $.ajax({
            type : 'GET',
            url : '/PolarGame/ajax/game/party/filters',
            data: {filterStatus: filterStatus, amountPlayers: $("#ouput_range").val(), gameId: gameId},
            success: function (partyList) {
                displayFoundParties(partyList);

                $('.party_filters').slideUp(200);
            },
            error : function () {
                console.log("error");
            }
        });
    });
}