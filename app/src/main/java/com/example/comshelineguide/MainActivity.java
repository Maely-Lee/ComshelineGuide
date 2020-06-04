package com.example.comshelineguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.comshelineguide.recipe.Fragment_recipe;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Fragment_list fragment_list;
    Fragment_map fragment_map;
    Fragment_recipe fragment_recipe;
    Fragment_mypage fragment_mypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_menu_bar);

        //프래그먼트 생성
        fragment_list = new Fragment_list();
        fragment_map = new Fragment_map();
        fragment_recipe = new Fragment_recipe();
        fragment_mypage = new Fragment_mypage();

        //제일 처음 띄워줄 뷰 세팅
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_list).commitAllowingStateLoss();

        //bottom menu의 아이콘을 선택했을 때 원하는 프래그먼트가 띄워질 수 있도록 리스너 추가
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    //bottom_menu.xml에서 지정해줬던 아이디 값을 받아와서 각 아이디값마다 다른 이벤트를 발생시킴
                    case R.id.tab1: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_list).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.tab2: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_map).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.tab3: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_recipe).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.tab4: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_mypage).commitAllowingStateLoss();
                        return true;
                    }

                    default:
                        return false;
                }
            }

        });

    }
}











