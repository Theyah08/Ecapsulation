import java.util.Scanner;

public class Main {
    // Main method with input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for car setup
        System.out.println("\n --Welcome to Car Fuel System-- ");

        System.out.print("\nEnter fuel capacity (L): ");
        double capacity = scanner.nextDouble();

        System.out.print("Enter fuel efficiency (km/L): ");
        double efficiency = scanner.nextDouble();

        CarFuelSystem car = new CarFuelSystem(capacity, efficiency);
        System.out.println("\nCar created: Fuel Capacity = " + capacity + "L, Efficiency = " + efficiency + " km/L\n");
        
        boolean running = true;
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Refuel Car");
            System.out.println("2. Drive Car");
            System.out.println("3. Check fuel level");
            System.out.println("4. Estimate range");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            System.out.println("  ");  // for spacing

            switch (choice) {
                case 1:
                    System.out.print("Enter liters to refuel: ");
                    double liters = scanner.nextDouble();
                    car.refuel(liters);
                    System.out.println("You can drive up to " 
                                       + String.format("%.2f", car.estimateRange()) + " km"); 
                    break;

                case 2:
                    System.out.print("Enter distance to drive (km): ");
                    double distance = scanner.nextDouble();
                    car.drive(distance);
                    
                    break;

                case 3:
                    System.out.println("Current fuel: " 
                                       + String.format("%.2f", car.getCurrentFuel()) + "L");
                    break;

                case 4:
                    System.out.println("You can drive up to " 
                                       + String.format("%.2f", car.estimateRange()) + " km with your current fuel");
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
            System.out.println();
        }
        scanner.close();
    }
    
}
