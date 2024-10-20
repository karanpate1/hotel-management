package com.company;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Customer extends Hotel{

    private String custName;
    private String phoneno;
    private int type;
    private String intime;
    private String outtime;

    /**
     * Constructor
     *  Name
     *  rating
     *  area
     *  City
     *  custName
     *  type
     *  phoneno
     */
    public Customer(String Name, float rating, String area, String City, String custName, int type, String phoneno){
        super(Name, rating, area, City);
        this.custName = custName;
        this.type = type;
        this.phoneno = phoneno;
        Date time = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy"); //Formatting Date :  In which manner You Have to Print
        intime =  sdf.format(time);// converting time to above The Format

        Calendar c = Calendar.getInstance(); // creating Calender
        c.setTime(time); // set Time of Calender
        c.add(Calendar.DATE, 1); // Number Days To add
        time = c.getTime(); // getting Time
        outtime = sdf.format(time); // Converting time to above Format
    }

    public String getCustName() {
        return custName;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public String getIntime() {
        return intime;
    }

    public String getOuttime() {
        return outtime;
    }

    public int getType() {
        return type;
    }
}

