import java.io.IOException;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import wikipedia.MediaWiki;

public class wiki_thread implements Runnable {
	
	String city;
	static int museums;
	static int cafes;
	static MediaWiki mediaWiki_obj;
	
	//constructor
	public wiki_thread(String city,int museums, int cafes, MediaWiki mediaWiki_obj) {
		this.city = city;
		wiki_thread.museums = museums;
		wiki_thread.cafes = cafes;
		wiki_thread.mediaWiki_obj = mediaWiki_obj;
	}
	
	@Override
	public void run() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			MediaWiki mediaWiki_obj =  mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2"),MediaWiki.class);
			System.out.println(mediaWiki_obj);
			museums = countOccurences(getMediaWiki_obj().getQuery().getPages().get(0).getExtract(), "museums");
			cafes = countOccurences(getMediaWiki_obj().getQuery().getPages().get(0).getExtract(), "cafes");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public static MediaWiki getMediaWiki_obj() {
		return mediaWiki_obj;
	}

	public void setMediaWiki_obj(MediaWiki mediaWiki_obj) {
		wiki_thread.mediaWiki_obj = mediaWiki_obj;
	}
	
	 public static int getMuseums() {
		return museums;
	}

	public void setMuseums(int museums) {
		wiki_thread.museums = museums;
	}

	public static int getCafes() {
		return cafes;
	}

	public void setCafes(int cafes) {
		wiki_thread.cafes = cafes;
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
	
}
