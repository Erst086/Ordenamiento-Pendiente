package fes.aragon.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;

public class Lectura {
	String csvFile = "archivo.csv";
	BufferedReader br = null;
	String line = "";
	//Se define separador ","
	String cvsSplitBy = ",";
	public void leer(String archivo) {
	try {
	    br = new BufferedReader(new FileReader(archivo));
	    while ((line = br.readLine()) != null) {                
	        String[] datos = line.split(cvsSplitBy);
	        //Imprime datos.
	       System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3] + ", " + datos[4] + ", " + datos[5]);
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    if (br != null) {
	        try {
	            br.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	
	
	}
}
