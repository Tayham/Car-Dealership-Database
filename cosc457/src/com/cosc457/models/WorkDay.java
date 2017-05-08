//package com.cosc457.models;
//
//import com.cosc457.util.DateUtil;
//
//import java.sql.Time;
//import java.time.DayOfWeek;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.HashMap;
//
///**
// * Created by donnie on 12/2/16.
// */
//public class WorkDay {
//    private int day;
//    private HashMap<Double,AvailabilityBundle> timeAvailabilityMap;
//    public WorkDay(int number){
//        timeAvailabilityMap = new HashMap<Double, AvailabilityBundle>();
//        day = number;
//        genMap();
//    }
//
//    private void genMap(){
//        for(double i = 7.00; i <= 19.45; i+=.25){
//            timeAvailabilityMap.put(i, new AvailabilityBundle());
//        }
//    }
//
//    public int getDay() {
//        return day;
//    }
//
//    public void fill(double time, Availability a){
//        AvailabilityBundle bundle = timeAvailabilityMap.get(time);
//        if(bundle != null){
//            if(bundle.needsManager() && a.retrieveEmployee().isManager()){
//                bundle.setManager(a);
//            }else if(bundle.needsStaff()){
//                bundle.setStaff(a);
//            }
//        }
//    }
//
//    public boolean needsFilled(double key){
//        return timeAvailabilityMap.get(key) == null || timeAvailabilityMap.get(key).needsFilled();
//    }
//
//    public static ArrayList<WorkDay> getWorkDays(){
//        ArrayList<WorkDay> days = new ArrayList<WorkDay>();
//        days.add(new WorkDay(DayOfWeek.MONDAY.getValue()));
//        days.add(new WorkDay(DayOfWeek.TUESDAY.getValue()));
//        days.add(new WorkDay(DayOfWeek.WEDNESDAY.getValue()));
//        days.add(new WorkDay(DayOfWeek.THURSDAY.getValue()));
//        days.add(new WorkDay(DayOfWeek.FRIDAY.getValue()));
//
//        return days;
//    }
//
//    public HashMap<Double, AvailabilityBundle> getAvailabilityMap(){
//        return timeAvailabilityMap;
//    }
//    public void printPretty(){
//        for(Double d : timeAvailabilityMap.keySet()){
//            System.out.println(d +" "+ timeAvailabilityMap.get(d));
//        }
//    }
//}
