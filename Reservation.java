public class Reservation {
    private final  String customerName;
    private final Room room;

    public Reservation(String customerName, Room room) {
        this.customerName = customerName;
        this.room = room;
        room.book(); // Mark the room as booked
    }

    public String getCustomerName() { return customerName; }
    public Room getRoom() { return room; }

    @Override
    public String toString() {
        return "Reservation for " + customerName + ": " + room.toString();
    }
}
