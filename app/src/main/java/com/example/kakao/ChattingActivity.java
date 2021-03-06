package com.example.kakao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class ChattingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        ListView chatview = (ListView)findViewById(R.id.lv_item);
        ImageButton btn_back = (ImageButton)findViewById(R.id.btn_back);
        TextView tv_title = (TextView)findViewById(R.id.tv_lasttalk);

        ChatViewAdapter adapter = new ChatViewAdapter();
        chatview.setAdapter(adapter);

        adapter.addTalk(ContextCompat.getDrawable(this, R.drawable.instagram), "instagram", "안녕하세요!");
        adapter.addTalk(ContextCompat.getDrawable(this, R.drawable.instagram), "instagram", "반갑습니다!");

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_back = new Intent(ChattingActivity.this, ChatlistActivity.class);
                startActivity(i_back);
                finish();

            }
        });
    }
}