package al.misn.trucklogistics.repository.Api

import android.util.Log

interface Api {

    suspend fun getData(){
        Log.d("Apiiiii Works", "getDataaa")
    }
}