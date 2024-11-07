package ConvertisseurToJson;


import com.exemple.devoirlibre.transaction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class TransactionConverter {

	  public String toJson(transaction transaction) {
	        GsonBuilder gsonBuilder = new GsonBuilder();
	        gsonBuilder.setPrettyPrinting();
	        Gson gson = gsonBuilder.create();
	        return gson.toJson(transaction);
	    }

	    public transaction fromJson(String json) {
	        GsonBuilder gsonBuilder = new GsonBuilder();
	        gsonBuilder.setPrettyPrinting();
	        Gson gson = gsonBuilder.create();
	        return gson.fromJson(json, transaction.class);
	    }}
