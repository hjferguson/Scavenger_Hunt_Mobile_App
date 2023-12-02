package ca.gbc.scavengerhunt.AchievementLogic;

import java.util.ArrayList;
import java.util.Date;

public class AchievementUtils {

    public static ArrayList<Achievement> createSampleAchievements() {
        ArrayList<Achievement> list = new ArrayList<>();
        Date date = new Date();
        String dateStr = date.toString();

        for (int i = 0; i < 4; i++) {
            Achievement achievement = new Achievement(
                    "Name: " + i, "Wow! " + i + " is such a cool place!",
                    dateStr, "some/path/to/an/ai/generated/achievement/icon"
            );
            list.add(achievement);
        }

        return list;
    }
}
