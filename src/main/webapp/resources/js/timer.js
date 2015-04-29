"use strict";

$(function() {
    var seconds = $('#timer').text();
    setTimeout(updateCountdown, 1000);

    function updateCountdown() {
        seconds--;
        if (seconds > 0) {
            $('#timer').text(seconds);
            setTimeout(updateCountdown, 1000);
        } else {
            submitForm();
        }
    }

    function submitForm() {
        $('#questionForm').submit();
    }
});