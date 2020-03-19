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
		
		Scanner newsc = new Scanner(System.in);
		
		// City(museums, cafes, weather, lat, lot)
		City athens = new City(40, 100, "rain", 103.321, 334.321);
		City thesaloniki = new City(50, 300, "clear", 123.321, 534.311);
		City ioannina = new City(60, 600, "rain", 503.221, 134.921);
		
		//Traveller(museums, cafes, weather, lat,  lon, name, age, currLatLon, plTravelers)
		Traveller traveller = new Traveller(1, 0, "rain", 0, 0, null, 0, 0, 0); // this is traveller
		
		System.out.println("1.Traveller\n2.Buissness\n3.Tourist");
		String choice = newsc.nextLine();
		
		System.out.println("give name");
		String name = newsc.nextLine();
		
		System.out.println("give age");
		String age = newsc.nextLine();
		
		System.out.println("give city (city,counrty)");
		String city = newsc.nextLine();
		
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
