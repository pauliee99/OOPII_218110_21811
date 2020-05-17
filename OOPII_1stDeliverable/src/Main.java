import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import GUI.BusinessTravellerGui;
import GUI.CreateCityNameGui;
import GUI.FormPanel;
import GUI.MainMenu;
import GUI.PrintCitiesGui;
import GUI.ShowTravellersGui;
import GUI.TouristTravellerGui;
import GUI.TravellerGui;
import weather.OpenWeatherMap;
import wikipedia.MediaWiki;

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


/**
 * This is main class
 *
 * @author it218110
 */

public class Main implements Serializable {
	
	
	private static final String filepath="obj.ser";
		
	
	
	// City(museums, cafes, weather, lat, lot)
//	static City athens = new City("athens", 40, 100, "rain", 103.321, 334.321);
//	static City thesaloniki = new City("thelsalloniki", 50, 300, "clear", 123.321, 534.311);
//	static City ioannina = new City("ioannina", 60, 600, "rain", 503.221, 134.921);

	
	
	public static void main(String args[]) throws IOException, SQLException {
		
		ArrayList <City> cities = new ArrayList<City>();
		Scanner string = new Scanner(System.in);
		Scanner integer = new Scanner(System.in);
		File file = new File("filename.txt");
		String line;
		String appid ="e9e0d5d96bd08a8c6d75d8b02a24b974";
		//RetrieveData("rome","it",appid,cities);
		//create_city(cities);
		
		makeJDBCConnection();
		ReadData(cities);
		
//		// City(museums, cafes, weather, lat, lot)
//		City athens = new City("athens", 40, 100, "rain", 103.321, 334.321);
//		City thesaloniki = new City("thelsalloniki", 50, 300, "clear", 123.321, 534.311);
//		City ioannina = new City("ioannina", 60, 600, "rain", 503.221, 134.921);
		City canditateCity = new City("", 0, 0, "", 0, 0);
		
		
		
		//Traveller(museums, cafes, weather, lat,  lon, name, age, currLatLon, plTravelers)
		String cityName="Rome"; int museums=0, cafes=0; String waether=null; double lat=7138.44789, lon=7138.44789; String name=null; int age=0; double currlatlon=0.0; int pltravelers=0;
		Business business = new Business(museums, cafes, waether, lat, lon, name, age, currlatlon, pltravelers);
		Tourist tourist = new Tourist(museums, cafes, waether, lat, lon, name, age, currlatlon, pltravelers);
		Traveller traveller2 = new Traveller(cityName, museums, cafes, waether, lat, lon, name, age, currlatlon, pltravelers);		
		
		ArrayList<Traveller> travellers = new ArrayList<>();
		//traveller2.read();
		Main objectIO = new Main();
		//objectIO.WriteObjectToFile(filepath, traveller2);
		
        //Read object from file
		objectIO.ReadObjectFromFile(filepath, travellers);
		
		print_travellers(travellers);
		
//		cities.add(thesaloniki);
//		cities.add(athens);
//		cities.add(ioannina);
		//new FormPanel();
		while (true) {
			//new MainMenu();
			System.out.println("note: you must firtst create city and traveller before doing anything else!");
			System.out.println("1.Create City\n2.Traveller\n3.Buissness Traveller\n4.Tourist Traveller\n5.Print Cities\n6.Show travellers\n7.Quit");
			String choice = string.nextLine();
			
			//String choice = FormPanel.getTmp();
			
			switch(choice) {
			case "1":
				create_city(cities);
				//new MainMenu();
				break;
			case "2":  //simple traveller
				
				System.out.println("1) Create Traveller \n2) Similarity \n3) Compaire cities \n4) print traveller \n5) free ticket \n6) back");
				int tmpchoice = integer.nextInt();
				int run =0;

				switch(tmpchoice) {
				case 1://create traveller
					Traveller traveller = new Traveller(cityName, museums, cafes, waether, lat, lon, name, age, currlatlon, pltravelers); // this is traveller
					//traveller=traveller2;
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
					
					
					if(check_travellers(travellers, traveller) == true) {
				        travellers.add(traveller);
				        objectIO.WriteObjectToFile(filepath, travellers);
					}else {
						System.out.println("this traveller already exists\n");
					}
					
					new MainMenu();
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
						System.out.println("give city name");
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
					//print_travellers(travellers);
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
				new MainMenu();
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
				new MainMenu();
				break;
			case "5":
				print_cities(cities);
				break;
			case "6"://sorting travellers
				Collections.sort(travellers);
				System.out.println("travellers after sorting : "); 
		        for (Traveller traveller3: travellers) 
		        { 
		            System.out.println(traveller3.getName() + " " + traveller3.getAge()); 
		        }
		        break;
			case "7":
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
		 OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
		 
		 System.out.println(city+" temperature: " + (weather_obj.getMain()).getTemp());
		 
		 System.out.println(city+" lat: " + weather_obj.getCoord().getLat()+" lon: " + weather_obj.getCoord().getLon());
		 
		 tmpcity.setWeather(weather_obj.getWeather().get(0).getMain());
		 //weather_obj.getWeather.get(0).getMain
		 
		 tmpcity.setLat(weather_obj.getCoord().getLat());
		 tmpcity.setLon(weather_obj.getCoord().getLon());
		 
		 MediaWiki mediaWiki_obj =  mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2"),MediaWiki.class);
		 
		 //System.out.println(city+" Wikipedia article: "+mediaWiki_obj.getQuery().getPages().get(0).getExtract());
		 
		 tmpcity.setMuseums(countOccurences(mediaWiki_obj.getQuery().getPages().get(0).getExtract(),"museums"));
		 
		 tmpcity.setCafes(countOccurences(mediaWiki_obj.getQuery().getPages().get(0).getExtract(),"Cafes"));
		 
		 System.out.println("musiums" + tmpcity.getMuseums());
		 System.out.println("cafes" + tmpcity.getCafes());
		// System.out.println(obj.getMain());
		 
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
				System.out.println("Congrats - Seems your MySQL JDBC Driver Registered!"); 
			} catch (ClassNotFoundException e) {
				System.out.println("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
				e.printStackTrace();
				return;
			}
	 
			try {
				// DriverManager: The basic service for managing a set of JDBC drivers.	 //We connect to a DBMS.
				db_con_obj = DriverManager.getConnection("jdbc:oracle:thin:@oracle12c.hua.gr:1521:orcl","it218110","it218110");// Returns a connection to the URL.
				//Attempts to establish a connection to the given database URL. The DriverManager attempts to select an appropriate driver from the set of registered JDBC drivers.
				if (db_con_obj != null) { 
					System.out.println("Connection Successful! Enjoy. Now it's time to CRUD data. ");
					
				} else {
					System.out.println("Failed to make connection!");
				}
			} catch (SQLException e) {
				System.out.println("MySQL Connection Failed!");
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
		Scanner sc = new Scanner(System.in);
		City tmp = null;
		for (int i=0; i<cities.size(); i++) {
			if (cities.get(i).getCityName().contentEquals(cityName)) {
				tmp = cities.get(i);
			}else {
				System.out.println("city not found");
				System.out.println("1) Do nothing\n2) Create a city");
				int noumero = sc.nextInt();
				switch(noumero) {
				case 1:
					break;
				case 2:
					try {
						create_city(cities, cityName);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				default:
					System.out.println("wrong option");
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
	
	
	
	
	
	
	
	static void create_city (ArrayList<City> cities) throws IOException {
		
		 Scanner string = new Scanner(System.in);
		 
		 //System.out.println("give the city you want to visit: ");
		 //new CreateCityNameGui();
		 String tmp = null;
		 String cityname = string.nextLine();

		 System.out.println("give the initials of the country the city is in: \n");
		 
		 if (equals(cities, cityname) == true) {
			 RetrieveData(cityname, tmp, "e9e0d5d96bd08a8c6d75d8b02a24b974", cities);
		 }else {
			 System.out.println("city already exist in database");
		 }

	}
	


	static void create_city (ArrayList<City> cities, String cityName) throws IOException {
		 Scanner string = new Scanner(System.in);
		 System.out.println("give the initials of the country the city is in: \n");
		 String ctryname = string.nextLine();
		 RetrieveData(cityName, ctryname, "e9e0d5d96bd08a8c6d75d8b02a24b974", cities);
	}

	
	
	
	
	
	public static boolean equals(ArrayList<City> cities, String cityName) {
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
	

	
}













/*





	
	private JButton createCity;
	private JButton traveller;
	private JButton buissnessTraveller;
	private JButton touristTraveller;
	private JButton printCities;
	private JButton showTravellers;
	private JButton quit;
	private JLabel note;
	
	private static String tmp;
	
	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250000;
		setPreferredSize(dim);
		
		createCity = new JButton("createCity");
		traveller = new JButton("traveller");
		buissnessTraveller = new JButton("buissnessTraveller");
		touristTraveller = new JButton("touristTraveller");
		printCities = new JButton("printCities");
		showTravellers = new JButton("showTravellers");
		quit = new JButton("quit");
		note = new JLabel("note: you must firtst create city and traveller before doing anything else!");
		
		createCity.addActionListener(this);
		traveller.addActionListener(this);
		buissnessTraveller.addActionListener(this);
		touristTraveller.addActionListener(this);
		printCities.addActionListener(this);
		showTravellers.addActionListener(this);
		quit.addActionListener(this);
		
//		Border innerBorder = BorderFactory.createTitledBorder("Main Menu");
//		Border outerBorder = BorderFactory.createEtchedBorder();
//		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		setBorder(BorderFactory.createTitledBorder("Main Menu"));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(createCity, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(traveller, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(buissnessTraveller, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(touristTraveller, gc);

		gc.gridx = 0;
		gc.gridy = 4;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(printCities, gc);
		
		gc.gridx = 0;
		gc.gridy = 5;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(showTravellers, gc);
		
		gc.gridx = 0;
		gc.gridy = 6;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(quit, gc);
		
		gc.gridx = 0;
		gc.gridy = 7;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(note);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		
		if (clicked == createCity) {
			tmp = "1";
		} else if (clicked == traveller){
			new TravellerGui();
		}else if (clicked == buissnessTraveller) {
			new BusinessTravellerGui();
		}else if (clicked == touristTraveller) {
			new TouristTravellerGui();
		}else if (clicked == printCities) {
			new PrintCitiesGui();
		}else if (clicked == showTravellers) {
			new ShowTravellersGui();
		}else if (clicked == quit) {
			
		}else {
			
		}
	}

	public static String getTmp() {
		return tmp;
	}

	public void setTmp(String tmp) {
		this.tmp = tmp;
	}
	
	*/
