
package ConvertisseurToJson;


import com.exemple.devoirlibre.client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class ClientConverter {
	
	public String toJson(client client) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.serializeNulls();
        Gson gson = gsonBuilder.create();
        return gson.toJson(client);
    }
    public client fromJson(String json) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.fromJson(json, client.class);
    }
}