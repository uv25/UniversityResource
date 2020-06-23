package com.uatech.MyUnix;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class WebViewActivity extends AppCompatActivity {

    AdView mAdView;
    WebView webView;
    //String url = "https://drive.google.com/file/d/1GFCwIlz9SRiBmneY-kUewN35FxmAfl6b/view?usp=sharing";
    String url = "https://brpaper.com/downloader/MTg0MjI=";
    ProgressBar progressBar;
    Button downloadButton;
    TextView download_textView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        progressBar = (ProgressBar) findViewById(R.id.webview_progress);
        downloadButton = (Button) findViewById(R.id.download_button);
        download_textView = (TextView) findViewById(R.id.download_textview);

        webView = (WebView) findViewById(R.id.webView);
        //webView.getSettings().setJavaScriptEnabled(true);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);



        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                progressBar.setVisibility(View.VISIBLE);
                setTitle("Loading...");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                progressBar.setVisibility(View.GONE);
            }
        });
        //webView.loadUrl("https://stackoverflow.com/questions/32984955/how-to-open-web-page-within-my-app");
        //webView.loadUrl("https://brpaper.com/downloader/MTg0MjI=");
        //webView.loadUrl("https://drive.google.com/open?id=1GFCwIlz9SRiBmneY-kUewN35FxmAfl6b");
        //webView.loadUrl("https://drive.google.com/file/d/1GFCwIlz9SRiBmneY-kUewN35FxmAfl6b/view?usp=sharing");

        if (BluePrint.currentNode.url.contains("drive.google.com"))
        {
            Log.d("url value for if : ", BluePrint.currentNode.url);
            webView.loadUrl(BluePrint.currentNode.url);
        }
        else
        {
            Log.d("url value for else : ", BluePrint.currentNode.url);
            downloadButton.setVisibility(View.VISIBLE);
            download_textView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
            downloadButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    webView.loadUrl(BluePrint.currentNode.url);
                    onBackPressed();
                }
            });
        }


        webView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimeType,
                                        long contentLength) {
                /*Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);*/

                //registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

                DownloadManager.Request request = new DownloadManager.Request(
                        Uri.parse(url));
                request.setMimeType(mimeType);
                String cookies = CookieManager.getInstance().getCookie(url);
                request.addRequestHeader("cookie", cookies);
                request.addRequestHeader("User-Agent", userAgent);
                request.setDescription("Downloading File...");
                request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimeType));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(
                         "/MyUniversity", URLUtil.guessFileName(
                                url, contentDisposition, mimeType));
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Toast.makeText(getApplicationContext(), "Downloading File", Toast.LENGTH_LONG).show();


            }


        });




        //webView.setWebViewClient(new MyWebViewClient());
        /*webView.setWebChromeClient(new WebChromeClient() );

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);

        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);

        webView.setInitialScale(30);
        webView.loadUrl(BluePrint.currentNode.url);*/
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack())
        {
            webView.goBack();
        }
        else
        {
            super.onBackPressed();
            BluePrint.backTraversal();
        }
    }

}
