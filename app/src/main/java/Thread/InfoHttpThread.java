package Thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Bean.HttpMethod;
import Util.HttpHelp;

/**
 * Created by asus on 2018-12-12.
 */
public class InfoHttpThread {
    private String result;
    public void run(){
        try {
            URL url = new URL(HttpHelp.URL+"info");
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod(String.valueOf(HttpMethod.GET));
            httpURLConnection.setConnectTimeout(HttpHelp.TIME_OUT);
            InputStream is=httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(is,"utf-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer=new StringBuffer();
            String temp;
            while ((temp=bufferedReader.readLine())!=null){
                stringBuffer.append(temp);
            }
            setResult(stringBuffer.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String getResult() {
        return result;
    }
}
