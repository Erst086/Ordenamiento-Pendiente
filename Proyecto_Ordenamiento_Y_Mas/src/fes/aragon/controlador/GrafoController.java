package fes.aragon.controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fes.aragon.Dijkstra.Dijkstra;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class GrafoController extends UniversalController {

    @FXML
    private Button btnGrafo;

    @FXML
    private Button btnSalir;

    @FXML
    private TextArea txtIngresar;

    @FXML
    private TextArea txtSalNumeros;

    @FXML
    void Grafo(ActionEvent event) {
//    	public static void main(String args[]){
//
//    	    int num=0;
//
//    	    System.out.println("\n\t	Grafo");
//    	    System.out.print("¿Cual es Numero de nodos? ");
//
//    	    do{
//    	      try{
//    	        InputStreamReader l1 = new InputStreamReader(System.in);
//    	        BufferedReader l2 = new BufferedReader(l1);
//    	        num=Integer.valueOf(l2.readLine()).intValue();
//    	      }
//    	      catch(IOException e){
//    	       
//    	        System.out.println("Cantidad de nodos :  ");
//    	      }
//    	      catch(NumberFormatException e2){
//    	        
//    	        System.out.println("Cuantos nodos tiene a resolver : ");
//    	      }
//    	      if(num<3 || num>26)
//    	       System.out.print(" *solo puede haber entre 3 a 26 nodos  ");
//
//    	    }while(num<3 || num>26);
//    	    Dijkstra obj = new Dijkstra(num);
//    	  }
    }
    

    @FXML
    void Salir(ActionEvent event) {
    	this.cerrarVentana(btnSalir);
    }

}
