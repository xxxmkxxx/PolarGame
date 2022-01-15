$(document).ready(() => {
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

