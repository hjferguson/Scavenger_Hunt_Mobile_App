package ca.gbc.scavengerhunt;

import java.util.ArrayList;

import ca.gbc.scavengerhunt.POI.PointOfInterest;

public class DataManager {
    private static DataManager instance;
    private ArrayList<PointOfInterest> myArrayList;

    private DataManager() {
        myArrayList = new ArrayList<>();
    }

    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public ArrayList<PointOfInterest> getMyArrayList() {
        return myArrayList;
    }
}
