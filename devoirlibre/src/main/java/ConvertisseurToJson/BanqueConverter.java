package ConvertisseurToJson;


import com.exemple.devoirlibre.banque;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class BanqueConverter {
	
	public String toJson(banque banque ) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.serializeNulls();
        Gson gson =gsonBuilder.create();
        return gson.toJson(banque);
    }
    public banque fromJson(String json) {
        Gson gson =new GsonBuilder().create();
        return gson.fromJson(json, banque.class);
    }

}

