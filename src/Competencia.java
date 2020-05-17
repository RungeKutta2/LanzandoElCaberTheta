import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Competencia {
	private List<Participante> participantes;
	private Podio consistencia;
	private Podio distancia;

	public Competencia() {
		List<Participante> ganadores = new ArrayList<Participante>();

	}

	public void obtenerGanadoresDistancia() {
		Set<Participante> ganadoresDistancia = new TreeSet<Participante>(new DistanciaComparator());
		for (Participante participante : participantes) {
			participante.calcularDistanciaTotal();
			ganadoresDistancia.add(participante);
		}
		
	}
	
	public void obtenerGanadoresConsistencia() {
		Set<Participante> ganadoresConsistencia = new TreeSet<Participante>(new DesviacionComparator());
		for (Participante participante : participantes) {
			if(participante.getEsValido()) {
				participante.calcularDistanciaTotal();
				ganadoresConsistencia.add(participante);
			}
		}
		
	}
	
	public void add(Participante participante) {
		participantes.add(participante);
	}

}
