package clases;
import java.util.ArrayList;
import java.util.List;


public class Competencia {
	private List<Participante> participantes;
	private Podio ganadoresDistancia;
	private Podio ganadoresConsistencia;

	public Competencia() {
		participantes = new ArrayList<Participante>();
	}

	public void obtenerGanadores() {
		ganadoresDistancia = new Podio (new DistanciaComparator());
		ganadoresConsistencia = new Podio (new DesviacionComparator());
		for (Participante participante : participantes) {
			if(participante.getEsValido()) {
				participante.calcularDesviacionTotal();
				ganadoresConsistencia.add(participante);
			}
			participante.calcularDistanciaTotal();
			if(participante.getDistanciaTotal()>0) {
				ganadoresDistancia.add(participante);
			}
		}
		
	}
	
	public Podio getGanadoresDistancia() {
		return ganadoresDistancia;
	}

	public Podio getGanadoresConsistencia() {
		return ganadoresConsistencia;
	}

	public void add(Participante participante) {
		participantes.add(participante);
	}

}
