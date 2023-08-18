import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarPark carPark = new CarPark();
        Controller controller = new Controller(carPark);

        int input;
        do {
            System.out.println("Please select an option (1-7):");
            System.out.println("1: Add a car slot");
            System.out.println("2: Delete a car slot");
            System.out.println("3: List all car slots");
            System.out.println("4: Park a car");
            System.out.println("5: Find a car by reg");
            System.out.println("6: Remove a car by reg");
            System.out.println("7: Find cars by make");
            System.out.println("8: Exit");

            input = scanner.nextInt();
            scanner.nextLine();
            String slotID;
            String registrationNumber,model,make;
            int year;

            switch (input) {
                case 1:
                    System.out.println("Please enter the slot ID (e.g., A001):");
                    slotID = scanner.nextLine();
                    controller.addACarSlot(slotID);
                    break;
                case 2:
                    System.out.println("Please enter a slot ID to delete:");
                    slotID = scanner.nextLine();
                    controller.deleteACarSlot(slotID);
                    break;
                case 3:
                    controller.listAllCarSlots();
                    break;
                case 4:
                    System.out.println("Please Enter the slot ID(e.g., A001) that you want to park at:");
                    slotID = scanner.nextLine();
                    System.out.println("Please Enter the car's registration number (such as D1234)");
                    registrationNumber = scanner.nextLine();
                    System.out.println("Please Enter the car's make (e.g., Toyota):");
                    make = scanner.nextLine();
                    System.out.println("Please enter the car's model (e.g., Corolla):");
                    model = scanner.nextLine();
                    System.out.println("Please enter the car's year (e.g., 2009)");
                    year = scanner.nextInt();
                    controller.parkCar(slotID,registrationNumber,model,make,year);
                    break;
                case 5:
                    System.out.println("Please enter the car's registration number (such as D1234):");
                    registrationNumber = scanner.nextLine();
                    controller.findACarByRegistration(registrationNumber);
                    break;
                case 6:
                    System.out.println("Please enter the car's registration number (such as D1234) to remove:");
                    registrationNumber = scanner.nextLine();
                    controller.removeCarByRegistration(registrationNumber);
                    break;
                case 7:
                    System.out.println("Please enter the car's make (e.g., Toyota):");
                    make = scanner.nextLine();
                    controller.findCarsByMake(make);
                    break;
                case 8:
                    System.out.println("Program end!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 & 7");
                    break;
            }
        } while(input > 0 && input <8);
    }
}