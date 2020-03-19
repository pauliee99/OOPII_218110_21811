package OOPII_1stDeliverable;

public class City {
	String cityName;
	int museums;
	int cafes;
	String weather;
	double lat;
	double lon;
	
	public City(String cityName, int museums, int cafes, String weather, double lat, double ion) {
		super();
		this.cityName = cityName;
		this.museums = museums;
		this.cafes = cafes;
		this.weather = weather;
		this.lat = lat; //katheto latitude
		this.lon = lon; //orizontio lottitude
	}
	
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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

	public void setLon(double ion) {
		this.lon = lon;
	}
	
	

}
