package com.btzw.fortunecookie;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class cookie extends AppCompatActivity {

    String fortuneText;
    TextView txtFortune;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookie);

    }


    public void fortune(View view) throws FileNotFoundException{
        List<String> quotes = new ArrayList<String>();
        txtFortune =(TextView)findViewById(R.id.fortune_text);
        String result = "";

        try {
            Resources res = getResources();

            Scanner scan = new Scanner(res.openRawResource(R.raw.quotes));

            while (scan.hasNextLine()) {
                 quotes.add(scan.nextLine());
            }
        }
        catch(Exception e){
                e.getMessage();
            }

        Random random = new Random();
        int listSize = quotes.size();
        int randomIndex = random.nextInt(listSize);

        fortuneText = quotes.get(randomIndex);
        txtFortune.setText(fortuneText.toString());

        }
}
