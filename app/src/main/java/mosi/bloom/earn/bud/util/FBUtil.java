package mosi.bloom.earn.bud.util;

import com.facebook.Profile;

import mosi.bloom.earn.bud.pojo.UserInformation;

/**
 * Created by Harendra Kumar on 07-01-2016.
 */
public class FBUtil {

    public static UserInformation parseProfile(Profile profile){
        UserInformation user = new UserInformation();
        user.setId(profile.getId());
        user.setUserName(profile.getName());
        user.setFirstName(profile.getFirstName());
        user.setMiddleName(profile.getMiddleName());
        user.setLastName(profile.getLastName());
        user.setPhoto(profile.getProfilePictureUri(500,500).toString());
        return user;
    }
}
