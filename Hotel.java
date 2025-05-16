import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final List<Room> rooms = new ArrayList<>();
    private final  List<Reservation> reservations = new ArrayList<>();

    public Hotel() {
        // Initialize rooms
        rooms.add(new Room(101, "Single", 100));
        rooms.add(new Room(102, "Double", 150));
        rooms.add(new Room(103, "Suite", 250));
        rooms.add(new Room(104, "Single", 100));
        rooms.add(new Room(105, "Double", 150));
    }

    public List<Room> searchAvailableRooms(String type) {
        List<Room> available = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.isBooked() && room.getType().equalsIgnoreCase(type)) {
                available.add(room);
            }
        }
        return available;
    }

    public Reservation makeReservation(String customerName, int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && !room.isBooked()) {
                Reservation res = new Reservation(customerName, room);
                reservations.add(res);
                return res;
            }
        }
        return null;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + "...");
        System.out.println("Payment successful.");
    }
}
