package ca.gbc.scavengerhunt.POI;


import java.util.ArrayList;
import com.google.android.gms.maps.model.LatLng;
import java.io.Serializable;

import ca.gbc.scavengerhunt.AchievementLogic.Achievement;

//decided to make the object serializable to make it easier to pass the object between activities
public class PointOfInterest implements Serializable{

    private String name;
    private String photoUrl;
    private String description;
    private transient LatLng coordinates; //transients stops this from getting serialized
    //google's LatLng is not serializable. I'll think of a better workaround later... 👀
    private ArrayList<Achievement> achievements;
    private float rating;
    private String task;
    private String[] tags;

    public PointOfInterest(String name, String photoUrl, String description, LatLng coordinates,
                            ArrayList<Achievement> achievements, float rating, String task, String[] tags ){

        this.name = name;
        this.photoUrl = photoUrl;
        this.description = description;
        this.coordinates = coordinates;
        this.achievements = achievements;
        this.rating = rating;
        this.task = task;
        this.tags = tags;

    }

    public String getName(){
        return name;
    }

    public String getPhotoUrl(){
        return photoUrl;
    }

    public String getDescription(){
        return description;
    }

    public LatLng getCoordinates(){
        return coordinates;
    }

    public ArrayList<Achievement> getAchievements(){
        return achievements;
    }

    public float getRating(){
        return rating;
    }

    public String getTask(){
        return task;
    }

    public String[] getTags(){
        return tags;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhotoUrl(String photoUrl){
        this.photoUrl = photoUrl;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setCoordinates(LatLng coordinates){
        this.coordinates = coordinates;
    }

    public void setAchievements(ArrayList<Achievement> achievements){
        this.achievements = achievements;
    }

    public void setRating(float rating){
        this.rating = rating;
    }

    public void setTask(String task){
        this.task = task;
    }

    public void setTags(String[] tags){
        this.tags = tags;
    }

}