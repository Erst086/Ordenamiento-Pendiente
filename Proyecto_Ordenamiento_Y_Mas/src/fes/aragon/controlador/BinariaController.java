package fes.aragon.controlador;


import java.util.Random;

import fes.aragon.metodos.Burbuja;
import fes.aragon.modelos.Modelos;
import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BinariaController extends UniversalController{
	public ListaSimple<Integer> datos = new ListaSimple<>();
	public String vacio = "";
	public BinariaController() {
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
    private TextArea txtSalNumeros;

    @FXML
    void Aleatorio(ActionEvent event) {
		int ransumns =10;
		Random rd = new Random();
		for (int i = 0; i < ransumns; i++) {
			datos.agregarEnCola(rd.nextInt(200));
			this.txtSalNumeros.setText(datos.obtenerCola()+"");
			datos.imprimirElementos();
		}
		// txtNumeros.setText("122,2,2,2,2");

    }

    @FXML
    void Buscar(ActionEvent event){
		Modelos m = new Modelos();
		Burbuja bu = new Burbuja();
		m.setBinaria(this.txtIngresar.getText());
		if (this.txtIngresar.getText().equals(vacio)) {

			this.mensaje("ERROR", "Sin contenido", "Por favor llenar la caja de texto con datos correctos");
			
		} else {
			
			bu.burbuja();
			datos.imprimirElementos();
			txtSalNumeros.setText(bu.toString());
		}
	

	}
    
	public void burbuja() {
		for (int i = 0; i < datos.getLongitud() - 1; i++) {
			for (int j = i + 1; j < datos.getLongitud(); j++) {
				if (datos.obtenerNodo(i) >= datos.obtenerNodo(j)) {
					Integer temp = datos.obtenerNodo(i);
					datos.asignar(datos.obtenerNodo(j), i);
					datos.asignar(temp, j);
				}

			}
		}
	}

    @FXML
    void Salir(ActionEvent event) {
    	this.cerrarVentana(btnSalir);

    }

}
