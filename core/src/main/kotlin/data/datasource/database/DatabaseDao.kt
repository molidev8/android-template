package data.datasource.database

import androidx.room.Dao
import androidx.room.Query
import data.datasource.database.model.EntityTemplate

@Dao
interface DatabaseDao {

    @Query("SELECT * from EntityTemplate")
    fun getTemplateEntities(): List<EntityTemplate>
}
