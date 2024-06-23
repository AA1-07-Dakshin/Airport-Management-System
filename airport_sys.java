import java.util.ArrayList;
import java.util.Scanner;

class Flight {
    private String flightNumber;
    private String destination;
    private String departureTime;

    public Flight(String flightNumber, String destination, String departureTime) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    @Override
    public String toString() {
        return "Flight Number: " + flightNumber + ", Destination: " + destination + ", Departure Time: " + departureTime;
    }
}

class AirportManagement {
    private ArrayList<Flight> flights;

    public AirportManagement() {
        flights = new ArrayList<>();
    }

    public void addFlight(String flightNumber, String destination, String departureTime) {
        Flight flight = new Flight(flightNumber, destination, departureTime);
        flights.add(flight);
        System.out.println("Flight added successfully.");
    }

    public void removeFlight(String flightNumber) {
        Flight flightToRemove = null;
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                flightToRemove = flight;
                break;
            }
        }
        if (flightToRemove != null) {
            flights.remove(flightToRemove);
            System.out.println("Flight removed successfully.");
        } else {
            System.out.println("Flight not found.");
        }
    }

    public void displayFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            for (Flight flight : flights) {
                System.out.println(flight);
            }
        }
    }
}

public class AirportManagementSystem {
    public static void main(String[] args) {
        AirportManagement airportManagement = new AirportManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Airport Management System");
            System.out.println("1. Add Flight");
            System.out.println("2. Remove Flight");
            System.out.println("3. Display Flights");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Flight Number: ");
                    String flightNumber = scanner.nextLine();
                    System.out.print("Enter Destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Enter Departure Time: ");
                    String departureTime = scanner.nextLine();
                    airportManagement.addFlight(flightNumber, destination, departureTime);
                    break;
                case 2:
                    System.out.print("Enter Flight Number to Remove: ");
                    flightNumber = scanner.nextLine();
                    airportManagement.removeFlight(flightNumber);
                    break;
                case 3:
                    airportManagement.displayFlights();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
