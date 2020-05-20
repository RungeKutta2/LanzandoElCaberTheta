package clases;
import java.util.Comparator;
import java.util.LinkedList;


public class Podio {
	private LinkedList<Participante> participantes;
	private Comparator<Participante> comparador;

	public Podio(Comparator<Participante> comparador) {
		this.comparador = comparador;
		participantes = new LinkedList<Participante>();
	}

	public void add(Participante participante) {
		boolean entro=false;
		int i=0;
		int len = participantes.size();
		while (!entro && i<len) {
			if(comparador.compare(participante, participantes.get(i)) > 0) {
				entro=true;
				participantes.add(i, participante);
			}
			i++;
		}
	
		if(participantes.size()>3) {
			participantes.removeLast();
		}
		else if(participantes.size()<3 && !entro) {
				participantes.add(participante);
		}
			
	}

	@Override
	public String toString() {
		String res = "";
		for (Participante participante : participantes) {
			res+=participante.getNumero()+" ";
		}
		return res;
	}
	
	public Integer size() {
		return participantes.size();
	}
}
