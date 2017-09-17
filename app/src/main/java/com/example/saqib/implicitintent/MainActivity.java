package com.example.saqib.implicitintent;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            final EditText editText1 = findViewById(R.id.editText1);
            Button button1 = findViewById(R.id.button1);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = editText1.getText().toString();

                    /*
                    https://stackoverflow.com/questions/3004515/sending-an-intent-to-browser-to-open-specific-url
                    append http with the url otherwise it will give activitynotfoundexception
                     */
                    if (!url.startsWith("https://") && !url.startsWith("http://")){
                        url = "http://" + url;
                    }
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
            });




    }
}
