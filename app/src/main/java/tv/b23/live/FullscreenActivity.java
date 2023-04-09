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
import com.google.android.material.snackbar.Snackbar;

//全屏模式的activity
public class FullscreenActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    public void displayLiveNaviPage() {
        final WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl("http://你自己的网站/live/");
    }

    public void switchScreenOrientationActivity() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//这个activity要强制横屏
        displayLiveNaviPage();

        FloatingActionButton fabBackLiveNavi = findViewById(R.id.backLiveNavi);
        fabBackLiveNavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayLiveNaviPage();
            }
        });
        FloatingActionButton fabSetScrOri = findViewById(R.id.setScrOri);
        fabSetScrOri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchScreenOrientationActivity();
                finish();
            }
        });
    }
}