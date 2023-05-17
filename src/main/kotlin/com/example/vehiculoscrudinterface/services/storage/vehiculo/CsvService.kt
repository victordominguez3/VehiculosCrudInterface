package com.example.vehiculoscrudinterface.services.storage.vehiculo

import com.example.vehiculoscrudinterface.ConcesionarioApplication
import com.example.vehiculoscrudinterface.enums.TipoMotor
import com.example.vehiculoscrudinterface.models.Vehiculo
import javafx.scene.image.Image
import mu.KLogger
import mu.KotlinLogging
import java.io.File
import java.time.LocalDate
import java.util.*

private val logger = KotlinLogging.logger{}

object CsvService: VehiculoService {

    private val path = "${System.getProperty("user.dir")}${File.separator}src${File.separator}main${File.separator}resources${File.separator}vehiculos.csv"
    private val fichero = File(path)
    private val iconos = listOf<Image>(
        Image(ConcesionarioApplication::class.java.getResourceAsStream("icons/cocheAmarillo.png")),
        Image(ConcesionarioApplication::class.java.getResourceAsStream("icons/cocheAzul.png")),
        Image(ConcesionarioApplication::class.java.getResourceAsStream("icons/cocheAzulOscuro.png")),
        Image(ConcesionarioApplication::class.java.getResourceAsStream("icons/cocheBlanco.png")),
        Image(ConcesionarioApplication::class.java.getResourceAsStream("icons/cocheMorado.png")),
        Image(ConcesionarioApplication::class.java.getResourceAsStream("icons/cocheNegro.png")),
        Image(ConcesionarioApplication::class.java.getResourceAsStream("icons/cocheRojo.png")),
        Image(ConcesionarioApplication::class.java.getResourceAsStream("icons/cocheRosa.png")),
        Image(ConcesionarioApplication::class.java.getResourceAsStream("icons/cocheVerde.png"))
    )

    override fun exportar(items: List<Vehiculo>) {
        TODO("Not yet implemented")
    }

    override fun importar(): List<Vehiculo> {
        logger.debug { "VehiculoCsvService -> Importando datos de CSV" }
        return fichero.readLines()
            .drop(1)
            .map { linea -> linea.split(";") }
            .map { columnas ->
                Vehiculo(
                    columnas[0],
                    columnas[1],
                    columnas[2],
                    TipoMotor.valueOf(columnas[3]),
                    columnas[4].toInt(),
                    LocalDate.parse(columnas[5]),
                    iconos.random()
                )
            }
    }

}