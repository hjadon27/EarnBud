package mosi.bloom.earn.bud;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * This will appear after application Launch
 */
public class LaunchActivity extends AppCompatActivity {

    //Load screen appear time
    static int loadTime = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_launch);
        countDownTimer.onTick(1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.exit(0);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    //    timmer class
    CountDownTimer countDownTimer = new CountDownTimer(30000, 1000) {

        public void onTick(long millisUntilFinished) {
            loadTime--;

            if(loadTime==0){
                countDownTimer.onFinish();

            }
        }
        public void onFinish() {
            launchLogin();
        }
    }.start();

    void launchLogin() {
        Intent intent = new Intent(this, FBLoginActivity.class);
        startActivity(intent);
    }

}
