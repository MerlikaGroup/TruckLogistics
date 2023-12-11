package al.misn.trucklogistics.views.SplashScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import al.misn.trucklogistics.R
import al.misn.trucklogistics.repository.Local.SharedPreferences.SharedPreferencesManager
import al.misn.trucklogistics.views.boarding.BoardingActivity
import android.animation.Animator
import android.content.Intent
import android.util.Log
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.RenderMode
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {

    @Inject
    lateinit var manager: SharedPreferencesManager;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()


        if(manager.getRole() == 1){
            navigateToNextScreen()
        }



        val splash: LottieAnimationView = findViewById(R.id.splash)

        splash.setRenderMode(RenderMode.HARDWARE);

        splash.setAnimation(R.raw.splash)
        splash.speed = 3F;
        splash.playAnimation()

        splash.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator) {
                Log.d("LOTTIE", "donothing")
            }

            override fun onAnimationEnd(p0: Animator) {
                navigateToNextScreen()
            }

            override fun onAnimationCancel(p0: Animator) {
                Log.d("LOTTIE", "donothing")
            }

            override fun onAnimationRepeat(p0: Animator) {
                Log.d("LOTTIE", "donothing")
            }
        })

    }
    private fun navigateToNextScreen() {
        val intent = Intent(this, BoardingActivity::class.java)
        startActivity(intent)
        finish() // Optional: Close the current activity if not needed anymore
    }

}