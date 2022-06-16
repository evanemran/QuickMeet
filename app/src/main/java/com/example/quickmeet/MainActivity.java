package com.example.quickmeet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton_join;
    EditText editText_room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_room = findViewById(R.id.editText_room);
        imageButton_join = findViewById(R.id.imageButton_join);

        try {
            // object creation of JitsiMeetConferenceOptions
            // class by the name of options
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(new URL(""))
                    .setWelcomePageEnabled(false)
                    .build();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        imageButton_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText_room.getText().toString();
                if (text.length() > 0) {
                    JitsiMeetConferenceOptions options
                            = new JitsiMeetConferenceOptions.Builder()
                            .setRoom(text)
                            .build();
                    JitsiMeetActivity.launch(MainActivity.this, options);
                }
            }
        }
        );

    }
}