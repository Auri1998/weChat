package Bean;

import android.media.Image;

import java.util.List;

/**
 * Created by asus on 2018-12-12.
 */
public class User {
    private String name;
    private String password;
    private Image picture;
    private String content;
    public User(){

    }
    public User(String name,String password,Image  picture){
        this.name=name;
        this.password=password;
        this.picture=picture;
    }

    public Image getPicture() {
        return picture;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public void setPicture(Image picture) {
        this.picture = picture;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
