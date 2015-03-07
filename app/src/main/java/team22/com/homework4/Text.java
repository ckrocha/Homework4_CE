package team22.com.homework4;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonParser;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Text extends ActionBarActivity {

    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
    }

    public void sendLocation(View view) throws MalformedURLException, IOException{
       Intent intent = new Intent(this,MainActivity.class);
       EditText text = (EditText) findViewById(R.id.location);

     /*   //Http Request
       String message = text.getText().toString();
        String address = "http://maps.googleapis.com/maps/api/geocode/json?address=" +
                parse(message) + "&key=AIzaSyBv1lyZriQgX5uBMmht9VINapov5CWtpwo";
        System.out.println(address);
       String result = GET(address);
        System.out.println(result);
        /*if (result == "Did not work") {
            //Debug
        }
        else {
            try {
                JSONObject json = new JSONObject(result);


            }  catch (JSONException e) {
                e.printStackTrace();
            }
        }*/
        startActivity(intent);
    }


    public String parse(String s){
        StringBuilder build = new StringBuilder();
        String[] magic = s.split("\\s+");

            for(int i = 0; i < magic.length;i++){
                if(i == magic.length-1) {
                    build.append(magic[i]);
                    break;
                }
                build.append(magic[i]);
                build.append("+");
            }
        return build.toString();
    }


    public static String GET(String link) throws MalformedURLException, IOException{

        StringBuilder response = new StringBuilder();
        URL url = new URL(link);

        HttpURLConnection httpURLConn = (HttpURLConnection) url.openConnection();
        try {
            if (httpURLConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader input = new BufferedReader(new InputStreamReader(httpURLConn.getInputStream()), 8192);
                String strLine = null;
                while ((strLine = input.readLine()) != null) {
                    response.append(strLine);
                }
                input.close();
            }
        } catch (IOException e){
            //Do something
            System.out.println("Error Here");
        }
        return response.toString();

        /*InputStream inputStream = null;
        String result = "";
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
            inputStream = httpResponse.getEntity().getContent();
            if (inputStream != null) {result=convertInputStreamToString(inputStream);}
            else {result = "Did not work";}
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());}

        return result;*/
    }



    public static String convertInputStreamToString(InputStream input) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null) {
            result += line;
        }
        input.close();
        return result;



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_text, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
