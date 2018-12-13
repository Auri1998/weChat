package Thread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import Util.HttpHelp;

/**
 * Created by asus on 2018-12-12.
 */
public class ImageHttpThread {
    private String imageUrl;
    private Bitmap resultBitmap;
    public ImageHttpThread(String imageUrl){
        this.imageUrl=imageUrl;
    }
    public void run(){
        try{
            URL url=new URL(HttpHelp.URL+imageUrl);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            setResultBitmap(BitmapFactory.decodeStream(inputStream));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Bitmap getResultBitmap() {
        return resultBitmap;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setResultBitmap(Bitmap resultBitmap) {
        this.resultBitmap = resultBitmap;
    }
}
