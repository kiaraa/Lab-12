import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CarApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		boolean keepGoing = true;
		LinkedList<Car> carList = new LinkedList<>();
		
		carList.add(new UsedCar("Pontiac", "G6", 2007, 2000, 125342));
		carList.add(new UsedCar("Toyota", "Camry", 2010, 3000, 200345));
		carList.add(new UsedCar("Honda", "Odyssey", 2004, 1000, 324945));
		carList.add(new Car("Honda", "Civic", 2019, 21000));
		carList.add(new Car("Tesla", "Model 3", 2019, 50000));
		carList.add(new Car("Subaru", "Outback", 2019, 25000));
		
		CarLot carLot = new CarLot(carList);

		while(keepGoing) {
			keepGoing = handleMainMenu(carLot, scan, keepGoing);
		}
		
				
	}
	private static boolean handleMainMenu(CarLot lot, Scanner scan, boolean keepGoing) {
		while (keepGoing){
			System.out.println("1. Show current lot");
			System.out.println("2. Buy a car");
			System.out.println("3. Sell a car");
			System.out.println("4. Lookup a car");
			System.out.println("5. Trade in a car");
			System.out.println("6. Quit");
			System.out.println();
			System.out.println("What would you like to do? ");
			int menuChoice = scan.nextInt();
			scan.nextLine();
			
			switch(menuChoice) {
			case 1: 	lot.showCars();
						return keepGoing;
						
			case 2:		handlePurchase(scan, lot);
						return keepGoing;
			
			case 3:		getNewCar(lot, scan);
						return keepGoing;
						
			case 4:		lookUpCar(lot, scan);
						return keepGoing;
						
			case 5:		tradeInCar(lot, scan);
						return keepGoing;
						
			case 6:		keepGoing = false;
						return keepGoing;
						
			default:	keepGoing = false;
						return keepGoing;
			}
		}
		return keepGoing;
		
	}

	private static void handlePurchase(Scanner scan, CarLot carLot) {

			carLot.showCars();

			System.out.println("Which car would you like? ");
			int carChoice = scan.nextInt();
			scan.nextLine();
			
			if (carChoice > carLot.getCarList().size()) {
				System.out.println("I didn't understand that. Returnin gto main menu.");
				return;
			}
			
			System.out.println(carLot.getCarList().get(carChoice - 1));
			System.out.println("Would you like to buy this car? ");
			if (scan.nextLine().equalsIgnoreCase("y")) {
				carLot.sellCar(carChoice - 1);
				System.out.println("Thank you for shopping with us!");
			}
			else {
				System.out.println("Sorry you didn't like that one.");
			}
		
		}
	
	public static void getNewCar(CarLot lot, Scanner scan) {
		System.out.println("Enter the make of your car: ");
		String make = scan.nextLine();
		System.out.println("Enter the model of your car: ");
		String model = scan.nextLine();
		System.out.println("Enter the year of your car: ");
		int year = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the value of your car: ");
		double price = scan.nextDouble();
		scan.nextLine();
		System.out.println("Enter the miles on your car: ");
		double miles = scan.nextDouble();
		scan.nextLine();
		Car newCar = new UsedCar(make, model, year, price, miles);
		lot.addCar(newCar);
	}
	
	public static void lookUpCar(CarLot lot, Scanner scan) {
		System.out.println("Which space in the lot did you want to look up? ");
		int index = scan.nextInt();
		scan.nextLine();
		try {
			System.out.println(lot.carLookup(index - 1));
		}
		catch(Exception e) {
			System.out.println("We don't have a car in that space.");
		}
	}
	
	public static void tradeInCar(CarLot lot, Scanner scan) {
		System.out.println("Which car would you like to buy?");
		int carToReplace = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter the make of your car: ");
		String make = scan.nextLine();
		System.out.println("Enter the model of your car: ");
		String model = scan.nextLine();
		System.out.println("Enter the year of your car: ");
		int year = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the value of your car: ");
		double price = scan.nextDouble();
		scan.nextLine();
		System.out.println("Enter the miles on your car: ");
		double miles = scan.nextDouble();
		scan.nextLine();
		Car newCar = new UsedCar(make, model, year, price, miles);
		
		try {
			lot.replaceCar(carToReplace - 1, newCar);
			//Car oldCar = lot.carLookup(carToReplace - 1);
			//oldCar = newCar;
		}
		catch(Exception e) {
			System.out.println("We can't trade you a car that doesn't exist!");
		}
	}
}	

