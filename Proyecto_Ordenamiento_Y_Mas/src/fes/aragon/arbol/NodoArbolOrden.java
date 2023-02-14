package fes.aragon.arbol;

import java.util.Objects;

public class NodoArbolOrden<E> {
		protected E dato;
		protected NodoArbolOrden<E> izquierdo;
		protected NodoArbolOrden<E> derecho;
		protected String etiqueta;

		public NodoArbolOrden() {
			this.izquierdo = this.derecho = null;
		}

		public NodoArbolOrden(E dato, String etiqueta) {
			this(dato, (NodoArbolOrden<E>) null, (NodoArbolOrden<E>) null, etiqueta);
		}

		public NodoArbolOrden(E dato, NodoArbolOrden<E> izquierdo, NodoArbolOrden<E> derecho, String etiqueta) {
			this.dato = dato;
			this.izquierdo = izquierdo;
			this.derecho = derecho;
			this.etiqueta = etiqueta;
		}

		public int hashCode() {
			return Objects.hash(new Object[]{this.dato});
		}

		public boolean mayor(Object obj) {
			boolean resultado = false;
			if (obj instanceof Integer && this.dato instanceof Integer) {
				Integer dato1 = (Integer) this.dato;
				Integer dato2 = (Integer) obj;
				if (dato1 < dato2) {
					return true;
				}
			}

			return resultado;
		}
		String val;
		NodoArbolOrden left, right;

		NodoArbolOrden(String val)
		{
			this.val = val;
			this.left = this.right = null;
		}

	
		@SuppressWarnings("unchecked")
		public boolean equals(Object obj) {
			if (obj instanceof Integer && this.dato instanceof Integer) {
				Integer dato1 = (Integer) this.dato;
				Integer dato2 = (Integer) obj;
				return dato1.equals(dato2);
			} else {
				NodoArbolOrden<E> other = (NodoArbolOrden<E>) obj;
				return Objects.equals(this.dato, other.dato);
			}
		}
	}

