package tv.b23.live;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

//正常情况下屏幕方向为竖屏
public class MainActivity extends AppCompatActivity {
    private WebView webView;
    final static String LiveNaviPageURL=MyStrings.你自己的网站;

    //让webview显示主页
    @SuppressLint("SetJavaScriptEnabled")
    public void displayLiveNaviPage() {
        webView.loadUrl(LiveNaviPageURL);
    }

    public void switchScreenOrientationActivity() {
        Intent intent = new Intent();
        intent.setClass(this, FullscreenActivity.class);
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
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        displayLiveNaviPage();

        Button buttonGoBackPage=findViewById(R.id.goBackPage);
        buttonGoBackPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goBack();
            }
        });
        Button buttonBackLiveNavi=findViewById(R.id.backLiveNavi);
        buttonBackLiveNavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayLiveNaviPage();
            }
        });
        Button buttonSetScrOri=findViewById(R.id.setScrOri);
        buttonSetScrOri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchScreenOrientationActivity();
                finish();
            }
        });

        //浮动按钮的行动 (准备弃用)
//        ExtendedFloatingActionButton fabBackLiveNavi = findViewById(R.id.fabBackLiveNavi);
//        fabBackLiveNavi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "返回导航页", Snackbar.LENGTH_SHORT)
//                        .setAction("Action", null).show();
//                displayLiveNaviPage();
//            }
//        });
//        ExtendedFloatingActionButton fabSetScrOri = findViewById(R.id.fabSetScrOri);
//        fabSetScrOri.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switchScreenOrientationActivity();
//                finish();
//            }
//        });
//        ExtendedFloatingActionButton fabGoBackPage = findViewById(R.id.fabGoBackPage);
//        fabGoBackPage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                webView.goBack();
//            }
//        });
    }
}