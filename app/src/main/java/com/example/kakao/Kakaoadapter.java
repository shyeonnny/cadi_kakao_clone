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

import lombok.Setter;

class Kakaoadapter extends BaseAdapter
{

    private ArrayList<Kakaolist_item> Kakaolist_itemList = new ArrayList<Kakaolist_item>();


    // 기본생성자 : 객체들을 초기화 (초기화할꺼없어서 안함)
    public Kakaoadapter()
    {

    }


    @Override
    public int getCount()
    {
        return Kakaolist_itemList.size(); // 3개로 묶은 세트 개수 리턴
    }

    @Override
    public Object getItem(int position)
    {
        return Kakaolist_itemList.get(position);
        // 어레이리스트에서 특정위치에있는 데이터(position)를 받아오기위해서
        // .get으로 호출
    }

    @Override
    public long getItemId(int position)
    // getItem : 특정위치에있는 항목을 끌어오겠다
    // getItemId : 특정위치에있는 항목의 좌표값을 끌어오겠다

    {
        return position; // 좌표값 = position이기 때문에
    }

    // 지정된 Position에 위치한 데이터를 화면에 출력하는데 사용할 View를 불러와 Return함
    // List의 position에 해당하는 View를 반환합니다. getView()는 실제로 화면에 보여질 View를 구성하기 위해,
    // 미리 생성해두었던 레이아웃과 연결하고 데이터를 세팅하는 작업을 수행하도록 작성
   @Override
    public View getView(int position, View convertView, ViewGroup parent)
   {
       // final : 상수값 형태로 활용하기위해서 키워드 사용
       final Context context = parent.getContext(); // 앱이나 객체의 현재 상태 정보

       // "Kakaolist_item" Layout을 inflate하여 convertView 참조 획득
       // inflate : xml로 정의된 view (또는 menu 등)를 실제 객체화 시키는 용도

       if (convertView == null)
       // 새롭게 만든 껍데기가 정의안되있다면 레이아웃인플레이터를 통해 새로운 컨버트뷰를 정의한다
       {
           // layoutInflater : XML에 미리 정의해둔 틀을 실제 메모리에 올려주는 역할
           // LAYOUT_INFLATER_SERVICE : OnCreatView 같은 LayoutInflater 인자가 주어지지 않는 곳에서 layout을 생성해
           // addView 하거나 할 때 사용하는 방법
           LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = inflater.inflate(R.layout.kakaolist_item, parent, false);
       }


       // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
       //findViewById : 새롭게 정의된 것(convertView)에서 하위 메소드로있는 f.I 사용하기위해서
       ImageView kakaoImageView = (ImageView) convertView.findViewById(R.id.imageView1);
       TextView nameTextView = (TextView) convertView.findViewById(R.id.textView1);
       TextView messageTextView = (TextView) convertView.findViewById(R.id.textView2);

       // Data Set (ListViewItemList)에서 position에 위치한 데이터 참조 획득
       // 특정위치에있는 데이터를 받아와야하기때문에 .get(position)사용
       Kakaolist_item kakaolist_item = Kakaolist_itemList.get(position);

       // 아이템 내 각 위젯에 데이터 반영
       kakaoImageView.setImageDrawable(kakaolist_item.getKakaoimage());
       nameTextView.setText(kakaolist_item.getName());
       messageTextView.setText(kakaolist_item.getMessage());

       return convertView;
       // 새롭게 리스트를 생성해서 데이터를 뿌려주려고할 때 뿌려줄 장소가 없으면
       // 장소를 정의하고 뿌려야함 만약에 장소가 있으면 또 만들 필요 없음
       // 뷰홀더패턴 : findViewID를 반복적으로 사용하면 성능이 떨어짐 -> 필요에 따라서 한번만 정의하기위해서 묶어서 사용
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(Drawable kakaoimage, String name, String message)
    {
        Kakaolist_item item = new Kakaolist_item(); // 하나의 리스트 항목을 하나의 객체로 간주함

        item.setKakaoimage(kakaoimage);
        item.setName(name);
        item.setMessage(message);
        // 메인에서 3개 인자값을 받아들일때 바꾸라는 뜻

        Kakaolist_itemList.add(item);
        // 3개 데이터를 어레이리스트 객체에다가 순차적으로 더해주라는 뜻
    }
}