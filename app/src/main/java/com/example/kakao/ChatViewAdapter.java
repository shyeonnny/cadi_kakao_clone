package com.example.kakao;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kakao.R;

import java.util.ArrayList;

public class ChatViewAdapter extends BaseAdapter {
    private ArrayList<com.example.kakao.ChattingItem> chattingItems = new ArrayList<>();

    @Override
    public int getCount() {
        return chattingItems.size();
    }

    @Override
    public Object getItem(int i) {
        return chattingItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos = i;
        final Context context = viewGroup.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.chatting_item, viewGroup, false);
        }

        ImageView iv_user = (ImageView) view.findViewById(R.id.iv_user);
        TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
        TextView tv_talk = (TextView) view.findViewById(R.id.tv_talk);

        com.example.kakao.ChattingItem chattingItem = chattingItems.get(i);

        iv_user.setImageDrawable(chattingItem.getUserDrawable());
        tv_name.setText(chattingItem.getNameStr());
        tv_talk.setText(chattingItem.getTalkStr());

        return view;
    }

    public void addTalk(Drawable image, String name, String talk){
        com.example.kakao.ChattingItem item = new com.example.kakao.ChattingItem();
        item.setUserDrawable(image);
        item.setNameStr(name);
        item.setTalkStr(talk);

        chattingItems.add(item);
    }


}