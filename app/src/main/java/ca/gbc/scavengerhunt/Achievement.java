package ca.gbc.scavengerhunt;

import java.util.Date;

public class Achievement {

    private String name;
    private String description;
    private Date dateEarned;
    private String imageUrl;


    public Achievement (String name, String description, Date dateEarned, String imageUrl){

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

    public Date getDateEarned(){
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

    public void setDateEarned(Date dateEarned){
        this.dateEarned = dateEarned;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

}
