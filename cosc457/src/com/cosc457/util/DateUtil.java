package com.cosc457.util;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by donnie on 11/30/16.
 */
public class DateUtil {

    public static ArrayList<String> getWeekdays(){
        ArrayList<String> days = new ArrayList<String>();
        days.add("Sunday");
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        return days;
    }

    public static ArrayList<String> getTimes(){
        return createTimeTable();
    }


    private static ArrayList<String> createTimeTable(){
        int[] hours = {12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        String[] mins = {"00", "15", "30", "45"}; //because 00
        String[] zz = {"am", "pm"};
        ArrayList<String> times = new ArrayList<String>();
        for(int k = 0; k < zz.length; k++){
            for(int i = 0; i < hours.length; i++){
                for(int j = 0; j < mins.length; j++){
                    times.add(hours[i] + ":"+ mins[j] + " " + zz[k]);
                }
            }
        }
        return times;
    }

    public static Time getTimeFromString(String t){
        DateFormat format = new SimpleDateFormat("hh:mm aa");
        try {
            return new Time(format.parse(t).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Time getTimeFromDouble(double t){
        int hour = (int)Math.floor(t);
        double minute = (t % 1) * 60;

        StringBuilder b = new StringBuilder();
        b.append(hour);
        b.append(":");
        b.append(minute);

        DateFormat format = new SimpleDateFormat("HH:mm");
        try {
            return new Time(format.parse(b.toString()).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<java.sql.Date> getFutureDates(){
        ArrayList<java.sql.Date> dates = new ArrayList<java.sql.Date>();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date d = new Date();
        d.setHours(0);
        d.setMinutes(0);
        d.setSeconds(0);
        dates.add(new java.sql.Date(c.getTime().getTime()));
        c.setTime(d);
        while(dates.size() < 38){
          c.add(Calendar.DATE, 1);
            dates.add(new java.sql.Date(c.getTime().getTime()));
        }
        return dates;

    }


    public static String getPrettyTime(Time t){
        DateFormat format = new SimpleDateFormat("hh:mm aa");
        try{
            return new String(format.format(t));
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static double get100OffsetTime(Time t){
        return (t.getHours() + (t.getMinutes()/60));
    }

    public static String getWeekDay(int number){
        switch(number){
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
        }
        return "";
    }





}
