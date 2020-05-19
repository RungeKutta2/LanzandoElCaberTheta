package clases;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Participante {
	private int numero;
	private List<Lanzamiento> lanzamientos;
	private Double distanciaTotal;
	private Double desviacionTotal;
	private boolean esValido;

	public Participante(int numero) {
		this.numero = numero;
		esValido = true;
		lanzamientos = new ArrayList<Lanzamiento>();
	}

	public void agregarLanzamiento(Lanzamiento lanzamiento) {
		lanzamientos.add(lanzamiento);
		if(!lanzamiento.esValido()) {
			esValido = false;
		}
	}

	private double calcularDesviacion(List<Double> numeros) {
		double suma = 0.0, desviacionEstandar = 0.0;
		int tam = numeros.size();

		for (double numero : numeros) {
			suma += numero;
		}

		double media = suma / tam;

		for (double numero : numeros) {
			desviacionEstandar += Math.pow(numero - media, 2);
		}

		return Math.sqrt(desviacionEstandar / tam);
	}

	private double calcularDesviacionDistancia() {
		return calcularDesviacion(lanzamientos.stream().map(x -> x.getDistancia()).collect(Collectors.toList()));
	}

	private double calcularDesviacionAngulo() {
		return calcularDesviacion(lanzamientos.stream().map(x -> x.getAngulo()).collect(Collectors.toList()));
	}

	public void calcularDistanciaTotal() {
		double distanciaTotal = 0;
		for (Lanzamiento lanzamiento : lanzamientos) {
			if (lanzamiento.esValido()) {
				distanciaTotal += lanzamiento.getDistancia();
			}
		}
		this.distanciaTotal = distanciaTotal;
	}

	public void calcularDesviacionTotal() {
		double desviacionDistancia = calcularDesviacionDistancia();
		double desviacionAngulo = calcularDesviacionAngulo();
		this.desviacionTotal = desviacionDistancia+desviacionAngulo;
	}

	public int getNumero() {
		return numero;
	}

	public Double getDistanciaTotal() {
		return distanciaTotal;
	}

	public Double getDesviacionTotal() {
		return desviacionTotal;
	}

	public boolean getEsValido() {
		return esValido;
	}

}
