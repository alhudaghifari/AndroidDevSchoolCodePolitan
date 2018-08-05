package com.alhudaghifari.codepolitanlite;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class DetailActivity extends AppCompatActivity {

    Artikel artikel;

    private LinearLayout layoutprogress;
    private ProgressBar progresbarweb;
    private ProgressDialog progdialog;

    private ActionBar aksibar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        layoutprogress = (LinearLayout) findViewById(R.id.layoutprogress);
        progresbarweb = (ProgressBar) findViewById(R.id.progressBarweb);

        artikel = getIntent().getParcelableExtra("ARTIKEL");

        aksibar = DetailActivity.this.getSupportActionBar();
        assert aksibar != null;
        aksibar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Detail Artikel");

        inisialiasiTampilan();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                DetailActivity.this.finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //MUNCUL PROGRES BAR
    private void munculProgressBar() {
        progdialog = new ProgressDialog(DetailActivity.this);
        progdialog.setMessage("Memuat data...");
        progdialog.setCancelable(false);
        progdialog.show();
    }


    public void inisialiasiTampilan() {
        munculProgressBar();

        WebView myWebView = (WebView) findViewById(R.id.browser);
        myWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int proses)
            {
                try {
                    if (layoutprogress != null && progresbarweb != null) {
                        layoutprogress.setVisibility(View.VISIBLE);
                        progresbarweb.setProgress(proses);

                        if (proses == 100) {
                            layoutprogress.setVisibility(View.GONE);
                            progresbarweb.setProgress(1);
                        } else if (proses > 40 && proses < 100) {
                            progdialog.dismiss();
                        } else {
                            layoutprogress.setVisibility(View.VISIBLE);
                        }
                    }
                } catch (Exception e) {
                    progdialog.dismiss();
                    e.printStackTrace();
                }
            }
        });
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl(artikel.getLink());
    }

}
