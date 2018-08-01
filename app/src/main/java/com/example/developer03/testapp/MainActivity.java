package com.example.developer03.testapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MY_PREFS_NAME = "MyData";
    private EditText etFirstName,etLastName,etFavouriteFood,etFabouriteNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        etFirstName.setText(prefs.getString("firstName",null));
        etLastName.setText(prefs.getString("lastName",null));
        etFavouriteFood.setText(prefs.getString("favouriteFood",null));
        etFabouriteNum.setText(prefs.getString("favouriteNum",null));

    }

    public void onClick(View view){

        String firstName=etFirstName.getText().toString().trim();
        String lastName=etLastName.getText().toString().trim();
        String favouriteFood=etFavouriteFood.getText().toString().trim();
        String favouriteNumber= etFabouriteNum.getText().toString().trim();

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("firstName", firstName);
        editor.putString("lastName", lastName);
        editor.putString("favouriteFood", favouriteFood);
        editor.putString("favouriteNum", favouriteNumber);
        editor.apply();

        if (TextUtils.isEmpty(firstName)){

            etFirstName.setError("Please enter your first name");
        }else if (TextUtils.isEmpty(lastName)){

            etLastName.setError("Please enter your last name");
        }else if (TextUtils.isEmpty(favouriteFood)){

            etFavouriteFood.setError("Please enter your favourite food");
        }else if (TextUtils.isEmpty(favouriteNumber)){

            etFabouriteNum.setError("Please enter your favourite number");
        }else {

            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            Bundle bundle=new Bundle();
            bundle.putString("firstName",firstName);
            bundle.putString("lastName",lastName);
            bundle.putString("favouriteFood",favouriteFood);
            bundle.putInt("favouriteNum",Integer.parseInt(favouriteNumber));
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }

    private void findViewById() {
        etFirstName=(EditText)findViewById(R.id.et_first_name);
        etLastName=(EditText)findViewById(R.id.et_last_name);
        etFavouriteFood=(EditText)findViewById(R.id.et_favourite_food);
        etFabouriteNum=(EditText)findViewById(R.id.et_favourite_number);
    }
}
