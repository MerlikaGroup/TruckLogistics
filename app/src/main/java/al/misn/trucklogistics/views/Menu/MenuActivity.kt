package al.misn.trucklogistics.views.Menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import al.misn.trucklogistics.R
import al.misn.trucklogistics.repository.Local.SharedPreferences.SharedPreferencesManager
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MenuActivity : AppCompatActivity() {

    @Inject
    lateinit var manager: SharedPreferencesManager;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        Log.d("Menulistttttttt", manager.getMenuList())
    }

}