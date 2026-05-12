package com.roselio.pixelzenkaiclicker;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView webView = getBridge().getWebView();
        WebSettings settings = webView.getSettings();

        // localStorage and DOM storage
        settings.setDomStorageEnabled(true);

        // Allow media autoplay (needed for MP4 cutscenes and music unlock)
        settings.setMediaPlaybackRequiresUserGesture(false);

        // Allow mixed content (needed when loading local assets)
        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        // Hardware acceleration for canvas/sprite rendering
        webView.setLayerType(WebView.LAYER_TYPE_HARDWARE, null);

        // Allow file access from local assets
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
    }
}
