package org.seniorsigan.mangareader.data

import org.seniorsigan.mangareader.models.MangaItem

class MangaSearchController {
    private val engines: MutableMap<String, MangaSearchRepository> = hashMapOf()

    fun search(engineName: String, query: String, callback: (Response<List<MangaItem>>) -> Unit) {
        engines[engineName]?.search(query, callback)
    }

    fun findAll(engineName: String, callback: (Response<List<MangaItem>>) -> Unit) {
        engines[engineName]?.findAll(callback)
    }

    fun find(engineName: String, url: String, callback: (Response<MangaItem?>) -> Unit) {
        engines[engineName]?.find(url, callback)
    }

    fun register(name: String, search: MangaSearchRepository): MangaSearchController {
        engines.put(name, search)
        return this
    }

    fun unregister(name: String): MangaSearchController {
        engines.remove(name)
        return this
    }

    fun engineNames(): List<String> = engines.keys.toList()
}