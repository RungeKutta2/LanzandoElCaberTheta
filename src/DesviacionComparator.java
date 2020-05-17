import java.util.Comparator;

public class DesviacionComparator implements Comparator<Participante> {
	@Override
	public int compare(Participante participante1, Participante participante2) {
		return participante2.getDesviacionTotal().compareTo(participante1.getDesviacionTotal());
	}
}