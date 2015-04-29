"use strict";

$(document).ready(function () {

    // Events for "Delete" buttons
    $("button[id ^= 'delete']").click(function () {
        window.location.href = "/webtester2-1.0/admin/delete/" + this.id.replace("delete", "");
    });

    // Events for "Edit" buttons
    $("button[id ^= 'edit']").click(function () {
        window.location.href = "/webtester2-1.0/admin/edit/" + this.id.replace("edit", "");
    });

    // Events for "Activate" buttons
    $("button[id ^= 'activate']").click(function () {
        window.location.href = "/webtester2-1.0/admin/activate/" + this.id.replace("activate", "");
    });

    // Events for "Deactivate" buttons
    $("button[id ^= 'deactivate']").click(function () {
        window.location.href = "/webtester2-1.0/admin/deactivate/" + this.id.replace("deactivate", "");
    });

    // Events for "Start" buttons
    $("button[id ^= 'start']").click(function () {
        window.location.href = "/webtester2-1.0/student/start/" + this.id.replace("start", "");
    });
});