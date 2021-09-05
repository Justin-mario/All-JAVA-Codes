package com.CHAPTER_EIGHT.trafficlight;

public class TrafficLightTest {
    public static void main(String[] args) {
        for(TrafficLight light: TrafficLight.values ()){
            System.out.printf ( "%s ", light.getDisplayTime ()  );
        }
    }
}
