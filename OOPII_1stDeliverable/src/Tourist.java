public class Tourist extends Traveller{

	public Tourist(int museums, int cafes, String weather, double lat, double lon, String name,
			int age, double currLatLon, int plTravelers) {
		super(name, museums, cafes, weather, lat, lon, name, age, currLatLon, plTravelers);
		// TODO Auto-generated constructor stub
	}
	
	@Override	
	public double Similarity(City city) {
		int counter = 0;
				
		if (city.museums != 0 && museums == 1) {
			counter = counter*city.museums;
		}
		if (city.cafes != 0 && cafes == 1) {
			counter = counter*city.cafes;
		}
		if (city.weather == "rain" && weather == "rain") {
			counter++;
		}
		if (city.weather != "rain" && weather != "rain") {
			counter++;
		}
		
		//double percentage = counter*100/3;
		
		return counter;
		
	}

}
