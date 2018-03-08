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

public class StudentMain extends AppCompatActivity {
    private Button BtnLogin1;

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    Button btnBack;
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);

        webview=(WebView)findViewById(R.id.webView1);
        webview.setWebViewClient(new MyWebViewClient());
        openURL();

        BtnLogin1=(Button)findViewById(R.id.std_update);
        BtnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stu_Main();
            }
        });

    }

    private void Stu_Main() {
        Intent intent = new Intent(StudentMain.this, StudentUpdate.class);
        startActivity(intent);
    }
    /** Opens the URL in a browser */
    private void openURL() {
        webview.loadUrl("http://nimitnagpal.000webhostapp.com/disp_std.php");
        webview.requestFocus();
    }
    @Override
    protected void onResume() {
        super.onResume();
        webview=(WebView)findViewById(R.id.webView1);
        webview.setWebViewClient(new MyWebViewClient());
        openURL();

        BtnLogin1=(Button)findViewById(R.id.std_update);
        BtnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stu_Main();
            }
        });
    }
}

