let stompClient;
let partyRow;

$(document).ready(() => {
    connectWebSocket("/PolarGame/party-websocket");

    openPartyFormEvent();
    closePartyFormEvent();

    loadPreviewEvent();
});

const searchPartyEvent = (element) => {
    const ajax = () => {
        let data = {
            searchPattern : $("#find_party").val(),
            gameId : gameId
        };

        $.ajax({
            type : "POST",
            url : "/PolarGame/ajax/game/party/search",
            data : data,
            success: function (message) {
                console.log(message);
                if(message.text === "success")
                    displayFoundParties(message.object);
                else
                    console.log(message.text);
            },
            error : function () {
                console.log("error");
            }
        });
    }

    $(element).on("input", function (event) {
        event.preventDefault();

        ajax();
    });

    $("#party_search").submit((event) => {
        event.preventDefault();

        ajax();
    });
}

const createPartiesRow = (id) => {
    let rowDiv = $("<div>", {
        "class" : "row1",
        "id" : "rowParty" + id
    });

    $("#com_party_place").append(rowDiv);

    return $("#rowParty" + id);
}

const createPartyBlock = (numberPartyOnRow, party) => {
    let partyOwner = getPartyOwner(party.members);

    let partySpan = $("<span>", {
        "class" : "form" + numberPartyOnRow
    });

    let div_row2 = $("<div>", {
        "class" : "row2"
    });

    let span_participans = $("<span>", {
        "class" : "participans"
    }).text(party.members.length + " из " + party.usersAmount + " игроков");

    let span_come_in = $("<span>", {
        "id" : party.partyId,
        "class" : "come_in"
    });

    let img_come_in = $("<img>", {
        "src" : "/PolarGame/images/come_in_icon.png"
    });

    let div_formsdata = $("<div>", {
        "class" : "formsdata"
    });

    let span_form_img = $("<span>", {
        "class" : "form_img"
    });

    let img_form_img = $("<img>", {
        "src" : "/PolarGame/images/" + partyOwner.user.urlUserIcon
    });

    let span_party_creator = $("<span>", {
        "class" : "party_creator"
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

const displayFoundParties = (partiesGroup) => {
    $("#com_party_place").remove();

    let com_party_place = $("<div>", {
        "class" : "com_party_place",
        "id" : "com_party_place"
    });

    $("#party_block").append(com_party_place);

    for(let i = 0; i < partiesGroup.length; i++) {
        partyRow = createPartiesRow(i + 1);

        for (let j = 0; j < partiesGroup[i].length; j++) {
            partyRow.append(createPartyBlock(j + 1, partiesGroup[i][j]));
        }

    }
}

const getPartyOwner = (members) => {
    let owner;

    for (let i = 0; i < members.length; i++) {
        if(members[i].role === "создатель") {
            owner = members[i];
            break;
        }
    }

    return owner;
}

const openFiltersFormEvent = (openTriggerElement, formElement) => {
    $(openTriggerElement).click(() => {
        displayElement(formElement);

        filterRangeChangeEvent();
    });
}

const closeFiltersFormEvent = (closeTriggerElement, formElement) => {
    closeOutZoneElement(formElement);
}

const filterRangeChangeEvent = () => {
    $("#filter_range").change(function() {
        $("#ouput_range").text($("#filter_range").val());
    });
}

const confirmPartyFiltersEvent = () => {
    $("#apply_party_filt").submit((event) => {
        event.preventDefault();

        let privateStatus = $("#privacy_filter1").prop("checked");
        let publicStatus = $("#privacy_filter2").prop("checked");

        let filterStatus;

        if(privateStatus == publicStatus)
            filterStatus = "all";
        else if(privateStatus)
            filterStatus = "private";
        else if(publicStatus)
            filterStatus = "public"

        let data = {
            filterStatus: filterStatus,
            amountPlayers: $("#ouput_range").val(),
            gameId: gameId
        };

        $.ajax({
            type : "GET",
            url : "/PolarGame/ajax/game/party/filters",
            data : data,
            success : function (message) {
                console.log("-------" + message)

                if(message.text === "success") {
                    displayFoundParties(message.object);
                } else {
                    console.log(message.text);
                }

                $(".party_filters").slideUp(200);
            },
            error : function () {
                console.log("error");
            }
        });
    });
}

const openPartyCreationFormEvent = (openTriggerElement, formElement) => {
    $(openTriggerElement).click(() => {
        displayElement(formElement);
    });
}

const closePartyCreationFormEvent = (closeTriggerElement, formElement) => {
    $(closeTriggerElement).click(() => {
        hideElement(formElement);
    });

    closeOutZoneElement(formElement);
}

const partyCreateEvent = (privacyElement, passwordFieldElement, countPlayerElement, textAreaElement, formElement) => {
    displayPasswordFieldEvent(privacyElement, passwordFieldElement);

    $(formElement).submit((event) => {
        event.preventDefault();

        let data = {
            privacy : $(privacyElement).prop("checked"),
            password : $(passwordFieldElement).val(),
            countPlayers : $(countPlayerElement).val(),
            description : $(textAreaElement).val(),
            gameId : gameId
        };

        $.ajax({
            type : "POST",
            url : "/PolarGame/ajax/game/party/create",
            data : data,
            success : () => {
                stompClient.send("/app/parties", {}, JSON.stringify({gameId : gameId}));

                $(formElement).slideUp(200);
            },
            error : function () {
                console.log("error");
            }
        });
    });
}

const displayPasswordFieldEvent = (displayTriggerElement, passwordFieldElement) => {
    $(displayTriggerElement).change(() => {
        if($(displayTriggerElement).prop("checked"))
            displayElement(passwordFieldElement);
        else
            hideElement(passwordFieldElement);
    });
}

const connectWebSocket = (endPoint) => {
    const socket = new SockJS(endPoint);

    stompClient = Stomp.over(socket);
    stompClient.connect({}, () => {
        stompClient.subscribe("/topic/new/party", (gropedParties) => {
            displayFoundParties(JSON.parse(gropedParties.body).object);
        });
    });
}

const readUrl = (input) => {
    if(input.files && input.files[0]) {
        const reader = new FileReader();
        reader.onload = function (e) {
            $('#preview').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}

const loadPreviewEvent = (input) => {
    $("#file").change(function() {
        console.log('load!');
        readUrl(this);
    });
}

const openPasswordFieldEvent = () => {
    $("#closed_icon").click(function() {
        $('#closed_icon').css("display","none");
        $("#participants").css("display","none");
        $("#passwordOfParty").children("input").css("display", "block");
    });
}

const closePasswordFieldEvent = () => {
    $(document).mouseup(function (event) {
        if(!$(".row2").is(event.target) && $(".row2").has(event.target).length === 0) {
            $('#closed_icon').css("display","block");
            $("#participants").css("display","block");
            $("#passwordOfParty").children("input").css("display", "none");
        }
    });
}

openPasswordFieldEvent();
closePasswordFieldEvent();

// const openPartyForm = (element) => {
//     element.click(function() {
//         $('#party_form').css("display","flex");
//     });
// }

const openPartyFormEvent = () => {
    $(".open").click(function() {
        console.log($(".open").attr("id"))

        let data = {
            partyId : $(".open").attr("id")
        };

        $.ajax({
            type : "POST",
            url : "/PolarGame/ajax/game/party/get",
            data : data,
            success : (message) => {
                console.log(message)
                setPartyInfo(message.object);
            },
            error : function () {
                console.log("error");
            }
        });

        displayElement('#party_form');
    });
}

const setPartyInfo = (party) => {
    $("#party_descriprion").text(party.description);
    $($(".party_icon").children("img")[0]).attr("src", '/PolarGame/images/' + party.urlPartyIcon);
    let temp = party.members.length;
    $("#members_here").text(temp);
    $("#members_amount").text("/" + party.usersAmount);
}

const closePartyFormEvent = () => {
    closeOutZoneElement('#party_form');
    $('#exit_button').click(function() {
        hideElement('#party_form')
    });
}

const readyEvent = () => {
    $('#ready_button').click(function() {
        console.log('hh');
        $('#my_nick').css("border-color", "#76D874");
    })
}

iAmReady();

const partyMemberRowGenerate = () => {
    let partyMemberIcon = $("<div>", {
        "class": "party_member_icon"
    });
    let partyMemberIconImg = $("<img>", {
        "src": "@{'/images/example_pic.png'}"
    });
    let partyMemberName = $("<div>", {
        "class": "party_member_name"
    });
    let gameNick = $("<div>", {
        "class": "game_nick"
    });

    partyMemberIcon.append(partyMemberIconImg);
    $(".party_member_row").append(partyMemberIconImg);
    $(".party_member_row").append(partyMemberName);
    $(".party_member_row").append(gameNick);
}

readyEvent();