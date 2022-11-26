package data.repository.mapper

import data.datasource.database.model.EntityTemplate
import domain.model.Template

fun EntityTemplate.toDomain() = Template(id, template)