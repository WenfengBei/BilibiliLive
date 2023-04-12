package tv.b23.live;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

//全屏模式的activity
public class FullscreenActivity extends AppCompatActivity {
    private WebView webView;
    final static String LiveNaviPageURL=MyStrings.你自己的网站;

    @SuppressLint("SetJavaScriptEnabled")
    public void displayLiveNaviPage() {
        webView.loadUrl(LiveNaviPageURL);
    }

    public void switchScreenOrientationActivity() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    };

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//这个activity要强制横屏

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        displayLiveNaviPage();

        FloatingActionButton fabGoBackPage = findViewById(R.id.fabGoBackPage);
        fabGoBackPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.goBack();
            }
        });
        FloatingActionButton fabBackLiveNavi = findViewById(R.id.fabBackLiveNavi);
        fabBackLiveNavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayLiveNaviPage();
            }
        });
        FloatingActionButton fabSetScrOri = findViewById(R.id.fabSetScrOri);
        fabSetScrOri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchScreenOrientationActivity();
                finish();
            }
        });
    }
}