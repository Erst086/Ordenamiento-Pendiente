package fes.aragon.arbol;

public class NodoArbol<E> {
		private E dato;
		private Integer izquierdo;
		private Integer derecho;

		public NodoArbol(E dato) {
			this(dato, (Integer) null, (Integer) null);
		}

		public NodoArbol(E dato, Integer izquierdo, Integer derecho) {
			this.dato = dato;
			this.izquierdo = izquierdo;
			this.derecho = derecho;
		}

		public E getDato() {
			return this.dato;
		}

		public void setDato(E dato) {
			this.dato = dato;
		}

		public Integer getIzquierdo() {
			return this.izquierdo;
		}

		public void setIzquierdo(Integer izquierdo) {
			this.izquierdo = izquierdo;
		}

		public Integer getDerecho() {
			return this.derecho;
		}

		public void setDerecho(Integer derecho) {
			this.derecho = derecho;
		}
}
