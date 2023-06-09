package domain.repository

import domain.model.Template

interface Repository {

    fun getTemplates(): List<Template>
}
