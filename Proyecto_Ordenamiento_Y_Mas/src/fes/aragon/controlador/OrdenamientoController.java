package fes.aragon.controlador;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class OrdenamientoController extends UniversalController implements Initializable {

    @FXML
    private BarChart<String, Number> area;

    @FXML
    private Button btnAleatorios;

    @FXML
    private Button btnInsercion;

    @FXML
    private Button btnQuickSort;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnSeleccion;

    @FXML
    private Button btnburbuja;
    
    private ListaSimple<Integer> lista = new ListaSimple<>();
	final CategoryAxis xAxis = new CategoryAxis();
	final NumberAxis yAxis = new NumberAxis();
	private XYChart.Series<String, Number> series;
	final String[] color = { "-fx-bar-fill: green", "-fx-bar-fill: red", "-fx-bar-fill: blue", "-fx-bar-fill: yellow" };
	private ScheduledExecutorService scheduledExecutorService;

    @FXML
    void Aleatorios(ActionEvent event) {
    	numerosAleatorios();
		series.getData().clear();
		for (int i = 0; i < lista.getLongitud(); i++) {
			series.getData().add(new XYChart.Data<>(String.valueOf(i), lista.obtenerNodo(i)));
			series.getData().get(i).getNode().setStyle(color[new Random().nextInt(4)]);
		}
		if (scheduledExecutorService != null) {
			scheduledExecutorService.shutdown();
		}
    }

    @FXML
    void Salir(ActionEvent event) {
    	this.cerrarVentana(btnSalir);

    }

    @FXML
    void burbuja(ActionEvent event) {
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleAtFixedRate(() -> {
			Platform.runLater(() -> {
				for (int i = 0; i < lista.getLongitud(); i++) {
					for (int j = lista.getLongitud() - 1; j > i; j--) {
						if (lista.obtenerNodo(j - 1) > lista.obtenerNodo(j)) {
							Integer aux = lista.obtenerNodo(j - 1);
							lista.asignar(lista.obtenerNodo(j), j - 1);
							lista.asignar(aux, j);
							String tmpEstilo = series.getData().get(j).getNode().getStyle();
							String tmpEstiloDos = series.getData().get(j - 1).getNode().getStyle();
							series.getData().get(j).getNode().setStyle(tmpEstiloDos);
							series.getData().get(j - 1).getNode().setStyle(tmpEstilo);
							series.getData().get(j).setYValue(lista.obtenerNodo(j));
							series.getData().get(j - 1).setYValue(lista.obtenerNodo(j - 1));

							break;
						}
					}
				}
			});
		}, 0, 1, TimeUnit.SECONDS);

    }

    @FXML
    void insercion(ActionEvent event) {
    	scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleAtFixedRate(() -> {
			Platform.runLater(() -> {
				int j = 1;
				// int i =1;
				for (int i = 1; i < lista.getLongitud(); i++) {
					Integer aux = lista.obtenerNodo(i);
					for (j = i; j > 0 && aux < lista.obtenerNodo(j - 1); j--) {
						lista.asignar(lista.obtenerNodo(j - 1), j);
					}

					lista.asignar(aux, j);
					String tmpEstilo = series.getData().get(j).getNode().getStyle();
					String tmpEstiloDos = series.getData().get(j).getNode().getStyle();
					series.getData().get(j).getNode().setStyle(tmpEstiloDos);
					series.getData().get(j).getNode().setStyle(tmpEstilo);
					series.getData().get(j).setYValue(lista.obtenerNodo(j));
					series.getData().get(j).setYValue(lista.obtenerNodo(j));

					// break;

				}
			});
		}, 0, 1, TimeUnit.SECONDS);


    }

    @FXML
    void quicksort(ActionEvent event) {
    	this.quickSort(0, lista.getLongitud()-1);
    }
    public void quickSort(int primero, int ultimo) {
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleAtFixedRate(() -> {
			Platform.runLater(() -> {
				int i, j, pivote, auxiliar;
				i = primero;
				j = ultimo;

				pivote = lista.obtenerNodo((primero + ultimo) / 2);
				// System.out.println(pivote);
				do {
					while (lista.obtenerNodo(i) < pivote) {
						i++;
					}

					while (lista.obtenerNodo(j) > pivote) {
						j--;
					}

					// aqui el intercambio
					if (i <= j) {
						auxiliar = lista.obtenerNodo(i);
						lista.asignar(lista.obtenerNodo(j), i);
						lista.asignar(auxiliar, j);
						i++;
						j--;
					}
				} while (i <= j);

				if (primero < j) {
					quickSort(primero, j);

			
				}
				if (i < ultimo) {
					quickSort(i, ultimo);
				}

				String tmpEstilo = series.getData().get(i).getNode().getStyle();
				String tmpEstiloDos = series.getData().get(i - 1).getNode().getStyle();
				series.getData().get(i).getNode().setStyle(tmpEstiloDos);
				series.getData().get(i - 1).getNode().setStyle(tmpEstilo);
				series.getData().get(i).setYValue(lista.obtenerNodo(i));
				series.getData().get(i - 1).setYValue(lista.obtenerNodo(i - 1));
				
			});
		}, 0, 1, TimeUnit.SECONDS);
		
	}

    @FXML
    void seleccion(ActionEvent event) {
    	scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleAtFixedRate(() -> {
			Platform.runLater(() -> {
				int min = 0;
				for (int i = 0; i < lista.getLongitud(); i++) {
					min = i;
					for (int j = i + 1; j < lista.getLongitud(); j++) {
						if (lista.obtenerNodo(j) <= lista.obtenerNodo(min)) {
							min = j;
						}
						if (i != min) {
							Integer aux = lista.obtenerNodo(i);
							lista.asignar(lista.obtenerNodo(min), i);
							lista.asignar(aux, min);
							String tmpEstilo = series.getData().get(i).getNode().getStyle();
							String tmpEstiloDos = series.getData().get(i).getNode().getStyle();
							series.getData().get(i).getNode().setStyle(tmpEstiloDos);
							series.getData().get(i).getNode().setStyle(tmpEstilo);
							series.getData().get(i).setYValue(lista.obtenerNodo(i));
							series.getData().get(i).setYValue(lista.obtenerNodo(i));

						}
						// break;
					}

				}

			});
		}, 0, 1, TimeUnit.SECONDS);
		
    	

    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
// TODO Auto-generated method stub
		numerosAleatorios();
		xAxis.setLabel("Time/s");
		xAxis.setAnimated(false);
		yAxis.setLabel("Value");
		yAxis.setAnimated(false);
// idArea = new LineChart<>(xAxis, yAxis);
		area.setTitle("Método Burbuja");
		area.setAnimated(false); // disable animations
		series = new XYChart.Series<>();
		area.getData().add(series);
		for (int i = 0; i < lista.getLongitud(); i++) {
			final XYChart.Data<String, Number> dato = new XYChart.Data<>(String.valueOf(i), lista.obtenerNodo(i));
			series.getData().add(dato);
			dato.getNode().setStyle(color[new Random().nextInt(4)]);
		}
	}

	private void numerosAleatorios() {
		lista = new ListaSimple<>();
		Random rd = new Random();
		for (int i = 0; i < 90; i++) {
			lista.agregarEnCola(rd.nextInt(200));
		}
	}

}
