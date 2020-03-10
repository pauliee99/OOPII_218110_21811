package OOPII_1stDeliverable;

public class Business extends Traveller{

	public Business(int museums, int cafes, String weather, double lat, double lon, String name,
			int age, double currLatLon, int plTravelers) {
		super(museums, cafes, weather, lat, lon, name, age, currLatLon, plTravelers);
		// TODO Auto-generated constructor stub
	}
	
    @Override	
	public double Similarity(City city) {
		int counter = 0;
				
		if (city.museums != 0 && museums == 1) {
			counter++;
		}
		if (city.cafes != 0 && cafes == 1) {
			counter++;
		}
		if (city.weather == "rain" && weather == "rain") {
			counter++;
		}
		if (city.weather != "rain" && weather != "rain") {
			counter++;
		}
		
		double percentage = counter*100/3;
		
		return percentage;
		
	}
}
