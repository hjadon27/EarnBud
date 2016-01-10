package mosi.bloom.earn.bud.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by DELL on 27-12-2015.
 */
public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        createNotification(context, "Boom ! time up", "Notification triggered after 30 sec", "Alert");

    }

    public void createNotification(Context context, String mes, String type, String alert){

        NotificationUtil.launchNotification(context);

    }
}
