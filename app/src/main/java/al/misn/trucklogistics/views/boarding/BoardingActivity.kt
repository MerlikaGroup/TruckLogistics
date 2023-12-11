package al.misn.trucklogistics.views.boarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import al.misn.trucklogistics.R
import al.misn.trucklogistics.repository.Local.SharedPreferences.SharedPreferencesManager
import al.misn.trucklogistics.databinding.ActivityBoardingBinding
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@AndroidEntryPoint
class BoardingActivity : AppCompatActivity(), BoardingInterface{
    @Inject
    lateinit var manager: SharedPreferencesManager;

    private val compositeDisposable = CompositeDisposable()

    private val viewModel: BoardingViewModel by viewModels()

    lateinit var binding: ActivityBoardingBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_boarding)

        initialize()


    }


    override fun onResume() {
        super.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }


    override fun onStop() {
        super.onStop()
    }


    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    override fun initialize() {

        navigateToFragment()
    }

    override fun navigateToFragment() {
        // Use FragmentTransaction to replace the current fragment with LoginFragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, LoginFragment()) // R.id.fragmentContainer is the container in your activity layout
            .commit()
    }


}