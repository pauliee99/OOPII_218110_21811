package OOPII_1stDeliverable;

import java.util.*;

public class Traveller extends City{	
	String name;
	int age;
	double currLatLon;
	int plTravelers;
	
	//City city = new City(museums, cafes, weather, lat, lon);
	
	public Traveller(String cityName, int museums, int cafes, String weather, double lat, double lon, String name, int age, double currLatLon, int plTravelers) {
		super(cityName, museums, cafes, weather, lat, lon);
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
	
	public City CompareCities(ArrayList<City> cities) {
		City maxCity = new City(cityName, museums, cafes, weather, lat, lon);
		City tmpCity = new City(cityName, museums, cafes, weather, lat, lon);
		//double max = Similarity(tmpCity);
		//int maxSimilarity = 0;
		
		for (int i = 0; i < cities.size(); i++) {
			tmpCity.museums = cities.get(i).getMuseums();
			tmpCity.cafes = cities.get(i).getCafes();
			tmpCity.weather = cities.get(i).getWeather();
			tmpCity.lat = cities.get(i).getLat();
			tmpCity.lon = cities.get(i).getLon();
			//Similarity(tmpCity);
			if (Similarity(tmpCity) > Similarity(maxCity)) {
				maxCity.museums = tmpCity.museums;
				maxCity.cafes = tmpCity.cafes;
				maxCity.weather = tmpCity.weather;
				maxCity.lat = tmpCity.lat;
				maxCity.lon = tmpCity.lon;
				//maxCity = tmpCity;
			}
		}
		System.out.println(cities.get(0).getMuseums());
//		for(City i : cities) {
//			if (Similarity(i) > Similarity(maxCity)) {
//				maxCity = Similarity(i);
//			}
//		}
		System.out.println(maxCity.getCityName());
		return maxCity;
	}
	
	public String CompareCities(Boolean weather) {
		return name;
		
	}

	
}
