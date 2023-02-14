package fes.aragon.controlador;

import java.util.Random;

import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class SecuencialController extends UniversalController {
	public ListaSimple<Integer> datos = new ListaSimple<>();
	public String vacio = "";
	public SecuencialController() {
		// TODO Auto-generated constructor stub
	}

    @FXML
    private Button btnAleatorio;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnSalir;

    @FXML
    private TextArea txtIngresar;

    @FXML
    private TextArea txtNumeros;

    @FXML
    void aleatorio(ActionEvent event) {
		int ransumns =10;
		Random rd = new Random();
		for (int i = 0; i < ransumns; i++) {
			datos.agregarEnCola(rd.nextInt(200));
			this.txtNumeros.setText(datos.obtenerCola()+"");
			datos.imprimirElementos();
		}
		// txtNumeros.setText("122,2,2,2,2");
    }

    @FXML
    void buscar(ActionEvent event) {}
    
        //Mostrar los datos del vector
        public void mostrarArreglos(int [] arreglo){
            int k;
            for(k=0; k < arreglo.length; k++){
                   System.out.print("["+ arreglo[k] +"]");
            }
            System.out.println();
            
        }

    @FXML
    void salir(ActionEvent event) {
    	this.cerrarVentana(btnSalir);

    }

}
