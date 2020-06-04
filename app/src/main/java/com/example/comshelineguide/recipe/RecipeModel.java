package com.example.comshelineguide.recipe;

public class RecipeModel {

    public long id;
    public String title;
    public String content;
    public byte[] image;

    public RecipeModel(long id, String title, String content, byte[] image){
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
    }

    public RecipeModel(String title, String content){
        this.title = title;
        this.content = content;
    }

    public RecipeModel(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString(){
        return "RecipeModel{" +
                "id=" + id +
                "title=" + title +
                "content=" + content +
                "image=" + image +
                "}";
    }
}
