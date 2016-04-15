package manjeet_hooda.news.fragment;

/**
 * Created by manjeet on 15/4/16.
 */
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import manjeet_hooda.news.Network.FetchNews;
import manjeet_hooda.news.R;
import manjeet_hooda.news.activity.MainActivity;
import manjeet_hooda.news.adapter.news_item_adapter;
import manjeet_hooda.news.model.news_item;
import manjeet_hooda.news.model.news_list;

public class top_news extends Fragment {

    private TextView mTextView;
    private RecyclerView mRecyclerView;
    private View view;
    private news_list mNewsList;
    private news_item_adapter mNewsAdapter;
    private FetchNews mFetchNews;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_news, container, false);

        setupRecyclerView();
        setupAdapter();
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mNewsList = new news_list();
        mFetchNews = new FetchNews(this,mNewsList.getNewsList());
        mFetchNews.execute("newsdefaultfeeds");
    }

    public void setupAdapter(){
        mNewsAdapter = new news_item_adapter(mNewsList.getNewsList());
        mRecyclerView.setAdapter(mNewsAdapter);
    }

    public void display(String str){
        Toast.makeText(getActivity(),str,Toast.LENGTH_LONG).show();
    }

    public void setupRecyclerView(){
        mRecyclerView = (RecyclerView)view.findViewById(R.id.news_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}