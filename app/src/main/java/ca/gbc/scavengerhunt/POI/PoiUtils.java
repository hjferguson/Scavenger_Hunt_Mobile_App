package ca.gbc.scavengerhunt.POI;

import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import ca.gbc.scavengerhunt.AchievementLogic.AchievementUtils;

public class PoiUtils {
    public static ArrayList<PointOfInterest> createSamplePois() {
        ArrayList<PointOfInterest> pois = new ArrayList<>();
        String[] names = {"Stairs", "George Brown College", "Tim Hortons", "Pour House", "Hipster Coffee"};
        String[] photos = {"pic_steps","pic_gbc","pic_timmies","pic_pourhouse","pic_hipster"};
        LatLng[] coords = {
                new LatLng(43.677492, -79.408194),
                new LatLng(43.676271, -79.410907),
                new LatLng(43.676700, -79.411633),
                new LatLng(43.675683, -79.403832),
                new LatLng(43.674331, -79.409541)
        };
        String[] tags = {"easy", "medium", "hard"};

        for (int i = 0; i < names.length; i++) {
            pois.add(new PointOfInterest(
                    names[i], photos[i], "A place: " + names[i],
                    coords[i], AchievementUtils.createSampleAchievements(),
                    4, "Stand within 10m of poi", tags));
        }
        return pois;
    }
}