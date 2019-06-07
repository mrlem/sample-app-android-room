package org.mrlem.vroom.data.access

import androidx.room.Database
import androidx.room.RoomDatabase
import org.mrlem.vroom.data.model.MyData

/**
 * I'm the database object: I point at:
 * - the entities
 * - the daos (data access objects)
 */
@Database(entities = arrayOf(MyData::class), version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun myDataDao(): MyDataDao

}
