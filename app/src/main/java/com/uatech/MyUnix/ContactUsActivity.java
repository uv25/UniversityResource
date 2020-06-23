package com.uatech.MyUnix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ContactUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        TextView textView = (TextView) findViewById(R.id.email_id);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    void sendMail()
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");
        intent.setPackage("com.google.android.gm");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"resourcesforuniversities@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback/Complaint/Suggestion");

        try {
            startActivity(Intent.createChooser(intent, "Send mail..."));
            //startActivity(intent);
            //Toast.makeText(ContactUsActivity.this, "Mail Sent!...", Toast.LENGTH_LONG).show();
            //finish();

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ContactUsActivity.this, "There is no email app installed.", Toast.LENGTH_LONG).show();
        }
    }
}
