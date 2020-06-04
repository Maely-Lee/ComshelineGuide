package com.example.comshelineguide.recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("recipe/list")
    Call<ResponseModel> getRecipeList();

    @GET("recipe")
    Call<ResponseModel> getRecipe(@Query("id") long id);

    @POST("recipe")
    Call<ResponseModel> postRecipe(@Body RecipeModel item);

    @DELETE("recipe")
    Call<ResponseModel> deleteRecipe(@Query("id") long id);






}
