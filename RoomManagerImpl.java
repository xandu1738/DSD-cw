import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class RoomManagerImpl extends java.rmi.server.UnicastRemoteObject implements RoomManager {
    //Assigning values of previously declared variables from RoomManager Interface to v,w,x,y and z respectively
    private int v = singleRoom;
    private int w = doubleRoom;
    private int x = twinRoom;
    private int y = tripleRoom;
    private int z = quadRoom;
    ArrayList<String> hotelGuests = new ArrayList<>();

    public RoomManagerImpl() throws RemoteException {
        super();
    }

    //Defining the commands to be executed at runtime 
    @Override
    public String list(String serverAddress) throws RemoteException {
        String listValues = ""+
        (String.valueOf(v)+" rooms of type 0 are available for 55,000 UGX per night\n")+
        (String.valueOf(w)+" rooms of type 1 are available for 75,000 UGX per night\n")+
        (String.valueOf(x)+" rooms of type 2 are available for 80,000 UGX per night\n")+
        (String.valueOf(y)+" rooms of type 3 are available for 150,000 UGX per night\n")+
        (String.valueOf(z)+" rooms of type 4 are available for 230,000 UGX per night\n");
        return listValues;
    }


    @Override
    public String book(String serverAddress, String roomType, String guestName) throws RemoteException {
        switch (roomType){
            case "0":
                if (v != 0){
                    hotelGuests.add(guestName);
                    v--;
                    return "you have booked a room of type "+roomType+" now remaining "+ v+" rooms";
                    
                }else{
                    return "All Room are occupied of type "+roomType+". Try another type";
                    
                }
            case "1":
                if (w != 0){
                    hotelGuests.add(guestName);
                    w--;
                    return "you have booked a room of type "+roomType+" now remaining "+ w+" rooms";
                }else{
                   return "All Room are occupied of type "+roomType+". Try another type";
                }
            case "2":
                if (x != 0){
                    hotelGuests.add(guestName);
                    x--;
                    return "you have booked a room of type "+roomType+" now remaining "+ x+" rooms";
                }else{
                   return "All Room are occupied of type "+roomType+". Try another type";
                }
            case "3":
                if (y != 0){
                    hotelGuests.add(guestName);
                    y--;
                    return "you have booked a room of type "+roomType+" now remaining "+ y+" rooms";
                }else{
                   return "All Room are occupied of type "+roomType+". Try another type";
                }
            case "4":
                if (z != 0){
                    hotelGuests.add(guestName);
                    z--;
                    return "you have booked a room of type "+roomType+" now remaining "+ z+" rooms";
                }else{
                    return "All Room are occupied of type "+roomType+". Try another type";
                }
            default:
                System.out.println("Make valid selection from [0,1,2,3,4]");
        }
        return "invalid selection";
    }

    @Override
    public ArrayList<String> guests(String serverAddress) throws RemoteException {
        return hotelGuests;
    }

    @Override
    public String revenue(String serverAddress) throws RemoteException {
        int currentRevenue = (((singleRoom-v)*singleRoomCost)+((doubleRoom-w)*doubleRoomCost)+((twinRoom-x)*twinRoomCost)+((tripleRoom-y)*tripleRoomCost)+((quadRoom-z)*quadRoomCost));
        String jgf = ""
        +"Revenue from rooms of type 0 = "+((singleRoom-v)*singleRoomCost)+" UGX\n"
        +"Revenue from rooms of type 1 = "+((doubleRoom-w)*doubleRoomCost)+" UGX\n"
        +"Revenue from rooms of type 2 = "+((twinRoom-x)*twinRoomCost)+" UGX\n"
        +"Revenue from rooms of type 3 = "+((tripleRoom-y)*tripleRoomCost)+" UGX\n"
        +"Revenue from rooms of type 4 = "+((quadRoom-z)*quadRoomCost)+" UGX\n"
        +"_____________________________________________"
        +"\nTotal Revenue \t\t     = "+currentRevenue+" UGX\n"
        +"_____________________________________________\n";
        return jgf;
    }
}
