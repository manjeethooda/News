package manjeet_hooda.news.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by manjeet on 15/4/16.
 */
public class news_item implements Parcelable{

    private long newsId;
    private String mHeadline;
    private String mDate;
    private String mUrl;
    private String mCaption;

    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setmUrl(String Url) {
        this.mUrl = Url;
    }

    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String mCaption) {
        this.mCaption = mCaption;
    }

    public void setHeadline(String Headline){
        this.mHeadline = Headline;
    }

    public String getHeadline(){
        return mHeadline;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int i) {
        out.writeLong(newsId);
        out.writeString(mHeadline);
        out.writeString(mCaption);
        out.writeString(mDate);
        out.writeString(mUrl);
    }

    public static final Creator<news_item> CREATOR = new Creator<news_item>() {
        @Override
        public news_item createFromParcel(Parcel parcel) {
            return new news_item(parcel);
        }

        @Override
        public news_item[] newArray(int i) {
            return new news_item[i];
        }
    };

    private news_item (Parcel in) {
        newsId = in.readInt();
        mHeadline = in.readString();
        mCaption = in.readString();
        mDate = in.readString();
        mUrl = in.readString();
    }

    public news_item () {}

}
