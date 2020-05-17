import java.util.Comparator;

public class DistanciaComparator implements Comparator<Participante> {
	@Override
	public int compare(Participante participante1, Participante participante2) {
		return participante1.getDistanciaTotal().compareTo(participante2.getDistanciaTotal());
	}
}
