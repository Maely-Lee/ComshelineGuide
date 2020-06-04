package com.example.comshelineguide.recipe;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comshelineguide.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_recipe extends Fragment {

    ResponseModel responseModel;
    List<RecipeModel> recipeList;
    Button recipe_add_btn;

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    ApiInterface apiInterface;

    GridView gridView;
    RecyclerView.LayoutManager layoutManager;

    ViewGroup viewGroup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_recipe, container, false);

        recipe_add_btn = (Button)viewGroup.findViewById(R.id.recipe_add_btn);
        recipe_add_btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent intent = new Intent(getActivity(), Recipe_insert.class);
                startActivityForResult(intent, 1);
            }

        });

        recyclerView = (RecyclerView)viewGroup.findViewById(R.id.recyclerView);

        getRecipe();

        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView = (RecyclerView)viewGroup.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.scrollToPosition(0);

        return viewGroup;
    }

    private void getRecipe(){

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<ResponseModel> call = apiInterface.getRecipeList();
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                responseModel = response.body();
                recipeList = responseModel.body;
                Log.d("Fragment_recipe", responseModel.toString());

//                if (getActivity()!=null){
//                    recyclerAdapter = new RecyclerAdapter(recipeList);
//                    recyclerAdapter.setRecipeList(recipeList);
//                    recyclerView.setAdapter(recyclerAdapter);
//                }

                recyclerAdapter = new RecyclerAdapter(recipeList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                System.out.println("Fail: " + t.getMessage());
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == 2){

                getRecipe();

            }else{
            }
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initDataset();
    }

    private void initDataset(){
        recipeList = new ArrayList<>();
        recipeList.add(new RecipeModel("배고파", "배고파"));
    }

}
