package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import info.androidhive.materialdesign.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link courses.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link courses#newInstance} factory method to
 * create an instance of this fragment.
 */
public class courses extends Fragment {
    public WebView mWebView;

    public courses() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.courses, container, false);

        mWebView = (WebView) rootView.findViewById(R.id.web);
        mWebView.loadUrl("http://www.tdsb.on.ca/Findyour/Schools/Course.aspx?schno=3437#dnn_ctr2821_ContentPane");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());


        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}