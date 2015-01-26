"use strict";

$(document).ready(function () {

    // Events for "Delete" buttons
    $("button[id ^= 'delete']").click(function () {
        window.location.href = "/admin/delete/" + this.id.replace("delete", "");
    });

    // Events for "Edit" buttons
    $("button[id ^= 'edit']").click(function () {
        window.location.href = "/admin/edit/" + this.id.replace("edit", "");
    });

    // Events for "Activate" buttons
    $("button[id ^= 'activate']").click(function () {
        window.location.href = "/admin/activate/" + this.id.replace("activate", "");
    });

    // Events for "Deactivate" buttons
    $("button[id ^= 'deactivate']").click(function () {
        window.location.href = "/admin/deactivate/" + this.id.replace("deactivate", "");
    });

    // Events for "Start" buttons
    $("button[id ^= 'start']").click(function () {
        window.location.href = "/student/start/" + this.id.replace("start", "");
    });
});