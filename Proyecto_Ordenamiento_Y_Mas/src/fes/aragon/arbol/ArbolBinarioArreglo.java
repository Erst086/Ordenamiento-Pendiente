package fes.aragon.arbol;

public class ArbolBinarioArreglo<E> {
	private NodoArbol<E>[] arreglo;

	private int contador;

	@SuppressWarnings("unchecked")
	public ArbolBinarioArreglo(int longitud) {
		this.arreglo = (NodoArbol<E>[]) new NodoArbol[longitud];
		this.contador = 0;
	}

	public void insertar(E dato, Integer izq, Integer der) throws Exception {
		if (this.contador < this.arreglo.length) {
			NodoArbol<E> info = new NodoArbol<>(dato, izq, der);
			this.arreglo[this.contador] = info;
			this.contador++;
		} else {
			throw new Exception("no se puede agregar mas nodos al Arbol binario");
		}
	}

	public void valorNodos() {
		for (int i = 0; i < this.arreglo.length; i++) {
			System.out.println(this.arreglo[i].getDato());
			if (this.arreglo[i].getIzquierdo() != null) {
				System.out.println("Hijo izq:=" + this.arreglo[this.arreglo[i].getIzquierdo().intValue()].getDato());
			} else {
				System.out.println("No tiene hijo izquierdo");
			}
			if (this.arreglo[i].getDerecho() != null) {
				System.out.println("Hijo der:=" + this.arreglo[this.arreglo[i].getDerecho().intValue()].getDato());
			} else {
				System.out.println("No tiene hijo derecha");
			}
		}
	}
}
