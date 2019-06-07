package org.mrlem.vroom.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import org.mrlem.vroom.MyApplication
import org.mrlem.vroom.data.model.MyData

/**
 * I'm a service, and I add more data to the database every now and then!
 */
class MyService : Service() {

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread(DataGenerator()).start()

        return START_STICKY
    }

    private class DataGenerator : Runnable {

        private val dataToAdd = arrayOf(
                "Just",
                "a",
                "quick",
                "room",
                "sample",
                "app!"
            )

        override fun run() {
            val dao = MyApplication.db.myDataDao()

            // start at current max id
            var idCounter = dao.getAll().map { myData -> myData.id }.max() ?: 0

            // add sample data to the database
            dataToAdd.forEach { data ->
                dao.insert(MyData(idCounter++, data))
                Thread.sleep(1000)
            }
        }

    }

}