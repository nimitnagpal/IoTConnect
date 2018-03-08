package com.example.nimitnagpal.iotconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DiscoverStudent extends AppCompatActivity {
    private Button BtnLogin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_student);

        BtnLogin2=(Button)findViewById(R.id.discover2);
        BtnLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Std_Disc();
            }
        });

    }
    private void Std_Disc() {
        Intent intent = new Intent(DiscoverStudent.this,StudentMain.class);
        startActivity(intent);
    }
}
