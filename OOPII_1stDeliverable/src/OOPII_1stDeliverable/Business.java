package OOPII_1stDeliverable;

public class Business extends Traveller{
	int museums;
	int cafes;
	String weather;
	double lat;
	double lon;
	String name;
	int age;
	double currLatLon;
	int plTravelers;
	
	public Business(int museums, int cafes, String weather, double lat, double lon, String name,
			int age, double currLatLon, int plTravelers) {
		super(name, museums, cafes, weather, lat, lon, name, age, currLatLon, plTravelers);
		// TODO Auto-generated constructor stub
	}
	
	public int getMuseums() {
		return museums;
	}



	public void setMuseums(int museums) {
		this.museums = museums;
	}



	public int getCafes() {
		return cafes;
	}



	public void setCafes(int cafes) {
		this.cafes = cafes;
	}



	public String getWeather() {
		return weather;
	}



	public void setWeather(String weather) {
		this.weather = weather;
	}



	public double getLat() {
		return lat;
	}



	public void setLat(double lat) {
		this.lat = lat;
	}



	public double getLon() {
		return lon;
	}



	public void setLon(double lon) {
		this.lon = lon;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public double getCurrLatLon() {
		return currLatLon;
	}



	public void setCurrLatLon(double currLatLon) {
		this.currLatLon = currLatLon;
	}



	public int getPlTravelers() {
		return plTravelers;
	}



	public void setPlTravelers(int plTravelers) {
		this.plTravelers = plTravelers;
	}



	private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			} else if (unit.equals("N")) {
				dist = dist * 0.8684;
			}
			return (dist);
		}
	}
	
    @Override	
	public double Similarity(City city) {
		return distance(getLat(), getLon(), city.getLat(), city.getLon(), "metra");
	}
    
    
    
    
}
