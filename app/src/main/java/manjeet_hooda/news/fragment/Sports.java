package manjeet_hooda.news.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import manjeet_hooda.news.R;

/**
 * Created by manjeet on 15/4/16.
 */
public class Sports extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }
}
