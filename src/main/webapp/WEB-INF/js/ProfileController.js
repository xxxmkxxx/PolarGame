$(document).ready(() => {
    displayRemoveFriendFormEvent("#delete_friend");
    closeRemoveFriendFormEvent("#confirmationCancel");
});

const chooseSection = () => {
  $(document).on('click', '#settings_button', function () {
    $('#friends_section').css('display', 'none');
    $('#settings_section').css('display', 'flex');
    $('#settings_button').css('opacity', '100%');
    $('#friends_button').css('opacity', '50%');
  });

  $(document).on('click', '#friends_button', function () {
    $('#settings_section').css('display', 'none');
    $('#friends_section').css('display', 'flex');
    $('#friends_button').css('opacity', '100%');
    $('#settings_button').css('opacity', '50%');
  });
};

const descriptionEvent = () => {
  let doesInEditMode = false;

  $(document).on('click', '#edit_description', function () {
    if (doesInEditMode === false) {
      document.getElementById('edit_description').src = '../images/apply.png';
      $('#user_description_area').css('pointer-events', 'auto');
      doesInEditMode = true;
    } else {
      document.getElementById('edit_description').src = '../images/edit_icon.png';
      $('#user_description_area').css('pointer-events', 'none');
      doesInEditMode = false;
    }
  });
};

const displayRemoveFriendFormEvent = (element) => {
    $(element).click(() => {
        displayElement(element);
    });
}

const closeRemoveFriendFormEvent = (element) => {
    $(element).click(() => {
        hideElement(element);
    });

    closeOutZoneElement(element, hideElement(element));
}

const deleteConfirmation = () => {
  $(document).on('click', '#delete_friend', function () {
    $('#whiteBack').css('display', 'flex');
    $('#confirmationBlock').css('display', 'flex');
  });

  $(document).on('click', '#confirmationToDelete', function () {
    $('#whiteBack').css('display', 'none');
    $('#confirmationBlock').css('display', 'none');
  });

  $(document).on('click', '#confirmationCancel', function () {
    $('#whiteBack').css('display', 'none');
    $('#confirmationBlock').css('display', 'none');
  });
};

chooseSection();
descriptionEvent();
deleteConfirmation();
