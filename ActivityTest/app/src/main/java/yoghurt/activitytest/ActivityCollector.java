package yoghurt.activitytest;


import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {
    public static List<Activity> activitys = new ArrayList<>();
    public static void addActivity(Activity activity){
        activitys.add(activity);
    }
    public static void removeActivity(Activity activity){
        activitys.remove(activity);
    }
    public static void finishAll(){
        for(Activity activity:activitys){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
