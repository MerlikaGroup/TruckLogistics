package al.misn.trucklogistics.utils

import al.misn.trucklogistics.repository.Local.SharedPreferences.SettingsManager
import al.misn.trucklogistics.repository.Local.SharedPreferences.SharedPreferencesManager
import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.LocaleList
import android.provider.Settings
import androidx.annotation.RequiresApi

class Utils {
    companion object {
        private lateinit var applicationContext: Context
        private lateinit var manager: SharedPreferencesManager;

        fun initialize(context: Context) {
            applicationContext = context.applicationContext
            manager = SettingsManager.getInstance(applicationContext)

        }


        val isTestingEnvironment: Boolean = true;

        // Function to get the Android ID
        @SuppressLint("HardwareIds")
        fun getAndroidID(context: Context): String {
            return Settings.Secure.getString(
                context.contentResolver,
                Settings.Secure.ANDROID_ID
            ) ?: ""
        }

        // Function to get the current locale
        @RequiresApi(Build.VERSION_CODES.N)
        fun getCurrentLocale(context: Context): LocaleList {
            return context.resources.configuration.locales;
        }

        fun getBaseURL(): String {
            return if (isTestingEnvironment) {
                "http://192.168.1.66:3001/";
            } else {
                "http://192.168.1.66:3001/";
            }
        }

        fun getName(): Boolean{
            val name = manager.isLoggedIn()
            return name;
        }

        fun saveToken(token: String){
            manager.setToken(token);
        }

        @RequiresApi(Build.VERSION_CODES.M)
        fun isNetworkAvailable(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            // Check if the device is connected to a network
            val network = connectivityManager.activeNetwork
            val networkCapabilities = connectivityManager.getNetworkCapabilities(network)

            return networkCapabilities != null &&
                    (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
        }
    }
}