package ru.qotofey.android.characterrecognition.app.navigation;

import android.app.Activity;
import android.content.Intent;

public class Navigation {

    public void invokeNewActivity(Activity activity, Class<?> tClass, boolean shouldFinish) {
        Intent intent = new Intent(activity, tClass);
        activity.startActivity(intent);
        if (shouldFinish) {
            activity.finish();
        }
    }

}
