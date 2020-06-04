package com.example.comshelineguide.recipe;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comshelineguide.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public Context c;
    public List<RecipeModel> recipeList;

    public RecyclerAdapter(Context c, List<RecipeModel> recipeList){
        this.c = c;
        this.recipeList = recipeList;
    }

    public RecyclerAdapter(List<RecipeModel> recipeList){
        this.recipeList = recipeList;
    }

    public void setRecipeList(List<RecipeModel> recipeList){
        this.recipeList = recipeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        //c는 recyclerAdapter꺼니까, viewgroup에 뿌리려면 parent.getContext()를 해줘야되는건가?
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position){

        holder.recipe_title.setText(recipeList.get(position).getTitle());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                String recipe_title = recipeList.get(position).getTitle();

                Intent intent = new Intent(v.getContext(), Recipe_detail.class);
                intent.putExtra("recipe_title", recipe_title);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){
        return recipeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView recipe_image;
        TextView recipe_title;
        TextView recipe_content;
        ItemClickListener itemClickListener;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            recipe_image = (ImageView)itemView.findViewById(R.id.recipe_image);
            recipe_title = (TextView)itemView.findViewById(R.id.recipe_title);
            recipe_content = (TextView)itemView.findViewById(R.id.recipe_content);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){

            this.itemClickListener.onItemClickListener(view, getLayoutPosition());

        }

        public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener = ic;
        }

    }



}
