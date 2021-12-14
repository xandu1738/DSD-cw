import java.rmi.Naming;

public class HotelServer {
    String serverAddress = "rmi://localhost/HotelService";
    public HotelServer(){
        try {
            RoomManager roomManager = new RoomManagerImpl();
            Naming.rebind(serverAddress,roomManager);
        }catch (Exception e){
            System.out.println("Server Exception:");
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        new HotelServer();
    }
}
