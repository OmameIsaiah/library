package com.library.app.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SchedulerTest {
    public static boolean schedulable(HashMap<String, ArrayList<String>> requests) {

        boolean status = false;

        String[] names = requests.keySet().toArray(new String[0]);
        int totalMaxWorkingHoursForAllEmployees = 16*7;
        int totalHoursForAllEmployees= 0;
        int [] employeeValidHours= new int[names.length];
        for(int i= 0; i< names.length; i++){
            Employee employee= new Employee(names[i], requests.get(names[i]));
            totalHoursForAllEmployees+=employee.getTotalHours();
            if(employee.getTotalHours()>40){
                employeeValidHours[i]= 40;
            }else{
                employeeValidHours[i]= employee.getTotalHours();
            }
            System.out.println("Name: "+employee.getName()+",\tLeave Days: "+employee.getLeaveDays()+ ",\tWork Days: "+ employee.getAvailableWorkDays()+ ",\tTotal Hours: "+employee.getTotalHours());
        }

        System.out.println("**********************************************************************");
        System.out.println("**********************************************************************");
        System.out.println("**********************************************************************");
        System.out.println("**********************************************************************");
        System.out.println("**********************************************************************");

        if(names.length<3){
            //Two employees cannot be scheduled for one week shift.
            System.out.println("Two employees cannot be scheduled for one week shift.");
            status = false;
        }else if(totalHoursForAllEmployees<totalMaxWorkingHoursForAllEmployees){
            //If the available working hours for all employees is less than the total working hours of the week, one of the employees must work beyond 40 hours.
            System.out.println("Total Max Working Hours for All Employees: "+totalMaxWorkingHoursForAllEmployees);
            System.out.println("Total Hours for All Employees: "+totalHoursForAllEmployees);
            int sumOfHours= 0;
            for(int i=0; i<employeeValidHours.length;i++){
                sumOfHours+=employeeValidHours[i];
            }
            System.out.println("Total Valid/Allowed Hours for All Employees: "+sumOfHours);
            status = false;
        }else if(!checkDayWorkloadToOneEmployeeOrNone(requests)){
            status = false;
        }
        else {
            int sumOfHours= 0;

            for(int i=0; i<employeeValidHours.length;i++){
                sumOfHours+=employeeValidHours[i];
            }

            if ((names.length >= 3) && (sumOfHours>=totalMaxWorkingHoursForAllEmployees)) {
                System.out.println("Total Max Working Hours for All Employees: "+totalMaxWorkingHoursForAllEmployees);
                System.out.println("Total Hours for All Employees: "+totalHoursForAllEmployees);
                System.out.println("Total Valid/Allowed Hours for All Employees: "+sumOfHours);
                status = true;
            } else {
                System.out.println("Total Max Working Hours for All Employees: "+totalMaxWorkingHoursForAllEmployees);
                System.out.println("Total Hours for All Employees: "+totalHoursForAllEmployees);
                System.out.println("Total Valid/Allowed Hours for All Employees: "+sumOfHours);
                status = false;
            }
        }
        return status;
    }
    public static boolean checkDayWorkloadToOneEmployeeOrNone(HashMap<String, ArrayList<String>> requests){
        int monCounter=0;
        int tueCounter=0;
        int wedCounter=0;
        int thuCounter=0;
        int friCounter=0;
        int satCounter=0;
        int sunCounter=0;
        HashMap<String, String> monChefs = new HashMap<>();
        HashMap<String, String> tueChefs = new HashMap<>();
        HashMap<String, String> wedChefs = new HashMap<>();
        HashMap<String, String> thuChefs = new HashMap<>();
        HashMap<String, String> friChefs = new HashMap<>();
        HashMap<String, String> satChefs = new HashMap<>();
        HashMap<String, String> sunChefs = new HashMap<>();
        String[] names = requests.keySet().toArray(new String[0]);
        for(int i= 0; i< names.length; i++){
            Employee employee= new Employee(names[i], requests.get(names[i]));
            employee.getAvailableWorkDays();
            if(employee.isMon()){
                ++monCounter;
                monChefs.put("mon",employee.getName());
            }
            if(employee.isTue()){
                ++tueCounter;
                tueChefs.put("tue",employee.getName());
            }
            if(employee.isWed()){
                ++wedCounter;
                wedChefs.put("wed",employee.getName());
            }
            if(employee.isThu()){
                ++thuCounter;
                thuChefs.put("thu",employee.getName());
            }
            if(employee.isFri()){
                ++friCounter;
                friChefs.put("fri",employee.getName());
            }
            if(employee.isSat()){
                ++satCounter;
                satChefs.put("sat",employee.getName());
            }
            if(employee.isSun()){
                ++sunCounter;
                sunChefs.put("sun",employee.getName());
            }
        }
        System.out.println("Number of Employees Available for Mondays: "+ monCounter+ ",\t"+monChefs.toString());
        System.out.println("Number of Employees Available for Tuesdays: "+ tueCounter+ ",\t"+tueChefs.toString());
        System.out.println("Number of Employees Available for Wednesdays: "+ wedCounter+ ",\t"+wedChefs.toString());
        System.out.println("Number of Employees Available for Thursdays: "+ thuCounter+ ",\t"+thuChefs.toString());
        System.out.println("Number of Employees Available for Fridays: "+ friCounter+ ",\t"+friChefs.toString());
        System.out.println("Number of Employees Available for Saturdays: "+ satCounter+ ",\t"+satChefs.toString());
        System.out.println("Number of Employees Available for Sundays: "+ sunCounter+ ",\t"+sunChefs.toString());

        if(monCounter>=2 && tueCounter>=2 && wedCounter>=2 && thuCounter>=2 && friCounter>=2 && satCounter>=2 && sunCounter>=2){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        HashMap<String, ArrayList<String>> requests = new HashMap<>();

        requests.put(
                "ada", new ArrayList<>(Arrays.asList(
                        new String[] {"mon", "tue", "wed", "fri", "sat", "sun"}
                ))
        );
        requests.put(
                "emma", new ArrayList<>(Arrays.asList(
                        new String[] {"tue", "wed", "thu", "sun"}
                ))
        );
        requests.put(
                "remy", new ArrayList<>(Arrays.asList(
                        new String[] {"mon", "sat"}
                ))
        );
        requests.put(
                "zach", new ArrayList<>(Arrays.asList(new String[] {}))
        );

        /////////////////////////////////////////////////////////////////

        /*
        requests.put(
                "ada", new ArrayList<>(Arrays.asList(
                        new String[] {"mon", "tue", "wed", "thu", "fri", "sat"}
                ))
        );
        requests.put(
                "emma", new ArrayList<>(Arrays.asList(
                        new String[] {"tue", "wed", "thu", "sun"}
                ))
        );
        requests.put(
                "remy", new ArrayList<>(Arrays.asList(
                        new String[] {"mon", "fri", "sun"}
                ))
        );
        requests.put(
                "zach", new ArrayList<>(Arrays.asList(new String[] {}))
        );


        requests.put(
                "emma", new ArrayList<>(Arrays.asList(
                        new String[] {"sun"}
                ))
        );
        requests.put(
                "remy", new ArrayList<>(Arrays.asList(
                        new String[] {"sun"}
                ))
        );
        requests.put(
                "zach", new ArrayList<>(Arrays.asList(new String[] {}))
        );
         */

        System.out.println("Status of Employees Schedule:"+schedulable(requests));

    }
}
