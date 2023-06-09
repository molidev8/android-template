package domain.dataSource

import data.datasource.database.model.EntityTemplate

interface DatabaseDataSource {

    fun getTemplates(): List<EntityTemplate>
}
