let closeOutZoneElement = (element) => {
    $(document).mouseup(function (event) {
        if(!$(element).is(event.target) && $(element).has(event.target).length === 0)
            $(element).slideUp(200);
    });
}