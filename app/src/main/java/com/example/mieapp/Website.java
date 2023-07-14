package com.example.mieapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Objects;

public class Website extends Fragment {

    private WebView webView;
    private SwipeRefreshLayout swipeRefreshLayout;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_website, container, false);

        CustomWebViewClient client = new CustomWebViewClient(getActivity());

        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        webView = view.findViewById(R.id.webView);
        webView.setWebViewClient(client);
        webView.getSettings().setJavaScriptEnabled(true);

        // Enable caching
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.reload();
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    swipeRefreshLayout.setRefreshing(false); // Stop the refreshing state
                }
            }
        });

        // Load a website
        webView.loadUrl("https://www.mie.edu.mw");

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        requireActivity().setTitle("Website");
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (webView.canGoBack()) {
                    webView.goBack(); // Go back in WebView history if possible
                } else {
                    // Let the system handle the back button press
                    requireActivity().onBackPressed();
                }
            }
        };
        onBackPressedDispatcher.addCallback(requireActivity(), callback);
    }

    class CustomWebViewClient extends WebViewClient {
        private final Activity activity;

        public CustomWebViewClient(Activity activity) {
            this.activity = activity;
        }

        // API level less than 24
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            return false;
        }

        // API level >= 24
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest request) {
            return false;
        }
    }
}
