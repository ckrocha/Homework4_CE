package team22.com.homework4;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Text extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
    }



    public String geocode(String addr){
        HttpClient h = new DefaultHttpClient();
        HttpGet res = new HttpGet(addr);
        HttpResponse response;
        String end = " ";
        JSONObject j;


        try {
            response = h.execute(res);

            HttpEntity ent = response.getEntity();
            String entity = EntityUtils.toString(ent);
            //InputStream in = ent.getContent();

            j = new JSONObject(entity);
            int Lat = (int) j.get("lat");
            int Long = (int) j.get("lng");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return " ";
    }
    public void sendLocation(View view){
        Intent intent = new Intent(this,MainActivity.class);
        EditText text = (EditText) findViewById(R.id.location);
        String message = text.getText().toString();
        String address = "http://maps.googleapis.com/maps/api/geocode/json?address=" +
                parse(message) + "&key=AIzaSyBv1lyZriQgX5uBMmht9VINapov5CWtpwo";

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
