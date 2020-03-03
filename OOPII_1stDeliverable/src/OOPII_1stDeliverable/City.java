package OOPII_1stDeliverable;

public class City {
	String museums;
	String cafes;
	String weather;
	String lat;
	String lon;
	
	public City(String museums, String cafes, String weather, String lat, String ion) {
		super();
		this.museums = museums;
		this.cafes = cafes;
		this.weather = weather;
		this.lat = lat; //katheto latitude
		this.lon = lon; //orizontio lottitude
	}

	public String getMuseums() {
		return museums;
	}

	public void setMuseums(String museums) {
		this.museums = museums;
	}

	public String getCafes() {
		return cafes;
	}

	public void setCafes(String cafes) {
		this.cafes = cafes;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String ion) {
		this.lon = ion;
	}
	
	

}
