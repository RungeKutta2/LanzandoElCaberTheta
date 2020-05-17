import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EntradaSalida {
	public Competencia leerDeArchivo(String archivoDeLectura) {
		Scanner scanner = null;
		Competencia competencia = null;
		try {
			scanner = new Scanner(new FileReader(archivoDeLectura));
			int cantidadDeParticipantes = scanner.nextInt();
			competencia = new Competencia();
			for (int i = 0; i < cantidadDeParticipantes; i++) {
				Participante participante = new Participante(i + 1);
				for (int j = 0; j < 3; j++) {
					double distancia = scanner.nextDouble();
					double angulo = scanner.nextDouble();
					Lanzamiento lanzamiento = new Lanzamiento(distancia, angulo);
					participante.agregarLanzamiento(lanzamiento);
				}
				competencia.add(participante);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return competencia;
	}

	public void escribirEnArchivo(String archivoDeEscritura, Competencia competencia) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(archivoDeEscritura));
			writer.write(competencia.getGanadoresConsistencia().toString());
			writer.newLine();
			writer.write(competencia.getGanadoresDistancia().toString());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}
}
