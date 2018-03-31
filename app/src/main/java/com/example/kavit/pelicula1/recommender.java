package com.example.kavit.pelicula1;

/**
 * Created by kavit on 30-09-2017.
 */
import android.text.TextUtils;
import android.util.Log;
import android.util.MalformedJsonException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.example.kavit.pelicula1.R.id.rec_name; //change
import static com.example.kavit.pelicula1.R.id.rec_genre; //change

/**
 * Created by deepak on 10/12/2016.
*/

// public final class recommender {
// public static final String LOG_TAG = recommender.class.getSimpleName();
//
// private recommender() {
// }
//
// public static List<Movie> fetchWeatherData(String requestUrl){
// URL url = createUrl(requestUrl);
// String jsonResponse = null;
// try
// {
// jsonResponse = makehttpRequest(url);
// }catch (IOException e){
// Log.e(LOG_TAG, "Error in making http request", e);
// }
// List<Movie> result = extractEarthquakes(jsonResponse);
// return result;
// }
// private static URL createUrl(String stringUrl){
// URL url = null;
// try
// {
// url = new URL(stringUrl);
// }catch (MalformedURLException e){
// Log.e(LOG_TAG,"Error in Creating URL",e);
// }
// return url;
// }
//
// private static String makehttpRequest(URL url) throws IOException{
// String jsonResponse = "";
// if(url == null){
// return jsonResponse;
// }
//
// HttpURLConnection urlConnection = null;
// InputStream inputStream = null;
// try {
// urlConnection = (HttpURLConnection) url.openConnection();
// urlConnection.setReadTimeout(10000 /* milliseconds */);
//            urlConnection.setConnectTimeout(15000 /* milliseconds */);
//            urlConnection.setRequestMethod("GET");
//            urlConnection.connect();
//
//            if (urlConnection.getResponseCode() == 200) {
//                inputStream = urlConnection.getInputStream();
//                jsonResponse = readFromStream(inputStream);
//            } else {
//                Log.e(LOG_TAG, "Error in connection!! Bad Response ");
//            }
//
//        }catch (IOException e){
//            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
//        } finally {
//            if(urlConnection != null){
//                urlConnection.disconnect();
//            }
//            if(inputStream != null){
//                inputStream.close();
//            }
//        }
//
//        return jsonResponse;
//
//    }
//    private static String readFromStream(InputStream inputStream) throws IOException{
//        StringBuilder output = new StringBuilder();
//        if (inputStream != null) {
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
//            BufferedReader reader = new BufferedReader(inputStreamReader);
//            String line = reader.readLine();
//            while (line != null) {
//                output.append(line);
//                line = reader.readLine();
//            }
//        }
//        return output.toString();
//    }
//    private static List<Movie> extractEarthquakes(String earthquakeJSON){ //change
//        if (TextUtils.isEmpty(earthquakeJSON)) {
//            return null;
//        }
//        ArrayList<Movie> earthquakes = new ArrayList<>(); //change
//        try {
//            JSONObject baseJsonResponse = new JSONObject(earthquakeJSON);
//            JSONArray featureArray = baseJsonResponse.getJSONArray("features");
//
//            for (int i = 0; i < featureArray.length(); i++) {
//                JSONObject currentEarthquake = featureArray.getJSONObject(i);
//                JSONObject properties = currentEarthquake.getJSONObject("properties");
//
//                double magnitude = properties.getDouble("mag");
//                String location = properties.getString("place");
//                long time = properties.getLong("time");
//                String Url = properties.getString("url");
//                Movie earthquake = new Movie(location, location, Url);
//                earthquakes.add(earthquake);
//            }
//
//        }catch (JSONException e){
//            Log.e(LOG_TAG,"Error in fetching data",e);
//        }
//        return earthquakes;
//    }
//
//}
//
