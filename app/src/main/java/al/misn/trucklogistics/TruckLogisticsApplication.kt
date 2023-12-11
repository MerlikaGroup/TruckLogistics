package al.misn.trucklogistics

import al.misn.trucklogistics.utils.Utils
import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TruckLogisticsApplication: Application() {


    override fun onCreate() {
        super.onCreate()

        Utils.initialize(this)
        FirebaseApp.initializeApp(this)
    }


}