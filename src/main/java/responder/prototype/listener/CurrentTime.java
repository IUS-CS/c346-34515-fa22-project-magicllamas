package responder.prototype.listener;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CurrentTime extends ListenerAdapter {
    //CurrentTime will find the current time and date for the timezone you ask for, but it is limited
    public static String CurrentTime(String location){
        //Pulls date library to get proper date of Location
        Date date = new Date();
        //Formats the Date Formatter to the String in the parentheses of SimpleDateFormat
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Uses TimeZone Library to get time of variable location and sets it to variable df
        df.setTimeZone(TimeZone.getTimeZone(location));
        //Places the current time and date of variable location in variable currentTime
        String localTime = df.format(date);
        return localTime;
    }

    public static void main(String[] args) {
        //Try catch just encase the user trys to break the CurrentTime function
        try {
            //Only finds the time for Greenwich mean time for testing purposes at the moment
            String currentTime = CurrentTime("GMT");
            System.out.println(currentTime);
        }catch (Exception ex){
            System.out.println("Error find the current time");
        }
    }
}
