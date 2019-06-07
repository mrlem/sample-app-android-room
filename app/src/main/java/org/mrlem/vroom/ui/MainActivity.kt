package org.mrlem.vroom.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.mrlem.vroom.MyApplication
import org.mrlem.vroom.R
import org.mrlem.vroom.service.MyService

/**
 * I'm an activity, and I show what's in the database!
 */
class MainActivity : AppCompatActivity() {

    private val myAdapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_list.apply {
            setHasFixedSize(true)
            adapter = myAdapter
        }

        // use the dao to query our data and observe its changes
        val dao = MyApplication.db.myDataDao()
        dao.getAllAsync().observe(this, Observer { data ->
            myAdapter.setData(data)
        })

        // start the service that generates data
        startService(Intent(this, MyService::class.java))
    }

}
