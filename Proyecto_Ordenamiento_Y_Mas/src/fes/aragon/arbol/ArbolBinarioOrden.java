package fes.aragon.arbol;

import fes.aragon.utilerias.dinamicas.cola.Cola;
import fes.aragon.utilerias.dinamicas.pila.Pila;

public class ArbolBinarioOrden<E> {
	protected NodoArbolOrden<E> raiz = null;

	public NodoArbolOrden<E> getRaiz() {
		return this.raiz;
	}

	public void insertar(E dato) {
		NodoArbolOrden<E> n = this.raiz;
		NodoArbolOrden<E> previo = null;

		while (n != null) {
			previo = n;
			if (n.mayor(dato)) {
				n = n.derecho;
			} else {
				n = n.izquierdo;
			}
		}

		if (this.raiz == null) {
			this.raiz = new NodoArbolOrden<E>(dato, "raiz");
		} else if (previo.mayor(dato)) {
			previo.derecho = new NodoArbolOrden<E>(dato, "derecho,padre=" + previo.dato);
		} else {
			previo.izquierdo = new NodoArbolOrden<E>(dato, "izquierdo,padre=" + previo.dato);
		}

	}

	public void imprimir(NodoArbolOrden<E> n) {
		System.out.println(n.dato + " " + n.etiqueta);
	}

	public void recorridoAmplitud() throws Exception {
		NodoArbolOrden<E> n = this.raiz;
		Cola<NodoArbolOrden<E>> cola = new Cola<NodoArbolOrden<E>>();
		if (n != null) {
			cola.insertar(n);

			while (!cola.estaVacia()) {
				n = (NodoArbolOrden<E>) cola.extraer();
				this.imprimir(n);
				if (n.izquierdo != null) {
					cola.insertar(n.izquierdo);
				}

				if (n.derecho != null) {
					cola.insertar(n.derecho);
				}
			}
		}

	}

	public void preorden(NodoArbolOrden<E> n) {
		if (n != null) {
			this.imprimir(n);
			this.preorden(n.izquierdo);
			this.preorden(n.derecho);
		}

	}

	public void orden(NodoArbolOrden<E> n) {
		if (n != null) {
			this.orden(n.izquierdo);
			this.imprimir(n);
			this.orden(n.derecho);
		}

	}

	public void postorden(NodoArbolOrden<E> n) {
		if (n != null) {
			this.postorden(n.izquierdo);
			this.postorden(n.derecho);
			this.imprimir(n);
		}

	}

	public void noRecursivoOrden() throws Exception {
		NodoArbolOrden<E> n = this.raiz;
		Pila<NodoArbolOrden<E>> pila = new Pila<NodoArbolOrden<E>>();

		while (n != null) {
			while (n != null) {
				if (n.derecho != null) {
					pila.insertar(n.derecho);
				}

				pila.insertar(n);
				n = n.izquierdo;
			}

			for (n = (NodoArbolOrden<E>) pila.extraer(); !pila.estaVacia() && n.derecho == null; n = (NodoArbolOrden<E>) pila.extraer()) {
				this.imprimir(n);
			}

			this.imprimir(n);
			if (!pila.estaVacia()) {
				n = (NodoArbolOrden<E>) pila.extraer();
			} else {
				n = null;
			}
		}

	}

	public void eliminar(E dato) {
		NodoArbolOrden<E> n = this.raiz;
		NodoArbolOrden<E> previo = null;

		while (n != null && !n.equals(dato)) {
			previo = n;
			if (n.mayor(dato)) {
				n = n.derecho;
			} else {
				n = n.izquierdo;
			}
		}

		if (n != null && n.equals(dato)) {
			NodoArbolOrden<E> nodo;
			if (n.derecho == null) {
				nodo = n.izquierdo;
			} else if (n.izquierdo == null) {
				nodo = n.derecho;
			} else {
				NodoArbolOrden<E> tmp;
				for (tmp = n.izquierdo; tmp.derecho != null; tmp = tmp.derecho) {
					;
				}

				tmp.derecho = n.derecho;
				nodo = n.izquierdo;
			}

			if (n == this.raiz) {
				this.raiz = nodo;
			} else if (previo.izquierdo == n) {
				previo.izquierdo = nodo;
			} else {
				previo.derecho = nodo;
			}
		} else if (this.raiz != null) {
			System.out.println("No se encuentra el dato " + dato);
		} else {
			System.out.println("Arbol vacio");
		}

	}
}
