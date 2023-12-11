package al.misn.trucklogistics.repository

import al.misn.trucklogistics.data.User
import al.misn.trucklogistics.repository.Api.Api
import al.misn.trucklogistics.repository.Local.Local.AppDatabase
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

open class Repository @Inject constructor(
    private val api: Api,
    private val local: AppDatabase
) {

   open fun getData(): Observable<List<User>> {
        return local.userDao().getAllUsers();
    }

    suspend fun insertDataToUser(user: User){
        return local.userDao().insertUser(user)
    }
}