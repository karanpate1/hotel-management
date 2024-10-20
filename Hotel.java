package com.company;

import java.util.ArrayList;

public class Hotel {

    private String Name; // Name Of The Hotel
    private String Area; // Area Of The Hotel
    private String City; // City Of The Hotel
    private float rating; // Rating Of The Hotel

    private int Deluxe; // Number Of Deluxe Room (By default : 8)
    private int Luxury; // Number Of Luxury Room (By default : 8)
    private ArrayList<String>fea; // Storing room detail
    private ArrayList<String>del1; // For detail in Deluxe room
    private ArrayList<String>lux1; // For detail in luxury room
    private ArrayList<Customer>book; // Booking List - Storing customer Information

    public Hotel(String Name, float rating, String area, String City){
        this.Name = Name;
        this.rating = rating;
        this.Area = area;
        this.City = City;

        this.Deluxe = 8;
        this.Luxury = 8;

        fea = new ArrayList<>();

        del1 = new ArrayList<>(); // Allocating The Memory
        lux1 = new ArrayList<>();
        book = new ArrayList<>();

        // Default Feature
        fea.add("Maximum Adults");
        fea.add("TV");
        fea.add("Personal Safe");
        fea.add("Air-conditioner");
        fea.add("Free-wifi");

        // Feature That Deluxe Room Has
        del1.add("3");
        del1.add("No");
        del1.add("No");
        del1.add("Yes");
        del1.add("Yes");

        //Feature That Luxury Room Has
        lux1.add("4");
        lux1.add("Yes");
        lux1.add("Yes");
        lux1.add("Yes");
        lux1.add("Yes");
    }

    public String getName() {
        return Name;
    }

    /**
     * Displaying All the Information
     */
    public void Display(){
        System.out.println("Name : " + this.Name);
        System.out.println("Rating : " + this.rating);
        System.out.println("City : " +this.City);
        System.out.println("Area : " + this.Area);

    }
    public void adddeluxe(int number){
        this.Deluxe +=number;
    }
    public void addluxury(int number){
        this.Luxury +=number;
    }
    public void remdel(int number){
        if(Deluxe > number)
            this.Deluxe -= number;
        else
        {
            this.Deluxe = 0;

        }
    }
    public void remluxury(int number){
        if(Luxury > number)
            this.Luxury -= number;
        else
            this.Luxury = 0;
    }

    /**
     * For Displaying Room Detail
     */
    public void displayroomdet(int num){

        if(num == 1){
            for (int i=0;i<fea.size();i++){
                System.out.println((i+1) + ") "+fea.get(i) + " : " + del1.get(i));
            }
            System.out.println("The Number of Vacant Deluxe Room is : " + getDeluxe());
        }
        else{
            for (int i=0;i<fea.size();i++){
                System.out.println( (i+1) + ") "+fea.get(i) + " : " + lux1.get(i));
            }
            System.out.println("The Number of Vacant Luxury Room is : " + getLuxury());
        }
        System.out.println();
    }

    /**
     * For adding new room-detail
     *  Feature
     *  ch
     */
    public void addFeature(String Feature, int ch){
        fea.add(Feature);
        if(ch == 1){
            del1.add("Yes");
            lux1.add("Yes");
        }else if(ch == 2){
            del1.add("Yes");
            lux1.add("No");
        }else{
            lux1.add("Yes");
            del1.add("No");
        }

    }

    /**
     * Updating Feature
     *  num
     *  change
     *  ch
     */
    public void updateFeature(int num,String change, int ch){
        if(ch == 1){
            del1.remove(num-1);
            del1.add(num-1, change);
        }else{
            lux1.remove(num-1);
            lux1.add(num-1, change);
        }

    }

    /**
     * For Booking Room
     *  num
     *  cusName
     *  phone
     */
    public void bookroom(int num, String cusName, String phone){

        if(num == 1){
            if(Deluxe > 0){
                Deluxe--;
                Customer c = new Customer(this.Name, this.rating, this.Area , this.City, cusName, 1, phone);
                book.add(c);
            }else
                System.out.println("The Deluxe Room is Full");
        }
        if(num == 2){
            if(Luxury > 0) {
                Luxury--;
                Customer c = new Customer(this.Name, this.rating, this.Area , this.City, cusName, 2, phone);
                book.add(c);
            }
            else
                System.out.println("The Luxury Room is Full");
        }
    }

    public int getDeluxe() {
        return Deluxe;
    }

    public int getLuxury() {
        return Luxury;
    }

    /**
     * for Displaying Booking Information
     */
    public void bookinginfo(){
        if(book.size() == 0){
            System.out.println("No booking Yet");
            return;
        }
        for(int i=0;i<book.size();i++){
            Customer b = book.get(i);
            System.out.println((i+1)+") Name : " + b.getCustName() );
            System.out.println("  Phone number : " + b.getPhoneno());
            if(b.getType() == 1)
                System.out.println("  Room : Deluxe");
            else
                System.out.println("  Room : Luxury");
            System.out.println("  Check-in Time : " + b.getIntime());
            System.out.println("  Check-out Time : "+ b.getOuttime());
        }
    }

}


