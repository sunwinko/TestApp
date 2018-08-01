package com.example.developer03.testapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private final int DISPLAY_TIME = 6000;
    private TextView txtResultShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtResultShow=(TextView)findViewById(R.id.txt_result_show);

        Bundle bundle=getIntent().getExtras();

        String firstName=bundle.getString("firstName");
        String lastName=bundle.getString("lastName");
        String favouriteFood=bundle.getString("favouriteFood");
        int favouriteNum=bundle.getInt("favouriteNum");

        if (isFibonacci(favouriteNum)==true){
            txtResultShow.setText("Hello "+firstName+", today is your lucky day with your favourite number "+favouriteNum);
        }else {
            txtResultShow.setText("Hello Mr/Ms "+lastName+", I love "+favouriteFood+" too. Lets go get that for lunch today.");
        }

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent main2Intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(main2Intent);
                finish();
            }
        }, DISPLAY_TIME);
    }

    public static boolean isFibonacci(int number){
        int a=0,b=0,c=1;
        for (int i=1;i<=100;i++){
            a=b;
            b=c;
            c=a+b;
            if (number<100){
                if (c==number){
                    return true;
                }
            }
        }
        return false;
    }
}
