
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;
import weather.OpenWeatherMap;
import weather.Weather;
import wikipedia.MediaWiki;


/**
 * This is main class
 *
 * @author it218110
 */

public class Main {
		
	/**Retrieves weather information, geotag (lan, lon) and a Wikipedia article for a given city.
	* @param city The Wikipedia article and OpenWeatherMap city. 
	* @param country The country initials (i.e. gr, it, de).
	* @param appid Your API key of the OpenWeatherMap.*/ 
	 public static void RetrieveData(String city, String country, String appid,ArrayList<City> cities) throws  IOException {
		 City tmpcity = new City("athens", 40, 100, "rain", 103.321, 334.321);
		 tmpcity.setCityName(city);
		 
		 ObjectMapper mapper = new ObjectMapper();
		 OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
		 
		 System.out.println(city+" temperature: " + (weather_obj.getMain()).getTemp());
		 
		 System.out.println(city+" lat: " + weather_obj.getCoord().getLat()+" lon: " + weather_obj.getCoord().getLon());
		 
		 tmpcity.setWeather(weather_obj.getWeather().get(0).getMain());
		 //weather_obj.getWeather.get(0).getMain
		 
		 tmpcity.setLat(weather_obj.getCoord().getLat());
		 tmpcity.setLon(weather_obj.getCoord().getLon());
		 
		 MediaWiki mediaWiki_obj =  mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2"),MediaWiki.class);
		 
		 System.out.println(city+" Wikipedia article: "+mediaWiki_obj.getQuery().getPages().get(0).getExtract());
		 
		 tmpcity.setMuseums(countOccurences(mediaWiki_obj.getQuery().getPages().get(0).getExtract(),"museums"));
		 
		 tmpcity.setCafes(countOccurences(mediaWiki_obj.getQuery().getPages().get(0).getExtract(),"Cafes"));
		 
		 System.out.println(tmpcity.getMuseums());
		 System.out.println(tmpcity.getCafes());
		// System.out.println(obj.getMain());
		 
		 cities.add(tmpcity);
	}
	
	// City(museums, cafes, weather, lat, lot)
//	static City athens = new City("athens", 40, 100, "rain", 103.321, 334.321);
//	static City thesaloniki = new City("thelsalloniki", 50, 300, "clear", 123.321, 534.311);
//	static City ioannina = new City("ioannina", 60, 600, "rain", 503.221, 134.921);

	
	
	
	public static void main(String args[]) throws IOException {
		ArrayList <City> cities = new ArrayList<City>();
		Scanner string = new Scanner(System.in);
		Scanner integer = new Scanner(System.in);
		
		String appid ="e9e0d5d96bd08a8c6d75d8b02a24b974";
		//RetrieveData("rome","it",appid,cities);
		//create_city(cities);
		
//		// City(museums, cafes, weather, lat, lot)
//		City athens = new City("athens", 40, 100, "rain", 103.321, 334.321);
//		City thesaloniki = new City("thelsalloniki", 50, 300, "clear", 123.321, 534.311);
//		City ioannina = new City("ioannina", 60, 600, "rain", 503.221, 134.921);
		City canditateCity = new City("", 0, 0, "", 0, 0);
		
		//Traveller(museums, cafes, weather, lat,  lon, name, age, currLatLon, plTravelers)
		String cityName="Rome"; int museums=0, cafes=0; String waether=null; double lat=7138.44789, lon=7138.44789; String name=null; int age=0; double currlatlon=0.0; int pltravelers=0;
		Traveller traveller = new Traveller(cityName, museums, cafes, waether, lat, lon, name, age, currlatlon, pltravelers); // this is traveller
		Business business = new Business(museums, cafes, waether, lat, lon, name, age, currlatlon, pltravelers);
		Tourist tourist = new Tourist(museums, cafes, waether, lat, lon, name, age, currlatlon, pltravelers);
		
		ArrayList<Traveller> travellers = new ArrayList<>();
		
		
//		cities.add(thesaloniki);
//		cities.add(athens);
//		cities.add(ioannina);
		while (true) {
			System.out.println("note: you must firtst create city and traveller before doing anything else!");
			System.out.println("1.Create City\n2.Traveller\n3.Buissness Traveller\n4.Tourist Traveller\n5.Print Cities\n6.Quit");
			String choice = string.nextLine();
		
			switch(choice) {
			case "2":  //simple traveller
				
				System.out.println("1) Create Traveller \n2) Similarity \n3) Compaire cities \n4) print traveller \n5) free ticket \n6) back");
				int tmpchoice = integer.nextInt();
				int run =0;

				switch(tmpchoice) {
				case 1://create traveller
					System.out.println("give name");
					name = string.nextLine();
					traveller.setName(name);
						
					System.out.println("give age");
					age = integer.nextInt();
					traveller.setAge(age);
						
					
						
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
						
					travellers.add(traveller);
					
					break;
				case 2://similarity
					Traveller taksidiotisSim = search_travellers(travellers, name);
					System.out.println("wanna choose from a list press 1\nwanna type your own press 2\n");
					int var = integer.nextInt();
					switch(var) {
					case 1:
						System.out.println("choose city: ");
						int k=0;
						print_cities(cities);
						System.out.println("choose the city you want based on the number");
						int temp = integer.nextInt();
						k = temp;
						String city = cities.get(k-1).getCityName();
						canditateCity.setCityName(city);
						break;
					case 2:
						System.out.println("give nity name");
						String cityname = string.nextLine();
						search_cities(cities, cityname);
						canditateCity.setCityName(cityname);

					}
					City poliSim = search_cities(cities, canditateCity.cityName);
					taksidiotisSim.Similarity(poliSim);
					System.out.println("the answer of similarity is : " + taksidiotisSim.Similarity(poliSim) + "\n");

					
					break;
				case 3://Compare cities
					Scanner bool = new Scanner (System.in);
					boolean tmp = false;
					String name2 = null;
					print_travellers(travellers);
					name2 = string.nextLine();
					Traveller taksidiotisCmp = search_travellers(travellers, name2);
					System.out.printf("do you care about rain? true/false");
					tmp = bool.nextBoolean();
					taksidiotisCmp.CompareCities(tmp, cities);
					break;
				case 4://print traveller
					System.out.println("name: " + name + "\nage: " + age + "\ncurrent location: " + currlatlon);
					break;
				case 5: //free ticket
					freeTicket(travellers, cities);
					break;
				case 6:
					run =1;
					break;
				}

				break;
			case "3": /////////////business
				System.out.println("you chose business");
				
				System.out.println("choose city: ");
				int k=0;
				print_cities(cities);
				System.out.println("choose the city you want based on the number");
				int temp = integer.nextInt();
				k = temp;
				String city = cities.get(k-1).getCityName();
				City poliSim = search_cities(cities, city);
				
				System.out.println("buisines similartty : " + business.Similarity(poliSim));
				break;
			case "4": /////////////tourist
				System.out.println("you chose tourist");

				System.out.println("choose city: ");
					int j=0;
					print_cities(cities);
				System.out.println("choose the city you want based on the number");
				int temp2 = integer.nextInt();
				j = temp2;
				String city2 = cities.get(j-1).getCityName();
				City poliSim2 = search_cities(cities, city2);
				System.out.println("tourist similarity: " + tourist.Similarity(poliSim2));
				
				break;
			case "6":
				System.exit(0);
				break;
			case "5":
				print_cities(cities);
				break;
			case "1":
				create_city(cities);
				break;
			default: 
				System.out.println("wrong choice");
			}//end go case
		}//end of while
		
	}//end of main
	
	
	
	
	
	
	
	public static void freeTicket(ArrayList<Traveller> travellers, ArrayList<City> cities) {
		System.out.println("choose city:\n");
		print_cities(cities);
		
		int k = 0;
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		City tmp;
		double tmpSimilarity, maxSimilarity = 0;
		tmp = search_cities(cities, name);
		
		for (int i=0; i<travellers.size(); i++) {
			if (travellers.get(i).Similarity(tmp) > maxSimilarity) {
				k = i;
				maxSimilarity = travellers.get(i).Similarity(tmp);
				System.out.println(maxSimilarity);
			}
		}
		System.out.println(travellers.get(k).getName() + " you have a free ticket for " + travellers.get(k).getCityName());
		//search_cities(cities, cityName);
	}
	
	
	
	
	
	

	public static void print_cities(ArrayList<City> cities) {
		for (int i=0; i<cities.size(); i++) {
			System.out.println("name: " + cities.get(i).getCityName() + "\tmuseums:" + cities.get(i).getMuseums() + 
					"\tcafes: " + cities.get(i).getCafes() + "\tweather: " + cities.get(i).getWeather() + "\tLatitude: " +
					cities.get(i).getLat() +"\tLonitude " + cities.get(i).getLon());
		}
	}
	
	
	
	
	
	public static void print_travellers(ArrayList<Traveller> travellers) {
		for (int i=0; i<travellers.size(); i++) {
			System.out.println("name: " + travellers.get(i).getName() + "\tage:" + travellers.get(i).getAge());
		}
	}
	
	
	
	
	
	
	
	public static City search_cities(ArrayList<City> cities, String cityName) {
		City tmp = null;
		for (int i=0; i<cities.size(); i++) {
			if (cities.get(i).getCityName().contentEquals(cityName)) {
				tmp = cities.get(i);
			}else {
				try {
					create_city(cities, cityName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return tmp;
	}
	
	
	
	
	
	
	
	
	public static Traveller search_travellers(ArrayList<Traveller> traveller, String name) {
		Traveller tmp = null;
		
		for (int i=0; i<traveller.size(); i++) {
			
			if (traveller.get(i).getName() == name) {
				
				//tmp.setCityName(cities.get(i).getCityName());
				tmp = traveller.get(i);
			}
		}
		
		return tmp;
	}
	
	
	
	
	
	
	
	
	static int countOccurences(String str, String word)  
	{ 
	    // split the string by spaces in a 
	    String a[] = str.split(" "); 
	  
	    // search for pattern in a 
	    int count = 0; 
	    for (int i = 0; i < a.length; i++)  
	    { 
	    // if match found increase count 
	    if (word.equals(a[i])) 
	        count++; 
	    } 
	  
	    return count; 
	}
	
	
	
	
	
	
	
	//RetrieveData(String city, String country, String appid,ArrayList<City> cities
	static void create_city (ArrayList<City> cities) throws IOException {
		Scanner integer = new Scanner(System.in);
		Scanner string = new Scanner(System.in);
		 
		 System.out.println("give the city you want to visit: ");
		 String cityname = string.nextLine();
		 System.out.println("give the initials of the country the city is in: \n");
		 String ctryname = string.nextLine();
		 RetrieveData(cityname, ctryname, "e9e0d5d96bd08a8c6d75d8b02a24b974", cities);
	}
	
	static void create_city (ArrayList<City> cities, String cityName) throws IOException {
		 Scanner string = new Scanner(System.in);
		 System.out.println("give the initials of the country the city is in: \n");
		 String ctryname = string.nextLine();
		 RetrieveData(cityName, ctryname, "e9e0d5d96bd08a8c6d75d8b02a24b974", cities);
	}

	
}
