package org.mrlem.vroom.data.access

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.mrlem.vroom.data.model.MyData

/**
 * I'm a DAO, that mean Data Access Object, I'm the one that can store / retrieve data from the database.
 */
@Dao
interface MyDataDao {

    /**
     * I list data synchronously (and once)
     */
    @Query("SELECT * FROM MyData")
    fun getAll(): List<MyData>

    /**
     * I allow you to observe data (and its subsequent updates)
     */
    @Query("SELECT * FROM MyData")
    fun getAllAsync(): LiveData<List<MyData>>

    @Insert
    fun insert(myData: MyData)

    @Query("DELETE FROM MyData")
    fun clear()

}
