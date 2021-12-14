import java.rmi.Naming;
import java.util.ArrayList;

public class HotelClient {
    public static void main(String[] args){
        if(args.length<1){
            System.out.println("Enter from the command list below;"+
                "\nlist rmi://localhost:1099/HotelService --> to view available rooms"+
                "\nbook rmi://localhost:1099/HotelService roomType guestName--> to book a room if available (roomType={0,1,2,3,4})"+
                "\nguests rmi://localhost:1099/HotelService --> to view guests"+
                "\nrevenue rmi://localhost:1099/HotelService --> to view revenue from rooms");
        }else{
            try{
            RoomManager rm = (RoomManager) Naming.lookup(args[1]);
            if (args[0].equals("list")) {
                System.out.println(rm.list(args[1]));
            }else if(args[0].equals("book")){
                System.out.println(rm.book(args[1],args[2],args[3]));
            }else if(args[0].equals("revenue")){
                System.out.println(rm.revenue(args[1]));
            }else if(args[0].equals("guests")){
                System.out.println("Registered Guests list");
                System.out.println(("\tNumber")+"\t:\t"+"Name");
                ArrayList<String> hotelGuests = rm.guests(args[1]);
                for (int i = 0; i <hotelGuests.size() ; i++) {
                    System.out.println("\t"+(i+1)+"\t\t"+hotelGuests.get(i));
                }
            }else{
                System.out.println("Invalid input command or syntax");
            }
        }catch (Exception e){
            System.out.println("Exception: \n"+e);
        }
        }
    }
}
