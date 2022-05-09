/*
Template Name: Tabib
Author: UXIGN
*/
"use strict";

$(function() {


    // ========================================================================= //
    //   initialize the external events
    // ========================================================================= //

    function init_events(ele) {
        ele.each(function() {

            // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
            // it doesn't need to have a start or end
            var eventObject = {
                title: $.trim($(this).text()) // use the element's text as the event title
            }

            // store the Event Object in the DOM element so we can get to it later
            $(this).data('eventObject', eventObject)

            // make the event draggable using jQuery UI
            $(this).draggable({
                zIndex: 1070,
                revert: true, // will cause the event to go back to its
                revertDuration: 0 //  original position after the drag
            })

        })
    }

    init_events($('#external-events div.external-event'))


    // ========================================================================= //
    //   initialize the external events
    // ========================================================================= //


    //Date for the calendar events (dummy data)
    var date = new Date()
    var d = date.getDate(),
        m = date.getMonth(),
        y = date.getFullYear()
    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        buttonText: {
            today: 'today',
            month: 'month',
            week: 'week',
            day: 'day'
        },
        //Random default events
        events: function(start, end, timezone, callback) {//ajax请求数据并显示在响应时间段内
            $.ajax({
                url: "/student/scheduleData",
                type: 'POST',
                dataType: 'json',
                success: function (data) {
                    alert("Success");
                    callback(data);
                },
                error: function (data) {
                    alert('Success!');
                }
            });
        },
        eventDrop:function(event) {//when event ends up dragging
            alert(event.start)
            alert(event.end)
            $.ajax({
                url: "/student/updateDragging",
                type: 'POST',
                dataType: 'json',
                contentType:'application/json;charset=utf-8',
                data:JSON.stringify({Start:event.start, End:event.end,
                    Title:event.title, backgroundColor:event.backgroundColor, borderColor:event.borderColor,
                    AllDay:event.allDay,id:event.id}),
                success: function (data) {
                    // alert("hahahahah");
                    // callback(data);
                    // alert(data)
                    alert("Success");
                },
                error: function (data) {
                    // alert(data)
                    alert('Success!');
                }
            });
        },
        eventResize: function(event) {//when event ends up resizing
            alert(event.end)
            $.ajax({
                url: "/student/updateResizing",
                type: 'POST',
                dataType: 'json',
                contentType:'application/json;charset=utf-8',
                data:JSON.stringify({Start:event.start, End:event.end,
                    Title:event.title, backgroundColor:event.backgroundColor, borderColor:event.borderColor,
                    AllDay:event.allDay,id:event.id}),
                success: function (data) {
                    // alert("hahahahah");
                    // callback(data);
                    alert(event._id);
                    alert("Success");
                },
                error: function (data) {
                    // alert(data)
                    alert(event._id);
                    alert('Success!');
                }
            });
        },
        eventClick: function(calEvent, jsEvent, view) {
            if(calEvent.backgroundColor === "ff4040"){

            }else{
                $.ajax({
                    url: "/student/deleteAttend",
                    type: 'POST',
                    dataType: 'json',
                    contentType:'application/json;charset=utf-8',
                    data:JSON.stringify({Start:calEvent.start, End:calEvent.end,
                        Title:calEvent.title, backgroundColor:calEvent.backgroundColor,
                        borderColor:calEvent.borderColor,
                        AllDay:calEvent.allDay,id:calEvent.id}),
                    success: function (data) {
                        // alert("hahahahah");
                        // callback(data);
                        // alert(data)
                        alert("Success");
                    },
                    error: function (data) {
                        // alert(data)
                        alert('Success!');
                    }
                });
                $('#calendar').fullCalendar('removeEvents' , function(ev){
                    return (ev._id == calEvent._id);})
            }
        },
        editable: true,
        droppable: true, // this allows things to be dropped onto the calendar !!!
        drop: function(date, allDay,dateStr) { // this function is called when something is dropped

            // retrieve the dropped element's stored Event Object
            var originalEventObject = $(this).data('eventObject')

            // we need to copy it, so that multiple events don't have a reference to the same object
            var copiedEventObject = $.extend(true,{}, originalEventObject)

            // assign it the date that was reported
            copiedEventObject.start = date
            // alert(copiedEventObject.start)
            copiedEventObject.end = moment(copiedEventObject.start).add(moment.duration("01:00:00"));
            // alert(copiedEventObject.end)
            copiedEventObject.allDay = false
            copiedEventObject.backgroundColor = $(this).css('background-color')
            copiedEventObject.borderColor = $(this).css('border-color')
            // copiedEventObject.id = "newActivity"
            // alert(copiedEventObject.title)
            // if ($(this).css('background-color') === "#9e5fff"){
            //     copiedEventObject.title = "Tutorial"
            // }
            // if ($(this).css('background-color') === "#00c0ef"){
            //     copiedEventObject.title = "Meeting"
            // }
            // if ($(this).css('background-color') === "#bbdc00"){//calendar-5
            //     copiedEventObject.title = "Travel"
            // }
            // if ($(this).css('background-color') === "#ff5583"){//calendar-3
            //     copiedEventObject.title = "Leisure"
            // }
            // if ($(this).css('background-color') === "#9d9d9d"){//calendar-6
            //     copiedEventObject.title = "Volunteer"
            // }
            // if ($(this).css('background-color') === "#ffbb3b"){//calendar-6
            //     copiedEventObject.title = "Birthdays"
            // }
            // alert(copiedEventObject.id)
            // alert(copiedEventObject.title)
            $.ajax({
                url: "/student/addNewActivity",
                type: 'POST',
                dataType: 'json',
                contentType:'application/json;charset=utf-8',
                data:JSON.stringify({Start:copiedEventObject.start, End:copiedEventObject.end,
                    Title:copiedEventObject.title, backgroundColor:copiedEventObject.backgroundColor,
                    borderColor:copiedEventObject.borderColor,
                    AllDay:copiedEventObject.allDay,id:copiedEventObject.id}),
                success: function (data) {
                    // alert("hahahahah");
                    // callback(data);
                    // alert(data.id);
                    // alert(data.test);
                    alert("Success");
                    // copiedEventObject.id = data.id;
                    copiedEventObject.id = data.id;
                    // alert(copiedEventObject.id);
                },
                error: function (data) {
                    // alert(data)
                    alert("Success!");
                }
            });

            // render the event on the calendar
            // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
            $('#calendar').fullCalendar('renderEvent', copiedEventObject, true)

            // // is the "remove after drop" checkbox checked?
            // if ($('#drop-remove').is(':checked')) {
            //     // if so, remove the element from the "Draggable Events" list
            //     $(this).remove()
            // }

        }
    })

    /* ADDING EVENTS */
    var currColor = '#3c8dbc' //Red by default
    //Color chooser button
    var colorChooser = $('#color-chooser-btn')
    $('#color-chooser > li > a').on('click', function(e) {
        e.preventDefault()
        //Save color
        currColor = $(this).css('color')
        //Add color effect to button
        $('#add-new-event').css({
            'background-color': currColor,
            'border-color': currColor
        })
    })
    $('#add-new-event').on('click', function(e) {
        e.preventDefault()
        //Get value and make sure it is not null
        var val = $('#new-event').val()
        if (val.length == 0) {
            return
        }

        //Create events
        var event = $('<div />')
        event.css({
            'background-color': currColor,
            'border-color': currColor,
            'color': '#fff'
        }).addClass('external-event btn')
        event.html(val)
        $('#external-events').prepend(event)

        //Add draggable funtionality
        init_events(event)

        //Remove event from text input
        $('#new-event').val('')
    })
})


/*Basic View Calendar */

/* initialize the calendar
   -----------------------------------------------------------------*/
//Date for the calendar events (dummy data)
var date = new Date()
var d = date.getDate(),
    m = date.getMonth(),
    y = date.getFullYear()
$('#calendar1').fullCalendar({
    header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,agendaWeek,agendaDay'
    },
    buttonText: {
        today: 'today',
        month: 'month',
        week: 'week',
        day: 'day'
    },
    //Random default events
    events: [{
        title: 'All Day Event',
        start: new Date(y, m, 1),
        backgroundColor: '#f56954', //red
        borderColor: '#f56954' //red
    },
        {
            title: 'Long Event',
            start: new Date(y, m, d - 5),
            end: new Date(y, m, d - 2),
            backgroundColor: '#f39c12', //yellow
            borderColor: '#f39c12' //yellow
        },
        {
            title: 'Meeting',
            start: new Date(y, m, d, 10, 30),
            allDay: false,
            backgroundColor: '#0073b7', //Blue
            borderColor: '#0073b7' //Blue
        },
        {
            title: 'Lunch',
            start: new Date(y, m, d, 12, 0),
            end: new Date(y, m, d, 14, 0),
            allDay: false,
            backgroundColor: '#00c0ef', //Info (aqua)
            borderColor: '#00c0ef' //Info (aqua)
        },
        {
            title: 'Birthday Party',
            start: new Date(y, m, d + 1, 19, 0),
            end: new Date(y, m, d + 1, 22, 30),
            allDay: false,
            backgroundColor: '#00a65a', //Success (green)
            borderColor: '#00a65a' //Success (green)
        },
        {
            title: 'Click for Google',
            start: new Date(y, m, 28),
            end: new Date(y, m, 29),
            url: 'http://google.com/',
            backgroundColor: '#3c8dbc', //Primary (light-blue)
            borderColor: '#3c8dbc' //Primary (light-blue)
        }
    ],
    eventClick: function(calEvent, jsEvent, view) {
        $('#calendar').fullCalendar('removeEvents' , function(ev){
            return (ev._id == calEvent._id);})
    },
    editable: true,
    droppable: true, // this allows things to be dropped onto the calendar !!!
    drop: function(date, allDay) { // this function is called when something is dropped

        // retrieve the dropped element's stored Event Object
        var originalEventObject = $(this).data('eventObject')

        // we need to copy it, so that multiple events don't have a reference to the same object
        var copiedEventObject = $.extend({}, originalEventObject)

        // assign it the date that was reported
        copiedEventObject.start = date
        copiedEventObject.allDay = allDay
        copiedEventObject.backgroundColor = $(this).css('background-color')
        copiedEventObject.borderColor = $(this).css('border-color')

        // render the event on the calendar
        // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
        $('#calendar').fullCalendar('renderEvent', copiedEventObject, true)

        // is the "remove after drop" checkbox checked?
        if ($('#drop-remove').is(':checked')) {
            // if so, remove the element from the "Draggable Events" list
            $(this).remove()
        }

    }
})

/* ADDING EVENTS */
var currColor = '#3c8dbc' //Red by default
//Color chooser button
var colorChooser = $('#color-chooser-btn')
$('#color-chooser > li > a').on('click', function(e) {
    e.preventDefault()
    //Save color
    currColor = $(this).css('color')
    //Add color effect to button
    $('#add-new-event').css({
        'background-color': currColor,
        'border-color': currColor
    })
})
$('#add-new-event').on('click', function(e) {
    e.preventDefault()
    //Get value and make sure it is not null
    var val = $('#new-event').val()
    if (val.length == 0) {
        return
    }

    //Create events
    var event = $('<div />')
    event.css({
        'background-color': currColor,
        'border-color': currColor,
        'color': '#fff'
    }).addClass('external-event btn')
    event.html(val)
    $('#external-events').prepend(event)

    //Add draggable funtionality
    init_events(event)

    //Remove event from text input
    $('#new-event').val('')
})