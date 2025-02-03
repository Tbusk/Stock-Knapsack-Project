package edu.ferris.seng355;

import java.time.Duration;
import java.time.LocalTime;


public class Timer {

    private LocalTime startTime, endTime;

    public void start() {
        startTime = LocalTime.now();
    }

    public void end() {
        endTime = LocalTime.now();
    }

    public long getDurationInMS() {
        return Duration.between(startTime, endTime).toMillis();
    }
}
