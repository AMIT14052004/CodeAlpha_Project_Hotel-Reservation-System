import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Hotel Reservation System ===");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter room type (Single/Double/Suite): ");
                    String type = scanner.next();
                    List<Room> availableRooms = hotel.searchAvailableRooms(type);
                    if (availableRooms.isEmpty()) {
                        System.out.println("No rooms available of type " + type);
                    } else {
                        for (Room room : availableRooms) {
                            System.out.println(room);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    scanner.nextLine(); // Consume newline
                    String name = scanner.nextLine();
                    System.out.print("Enter room number to book: ");
                    int roomNum = scanner.nextInt();
                    Reservation res = hotel.makeReservation(name, roomNum);
                    if (res != null) {
                        System.out.println("Reservation successful!");
                        System.out.println(res);
                        hotel.processPayment(res.getRoom().getPrice());
                    } else {
                        System.out.println("Room not available or does not exist.");
                    }
                    break;

                case 3:
                    List<Reservation> reservations = hotel.getReservations();
                    if (reservations.isEmpty()) {
                        System.out.println("No reservations found.");
                    } else {
                        for (Reservation r : reservations) {
                            System.out.println(r);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the system!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
