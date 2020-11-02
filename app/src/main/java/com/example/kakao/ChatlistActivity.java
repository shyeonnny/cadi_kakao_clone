package com.example.kakao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.kakao.ChatViewAdapter;
import com.example.kakao.R;

public class ChatlistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatlist);

        ListView chatlistview = (ListView)findViewById(R.id.lv_chat);
        ChatlistViewAdapter adapter = new ChatlistViewAdapter();
        chatlistview.setAdapter(adapter);

        adapter.addTalk(ContextCompat.getDrawable(this, R.drawable.instagram), "instagram", "안녕하세요!");
        adapter.addTalk(ContextCompat.getDrawable(this, R.drawable.facebook), "facebook", "안녕하세요!");
        adapter.addTalk(ContextCompat.getDrawable(this, R.drawable.youtube), "youtube", "안녕하세요!");

    }
}