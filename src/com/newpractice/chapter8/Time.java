package com.newpractice.chapter8;

public class Time {
    int hour;
    int minutes;
    int seconds;

        public void setTime(int hour, int minutes, int seconds){
            validateTime ( hour, minutes, seconds );
            this.hour = hour;
            this.minutes = minutes;
            this.seconds = seconds;


        }
        public void validateTime(int hour, int minutes, int seconds){
            if(hour < 0 || hour >= 24 || minutes < 0 || minutes >= 60 || seconds < 0 || seconds >= 60){
                throw new IllegalArgumentException ("Hour or Minutes or Seconds is out of range ");
            }
        }

        public String toUniversalTime(){
            return String.format ( "%02d: %02d: %02d", hour, minutes, seconds);
        }

        @Override
        public String toString(){
            return String.format ( "%d : %02d : %02d %s",((hour == 0 || hour ==12)? 12 : hour % 12),
                    minutes, seconds,(hour < 12)? "AM" : "PM"   );
        }

    public static void main(String[] args) {
        Time time = new Time ();
        try {
            time.setTime ( 1, 34, 59 );
        }catch (IllegalArgumentException ex){
//            ex.printStackTrace ();
        }
        String newTime = time.toString ();
        System.out.printf ( "%s", newTime );
        }
}
