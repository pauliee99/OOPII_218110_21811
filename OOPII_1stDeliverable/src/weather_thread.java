import java.io.IOException;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import weather.OpenWeatherMap;

public class weather_thread implements Runnable{
	
	String city;
	String country;
	String appid;
	static OpenWeatherMap weather_obj;
	
	public weather_thread(String city, String country, String appid, OpenWeatherMap weather_obj) {
		this.city = city;
		this.country = country;
		this.appid = appid;
		weather_thread.weather_obj = weather_obj;
	}
	

	@Override
	public void run(){		 
		ObjectMapper mapper = new ObjectMapper();
		try {
			weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(city+" temperature: " + (weather_obj.getMain()).getTemp());
		System.out.println(city+" lat: " + weather_obj.getCoord().getLat()+" lon: " + weather_obj.getCoord().getLon());
	}
	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public static OpenWeatherMap getWeather_obj() {
		return weather_obj;
	}

	public void setWeather_obj(OpenWeatherMap weather_obj) {
		weather_thread.weather_obj = weather_obj;
	}
	
	
	
}
