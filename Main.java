package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class IllegalValueException extends Exception
{
}

class NegativeNumberRoomException extends Exception{

}
public class Main {

    public static void main(String[] args) {
        ArrayList<Hotel> hotel = new ArrayList<>();     // storing all Hotel/s Detail
        Scanner sc = new Scanner(System.in);
        while (true){

            System.out.println("Press 1 For Add Hotel Details");
            System.out.println("Press 2 For Delete Hotel Details");
            System.out.println("Press 3 For Display Hotel Details");
            System.out.println("Press 4 For Selecting Hotel");
            System.out.println("Press 5 For Exit");

            int choice;
            try {
                choice = sc.nextInt();
                if(choice > 5)
                    throw new IllegalValueException();
            }
            catch (IllegalValueException e){
                System.out.println(" Invalid Choice");
                continue;
            }


            System.out.println();

            switch (choice){
                case 1:{
                    boolean done; // Name checking
                    String Name;
                    System.out.println("Enter The Name of The Hotel");

                    boolean notfirst= false;
                    do{
                        done = false;

                        if(notfirst) {
                            System.out.println("Hotel is already Exists Enter The Name Again");
                        }
                        notfirst = true;
                        Name = sc.next();

                        for(int i=0;i<hotel.size();i++){

                            Hotel h = hotel.get(i);
                            if(Name.equals(h.getName())){ // checking for same hotel name
                                done = true;
                                break;
                            }
                        }

                    }while (done);

                    System.out.println("Enter The Rating For Hotel(Out of 5)");
                    float rating = Float.parseFloat(sc.next());

                    System.out.println("Enter The Name of the City where The Hotel is");
                    String city = sc.next();

                    System.out.println("Enter The Area Of The Hotel");
                    String area = sc.next();


                    Hotel h = new Hotel(Name, rating , city ,  area);
                    hotel.add(h);

                    break;
                }

                case 2:{
                    System.out.println("Enter The Name of The Hotel to Delete");
                    String Name = sc.next();

                    boolean delete = false;
                    for(int i=0;i<hotel.size();i++){
                        Hotel h = hotel.get(i);

                        if(Name.equals(h.getName())){
                            hotel.remove(i);
                            delete = true; //if hotel is available and delete
                            break;
                        }
                    }

                    if(delete){
                        System.out.println("Hotel Details is Successfully Removed");
                    }else
                        System.out.println("The Hotel is not found");
                    break;
                }

                case 3:{       // printing Hotel Detail

                    if(hotel.size() == 0){
                        System.out.println("No Hotel in the List");
                    }
                    for (int i=0;i<hotel.size();i++){
                        Hotel h = hotel.get(i);
                        h.Display();
                        System.out.println();
                    }
                    break;
                }

                case 4:{         // Access Hotel
                    System.out.println("Enter The Name Of The Hotel");
                    String name = sc.next();

                    Hotel sel = null; // for storing hotel reference which NAME is name.
                    boolean select = false; // if hotel is found in list with NAME is : name then select = true;
                    for(int i=0;i<hotel.size();i++){
                        Hotel h = hotel.get(i);


                        if(name.equals(h.getName())){
                            sel = h;
                            select = true;
                            break;
                        }
                    }

                    if(select){
                        boolean till = true; // for exit form this case
                        while(till){

                            System.out.println("Press 1 For Add/Update/Display Room details");
                            System.out.println("Press 2 For Book a room");
                            System.out.println("Press 3 For Display Booking Information");
                            System.out.println("Press 4 For Display Number Of vacant Room");
                            System.out.println("Press 5 For back");

                            int ch = sc.nextInt();
                            System.out.println();

                            switch (ch){
                                case 1:{
                                    System.out.println("Press 1 For Adding New Room/Rooms");
                                    System.out.println("Press 2 For Remove a Room");
                                    System.out.println("Press 3 For Add Room Detail");
                                    System.out.println("press 4 Update Room Detail");
                                    System.out.println("Press 5 For Print Room detail");
                                    int cha = sc.nextInt();
                                    System.out.println();

                                    boolean right = true;
                                    int ch1 = 1; // for selecting Deluxe or Luxury
                                    if(cha != 3){

                                        while(right){ // for checking value of ch1 is 1 and 2 only

                                            System.out.println("Press 1 For Deluxe Room");
                                            System.out.println("Press 2 For Luxury Room");
                                            ch1 = sc.nextInt();

                                            if(ch1 ==2 || ch1 == 1){
                                                right = false;
                                            }
                                        }
                                    }

                                    switch (cha){
                                        case 1:{              // adding Rooms
                                            System.out.println("Enter The Number of Room to Add");
                                            int num = 0;
                                            try{
                                                num = Integer.parseInt(sc.next());
                                                if(num < 0)
                                                    throw new NegativeNumberRoomException();
                                            }catch (NegativeNumberRoomException e){
                                                System.out.println("Negative Numbers of Rooms is not Possible");
                                                break;
                                            }

                                            if(ch1 == 1){
                                                sel.adddeluxe(num); // adding Deluxe Room
                                            }
                                            else
                                                sel.addluxury(num); // adding luxury Room
                                            break;
                                        }
                                        case 2:{     // Remove Room
                                            System.out.println("Enter The Number of Room to Remove");

                                            int num = 0;
                                            try{
                                                num = Integer.parseInt(sc.next());
                                                if(num < 0)
                                                    throw new NegativeNumberRoomException();
                                            }catch (NegativeNumberRoomException e){
                                                System.out.println("Negative Numbers of Rooms is not Possible");
                                                break;
                                            }

                                            if(ch1 == 1){
                                                sel.remdel(num); // remove Deluxe Room
                                            }
                                            else
                                                sel.remluxury(num); // remove luxury Room
                                            break;
                                        }
                                        case 3:{     //For  Adding New Feature
                                            System.out.println("Enter The Feature Name : ");
                                            String fea = sc.next();

                                            System.out.println("Press 1 if Both type of Room has this Feature");
                                            System.out.println("Press 2 if only Deluxe Room has this Feature");
                                            System.out.println("Press 3 if only Luxury Room has this Feature");

                                            int chc = sc.nextInt();
                                            if(chc < 0 || chc > 3)
                                                System.out.println("You Entered Invalid Choice");
                                            else{
                                                sel.addFeature(fea, chc);
                                            }
                                            break;
                                        }
                                        case 4:{     // Display Room Detail
                                            sel.displayroomdet(ch1);
                                            System.out.println("Enter The Number Of Detail To Update : ");
                                            int fea = Integer.parseInt(sc.next());
                                            System.out.println("Enter The Change : ");
                                            String change = sc.next();
                                            sel.updateFeature(fea, change, ch1);
                                            break;
                                        }
                                        case 5:{
                                            sel.displayroomdet(ch1);
                                            break;
                                        }

                                        default:{
                                            System.out.println("Invalid Choice");
                                        }
                                    }
                                    break;
                                }
                                case 2 : { // Book The Room
                                    System.out.println("The Number of Vacant Deluxe Room is : " + sel.getDeluxe());
                                    System.out.println("The Number of Vacant Luxury Room is : " + sel.getLuxury());
                                    System.out.println("Press 1 For Booking a Deluxe Room");
                                    System.out.println("Press 2 For Booking a Luxury Room");

                                    int chc = sc.nextInt();
                                    System.out.println("Enter The Your Name");
                                    String cusname = sc.next();
                                    System.out.println("Enter Your Phone-number");
                                    boolean rig = true;
                                    String phone = "";
                                    while(rig){
                                        try{
                                            phone = sc.next();
                                            if(phone.length() != 10){
                                                throw new IllegalValueException();
                                            }
                                            else
                                                rig = false;
                                        }catch (IllegalValueException e){
                                            System.out.println("Phone number Must have 10 digit");
                                        }
                                    }
                                    sel.bookroom(chc, cusname, phone);
                                    break;
                                }
                                case 3:{    // Displaying Booking Info
                                    sel.bookinginfo();
                                    break;
                                }
                                case 4:{
                                    System.out.println("Deluxe Room : "+sel.getDeluxe());
                                    System.out.println("Luxury Room : "+sel.getLuxury());
                                    break;
                                }
                                case 5:{
                                    till = false;
                                    break;
                                }
                                default:{
                                    System.out.println("You Entered Invalid Choice");
                                }
                            }

                        }
                    }else{
                        System.out.println("The Hotel is not found");
                    }

                    break;
                }

                case 5:{
                    System.exit(1);
                    break;
                }

            }


        }
    }
}

