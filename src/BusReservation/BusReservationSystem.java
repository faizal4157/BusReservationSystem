package BusReservation;


import java.util.Scanner;

class Bus {
    private String[] seats;
    private int totalSeats;

    public Bus(int totalSeats) {
        this.totalSeats = totalSeats;
        seats = new String[totalSeats];
        for (int i = 0; i < totalSeats; i++) {
            seats[i] = "empty";
        }
    }

    public void displayAvailableSeats() {
        System.out.println("Available Seats:");
        for (int i = 0; i < totalSeats; i++) {
            if (seats[i].equals("empty")) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    public void bookSeat(int seatNumber, String passengerName) {
        seats[seatNumber - 1] = passengerName;
        System.out.println("Seat number " + seatNumber + " booked for " + passengerName);
    }

    public void cancelReservation(int seatNumber) {
        if (seats[seatNumber - 1].equals("empty")) {
            System.out.println("Seat number " + seatNumber + " is already empty.");
        } else {
            seats[seatNumber - 1] = "empty";
            System.out.println("Reservation for seat number " + seatNumber + " canceled successfully.");
        }
    }
}

public class BusReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total number of seats in the bus: ");
        int totalSeats = scanner.nextInt();
        Bus bus = new Bus(totalSeats);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Display Available Seats");
            System.out.println("2. Book a Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bus.displayAvailableSeats();
                    break;
                case 2:
                    System.out.print("Enter seat number to book: ");
                    int seatToBook = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter passenger name: ");
                    String passengerName = scanner.nextLine();
                    bus.bookSeat(seatToBook, passengerName);
                    break;
                case 3:
                    System.out.print("Enter seat number to cancel reservation: ");
                    int seatToCancel = scanner.nextInt();
                    bus.cancelReservation(seatToCancel);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
