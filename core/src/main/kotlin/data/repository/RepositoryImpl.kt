package data.repository

import data.repository.mapper.toDomain
import domain.dataSource.DatabaseDataSource
import domain.model.Template
import domain.repository.Repository

class RepositoryImpl(
    private val database: DatabaseDataSource
) : Repository {

    override fun getTemplates(): List<Template> {
        return database.getTemplates().map { it.toDomain() }
    }
}