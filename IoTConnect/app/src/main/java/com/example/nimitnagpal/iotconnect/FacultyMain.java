package com.example.nimitnagpal.iotconnect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class FacultyMain extends AppCompatActivity {
    private Button BtnLogin;

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_main);

        webview=(WebView)findViewById(R.id.webView);
        webview.setWebViewClient(new MyWebViewClient());
        openURL();

        BtnLogin=(Button)findViewById(R.id.Btn_Update);
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fac_Main();
            }
        });

    }

    private void Fac_Main() {
        Intent intent = new Intent(FacultyMain.this, FacultyUpdate.class);
        startActivity(intent);
    }
    /** Opens the URL in a browser */
    private void openURL() {
        webview.loadUrl("http://nimitnagpal.000webhostapp.com/disp_fac.php");
        webview.requestFocus();
    }
    @Override
    protected void onResume() {
        super.onResume();
        webview=(WebView)findViewById(R.id.webView);
        webview.setWebViewClient(new MyWebViewClient());
        openURL();

        BtnLogin=(Button)findViewById(R.id.Btn_Update);
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fac_Main();
            }
        });

    }
}

