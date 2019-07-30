import java.util.ArrayList;
import java.util.List;

public class CarLot {

	List<Car> carList;
	
	public CarLot(List<Car> carList) {
		this.carList = carList;
	}
	
	
	public List<Car> getCarList() {
		return carList;
	}


	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}


	public void showCars() {
		int i = 1;
		for (Car car : carList) {
			System.out.println(i + ". " + car);
			i++;
		}
		System.out.println(i + ". Quit");
		System.out.println();
	}
	
	public void sellCar(int i) {
		carList.remove(i);
	}
	
	public void addCar(Car newCar) {
		carList.add(newCar);
	}
	
	public Car carLookup(int i) {
		return carList.get(i);
	}
	
	public void replaceCar(int i, Car newCar) {
		carList.remove(i);
		carList.add(i, newCar);
	}
	
}

