package com.example.asus.pyquan;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;
import Thread.InfoHttpThread;
import Thread.ImageHttpThread;
import Bean.User;
import Adapter.infoAdapter;
import com.alibaba.fastjson.JSON;

public class readPY extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_py);
        InfoHttpThread infoHttpThread=new InfoHttpThread();
        infoHttpThread.start();
        try{
            infoHttpThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        List<User> list= JSON.parseArray(infoHttpThread.getResult(),User.class);
        infoAdapter infoa=new infoAdapter(this,R.layout.infomation,list);
        ListView listView=(ListView)findViewById(R.id.info);
        listView.setAdapter(infoa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_read_py, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
