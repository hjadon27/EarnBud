package mosi.bloom.earn.bud.util;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import mosi.bloom.earn.bud.R;

/**
 * Created by DELL on 26-12-2015.
 */
public class NotificationUtil {

    private static String notificationTitle ;
    private static Bitmap nofificationImage;

    public static void launchNotification(Context context){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.earn_bud_icon).setLargeIcon(getNofificationImage())
                .setContentTitle(getNotificationTitle()).setContentText("Events received");
        mBuilder.setAutoCancel(true);
//        Intent resultIntent = new Intent(context, DisplayAdActivity.class);

        NotificationCompat.BigPictureStyle inboxStyle =
                new NotificationCompat.BigPictureStyle();
        inboxStyle.bigPicture(getNofificationImage());

        // Moves the expanded layout object into the notification object.
        mBuilder.setStyle(inboxStyle);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
//        stackBuilder.addParentStack(DisplayAdActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
//        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(1, mBuilder.build());
    }

    public static void launchNotificationFrmReceiver(Context context){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.earn_bud_icon).setLargeIcon(getNofificationImage())
                .setContentTitle(getNotificationTitle()).setContentText("Events received");
        mBuilder.setAutoCancel(true);
        mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);
//        Intent resultIntent = new Intent(context, DisplayAdActivity.class);

        NotificationCompat.BigPictureStyle inboxStyle =
                new NotificationCompat.BigPictureStyle();
        inboxStyle.bigPicture(getNofificationImage());

        // Moves the expanded layout object into the notification object.
        mBuilder.setStyle(inboxStyle);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
//        stackBuilder.addParentStack(DisplayAdActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
//        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(1, mBuilder.build());
    }

    public static String getNotificationTitle() {
        return notificationTitle;
    }

    public static void setNotificationTitle(String notificationTitle) {
        NotificationUtil.notificationTitle = notificationTitle;
    }

    public static Bitmap getNofificationImage() {
        return nofificationImage;
    }

    public static void setNofificationImage(Context context, int imageId ) {
        Bitmap nofificationImage = BitmapFactory.decodeResource(
                context.getResources(), imageId);
        NotificationUtil.nofificationImage = nofificationImage;
    }
}
