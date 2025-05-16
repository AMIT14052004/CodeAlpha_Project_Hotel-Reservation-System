public class Room {
    private final int roomNumber;
    private final String type;
    private final double price;
    private boolean isBooked;

    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isBooked = false;
    }

    public int getRoomNumber() { return roomNumber; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public boolean isBooked() { return isBooked; }

    public void book() { isBooked = true; }
    public void unbook() { isBooked = false; }

    @Override
    public String toString() {
        return "Room " + roomNumber + " (" + type + ") - $" + price + " - " + (isBooked ? "Booked" : "Available");
    }
}
