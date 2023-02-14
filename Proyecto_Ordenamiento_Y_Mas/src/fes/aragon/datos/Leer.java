package fes.aragon.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;

public class Leer {
	ArrayList<Persona> al = new ArrayList<Persona>();
	ListaSimple<Persona> no = new ListaSimple<>();
	ListaSimple<Persona> es = new ListaSimple<>();
	ListaSimple<Persona> ed = new ListaSimple<>();
	ListaSimple<Persona> pe = new ListaSimple<>();
	ArrayList lista = new ArrayList();
	BufferedReader br = null;
	String line = "";
	// Se define separador ","
	String cvsSplitBy = ",";
	Persona p;
	Persona n;
	Persona e;
	Persona eda;

	public void leer(String archivo) {
		try {
			br = new BufferedReader(new FileReader(archivo));
			while ((line = br.readLine()) != null) {
				String[] datos = line.split(cvsSplitBy);
				// p = new
				// Persona(datos[0],Double.parseDouble(datos[1]),Integer.parseInt(datos[2]),
				// Float.parseFloat(datos[3]))
				es.agregarEnCola(p);
				lista.add(datos[2]);
				lista.add(datos[0]);
			}
		} catch (Exception e) {

		}

		System.out.println(lista);
//	no.imprimirElementos();
//	es.imprimirElementos();
	}
}
