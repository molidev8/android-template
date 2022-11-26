package data.datasource.database

import data.datasource.database.model.EntityTemplate
import domain.dataSource.DatabaseDataSource

class DatabaseDataSourceImpl(
    db: LocalDatabase
) : DatabaseDataSource {

    private val dao = db.dao()

    override fun getTemplates(): List<EntityTemplate> {
        return dao.getTemplateEntities()
    }
}