
import java.util.*;

import javax.swing.JOptionPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Traveller extends City implements Comparable<Traveller>, Serializable {	
	String name;
	int age;
	double currLatLon;
	static int plTravelers;
	
	private static final long serialVersionUID = 1L;
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
		City maxCity = new City(null, 0, 0, null, 0.0, 0.0);
		City tmpCity = new City(cityName, museums, cafes, weather, lat, lon);
		//double max = Similarity(tmpCity);
		//int maxSimilarity = 0;
		System.out.println(maxCity.museums);
		
		for (int i = 0; i < cities.size(); i++) {
			tmpCity.setCityName(cities.get(i).getCityName());
			System.out.println(cities.get(i).getCityName());
			tmpCity.setMuseums(cities.get(i).getMuseums());
			tmpCity.setCafes(cities.get(i).getCafes());
			tmpCity.setWeather(cities.get(i).getWeather());
			tmpCity.setLat(cities.get(i).getLat());
			tmpCity.setLon(cities.get(i).getLon());
			System.out.println(Similarity(tmpCity));
			System.out.println(Similarity(maxCity));
			if (Similarity(tmpCity) >= Similarity(maxCity)) {
				maxCity.setCityName(tmpCity.cityName);
				maxCity.setMuseums(tmpCity.museums);
				maxCity.setCafes(tmpCity.cafes);
				maxCity.setWeather(tmpCity.weather);
				maxCity.setLat(tmpCity.lat);
				maxCity.setLon(tmpCity.lon);
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
	
	public City CompareCities(Boolean kairos, ArrayList<City> weatherbool) {
		ArrayList<City> cities = new ArrayList<City>();

		for (int i = 0; i < weatherbool.size(); i++) {
			if (kairos == true) {
				if (weatherbool.get(i).getWeather().equals("rain")) {
					cities.add(weatherbool.get(i));
				}else {
					JOptionPane.showMessageDialog(null, "no cities with rain found");
					System.out.println("no cities with rain found");
					return CompareCities(weatherbool); 
				}
			}else if (kairos == false) {
				if (!(weatherbool.get(i).getWeather().equals("rain"))) {
					cities.add(weatherbool.get(i));
				}else {
					JOptionPane.showMessageDialog(null, "no cities without rain found");
					System.out.println("no cities without rain found");
				}
			}
		}
		return CompareCities(cities);
	}

	@Override
	public int compareTo(Traveller o) {
		// TODO Auto-generated method stub
		return this.age - o.age;
	}
	
	
	@Override
    public String toString() {
        return "Traveller{" +
                "Name='" + name + '\'' +
                ", Age='" + age + '\'' +
                ", museums=" + museums + '\'' +
                ", cafes=" + cafes + '\'' +
                ", waether=" + weather +
                "}\n";
    }
	
//	
//	public void read() {
//		try{
//			FileInputStream readData = new FileInputStream("travellerslist.ser");
//		    ObjectInputStream readStream = new ObjectInputStream(readData);
//		    ArrayList travellers = (ArrayList<Traveller>) readStream.readObject();
//			readStream.close();
//			System.out.println(travellers.toString());
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	public void write(ArrayList<Traveller> travellers) {
//		//write to file
//        try{
//            FileOutputStream writeData = new FileOutputStream("travellerslist.ser");
//            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
//
//            writeStream.writeObject(travellers);
//            writeStream.flush();
//            writeStream.close();
//
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//	}
//	

	
}
