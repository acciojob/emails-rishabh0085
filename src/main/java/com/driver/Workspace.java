package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail {
    private ArrayList<Meeting> calendar;

    public Workspace(String emailId) {
        super(emailId, Integer.MAX_VALUE); // Default inbox capacity is set to maximum integer value
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        calendar.add(meeting);
    }

    public int findMaxMeetings() {
        Collections.sort(calendar, Comparator.comparing(Meeting::getEndTime));

        int maxMeetings = 0;
        LocalTime lastEndTime = LocalTime.MIN;

        for (Meeting meeting : calendar) {
            if (meeting.getStartTime().compareTo(lastEndTime) >= 0) {
                maxMeetings++;
                lastEndTime = meeting.getEndTime();
            }
        }

        return maxMeetings;
    }
}
