package OOPII_1stDeliverable;

import java.util.*;
import java.util.Scanner;

/**
 * This is main class
 *
 * @author it218110
 */

public class Main {
	public static void main(String args[]) {
		
		Scanner string = new Scanner(System.in);
		Scanner integer = new Scanner(System.in);
		
		// City(museums, cafes, weather, lat, lot)
		City athens = new City("athens", 40, 100, "rain", 103.321, 334.321);
		City thesaloniki = new City("thelsalloniki", 50, 300, "clear", 123.321, 534.311);
		City ioannina = new City("ioannina", 60, 600, "rain", 503.221, 134.921);
		
		//Traveller(museums, cafes, weather, lat,  lon, name, age, currLatLon, plTravelers)
		String cityName=null; int museums=0, cafes=0; String waether=null; double lat=0.0, lon=0.0; String name=null; int age=0; double currlatlon=0.0; int pltravelers=0;
		Traveller traveller = new Traveller(cityName, museums, cafes, waether, lat, lon, name, age, currlatlon, pltravelers); // this is traveller
		
		ArrayList <City> cities = new ArrayList<City>();
		cities.add(thesaloniki);
		cities.add(athens);
		cities.add(ioannina);
		
		System.out.println("1.Traveller\n2.Buissness\n3.Tourist");
		String choice = string.nextLine();
		
		System.out.println("give name");
		name = string.nextLine();
		
		System.out.println("give age");
		age = integer.nextInt();
		
		System.out.println("give city (city,counrty)");
		String city = string.nextLine();
		
		switch(choice) {
		case "1": 
			Scanner ans = new Scanner(System.in);
			System.out.println("you choose traveller");
			System.out.println("do you like museums?"); //mousia
			System.out.println("1.yes/2.no");
			int ansmus = ans.nextInt();
			System.out.printf("ansmus:" + ansmus);
			if (ansmus == 1) {
				traveller.setMuseums(1);
				System.out.printf("set musia" + traveller.getMuseums());
			}
			
			System.out.println("do you like cafes?"); //cafes
			System.out.println("1.yes/2.no");
			int anscafe = ans.nextInt();
			if (anscafe == 1) {
				traveller.setCafes(1);
			}
			
			System.out.println("do you like rain?"); //kairos
			System.out.println("1.yes/2.no");
			int answeather = ans.nextInt();
			if (answeather == 1) {
				traveller.setWeather("rain");
			}
			
			System.out.println("the answer of similarity is : " + traveller.Similarity(athens));
			
			traveller.CompareCities(cities);
			
			break;
		case "2": 
			System.out.println("you choose buissness");
			break;
		case "3": 
			System.out.println("you choose turist");
			break;
		default: 
			System.out.println("wrong choice");
		}
		
		
	}
}
