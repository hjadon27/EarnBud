package mosi.bloom.earn.bud.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harendra Kumar on 05-01-2016.
 */
public class Constants {
    public static List<String> notificationImageList = new ArrayList<>();
    public static String notificationImage1 = "http://earnbud.com/wp-content/uploads/2015/12/image1.jpg";
    public static String notificationImage2 = "http://earnbud.com/wp-content/uploads/2015/12/image2.jpg";
    public static String notificationImage3 = "http://earnbud.com/wp-content/uploads/2015/12/image3.jpg";

    public static void loadImagesList(){
        notificationImageList.add(notificationImage1);
        notificationImageList.add(notificationImage2);
        notificationImageList.add(notificationImage3);

    }
}
