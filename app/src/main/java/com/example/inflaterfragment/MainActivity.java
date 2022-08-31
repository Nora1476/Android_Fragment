package com.example.inflaterfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

  private LinearLayout container;
  private SubFragment subFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    container = findViewById(R.id.container);
    subFragment = new SubFragment();

    // sub1 추가하는 버튼클릭 이벤트
    findViewById(R.id.button).setOnClickListener(v->{
      LayoutInflater inf = getLayoutInflater();
      inf.inflate(R.layout.sub1, container, true); //layout sub1의 container를 붙여서 sub1 안에 checkbox속성을 바꿈
      CheckBox cb = container.findViewById(R.id.checkBox);
//      try {
//        Thread.sleep(2000);  //2초 후에 실행
//      } catch (InterruptedException e){
//        e.printStackTrace();
//      }
      cb.setText("Completed");
    });

    // Fragment 추가하는 버튼클릭 이벤트
    findViewById(R.id.btnAddFrag).setOnClickListener(v -> {
      getSupportFragmentManager().beginTransaction().replace(R.id.frame2,subFragment).commit();
    });
  }
}