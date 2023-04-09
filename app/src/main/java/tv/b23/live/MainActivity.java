package tv.b23.live;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//正常情况下屏幕方向为竖屏
public class MainActivity extends AppCompatActivity {

    //让webview显示主页
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
        intent.setClass(this, FullscreenActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayLiveNaviPage();

        //浮动按钮的行动
        ExtendedFloatingActionButton fabBackLiveNavi = findViewById(R.id.backLiveNavi);
        fabBackLiveNavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "返回导航页", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
                displayLiveNaviPage();
            }
        });
        ExtendedFloatingActionButton fabSetScrOri = findViewById(R.id.setScrOri);
        fabSetScrOri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchScreenOrientationActivity();
                finish();
            }
        });
    }
}