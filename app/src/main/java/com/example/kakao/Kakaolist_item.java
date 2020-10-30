package com.example.kakao;

import android.graphics.drawable.Drawable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Kakaolist_item
{
    private Drawable kakaoimage;
    private String name;
    private String message;

    public void setKakaoimage(Drawable kakaoimage)
    {
        this.kakaoimage = kakaoimage;
    }

    public Drawable getKakaoimage() {
        return kakaoimage;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
