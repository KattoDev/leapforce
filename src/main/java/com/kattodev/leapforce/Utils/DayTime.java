package com.kattodev.leapforce.Utils;

import java.time.LocalTime;

public class DayTime {
    private final int localHour = LocalTime.now().getHour();

    public String getDayGreeting(){
        String greeting;
        if (localHour >= 0 && localHour <= 12){
            greeting = "Buenos días";
        } else if (localHour >= 13 && localHour <= 18) {
            greeting = "Buenas tardes";
        }
        else {
            greeting = "Buenas noches";
        }
        return greeting;
    }
}
