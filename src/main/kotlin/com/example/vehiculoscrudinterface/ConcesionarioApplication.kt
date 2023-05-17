package com.example.vehiculoscrudinterface

import com.example.vehiculoscrudinterface.controllers.ConcesionarioController
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage


class ConcesionarioApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(ConcesionarioApplication::class.java.getResource("views/vista-principal.fxml"))
        fxmlLoader.setController(ConcesionarioController())
        val scene = Scene(fxmlLoader.load(), 600.0, 400.0)
        stage.title = "Concesionario"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(ConcesionarioApplication::class.java)
}