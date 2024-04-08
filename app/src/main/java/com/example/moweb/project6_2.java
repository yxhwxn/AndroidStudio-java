package com.example.moweb;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class project6_2 extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity6_2);

        final EditText urlEditText = findViewById(R.id.urlEditText);
        Button goButton = findViewById(R.id.goButton);
        Button backButton = findViewById(R.id.backButton);
        webView = findViewById(R.id.webview);

        webView.setWebViewClient(new WebViewClient()); // 클릭 시, 새 창이 아닌 웹뷰 내에서 페이지 로드
        webView.getSettings().setJavaScriptEnabled(true); // 자바스크립트 활성화

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = urlEditText.getText().toString();
                webView.loadUrl(url); // 입력된 URL 로드
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (webView.canGoBack()) {
                    webView.goBack(); // 이전 페이지로 돌아가기
                }
            }
        });
    }

}
