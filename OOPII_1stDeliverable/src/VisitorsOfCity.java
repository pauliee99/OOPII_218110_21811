

import java.util.ArrayList;

public class VisitorsOfCity extends City {
	/**
	 * 
	 */
	
	
	int total;
    ArrayList<String> travellersnames= new ArrayList<String>();
	public VisitorsOfCity(String cityName, int museums, int cafes, String weather, double lat, double ion,ArrayList<String> travellersname) {
		super(cityName, museums, cafes, weather, lat, ion);
		
		this.travellersnames = travellersname;
		// TODO Auto-generated constructor stub
	}
	public ArrayList<String> getTravellersnames() {
		return travellersnames;
	}
	public void setTravellersnames(ArrayList<String> travellersnames) {
		this.travellersnames = travellersnames;
	}
	
	
	public String getTravellername(int i){
		return travellersnames.get(i);
	}
	public void setTravellername(String travellername){
		System.out.println(travellersnames);
		
		    	System.out.println("here");
		    	travellersnames.add(travellername) ;
		    }
	

	public int counttravellers(){
		int counter = 0;
		for (int i = 0; i < travellersnames.size(); i ++)
		    if (travellersnames.get(i) != null)
		        counter ++;
		return counter;
		
	}
}