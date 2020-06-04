package com.example.comshelineguide.recipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.comshelineguide.R;

public class Recipe_detail extends AppCompatActivity {

    //ImageView recipe_pic;
    TextView recipe_title;
    TextView recipe_contents;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_detail);

        final Intent intent = getIntent();

        recipe_title = findViewById(R.id.recipe_title_detail);
        recipe_contents = findViewById(R.id.recipe_content);

        String title = intent.getStringExtra("dTitle");
        String content = intent.getStringExtra("dContent");

        recipe_title.setText(title);
        recipe_contents.setText(content);
    }


}
