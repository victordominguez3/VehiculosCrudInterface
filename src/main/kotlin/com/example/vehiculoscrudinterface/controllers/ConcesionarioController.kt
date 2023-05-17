package com.example.vehiculoscrudinterface.controllers

import com.example.vehiculoscrudinterface.ConcesionarioApplication
import com.example.vehiculoscrudinterface.models.Vehiculo
import com.example.vehiculoscrudinterface.repositories.ConcesionarioRepositoryMemory
import com.example.vehiculoscrudinterface.services.storage.vehiculo.CsvService
import com.example.vehiculoscrudinterface.services.storage.vehiculo.VehiculoService
import javafx.collections.FXCollections.observableArrayList
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ListView
import javafx.scene.control.MenuItem
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.image.ImageView

class ConcesionarioController(
    private val repository: ConcesionarioRepositoryMemory = ConcesionarioRepositoryMemory(),
    private val service: VehiculoService = CsvService
    ) {

    @FXML
    private lateinit var exportarJson: MenuItem

    @FXML
    private lateinit var barraBusqueda: TextField

    @FXML
    private lateinit var botonBuscar: Button

    @FXML
    private lateinit var listaVehiculos: ListView<Vehiculo>

    @FXML
    private lateinit var matricula: Label

    @FXML
    private lateinit var imagenVehiculo: ImageView

    @FXML
    private lateinit var marcaText: TextField

    @FXML
    private lateinit var modeloText: TextField

    @FXML
    private lateinit var tipoMotorText: TextField

    @FXML
    private lateinit var kilometrajeText: TextField

    @FXML
    private lateinit var fechaText: TextField

    @FXML
    private lateinit var botonEditar: Button

    @FXML
    private lateinit var botonBorrar: Button

    @FXML
    private lateinit var botonImprimir: Button

    @FXML
    private fun initialize() {

        listaVehiculos.selectionModel.selectedIndexProperty().addListener { _, _, value ->
            if (value in 0 until listaVehiculos.items.size) {
                rellenarCampos(listaVehiculos.items[value.toInt()])
            } else {
                resetearCampos()
            }
        }

        iniciarBotonBuscar()

        exportarJson.setOnAction { exportarAJson() }
        barraBusqueda.setOnAction{ ejecutarBusqueda() }
        botonBuscar.setOnAction { ejecutarBusqueda() }
        botonEditar.setOnAction { onBotonEditarClick() }
        botonBorrar.setOnAction { onBotonBorrarClick() }
        botonImprimir.setOnAction { onBotonImprimirClick() }

        // leemos el csv e importamos a la base de datos
        repository.importar(service.importar())
        // sacamos los datos de la base de datos y la añadimos al ListView
        listaVehiculos.items = observableArrayList(repository.buscarTodos())
    }

    private fun rellenarCampos(item: Vehiculo) {
        matricula.text = item.id
        imagenVehiculo.image = item.imagen
        marcaText.text = item.marca
        modeloText.text = item.modelo
        tipoMotorText.text = item.tipoMotor.toString()
        kilometrajeText.text = item.km.toString()
        fechaText.text = item.fechaMatriculacion.toString()
    }

    private fun resetearCampos() {
        marcaText.text = ""
        modeloText.text = ""
        tipoMotorText.text = ""
        kilometrajeText.text = ""
        fechaText.text = ""
    }

    private fun iniciarBotonBuscar() {
        val icono = ImageView(Image(ConcesionarioApplication::class.java.getResourceAsStream("icons/lupa.png")))
        icono.fitHeight = 15.0
        icono.fitWidth = 15.0
        botonBuscar.graphic = icono
    }

    private fun exportarAJson() {

    }

    private fun ejecutarBusqueda() {
        val vehiculos = repository.buscarTodos().filter { it.id.contains(barraBusqueda.text.uppercase()) }
        listaVehiculos.items = observableArrayList(vehiculos)
    }

    private fun onBotonEditarClick() {

    }

    private fun onBotonBorrarClick() {

    }

    private fun onBotonImprimirClick() {

    }

}