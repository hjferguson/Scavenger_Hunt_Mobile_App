package ca.gbc.scavengerhunt.POI;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;


public class PoiCreator {
    public static List<PointOfInterest> getSamplePois(){
        List<PointOfInterest> pois = new ArrayList<>();
        pois.add(new PointOfInterest(
                "George Brown College", "path/to/photo","A place where we learn mobile app dev",
                new LatLng(43.676271, -79.410907),
        ))
    }
}
