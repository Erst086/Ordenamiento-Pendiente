package fes.aragon.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController extends UniversalController {

    @FXML
    private Button btnArbol;

    @FXML
    private Button btnBinaria;

    @FXML
    private Button btnGrafo;

    @FXML
    private Button btnOrdenamiento;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnSecuencial;

    @FXML
    void Arbol(ActionEvent event) {
    	this.nuevaVentana("Arbol");

    }

    @FXML
    void Binaria(ActionEvent event) {
    	this.nuevaVentana("BusquedaBin");

    }

    @FXML
    void Grafo(ActionEvent event) {
    	this.nuevaVentana("Grafos");

    }

    @FXML
    void Odenamiento(ActionEvent event) {
    	this.nuevaVentana("Ordenamiento");

    }

    @FXML
    void Salir(ActionEvent event) {
    	this.cerrarVentana(btnSalir);

    }

    @FXML
    void Secuencial(ActionEvent event) {
    	this.nuevaVentana("BusquedaSecu");

    }

}
