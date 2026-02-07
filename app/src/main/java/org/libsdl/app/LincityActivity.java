package org.libsdl.app;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class LincityActivity extends SDLActivity {
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize Mobile Ads SDK
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        // Create AdView
        adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        // Sample Ad Unit ID for Banner
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");

        // Add AdView to the layout
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        // Position the ad at the bottom of the screen
        FrameLayout.LayoutParams adParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT,
                Gravity.BOTTOM);

        // Get the SDL layout and add the adView to it
        ViewGroup layout = (ViewGroup) mLayout;
        layout.addView(adView, adParams);
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}
