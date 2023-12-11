package al.misn.trucklogistics.repository.Local.Local

import al.misn.trucklogistics.data.User
import al.misn.trucklogistics.repository.Local.SharedPreferences.SharedPreferencesManager
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val manager = SharedPreferencesManager.getInstance(context)

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    manager.getLanguage()
                )
                    .addMigrations(Migration1to2) // Add your migration from version 1 to version 2
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

val Migration1to2: Migration = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Update the migration logic to add the new column
        database.execSQL("ALTER TABLE User ADD COLUMN new_column_name TEXT")
    }
}
