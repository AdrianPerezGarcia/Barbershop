import org.apache.commons.math3.distribution.ExponentialDistribution;

public class Barbero extends Thread{

	public static Barberia barberia;
	
	public boolean disponible;
	
	private int identificador;

	private char charidentificador;
	
	public static ExponentialDistribution distribucionExponencial;

	public Barbero(int i) {
		this.identificador = i;
		this.charidentificador = (char)(this.identificador + '@');
		System.out.println("El barbero " +this.charidentificador+ " se ha creado.");
	}

	public void run() {
		try {
			while(true) {
				Cliente cliente = barberia.buscarCliente(this);
				this.cortarPelo(cliente);
			}
		}catch (InterruptedException e) {
			System.out.println("El barbero " +this.charidentificador+ " ha sido destruido.");
		}
	}
	
	public void cortarPelo(Cliente cliente) throws InterruptedException {
		Thread.sleep((long)Math.abs(distribucionExponencial.sample()));
		System.out.println("El barbero " +this.charidentificador+ " ha cortado el pelo al cliente " +cliente.getIdentificador()+ ".");
		cliente.esperando = false;
	}
	
	public char getCharidentificador() {
		return this.charidentificador;
	}
	
	public int getIdentificador() {
		return this.identificador;
	}

}
