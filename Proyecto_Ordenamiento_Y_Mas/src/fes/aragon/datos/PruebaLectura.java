package fes.aragon.datos;

public class PruebaLectura {
public static void main(String[] args) {
	Leer archivo = new Leer();
	archivo.leer(System.getProperty("user.dir")+"/src/fes/aragon/datos/Datos.csv");
}
}
