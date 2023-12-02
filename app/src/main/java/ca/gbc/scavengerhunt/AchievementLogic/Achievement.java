package ca.gbc.scavengerhunt.AchievementLogic;

import java.io.Serializable;

public class Achievement implements Serializable{

    private String name;
    private String description;
    private String dateEarned;
    private String imageUrl;


    public Achievement (String name, String description, String dateEarned, String imageUrl){

        this.name = name;
        this.description = description;
        this.dateEarned = dateEarned;
        this.imageUrl = imageUrl;

    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getDateEarned(){
        return dateEarned;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setDateEarned(String dateEarned){
        this.dateEarned = dateEarned;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

}
