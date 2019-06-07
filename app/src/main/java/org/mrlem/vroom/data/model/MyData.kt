package org.mrlem.vroom.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * I'm an entity, I represent a database table. Each line of this table will represent an instance of me!
 */
@Entity
data class MyData(
    @PrimaryKey var id: Int,
    var name: String
)
