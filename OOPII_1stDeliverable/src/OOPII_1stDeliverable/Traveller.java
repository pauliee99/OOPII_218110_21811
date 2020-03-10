package OOPII_1stDeliverable;

import java.util.*;

public class Traveller extends City{
	String name;
	int age;
	double currLatLon;
	int plTravelers;
	
	//City city = new City(museums, cafes, weather, lat, lon);
	
	public Traveller(int museums, int cafes, String weather, double lat, double lon, String name, int age, double currLatLon, int plTravelers) {
		super(museums, cafes, weather, lat, lon);
		this.name = name;
		this.age = age;
		this.currLatLon = currLatLon;
		this.plTravelers = plTravelers;
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
	
	public String CompareCities() {
		return name;
		
	}
	
//	public String equal() {
//		if (museums == 1) {
//			
//		}
//	}
	
}
