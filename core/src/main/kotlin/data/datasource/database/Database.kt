package data.datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import data.datasource.database.model.EntityTemplate

private const val DATABASE_NAME = "recipes_db"

@Database(
    entities = [EntityTemplate::class],
    version = 1,
    exportSchema = false
)

abstract class LocalDatabase : RoomDatabase() {
    abstract fun dao(): DatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: LocalDatabase? = null

        fun getInstance(context: Context): LocalDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LocalDatabase::class.java,
                        DATABASE_NAME
                    ).setJournalMode(JournalMode.TRUNCATE).build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}