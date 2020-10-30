package com.example.kakao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Kakaoprofile_item extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakaoprofile_item);

        TextView tv_chat = (TextView)findViewById(R.id.tv_chat);

        tv_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Kakaoprofile_item.this, ChattingActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}