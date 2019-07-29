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
	}
	
	public void sellCar(int i) {
		carList.remove(i);
	}
	
}

