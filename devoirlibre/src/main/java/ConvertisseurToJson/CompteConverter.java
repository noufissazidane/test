package ConvertisseurToJson;

import com.exemple.devoirlibre.compte;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;




public class CompteConverter {
	
	 public String toJson(compte compte) {
	        GsonBuilder gsonBuilder = new GsonBuilder();
	        gsonBuilder.setPrettyPrinting();
	        Gson gson = gsonBuilder.create();
	        return gson.toJson(compte);
	    }
	    public compte fromJson(String json) {
	        GsonBuilder gsonBuilder = new GsonBuilder();
	        gsonBuilder.setPrettyPrinting();
	        Gson gson = gsonBuilder.create();
	        return gson.fromJson(json, compte.class);
	    }

}
