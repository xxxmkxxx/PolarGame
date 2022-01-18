$(document).ready(() => {
    partyEvents();
    gameCommentsEvents();

    chooseSection();

    foo();

    openTeam();
});

const chooseSection = () => {
    $(document).on('click', '#find_party_button', function () {
        $('#party_block').css('display', 'block');
        $('#team_block').css('display', 'none');
        $('#find_team_button').css('opacity', '50%');
        $('#find_party_button').css('opacity', '100%');
    });

    $(document).on('click', '#find_team_button', function () {
        $('#team_block').css('display', 'block');
        $('#party_block').css('display', 'none');
        $('#find_party_button').css('opacity', '50%');
        $('#find_team_button').css('opacity', '100%');
    });
};

function partyEvents() {
    openFiltersFormEvent(".filter_icon", ".party_filters");
    closeFiltersFormEvent(".filter_icon", ".party_filters");

    openPartyCreationFormEvent(".create_party", "#create_party_block");
    closePartyCreationFormEvent(".close_party_creator", "#create_party_block")

    searchPartyEvent("#find_party");

    confirmPartyFiltersEvent();

    partyCreateEvent("#privacy", "#passwordForm", "#player_num", "#party_descr", "#create_party_form");
}

function gameCommentsEvents() {
    openCreationGameCommentFormEvent();
    closeCreationGameCommentFormEvent();

    moreGameCommentsEvent();

    createCommentEvent();
}

function openTeam() {
    $(".openTeam").click(function () {
        window.location.href = '/PolarGame/team/' + $(this).attr("id");
    })
}

