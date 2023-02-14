package fes.aragon.datos;

public class Persona {
	private int cuenta;
	private int estatura;
	private int edad;
	private int peso;
	public Persona(int cuenta,int estatura,int edad,int peso) {
		this.cuenta=cuenta;
		this.estatura=estatura;
		this.edad=edad;
		this.peso=peso;
	}
	public Persona(int cuenta) {
		this.cuenta=cuenta;
	}
	
	@Override
	public String toString() {
		return "Persona [estatura=" + estatura + "]";
	}
	

	public final int getCuenta() {
		return cuenta;
	}
	public final int getEstatura() {
		return estatura;
	}
	public final int getEdad() {
		return edad;
	}
	public final double getPeso() {
		return peso;
	}
	public final void setNombre(String nombre) {
		this.cuenta = cuenta;
	}
	public final void setEstatura(int estatura) {
		this.estatura = estatura;
	}
	public final void setEdad(int edad) {
		this.edad = edad;
	}
	public final void setPeso(int peso) {
		this.peso = peso;
	}

}
