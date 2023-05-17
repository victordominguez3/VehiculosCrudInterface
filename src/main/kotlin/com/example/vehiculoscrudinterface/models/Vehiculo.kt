package com.example.vehiculoscrudinterface.models

import com.example.vehiculoscrudinterface.enums.TipoMotor
import javafx.scene.image.Image
import java.time.LocalDate
import java.util.Date

data class Vehiculo(
    val id: String,
    val marca: String,
    val modelo: String,
    val tipoMotor: TipoMotor,
    val km: Int,
    val fechaMatriculacion: LocalDate,
    val imagen: Image
    ) {
    override fun toString(): String {
        return "Vehiculo - " +
                "Matrícula: $id"
    }
}