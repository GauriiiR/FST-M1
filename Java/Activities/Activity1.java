package Activities;

public class Activity1 {
	
	public static void main(String[] args) {
		Car toyota = new Car();
		toyota.make = 2014;
		toyota.transmission = "Manual";
		toyota.color = "Black";
		
		toyota.displayCharacteristics();
		toyota.accelerate();
		toyota.brake();
	}
	

}
