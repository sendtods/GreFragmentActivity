package com.pmapps.grefragmentactivity;

import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements FragmentPicture.OnTextChangedListener{
    Button btnNext,btnPrevious;
    String TVnumber;
    Integer tvnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNext = (Button)findViewById(R.id.btnNext);
        btnPrevious = (Button)findViewById(R.id.btnPrevious);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              TVnumber = GetTextFromTVDisplay();
              tvnum = Integer.parseInt(TVnumber);
                if(tvnum==10)
                {
                    Toast.makeText(MainActivity.this,"Last Number!Can't Go Beyond That",Toast.LENGTH_LONG).show();
                }else
                {   tvnum = tvnum + 1;
                    TVnumber = tvnum.toString();
                    FragmentPicture f1 = (FragmentPicture)getSupportFragmentManager().findFragmentById(R.id.fragment_id);
                    f1.updateTVDisplay(TVnumber);

                }
            }
        });
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TVnumber = GetTextFromTVDisplay();
                tvnum = Integer.parseInt(TVnumber);
                if(tvnum==1)
                {
                    Toast.makeText(MainActivity.this,"First Number!Can't Go Beyond That",Toast.LENGTH_LONG).show();
                }else
                {   tvnum = tvnum - 1;
                    TVnumber = tvnum.toString();
                    FragmentPicture f1 = (FragmentPicture)getSupportFragmentManager().findFragmentById(R.id.fragment_id);
                    f1.updateTVDisplay(TVnumber);

                }
            }
        });
    }



    @Override
    public String GetTextFromTVDisplay() {
        FragmentPicture f1 = (FragmentPicture)getSupportFragmentManager().findFragmentById(R.id.fragment_id);
        return f1.GetTextFromDisplay();
    }
}
