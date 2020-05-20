package clases;
public class Lanzamiento {
	private double angulo;
	private double distancia;
	private boolean esValido;

	public Lanzamiento(double distancia,double angulo) {
		this.angulo = angulo;
		this.distancia = distancia;
		calcularDistanciaFinal();
	}

	private void calcularDistanciaFinal() {
		if(angulo < 90 && angulo > -90) {
			esValido = true;
			if(angulo >= 30 || angulo <= -30) {
				distancia *= 0.8;
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
