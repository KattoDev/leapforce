package com.kattodev.leapforce.Utils;

import java.time.LocalTime;

public class DayTime {
    /**
     * Gets the local hour to make a greeting depending on the day time
     *
     * @return "Buenos dias" if its between 6:00 -- 12:00 <br>
     * "Buenas tardes" if its between 13:00 -- 18:00 <br>
     * "Buenas noches" if its between 19:00 -- 5:00
     */
    public String getDayGreeting() {
        int localHour = LocalTime.now().getHour();
        String greeting;
        if (localHour >= 6 && localHour <= 12) {
            greeting = "Buenos días";
        } else if (localHour >= 13 && localHour <= 18) {
            greeting = "Buenas tardes";
        } else {
            greeting = "Buenas noches";
        }
        return greeting;
    }
}
