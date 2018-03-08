package com.example.nimitnagpal.iotconnect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Login extends AppCompatActivity {
    public static final String LOGIN_URL="http://nimitnagpal.000webhostapp.com/login1.php";;
    public static final String KEY_EMAIL="id";
    public static final String KEY_PASSWORD="password";
    public static final String LOGIN_Faculty="F";
    public static final String LOGIN_Student="S";
    public static final String LOGIN_TA="T";
    public static final String LOGIN_MS="M";
    public static final String SHARED_PREF_NAME="tech";
    public static final String EMAIL_SHARED_PREF="email";
    public static final String LOGGEDIN_SHARED_PREF="loggedin";
    private EditText editLoginId;
    private EditText editPass;
    private Button BtnLogin;
    private boolean loggedIn=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editLoginId=(EditText)findViewById(R.id.loginid);
        editPass=(EditText)findViewById(R.id.password);
        BtnLogin=(Button)findViewById(R.id.Btn_Login);
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        final String id = editLoginId.getText().toString().trim();
        final String password = editPass.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equalsIgnoreCase(LOGIN_Faculty)){

                            SharedPreferences sharedPreferences = Login.this.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            editor.putBoolean(LOGGEDIN_SHARED_PREF, true);
                            editor.putString(EMAIL_SHARED_PREF, id);

                            editor.commit();

                            Intent intent = new Intent(Login.this, DiscoverFaculty.class);
                            startActivity(intent);
                        }
                        else if(response.trim().equalsIgnoreCase(LOGIN_Student)) {

                            SharedPreferences sharedPreferences = Login.this.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            editor.putBoolean(LOGGEDIN_SHARED_PREF, true);
                            editor.putString(EMAIL_SHARED_PREF, id);

                            editor.commit();

                            Intent intent = new Intent(Login.this, DiscoverStudent.class);
                            startActivity(intent);
                        }
                        else if(response.trim().equalsIgnoreCase(LOGIN_TA)) {

                            SharedPreferences sharedPreferences = Login.this.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            editor.putBoolean(LOGGEDIN_SHARED_PREF, true);
                            editor.putString(EMAIL_SHARED_PREF, id);

                            editor.commit();

                            Intent intent = new Intent(Login.this, TaMain.class);
                            startActivity(intent);
                        }
                        else if(response.trim().equalsIgnoreCase(LOGIN_MS)) {

                            SharedPreferences sharedPreferences = Login.this.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            editor.putBoolean(LOGGEDIN_SHARED_PREF, true);
                            editor.putString(EMAIL_SHARED_PREF, id);

                            editor.commit();

                            Intent intent = new Intent(Login.this, MsMain.class);
                            startActivity(intent);
                            finish(); //To maintain time cycle, and not repeat on this page again
                        }
                        else{
                            Toast.makeText(Login.this, "Invalid Id or password", Toast.LENGTH_LONG).show();
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
                prams.put("password", password);

                return prams;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        loggedIn = sharedPreferences.getBoolean(LOGGEDIN_SHARED_PREF, false);
        if(loggedIn){
            Intent intent = new Intent(Login.this, Login.class);
            startActivity(intent);
            finish();
        }
    }
}

