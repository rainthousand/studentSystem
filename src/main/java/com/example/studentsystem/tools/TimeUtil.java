package com.example.studentsystem.tools;

import com.example.studentsystem.entity.EditableEvent;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeUtil {
    public EditableEvent OriginalEvent() throws ParseException {
        EditableEvent newevent = new EditableEvent();
        String dateStart = "1900/01/01 00:00:00";
        String dateEnd = "1900/01/01 00:00:01";
        newevent.setId("NoEvent");
        newevent.setTitle("NoEvent");
        newevent.setStart(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(dateStart));
        newevent.setEnd(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(dateEnd));
        newevent.setAllDay(false);
        newevent.setDurationEditable(false);
        newevent.setStartEditable(false);
        newevent.setBorderColor("#000000");
        newevent.setBackgroundColor("#000000");
        return newevent;
    }
}
