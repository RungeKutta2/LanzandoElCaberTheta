public class Lanzamiento {
	private double angulo;
	private double distancia;
	private boolean esValido;

	public Lanzamiento(double angulo, double distancia) {
		this.angulo = angulo;
		this.distancia = distancia;
		calcularDistanciaFinal();
	}

	private void calcularDistanciaFinal() {
		//entre 22.5 y -22.5 100% de la distancia
		//entre 90 y 22.5 y -90 y -22.5 80% de la distancia
		//demas son tiros invalidos
		if(angulo < 90 || angulo > -90) {
			esValido = true;
			if(angulo > 22.5 || angulo < -22.5) {
				distancia = getDistancia() * 0.8;
			}
		}
		else {
			esValido = false;
		}
	}

	public double getDistancia() {
		return distancia;
	}
	
	public double getAngulo() {
		return angulo;
	}

	public boolean esValido() {
		return esValido;
	}
}
