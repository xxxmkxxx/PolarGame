$(document).ready(() => {
    partyEvents();

    chooseSection();
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
    searchPartyEvent("#find_party");

    openFiltersFormEvent(".filter_icon", ".party_filters");
    closeFiltersFormEvent(".filter_icon", ".party_filters");

    confirmPartyFiltersEvent();

    openPartyCreationFormEvent(".create_party", ".create_party_form");
    closePartyCreationFormEvent(".close_party_creator", ".create_party_form")

    partyCreateEvent("#privacy", "#passwordForm", "#player_num", "#party_descr", "#create_party_form");
}

const gameCommentsEvents = () => {

}

