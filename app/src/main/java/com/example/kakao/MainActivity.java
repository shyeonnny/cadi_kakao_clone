package com.example.kakao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
    {
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ListView listView;
            Kakaoadapter adapter;

            // Adapter 생성
            adapter = new Kakaoadapter();

            // 리스트뷰 참조 및 Adapter달기
            listView = (ListView) findViewById(R.id.kakaolist);
            listView.setAdapter(adapter);

            // 첫 번째 아이템 추가
            adapter.addItem(ContextCompat.getDrawable(this,R.drawable.instagram),"abb","a");

            // 두 번째 아이템 추가
            adapter.addItem(ContextCompat.getDrawable(this,R.drawable.facebook),"bbb","b");

            // 세 번째 아이템 추가
            adapter.addItem(ContextCompat.getDrawable(this,R.drawable.youtube),"cbb","c");


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id)
                {
                    // Posistion에 위치한 값을 가져와 변수에 저장하여 사용가능
                    Kakaolist_item item = (Kakaolist_item) parent.getItemAtPosition(position);

                    Intent intent = new Intent(MainActivity.this, Kakaoprofile_item.class);
                    startActivity(intent);
                }
            });

    }
}