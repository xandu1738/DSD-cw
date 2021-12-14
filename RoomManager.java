import java.rmi.*;
import java.util.ArrayList;

public interface RoomManager extends Remote {
    //initializing variables to represent number of rooms available by type
    int singleRoom = 10;
    int doubleRoom = 20;
    int twinRoom = 5;
    int tripleRoom = 3;
    int quadRoom = 2;
    
    //Initializing variables to represent the prices of rooms per type
    int singleRoomCost = 55000;
    int doubleRoomCost = 75000;
    int twinRoomCost = 80000;
    int tripleRoomCost = 150000;
    int quadRoomCost = 230000;

    //Defining methods list, book, guests and revenue which will be passed at runtime
    String list(String serverAddress) throws RemoteException;
    String book(String serverAddress,String roomType,String guestName) throws RemoteException;
    ArrayList<String> guests(String serverAddress) throws RemoteException;
    String revenue(String serverAddress) throws RemoteException;
}
