package com.example.vehiculoscrudinterface.config

import java.util.Properties

object AppConfig {
    lateinit var app_name: String
    lateinit var app_version: String
    lateinit var app_author: String
    lateinit var app_url: String
    lateinit var app_init_url: String


    init {
        loadProperties()
    }

    private fun loadProperties() {
        val properties = Properties()
        properties.load(AppConfig::class.java.getResourceAsStream("/config.properties"))
        app_name = properties.getProperty("app.name") ?: "Concesionario"
        app_version = properties.getProperty("app.version") ?: "1.0"
        app_author = properties.getProperty("app.author") ?: "VictorDominguez"
        app_url = properties.getProperty("app.url") ?: "jdbc:sqlite:concesionario.db"
        app_init_url = properties.getProperty("app.init.url") ?: "initSqlScript.sql"
    }
}