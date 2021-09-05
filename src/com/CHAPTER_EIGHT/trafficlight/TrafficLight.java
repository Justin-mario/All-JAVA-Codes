package com.CHAPTER_EIGHT.trafficlight;

import java.time.LocalTime;

public enum TrafficLight {

    RED( LocalTime.now ()),
    YELLOW( LocalTime.now ().plusMinutes ( 1 )),
    GREEN( LocalTime.now ().plusMinutes ( 2 ));

    private final LocalTime displayTime;


    TrafficLight(LocalTime displayTime){
        this.displayTime = displayTime;

    }

    public LocalTime getDisplayTime() {
        return displayTime;
    }

}
