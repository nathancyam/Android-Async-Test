package edu.billkas.MultiscreenActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.ListActivity;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

public class ServerLink {
	
	public static final String rootURL = "http://10.0.2.2/core";

    public static Articles[] getData(){
        String oput;
        Articles[] articlesA = null;
        Log.i("ServerLink.java","ServerLink.ArticlesAsync() Running");
        try{
            // HttpClient is the main class that allows the ability to GET, POST, PUT and DELETE data from a webservice
            HttpClient httpclient = new DefaultHttpClient();

            // Here we connect with the /articles section of the webservice and define the header as JSON
            HttpGet getRequest = new HttpGet(rootURL + "/articles/");
            getRequest.addHeader("accept", "application/json");

            // Finally we use HttpResponse to execute the request
            HttpResponse response = httpclient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }

            // We use buffered reader to read from the Input stream
            System.out.println("nya - bufferedreader");
            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            System.out.println("Output from Server .... \n");

            if((oput = br.readLine()) != null) {
                articlesA = processJSONintoArray(oput, articlesA);
            }
            else {
                System.out.println("Nothing found");
            }
            httpclient.getConnectionManager().shutdown();
        }
        catch (ClientProtocolException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        catch (Exception e){
            // do some thing
            e.printStackTrace();
            return null;
        }
        System.out.println("ServerLink.ArticlesAsync() Finished");
        return articlesA;
    }

	public static void postData(String str_Title, String str_Date){
		String output;
        try{
            DefaultHttpClient httpClient = new DefaultHttpClient();
            Log.i("User Debug","NYA: Getting localhost...");
            HttpPost postRequest = new HttpPost(rootURL + "/article/");

            Log.i("User Debug","NYA: {\"title\":\"" + str_Title + "\",\"date\":\"" + str_Date + "\"}");
            StringEntity input = new StringEntity("{\"title\":\"" + str_Title + "\",\"date\":\"" + str_Date + "\"}");

            Log.i("User Debug",input.toString());
            input.setContentType("application/json");
            postRequest.setEntity(input);

            Log.i("User Debug","NYA: Executing postRequest");
            HttpResponse response = httpClient.execute(postRequest);

            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            httpClient.getConnectionManager().shutdown();
        }
        catch (Exception e){
            e.printStackTrace();
        }
	}

	protected static Articles[] processJSONintoArray(String oput, Articles[] art_Array) {
		System.out.println("ServerLink.processJSONintoArray Running");
		System.out.println(oput);
		try{
			JSONObject obj = new JSONObject(oput);
			JSONArray articleArray = obj.getJSONArray("articles");
			art_Array = new Articles[articleArray.length()];
			for(int i=0; i < articleArray.length(); i++){
				art_Array[i] = new Articles();
				art_Array[i].id = Integer.parseInt(articleArray.getJSONObject(i).getString("id"));
				art_Array[i].title = articleArray.getJSONObject(i).getString("title");
				art_Array[i].date = articleArray.getJSONObject(i).getString("date");
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("ServerLink.processJSONintoArray Finished");
		return art_Array; 
	}
}
