package ca.gbc.scavengerhunt.POI;



import com.google.android.gms.maps.model.LatLng;

public class PointOfInterest {
    private String name;
    private String photoUrl;
    private String description;
    private LatLng coordinates;
    private String[] achievements;
    private float rating;
    private String task;
    private String[] tags;

    public PointOfInterest(String name, String photoUrl, String description, LatLng coordinates,
                            String[] achievements, float rating, String task, String[] tags ){

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

    public String[] getAchievements(){
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

    public void setAchievements(String[] achievements){
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