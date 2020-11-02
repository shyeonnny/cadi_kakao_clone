package com.example.kakao;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatlistViewAdapter extends BaseAdapter {
    private ArrayList<ChatlistItem> chatlistItems = new ArrayList<>();

    @Override
    public int getCount() {
        return chatlistItems.size();
    }

    @Override
    public Object getItem(int i) {
        return chatlistItems.get(i);
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
            view = inflater.inflate(R.layout.chatlist_item, viewGroup, false);
        }

        ImageView iv_user = (ImageView) view.findViewById(R.id.iv_chat);
        TextView tv_name = (TextView) view.findViewById(R.id.tv_title);
        TextView tv_talk = (TextView) view.findViewById(R.id.tv_lasttalk);

        com.example.kakao.ChatlistItem chatlistItem = chatlistItems.get(i);

        iv_user.setImageDrawable(chatlistItem.getChatDrawable());
        tv_name.setText(chatlistItem.getTitleStr());
        tv_talk.setText(chatlistItem.getLasttalkStr());

        return view;
    }

    public void addTalk(Drawable image, String name, String talk){
        com.example.kakao.ChatlistItem item = new com.example.kakao.ChatlistItem();
        item.setChatDrawable(image);
        item.setTitleStr(name);
        item.setLasttalkStr(talk);

        chatlistItems.add(item);
    }
}
