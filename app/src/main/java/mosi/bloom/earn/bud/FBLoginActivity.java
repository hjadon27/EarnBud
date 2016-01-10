package mosi.bloom.earn.bud;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import mosi.bloom.earn.bud.util.FBUtil;

public class FBLoginActivity extends AppCompatActivity {
    String get_id, get_name, get_gender, get_email, get_birthday, get_locale, get_location;
    static Profile currentFBProfile;
    private TextView info;
    public static LoginButton loginButton;

    private CallbackManager callbackManager;
    boolean loggedIn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_fblogin);

        loggedIn = AccessToken.getCurrentAccessToken() != null;
        loginButton = (LoginButton) findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();
        loginButton.setReadPermissions(Arrays.asList("email", "public_profile"));
        info = (TextView) findViewById(R.id.info);
        if(loggedIn){
            currentFBProfile = Profile.getCurrentProfile();
            UserEntryActivity.user = FBUtil.parseProfile(currentFBProfile);
            launchUserEntryActivity();
        }else {Toast.makeText(this, "Logged out .... ", Toast.LENGTH_SHORT).show();
            onLoginButtonClick();
            }

    }
    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if(callbackManager!=null) {
            callbackManager.onActivityResult(requestCode, resultCode, data);
            launchUserEntryActivity();
//        }else{
//            Intent intent = new Intent(this, FBLoginActivity.class);
//            startActivity(intent);
//        }
    }


    void onLoginButtonClick(){
        UserEntryActivity.doLogout=false;
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                info.setText(
                        "UserInformation ID: "
                                + loginResult.getAccessToken().getUserId()
                                + "\n" +
                                "Auth Token: "
                                + loginResult.getAccessToken().getToken()
                );
//                loginResult.
                currentFBProfile = Profile.getCurrentProfile();
                Log.d("##### AUTH TOKEN FB ::", loginResult.getAccessToken().getToken());
                Log.d("FaceBOOK Profile :: ", " Name " + currentFBProfile.getName() + "\nPicture url " +
                        currentFBProfile.getProfilePictureUri(50, 50).toString());
                Log.d("FaceBOOK Permission :: ", String.valueOf(AccessToken.getCurrentAccessToken().getPermissions()));
                AccessToken.getCurrentAccessToken().getPermissions();
                UserEntryActivity.user = FBUtil.parseProfile(currentFBProfile);
                launchUserEntryActivity();
            }

            @Override
            public void onCancel() {
                info.setText("Login attempt canceled.");
            }

            @Override
            public void onError(FacebookException e) {
                info.setText("Login attempt failed.");
            }
        });
    }

    void launchUserEntryActivity() {
        if(!UserEntryActivity.doLogout) {
            Toast.makeText(this, "Logged in .... ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, UserEntryActivity.class);
            startActivity(intent);
        }
    }




}
