package org.mrlem.vroom

import android.app.Application
import androidx.room.Room
import org.mrlem.vroom.data.access.MyDatabase

/**.
 * I represent the application: I'm the one who holds the database object statically!
 * (so it can be accessed everywhere)
 *
 * note that in evolved apps, I wouldn't be static, but injected via dependency injection
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            applicationContext,
            MyDatabase::class.java, "mydata-database"
        )
            .allowMainThreadQueries()
            .build()

        // remove all data!
        db.myDataDao().clear()
    }

    companion object {
        lateinit var db: MyDatabase
    }

}