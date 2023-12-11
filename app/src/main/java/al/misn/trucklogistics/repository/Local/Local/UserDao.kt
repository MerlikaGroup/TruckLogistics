package al.misn.trucklogistics.repository.Local.Local

import al.misn.trucklogistics.data.User
import io.reactivex.rxjava3.core.Observable
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user")
    fun getAllUsers(): Observable<List<User>>

    // Add other queries or operations as needed
}