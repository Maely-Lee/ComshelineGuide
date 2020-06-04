package com.example.comshelineguide.recipe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.comshelineguide.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Recipe_insert extends AppCompatActivity {

    RecipeModel newRecipe;

    EditText recipe_title, recipe_content;

    static ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_insert);

        final Intent intent = getIntent();

        recipe_title = findViewById(R.id.recipe_title_insert);
        recipe_content = findViewById(R.id.recipe_content_insert);

        newRecipe = new RecipeModel("", "");

        Button insert_btn = findViewById(R.id.recipe_send_btn);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        insert_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                upload();
                intent.putExtra("result","some value");
                setResult(2, intent);

                finish();

            }
        });
    }

    public void upload(){

        final RecipeModel newRecipe = new RecipeModel();

        //EditText의 텍스트 가져오기
        newRecipe.title = recipe_title.getText().toString();
        newRecipe.content = recipe_content.getText().toString();

        new Thread(){

            @Override
            public void run(){
                final Call<ResponseModel> call = apiInterface.postRecipe(newRecipe);

                call.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                        Log.v("Test", response.body().toString());

                        ResponseModel responseModel = response.body();
                        Integer statusCode = responseModel.statusCode;
                        Long serverTime = responseModel.serverTime;
                        List<RecipeModel> recipeList = responseModel.body;
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        Log.e("Test", t.getMessage());
                        call.cancel();
                    }
                });
            }

        }.start();

    }
}
