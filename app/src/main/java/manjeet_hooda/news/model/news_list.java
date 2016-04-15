package manjeet_hooda.news.model;

import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by manjeet on 15/4/16.
 */
public class news_list {

    private ArrayList<news_item> newsList;

    public news_list(){
        newsList = new ArrayList<>();
    }

    public void addNews(news_item news){
        newsList.add(news);
    }

    public int getCount(){
        return newsList.size();
    }

    public ArrayList<news_item> getNewsList(){
        return newsList;
    }

}
