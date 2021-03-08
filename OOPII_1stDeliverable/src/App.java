import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;s
import weather.OpenWeatherMap;
import wikipedia.MediaWiki;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.Writer;
/*
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
*/

/**
 * This is main class
 *
 * @author it218110
 */
@SuppressWarnings("serial")
public class App extends JFrame implements Serializable {
	
	private static final String filepath="obj.ser";
	private static final String filepath2="obj2.ser";

	public static void main(String args[]) throws IOException, SQLException {
		ArrayList <City> cities = new ArrayList<City>();
		//Scanner string = new Scanner(System.in);
		//Scanner integer = new Scanner(System.in);
		//File file = new File("filename.txt");
		String line;
		String appid =${{ secrets.OPENWEATHERMAP }};
		
		makeJDBCConnection();
		ReadData(cities);
		
		//print_cities(cities);
		

		City canditateCity = new City("", 0, 0, "", 0, 0);
		
		
		
		//Traveller(museums, cafes, weather, lat,  lon, name, age, currLatLon, plTravelers)
		String cityName="Athens"; int museums=0, cafes=0; String waether=null; double lat=7138.44789, lon=7138.44789; String name=null; int age=0; double currlatlon=0.0; int pltravelers=0;
		Business business = new Business(museums, cafes, waether, lat, lon, name, age, currlatlon, pltravelers);
		Tourist tourist = new Tourist(museums, cafes, waether, lat, lon, name, age, currlatlon, pltravelers);
		Traveller traveller2 = new Traveller(cityName, museums, cafes, waether, lat, lon, name, age, currlatlon, pltravelers);		
		
		ArrayList <String> travellersnames = new ArrayList<String>();
		ArrayList <VisitorsOfCity> visitors = new ArrayList<VisitorsOfCity>();
		ArrayList<Traveller> travellers = new ArrayList<>();
		App objectIO = new App();
		objectIO.ReadObjectFromFile(filepath, travellers);
		
		print_travellers(travellers);
		
		objectIO.ReadObjectFromFileVisitors(filepath2,  visitors);
		 print_visitors(visitors);
		 //int v=0;
		 //System.out.println(visitors.get(v).counttravellers());
		 if(visitors.isEmpty()){
		 VisitorsOfCity dummyvisitor = new VisitorsOfCity("athens",0,0,null,0,0 ,travellersnames);
			visitors.add(dummyvisitor);
		 }
		
		 JOptionPane.showMessageDialog(null, "Visitors are created through compare cities in order for the city to be recommended!");
		while (true) {
			int mm = 0;
			String[] mainMenubuttons = { "create city", "Traveller", "buisiness Traveller", "tourist Traveller", "Print Cities", "Show travellers", "Visitors of city", "Quit" };    
			int mainMenu = JOptionPane.showOptionDialog(null, "Main Menu", "Narrative",
			        JOptionPane.WARNING_MESSAGE, 0, null, mainMenubuttons, mainMenubuttons[mm]);
			System.out.println(mainMenu);
			System.out.println("note: you must firtst create city and traveller before doing anything else!");
			System.out.println("1.Create City\n2.Traveller\n3.Buissness Traveller\n4.Tourist Traveller\n5.Print Cities\n6.Show travellers\n7.Quit");
			
			switch(mainMenu) {
			case 0:
				create_city(cities);
				break;
			case 1:  //simple traveller
				int i = 0;
				String[] buttons = { "Create Traveller", "Similarity", "Compaire cities", "print traveller", "free ticket","similarity travellers","visitors", "back"};    
				int returnValue = JOptionPane.showOptionDialog(null, "Traveller", "Narrative",
				        JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[i]);
				int tmpchoice = returnValue;
				int run =0;
				
				switch(tmpchoice) {
				case 0://create traveller
					Traveller traveller = new Traveller(cityName, museums, cafes, waether, lat, lon, name, age, currlatlon, pltravelers); // this is traveller
					name = JOptionPane.showInputDialog(null, "give name:");
					traveller.setName(name);
						
					age = Integer.parseInt(JOptionPane.showInputDialog(null, "give age:"));
					traveller.setAge(age);
						
					
						
					JOptionPane.showMessageDialog(null, "you choose traveller!");
					
					String[] buttons1 = { "yes", "no"};
					int ansmus = JOptionPane.showOptionDialog(null, "do you like museums?", "Narrative",JOptionPane.WARNING_MESSAGE, 0, null, buttons1, buttons1[i]);
					if (ansmus == 0) { //==1
						traveller.setMuseums(1);
						System.out.printf("set musia" + traveller.getMuseums());
					}
					
						
					String[] buttons2 = { "yes", "no"};
					int anscafe = JOptionPane.showOptionDialog(null, "do you like cafes?", "Narrative",JOptionPane.WARNING_MESSAGE, 0, null, buttons2, buttons2[i]);
					if (anscafe == 0) { //==1
						traveller.setCafes(1);
					}
						
					String[] buttons3 = { "yes", "no"};
					int answeather = JOptionPane.showOptionDialog(null, "do you like rain?", "Narrative",JOptionPane.WARNING_MESSAGE, 0, null, buttons3, buttons3[i]);
					if (answeather == 0) {
						traveller.setWeather("rain");
					}
					
					
					if(check_travellers(travellers, traveller) == true) {
				        travellers.add(traveller);
				        objectIO.WriteObjectToFile(filepath, travellers);
					}else {
						JOptionPane.showMessageDialog(null, "this traveller already exists", "Failure", JOptionPane.ERROR_MESSAGE);
					}
					break;
				case 1://similarity
					name = JOptionPane.showInputDialog(null, "give name:");
					Traveller taksidiotisSim = search_travellers(travellers, name);
					System.out.println(name);
					String[] buttonssim = { "wanna choose from a list", "wanna type your own"};
					int var = JOptionPane.showOptionDialog(null, "similarity", "Narrative",JOptionPane.WARNING_MESSAGE, 0, null, buttonssim, buttonssim[i]);
					switch(var) {
					case 0:
						System.out.println("choose city: ");
						int k=0;
						print_cities(cities);
						String[] bottons = new String[cities.size()];
						for(int arr=0; arr<cities.size(); arr++) {
							bottons[arr] = cities.get(arr).getCityName();
						}
						int temp = JOptionPane.showOptionDialog(null, "chose the city you want based on the number", "similarity",JOptionPane.WARNING_MESSAGE, 0, null, bottons, bottons[i]);
						k = temp;
						String city = cities.get(k).getCityName();
						canditateCity.setCityName(city);
						break;
					case 1:
						String cityname = JOptionPane.showInputDialog(null, "give city name:");
						//search_cities(cities, cityname);
						canditateCity.setCityName(cityname);

					}
					City poliSim = search_cities(cities, canditateCity.cityName);
					System.out.println(poliSim);
					taksidiotisSim.Similarity(poliSim);
					System.out.println("the answer of similarity is : " + taksidiotisSim.Similarity(poliSim) + "\n");
					JOptionPane.showMessageDialog(null, "the answer of similarity is : "+ taksidiotisSim.Similarity(poliSim));

					break;
				case 2://Compare cities
					int p=0;
					
					boolean tmp = false;
					String name2 = null;
					print_travellers(travellers);
					name2 = JOptionPane.showInputDialog(null, "write the name of the traveller");
					Traveller taksidiotisCmp = search_travellers(travellers, name2);
					
					
					//taksidiotisCmp.CompareCities(tmp, cities);
					City maxcity=taksidiotisCmp.CompareCities(tmp, cities);
					for (int o = 0; o < visitors.size(); o ++)
						//System.out.println("here");
					if(visitors.get(o).getCityName().equals(maxcity.getCityName())){
						System.out.println("here1");
						visitors.get(o).setTravellername(taksidiotisCmp.getName());
						p=1;
					}
					if( p==1){
						System.out.println("added to to city that exists");
						print_visitors(visitors);
						WriteObjectToFileVisitors(filepath2,visitors);
						break;
					}
					
						//System.out.println("here2");
					ArrayList <String> travellersnames2 = new ArrayList<String>();
					VisitorsOfCity visitor = new VisitorsOfCity(maxcity.getCityName(),0,0,null,0,0,travellersnames2);
					visitor.setTravellername(name2);
					visitors.add(visitor);
					
					System.out.println("here3");
					print_visitors(visitors);
					WriteObjectToFileVisitors(filepath2,visitors);
					break;
				case 3://print traveller
					JOptionPane.showMessageDialog(null, "name: " + name + "\nage: " + age + "\ncurrent location: " + currlatlon);
					System.out.println("name: " + name + "\nage: " + age + "\ncurrent location: " + currlatlon);
					break;
				case 4: //free ticket
					freeTicket(travellers, cities);
					break;
				case 5: //similarity travellers
					print_travellers(travellers);
					System.out.println("choose traveller: ");
					int k=0;
					String[] bottons = new String[travellers.size()];
					for(int arr=0; arr<travellers.size(); arr++) {
						bottons[arr] = travellers.get(arr).getName();
					}
					int temp = JOptionPane.showOptionDialog(null, "chose the traveller you want based on the number", "similarity",JOptionPane.WARNING_MESSAGE, 0, null, bottons, bottons[i]);
					k = temp;
					String city = travellers.get(k).getName();
					traveller = search_travellers(travellers, city);
					similarityTraveller(travellers, cities, traveller);
					break;
				case 6:
					for(int c=0;c<visitors.size();c++){
						System.out.println("City "+visitors.get(i).getCityName()+"Number of visitors: "+visitors.get(c).counttravellers());
						}
						break;
				case 7:
					run =1;
					break;
				}

				break;
			case 2: /////////////business
				JOptionPane.showMessageDialog(null, "you chose business");
				int bussinesscounter=0;
				String[] businessbottons = new String[cities.size()];
				for(int arr=0; arr<cities.size(); arr++) {
					businessbottons[arr] = cities.get(arr).getCityName();
				}
				int temp = JOptionPane.showOptionDialog(null, "choose city:", "business",JOptionPane.WARNING_MESSAGE, 0, null, businessbottons, businessbottons[bussinesscounter]);
				int k=0;
				k = temp;
				String city = cities.get(k-1).getCityName();
				City poliSim = search_cities(cities, city);
				JOptionPane.showMessageDialog(null, "buisines similartty : " + business.Similarity(poliSim));
				break;
			case 3: /////////////tourist
				JOptionPane.showMessageDialog(null, "you chose tourist");

				int touristcounter=0;
				String[] touristbottons = new String[cities.size()];
				for(int arr=0; arr<cities.size(); arr++) {
					touristbottons[arr] = cities.get(arr).getCityName();
				}
				int temp2 = JOptionPane.showOptionDialog(null, "choose city:", "tourist",JOptionPane.WARNING_MESSAGE, 0, null, touristbottons, touristbottons[touristcounter]);
				int j=0;
				j = temp2;
				String city2 = cities.get(j-1).getCityName();
				City poliSim2 = search_cities(cities, city2);
				JOptionPane.showMessageDialog(null, "tourist similarity: " + tourist.Similarity(poliSim2));
				break;
			case 4:
				print_cities(cities);
				break;
			case 5://sorting travellers
				Collections.sort(travellers);
				System.out.println("travellers after sorting : "); 
		        for (Traveller traveller3: travellers) 
		        { 
		        	JOptionPane.showMessageDialog(null,traveller3.getName() + " " + traveller3.getAge());
		        }
		        break;
			case 6://visitors of city
				print_visitors(visitors);
				break;
			case 7:
				System.exit(0);
				break;
			default: 
				System.out.println("wrong choice");
			}//end go case
		}//end of while
		
	}//end of main
	
	
////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	/**Retrieves weather information, geotag (lan, lon) and a Wikipedia article for a given city.
	* @param city The Wikipedia article and OpenWeatherMap city. 
	* @param country The country initials (i.e. gr, it, de).
	* @param appid Your API key of the OpenWeatherMap.*/ 
	 public static void RetrieveData(String city, String country, String appid,ArrayList<City> cities) throws  IOException {
		 City tmpcity = new City("athens", 40, 100, "rain", 103.321, 334.321);
		 tmpcity.setCityName(city);
		 ObjectMapper mapper = new ObjectMapper();
		 int museums = 0,cafes = 0;
		 
		 /////////weather
		 OpenWeatherMap weather_obj = new OpenWeatherMap();//mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
		 //OpenWeatherMap weather_obj1 = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
		 weather_thread weatherthread = new weather_thread(city, country, appid, weather_obj);
		 Thread thread_weather = new Thread(weatherthread);
		 thread_weather.start();
		 try {
			TimeUnit.SECONDS.sleep(10);
			System.out.println(thread_weather.getState());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 tmpcity.setWeather(weather_thread.getWeather_obj().getWeather().get(0).getMain());
		 tmpcity.setLat(weather_thread.getWeather_obj().getCoord().getLat());
		 tmpcity.setLon(weather_thread.getWeather_obj().getCoord().getLon());
		 
		 /////////////wiki
		 MediaWiki mediaWiki_obj =  new MediaWiki();//mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2"),MediaWiki.class);
		 wiki_thread wikithread = new wiki_thread(city, museums, cafes, mediaWiki_obj);
		 Thread thread_wiki = new Thread(wikithread);
		 thread_wiki.start();
		 try {
			TimeUnit.SECONDS.sleep(10);
		 } catch (InterruptedException e) {
			e.printStackTrace();
		 }
		 tmpcity.setMuseums(wiki_thread.getMuseums());
		 tmpcity.setCafes(wiki_thread.getCafes());
		 
		 System.out.println("musiums" + tmpcity.getMuseums());
		 System.out.println("cafes" + tmpcity.getCafes());
		 
		 cities.add(tmpcity);
		 addDataToDB(tmpcity);
	}
	 
	 
	 
	 
	 static Connection db_con_obj = null; //A connection (session) with a specific database. SQL statements are executed and results are returned within the context 
		//of a connection. A Connection object's database is able to provide information describing its tables, its supported SQL grammar, its stored procedures, 
		//the capabilities of this connection, and so on. This information is obtained with the getMetaData method.
		static PreparedStatement db_prep_obj = null;//An object that represents a precompiled SQL statement.
		//A SQL statement is precompiled and stored in a PreparedStatement object. This object can then be used to efficiently execute this statement multiple times.
		
		private static void makeJDBCConnection() {
			 
			try {//We check that the DB Driver is available in our project.		
				Class.forName("oracle.jdbc.driver.OracleDriver"); //This code line is to check that JDBC driver is available. Or else it will throw an exception. Check it with 2. 
				//System.out.println("Congrats - Seems your MySQL JDBC Driver Registered!");
				JOptionPane.showMessageDialog(null, "Congrats - Seems your MySQL JDBC Driver Registered!");
			} catch (ClassNotFoundException e) {
				//System.out.println("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
				JOptionPane.showMessageDialog(null, "Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly", "Failure", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				return;
			}
	 
			try {
				// DriverManager: The basic service for managing a set of JDBC drivers.	 //We connect to a DBMS.
				db_con_obj = DriverManager.getConnection("jdbc:oracle:thin:@oracle12c.hua.gr:1521:orcl","it218110","it218110");// Returns a connection to the URL.
				//Attempts to establish a connection to the given database URL. The DriverManager attempts to select an appropriate driver from the set of registered JDBC drivers.
				if (db_con_obj != null) { 
					JOptionPane.showMessageDialog(null, "Connection Successful! Enjoy. Now it's time to CRUD data.");
					//System.out.println("Connection Successful! Enjoy. Now it's time to CRUD data. ");
				} else {
					//System.out.println("Failed to make connection!");
					JOptionPane.showMessageDialog(null, "Failed to make connection!", "Failure", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e) {
				//System.out.println("MySQL Connection Failed!");
				JOptionPane.showMessageDialog(null, "MySQL Connection Failed!", "Failure", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				return;
			}
	 
		}
		
		private static void addDataToDB(City city) {
			 
			try {
				String insertQueryStatement = "INSERT  INTO  CITY  VALUES  (?,?,?,?,?,?)";
				
				//static Connection db_con_obj = null;
				//static PreparedStatement db_prep_obj = null;
				db_prep_obj = db_con_obj.prepareStatement(insertQueryStatement);
				db_prep_obj.setString(1, city.getCityName());//.setString
				db_prep_obj.setInt(2, city.getMuseums());
				db_prep_obj.setInt(3, city.getCafes());
				db_prep_obj.setString(4, city.getWeather());
				db_prep_obj.setDouble(5, city.getLat());//.setString
				db_prep_obj.setDouble(6, city.getLon());
				//db_prep_obj.setInt(7, 1);
				//db_prep_obj.setInt(8, 1);
				//db_prep_obj.setObject(9, new Date());
				
				
				// execute insert SQL statement Executes the SQL statement in this PreparedStatement object, which must be an SQL Data Manipulation Language (DML) statement
				int numRowChanged = db_prep_obj.executeUpdate(); //either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
				System.out.println("Rows "+numRowChanged+" changed.");
				
			} catch (
	 
			SQLException e) {
				e.printStackTrace();
			}
		}
		
		private static void ReadData(ArrayList<City> cities) throws SQLException {
			db_prep_obj = db_con_obj.prepareStatement("select * from CITY");
			ResultSet  rs = db_prep_obj.executeQuery();

		    while (rs.next()){
		        String cityName = rs.getString("CITYNAME");
		        int museums = rs.getInt("MUSEUMS");
		        int cafes = rs.getInt("CAFES");
		        //int restaurants = rs.getInt("restaurants");
		        //int bars = rs.getInt("bars");
		        String weather = rs.getString("WEATHER");
		        double lat = rs.getDouble("LATITUDE");
		        double lon = rs.getFloat("LONTIDUDE");
		        System.out.println("The data are: "+ cityName + " "+ cafes );
		        City tmpCity = new City(cityName, museums, cafes, weather, lat, lon);
		        cities.add(tmpCity);
		    }
		}
		

		
		
		
		
		
		
		
		
		
	
	
	
	
	
	public static void freeTicket(ArrayList<Traveller> travellers, ArrayList<City> cities) throws IOException {
		System.out.println("choose city:\n");
		print_cities(cities);
		
		int k = 0;
		//Scanner sc = new Scanner(System.in);
		String name = JOptionPane.showInputDialog(null, "name:");
		City tmp;
		double tmpSimilarity, maxSimilarity = 0;
		tmp = search_cities(cities, name);
		
		for (int i=0; i<travellers.size(); i++) {
			if (travellers.get(i).Similarity(tmp) > maxSimilarity) {
				k = i;
				maxSimilarity = travellers.get(i).Similarity(tmp);
				JOptionPane.showMessageDialog(null, maxSimilarity);
				//System.out.println(maxSimilarity);
				travellers.get(i).setCityName(tmp.getCityName());
			}
		}
		JOptionPane.showMessageDialog(null, travellers.get(k).getName() + " you have a free ticket for " + travellers.get(k).getCityName() );
		System.out.println(travellers.get(k).getName() + " you have a free ticket for " + travellers.get(k).getCityName());
	}
	
	
	
	
	
	

	public static void print_cities(ArrayList<City> cities) {
		for (int i=0; i<cities.size(); i++) {
			System.out.println("name: " + cities.get(i).getCityName() + "\tmuseums:" + cities.get(i).getMuseums() + 
					"\tcafes: " + cities.get(i).getCafes() + "\tweather: " + cities.get(i).getWeather() + "\tLatitude: " +
					cities.get(i).getLat() +"\tLonitude " + cities.get(i).getLon());
		}
		String[] bottons = new String[10];
		int arr=0;
		for(int i=0; i<cities.size(); i++) {
			bottons[arr] = cities.get(i).getCityName();
			bottons[arr+1] = Integer.toString(cities.get(i).getMuseums());
			bottons[arr+2] = Integer.toString(cities.get(i).getCafes());
			bottons[arr+3] = cities.get(i).getWeather();
			bottons[arr+4] = Double.toString(cities.get(i).getLat());
			bottons[arr+5] = Double.toString(cities.get(i).getLon());
			JOptionPane.showMessageDialog(null, bottons);
		}
		
		
	}
	
	
	
	
	
	public static void print_travellers(ArrayList<Traveller> travellers) {
		for (int i=0; i<travellers.size(); i++) {
			System.out.println("name: " + travellers.get(i).getName() + "\tage:" + travellers.get(i).getAge());
		}
	}
	
	
	
	
	
	
	
	public static City search_cities(ArrayList<City> cities, String cityName) throws IOException {
		Scanner sc = new Scanner(System.in);
		City tmp = new City(cityName, 1, 0, null, 0, 0);
		int nigga = 0;
		for (int i=0; i<cities.size(); i++) {
			if (cityName.equals(cities.get(i).getCityName())) {
				//tmp = cities.get(i);
				tmp.setCityName(cities.get(i).getCityName());
				tmp.setMuseums(cities.get(i).getMuseums());
				tmp.setCafes(cities.get(i).getCafes());
				tmp.setWeather(cities.get(i).getWeather());
				tmp.setLat(cities.get(i).getLat());
				tmp.setLon(cities.get(i).getLon());
				nigga=1;
				System.out.println("city found");
				int j=0;
				String[] buttons = { "yes", "no"};    
				int returnValue = JOptionPane.showOptionDialog(null, "do you want to return that city?", "Narrative",
				        JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[j]);
				System.out.println(returnValue);
				int noumero = returnValue;//sc.nextInt();
				switch(noumero) {
				case 0:
					System.out.println("mpike");
					System.out.println(tmp.getCityName());
					return tmp;
				case 1:
					break;
				default:
					System.out.println("wrong option");
				}
				break;
			}//else {
		}
			/*	if (nigga == 0) {
					int i = 0;
					String[] buttons = { "Do nothing", "Create a city"};    
					int returnValue = JOptionPane.showOptionDialog(null, "Narrative", "Narrative",
					        JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[i]);
					System.out.println(returnValue);
					System.out.println("city not found");
					System.out.println("0) Do nothing\n1) Create a city");
					int noumero = returnValue;//sc.nextInt();
					switch(noumero) {
					case 0:
						break;
					case 1:
						try {
							create_city(cities, cityName);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					default:
						System.out.println("wrong option");
					}
				}*/
		tmp=null;		
		return tmp;
	}
	
	
	
	
	
	
	
	
	public static Traveller search_travellers(ArrayList<Traveller> traveller, String name) {
		Traveller tmp = null;
		for (int i=0; i<traveller.size(); i++) {
			if (traveller.get(i).getName().equals(name)) {
				tmp = traveller.get(i);
				return tmp;
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
	
	
	
	
	
	
	
	static void create_city (ArrayList<City> cities) throws IOException{
		 String cityName = JOptionPane.showInputDialog(null, "give the city you want ot visit:");
		 String countryName = JOptionPane.showInputDialog(null, "give the initials of the country you want ot visit:");
		 if (equals(cities, cityName) == true) {
			 RetrieveData(cityName, countryName, "e9e0d5d96bd08a8c6d75d8b02a24b974", cities);
		 }else {
			 JOptionPane.showMessageDialog(null, "city already exist in database");
			 System.out.println("city already exist in database");
		 }

	}
	


	static void create_city (ArrayList<City> cities, String cityName) throws IOException {
		 Scanner string = new Scanner(System.in);
		 System.out.println("give the initials of the country the city is in: \n");
		 String ctryname = JOptionPane.showInputDialog(null, "give the initials of the country the city is in:");
		 RetrieveData(cityName, ctryname, "e9e0d5d96bd08a8c6d75d8b02a24b974", cities);
	}

	
	
	
	
	
	public static boolean equals(ArrayList<City> cities, String cityName) throws IOException {
		if (search_cities(cities, cityName) == null) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	
	public static boolean check_travellers(ArrayList<Traveller> travellers, Traveller traveller) {
		for (int i=0; i<travellers.size(); i++) {
			if (travellers.get(i).getName().equals(traveller.name) && travellers.get(i).getAge() == traveller.age && travellers.get(i).getMuseums() == traveller.museums && travellers.get(i).getCafes() == traveller.cafes && travellers.get(i).getWeather() == traveller.weather) {
				return false;
			}
		}
		return true;
	}
	

	
	
	
    public void WriteObjectToFile(String filepath,ArrayList<Traveller> travellers) {
    	 
        try {
        	int i=0;
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (Traveller m : travellers) {
            	objectOut.writeObject(travellers.get(i));
            	i++;
            }
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
    }
 
    public void ReadObjectFromFile(String filepath, ArrayList<Traveller> travellers) {
 
        try {
        	
        	
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            //Object obj = objectIn.readObject();
            
            // create a reader instance
            BufferedReader br = new BufferedReader(new FileReader(filepath));

            // read until end of file
            String line;
            boolean cont = true;
            //while ((line = br.readLine()) != null) {
            while(cont) {
            	//System.out.println(line);
            	Traveller tmp = new Traveller(null, 0, 0, null, 0, 0, null, 0, 0, 0);
            	Object obj = objectIn.readObject();
                //System.out.println(line);
                tmp = (Traveller) obj;
                if ( obj != null) {
                	travellers.add(tmp);
                }else {
                	cont =false;
                }
                
            }

            // close the reader
            br.close();
            
            System.out.println("The Object has been read from the file");
            objectIn.close();
            //return obj;
 
        } catch (Exception ex) {
            
        	//ex.printStackTrace();
            //return null;
        }
    }
    
    public static City similarityTraveller(ArrayList<Traveller> travellers, ArrayList<City> cities, Traveller traveller) throws IOException {
    	int tmpsimilarity, maxsimilarty = 0;
    	City city = new City("", 0, 0, "", 0, 0);
    	Stream<Traveller> stream = travellers.stream();
		Map <String,Integer> cityToRank=stream.collect(Collectors.toMap(i->i.getCityName(),i->innerDot(i,traveller), (address1, address2) -> address1
	            //System.out.println("duplicate key found!");
	        ));
		
		//cityToRank.forEach((k,v)->System.out.println("city:"+k+" rank: "+v));
		//System.out.println("The Recommended City:"+cityToRank);	
		Optional<RecommendedCity> recommendedCity=
				travellers.stream().map(i-> new RecommendedCity(i.getCityName(),innerDot(i,traveller))).max(Comparator.comparingInt(RecommendedCity::getRank));
		//search_cities(cities, recommendedCity.toString());
		System.out.println("The Recommended City:"+recommendedCity.get().getCity());
		JOptionPane.showMessageDialog(null, "The Recommended City" +recommendedCity.get().getCity() );

		return search_cities(cities, recommendedCity.get().getCity());
    }
    
	private static int innerDot(Traveller currTraveller, Traveller candTraveller) {
		int sum=0;
		int[] currentTraveller = {1,2}, candidateTraveller = {1,2};
		currentTraveller[0] = currTraveller.getMuseums();
		currentTraveller[1] = currTraveller.getCafes();
		candidateTraveller[0] = candTraveller.getMuseums();
		candidateTraveller[1] = candTraveller.getCafes();
		
		for (int i=0; i<currentTraveller.length;i++)
			sum+=currentTraveller[i]*candidateTraveller[i];
		
		//if (currTraveller.getWeather().equals(candTraveller.getWeather())) {
			sum++;
		//}
		//System.out.println(sum);
		//System.out.println("cityName:" + currTraveller.getCityName());

		return sum;
			
	}
	
	
	
	public void ReadObjectFromFileVisitors(String filepath2, ArrayList<VisitorsOfCity> visitors) {
		 
	    try {
	    	
	    	
	        FileInputStream fileIn = new FileInputStream(filepath2);
	        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

	        //Object obj = objectIn.readObject();
	        
	        // create a reader instance
	        BufferedReader br = new BufferedReader(new FileReader(filepath2));

	        // read until end of file
	        String line;
	        boolean cont = true;
	        //while ((line = br.readLine()) != null) {
	        while(cont) {
	        	//System.out.println(line);
	        	VisitorsOfCity tmp = new VisitorsOfCity(null, 0, 0, null, 0, 0, null);
	        	Object obj = objectIn.readObject();
	            //System.out.println(line);
	            tmp = (VisitorsOfCity) obj;
	            if ( obj != null) {
	            	visitors.add(tmp);
	            }else {
	            	cont =false;
	            }
	            
	        }

	        // close the reader
	        br.close();
	        
	        System.out.println("The Object has been read from the file");
	        objectIn.close();
	        //return obj;

	    } catch (Exception ex) {
	        
	    	//ex.printStackTrace();
	        //return null;
	    }
	}
	public static void WriteObjectToFileVisitors(String filepath2,ArrayList<VisitorsOfCity> visitors) {
		 
	    try {
	    	int i=0;
	        FileOutputStream fileOut = new FileOutputStream(filepath2);
	        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
	        for (VisitorsOfCity m : visitors) {
	        	objectOut.writeObject(visitors.get(i));
	        	i++;
	        }
	        objectOut.close();
	        System.out.println("The Object  was succesfully written to a file");

	    } catch (Exception ex) {
	        //ex.printStackTrace();
	    }
	}
	public static void print_visitors(ArrayList<VisitorsOfCity> visitors) {
		for (int i=0; i<visitors.size(); i++) {
			System.out.println("City name: " + visitors.get(i).getCityName() + "\tVisitor names:" + visitors.get(i).getTravellersnames());
		}
	}

	
}

