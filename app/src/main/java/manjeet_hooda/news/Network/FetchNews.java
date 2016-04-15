package manjeet_hooda.news.Network;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

import manjeet_hooda.news.R;
import manjeet_hooda.news.activity.MainActivity;
import manjeet_hooda.news.fragment.top_news;
import manjeet_hooda.news.model.news_item;

/**
 * Created by manjeet on 15/4/16.
 */
public class FetchNews extends AsyncTask<String, Void, Void> {

    private static final String NEWS_API =
            "http://timesofindia.indiatimes.com/feeds/";

    private String feedType = ".cms?feedtype=sjson";

    private top_news fragment;
    private JSONObject data;
    private ArrayList<news_item> list;

    public FetchNews(top_news fragment, ArrayList<news_item> list) {
        this.fragment = fragment;
        this.list = list;
    }

    @Override
    public Void doInBackground(String... params) {
        try {
            String newsType = params[0];
            URL url = new URL(String.format(NEWS_API + newsType + feedType));
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();


            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp = "";
            while ((tmp = reader.readLine()) != null)
                json.append(tmp).append("\n");
            reader.close();

            data = new JSONObject(json.toString());

            // This value will be 404 if the request was not
            // successful
            if (data.getInt("cod") != 200) {
                return null;
            }
            formList(data);
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    private void formList(JSONObject json){
        try {
            JSONArray newsItem = json.getJSONArray("NewsItem");
            int length  = newsItem.length();
            for(int i =0; i<length; i++){
                JSONObject news_json = newsItem.getJSONObject(i);
                news_item news = new news_item();
                news.setHeadline(news_json.getString("Headline"));
                news.setCaption(news_json.getString("Caption"));
                news.setDate(news_json.getString("Dateline"));
                news.setmUrl(news_json.getString("WebURL"));
                news.setNewsId(news_json.getLong("NewsItemId"));
                list.add(news);
            }
        }catch(Exception e){
            Log.e("News", "One or more fields not found in the JSON data");
        }
    }

    @Override
    protected void onPostExecute(Void avoid){
        super.onPostExecute(avoid);
        fragment.display(list.get(0).getHeadline());
    }
}
