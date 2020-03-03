package OOPII_1stDeliverable;

public class Traveller {
	String name;
	int age;
	double currLatLon;
	int plTravelers;
	
	public Traveller(String name, int age, double currLatLon, int plTravelers) {
		super();
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
	
	public int Similarity() {
		int similarity = 0;
		
		return similarity;
		
	}
	
}
