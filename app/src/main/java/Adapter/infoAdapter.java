package Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.pyquan.R;

import java.util.List;

import Bean.User;
import Thread.ImageHttpThread;

/**
 * Created by asus on 2018-12-12.
 */
public class infoAdapter extends ArrayAdapter{
    private int resourceID;
    public infoAdapter(Context context,int resource,List object){
        super(context,resource,object);
        resourceID=resource;
    }
    public View getView(int position,View convertView,ViewGroup parent){
        User user=(User)getItem(position);
        UserLayout userLayout=new UserLayout();
        View view;
        if(convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(resourceID, parent, false);
            userLayout.profileView=(ImageView) view.findViewById(R.id.profile);
            userLayout.contentView=(TextView) view.findViewById(R.id.content1);
            userLayout.imageView =(ImageView) view.findViewById(R.id.follow);
            view.setTag( userLayout);
        }else{
            view=convertView;
            userLayout=(UserLayout)view.getTag();
        }

        ImageHttpThread imageHttpThread=new ImageHttpThread(user.getPicture());
        imageHttpThread.start();
        try{
            imageHttpThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        userLayout.imageView.setImageBitmap(imageHttpThread.getResultBitmap());
        return view;
    }
    class UserLayout{
        ImageView profileView;
        TextView contentView;
        ImageView imageView;
    }

}
