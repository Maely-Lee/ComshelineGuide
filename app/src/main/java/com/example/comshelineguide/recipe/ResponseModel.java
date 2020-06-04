package com.example.comshelineguide.recipe;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModel {

    @SerializedName("statusCode")
    public int statusCode;
    @SerializedName("serverTime")
    public long serverTime;
    @SerializedName("body")
    public List<RecipeModel> body;

    @Override
    public String toString() {
        return "ResponseModel{" +
                "body=" + body +
                '}';
    }
}
