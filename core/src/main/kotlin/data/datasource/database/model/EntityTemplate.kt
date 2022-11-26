package data.datasource.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EntityTemplate(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val template: String
)