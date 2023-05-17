package com.example.vehiculoscrudinterface.services.storage.database

import com.example.vehiculoscrudinterface.config.AppConfig
import org.apache.ibatis.jdbc.ScriptRunner
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.sql.DriverManager

object DataBaseManager {

    val connection get() = DriverManager.getConnection(AppConfig.app_url)
    private val initScript = "${System.getProperty("user.dir")}${File.separator}src${File.separator}main${File.separator}resources${File.separator}initSqlScript.sql"

    init {
        ejecutarSql(initScript)
    }

    private fun ejecutarSql(sql: String) {
        val sr = ScriptRunner(connection)
        val script = BufferedReader(FileReader(sql))
        sr.runScript(script)
    }

}