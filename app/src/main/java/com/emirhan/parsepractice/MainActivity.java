package com.emirhan.parsepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Put Data to database
      /*  ParseObject object = new ParseObject("Fruits");
        object.put("name", "banane");
        object.put("calories", 120);
        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e!=null){
                    Toast.makeText(getApplicationContext(), e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Loaded Successfully",Toast.LENGTH_LONG).show();

                }
            }
        });

        //Its inconvenient because we have to know the UID of the object but its a way at least
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Fruits");
        query.getInBackground("1OGfato8FX", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if(e!=null){
                    Toast.makeText(getApplicationContext(), e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Got Successfully",Toast.LENGTH_LONG).show();
                    String a = object.getString("name");
                    int b = object.getInt("calories");
                    System.out.println(a+b);
                }
            }
        }); */

      ParseQuery<ParseObject> query = ParseQuery.getQuery("Fruits");
      //we can filter by usign whereEqualto methods
      //query.whereEqualTo("name","banane");
        //query.whereGreaterThan("calories", 100);
      query.findInBackground(new FindCallback<ParseObject>() {
          @Override
          public void done(List<ParseObject> objects, ParseException e) {
              if(e != null){
                  e.printStackTrace();
              }
              else {
                  if(objects.size() > 0){
                       for(ParseObject object : objects ){
                           String objectName = object.getString("name");
                           int calories = object.getInt("calories");
                           System.out.println(objectName + " includes " + calories);
                       }
                  }
              }
          }
      });


      // USER USER USER sign up
     /*   ParseUser user = new ParseUser();

        user.setUsername("emir");
        user.setPassword("123456");
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e != null){
                    Toast.makeText(MainActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Signed up successfully",Toast.LENGTH_LONG).show();

                }
            }
        });*/

     //User sign in
        ParseUser.logInInBackground("emir", "123456", new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e != null){
                    Toast.makeText(MainActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(MainActivity.this,user.getUsername() + " Logged in successfully",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}