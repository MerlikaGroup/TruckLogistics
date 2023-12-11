package al.misn.trucklogistics.repository.Local.SharedPreferences

import android.content.Context

object SettingsManager {
    private var instance: SharedPreferencesManager? = null

    fun getInstance(context: Context): SharedPreferencesManager {
        if (instance == null) {
            // Create the instance if it doesn't exist
            val sharedPreferences = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
            instance = SharedPreferencesManagerImpl(sharedPreferences)
        }
        return instance!!
    }
}