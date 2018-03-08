package com.example.nimitnagpal.iotconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class DiscoverFaculty extends AppCompatActivity {
    private Button BtnLogin1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_faculty);

        BtnLogin1=(Button)findViewById(R.id.discover1);
        BtnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fac_Disc();
            }
        });

    }
    private void Fac_Disc() {
        Intent intent = new Intent(DiscoverFaculty.this, FacultyMain.class);
        startActivity(intent);
    }
    protected void onResume() {
        super.onResume();
        BtnLogin1=(Button)findViewById(R.id.discover1);
        BtnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fac_Disc();
            }
        });

    }
}
