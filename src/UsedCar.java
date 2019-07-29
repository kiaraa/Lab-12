
public class UsedCar extends Car {

	double miles = 0.00;
	
	public UsedCar() {
	}

	public UsedCar(String make, String model, int year, double price) {
		super(make, model, year, price);
	}
	
	public UsedCar(String make, String model, int year, double price, double miles) {
		super(make, model, year, price);
		this.miles = miles;
	}

	@Override
	public String toString() {
		return super.toString() + " (used) " + miles + " miles";
	}

}
