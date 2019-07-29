import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CarApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		boolean keepGoing = true;
		LinkedList<Car> carList = new LinkedList<>();
		
		carList.add(new UsedCar("Pontiac", "G6", 2007, 2000, 125342));
		carList.add(new UsedCar("Ford", "Fusion", 2010, 3000, 200345));
		carList.add(new UsedCar("Honda", "Odyssey", 2004, 1000, 324945));
		carList.add(new Car("Honda", "Civic", 2019, 21000));
		carList.add(new Car("Tesla", "Model 3", 2019, 50000));
		carList.add(new Car("Subaru", "Outback", 2019, 25000));
		
		CarLot carLot = new CarLot(carList);

		keepGoing = handlePurchase(scan, keepGoing, carLot);
				
	}

	private static boolean handlePurchase(Scanner scan, boolean keepGoing, CarLot carLot) {
		while (keepGoing){
			carLot.showCars();

			System.out.println("Which car would you like? ");
			int carChoice = scan.nextInt();
			scan.nextLine();
			
			if (carChoice > carLot.getCarList().size()) {
				keepGoing = false;
				break;
			}
			
			System.out.println(carLot.getCarList().get(carChoice - 1));
			System.out.println("Would you like to buy this car? ");
			if (scan.nextLine().equalsIgnoreCase("y")) {
				carLot.sellCar(carChoice - 1);
				System.out.println("Thank you for shopping with us!");
			}
			else {
				continue;
			}
		
		}
		return keepGoing;
	}	

}
