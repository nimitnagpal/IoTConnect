package com.example.nimitnagpal.iotconnect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class FacultyUpdate extends AppCompatActivity {
    public static final String LOGIN_URL_ON="http://nimitnagpal.000webhostapp.com/device_on.php";;
    public static final String KEY_DEVICE="id";
    public static final String SHARED_PREF_NAME="tech";
    public static final String EMAIL_SHARED_PREF="email";
    public static final String LOGGEDIN_SHARED_PREF="loggedin";
    private EditText Device_id;
    private Switch Switch_Update;
    private Button BtnLogout;
    private boolean loggedIn=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_update);
        Device_id = (EditText) findViewById(R.id.fac_enter);
        Switch_Update = (Switch) findViewById(R.id.switch1);

        Switch_Update.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean ischecked)
            {
                boolean a = ischecked;

                device_update(a);

                            }
        });
        BtnLogout=(Button)findViewById(R.id.btn_logout);
        BtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fac_Logout();
            }
        });
    }

    private void Fac_Logout() {


        SharedPreferences sharedPreferences = FacultyUpdate.this.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(LOGGEDIN_SHARED_PREF, false);  //Initially setting it to false
        editor.putString(EMAIL_SHARED_PREF, null);      //Initially setting it to Null

        editor.commit();

        Intent intent = new Intent(getApplicationContext(), Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //Finishing Clear activity flag here only
        startActivity(intent);
        finish();
    }


    private void device_update(final boolean a){
        final String id = Device_id.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL_ON,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {

                        if (a) {

                            SharedPreferences sharedPreferences = FacultyUpdate.this.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            editor.putBoolean(LOGGEDIN_SHARED_PREF, true);
                            editor.putString(EMAIL_SHARED_PREF, id);

                            editor.commit();
                            Toast.makeText(FacultyUpdate.this, "Status Updated!", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(FacultyUpdate.this, FacultyMain.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(FacultyUpdate.this, "Device status updated!", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> prams = new HashMap<>();
                prams.put("id",id);

                return prams;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
    @Override
    protected void onResume() {
        super.onResume();
        BtnLogout=(Button)findViewById(R.id.btn_logout);
        BtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fac_Logout();
            }
        });

    }



}
