import org.apache.commons.math3.distribution.NormalDistribution;

public class Cliente implements Runnable {

	public static Barberia barberia;
	
	private int identificador;
	
	public int getIdentificador() {
		return this.identificador;
	}

	public boolean waiting = false;
	
	public static NormalDistribution distribucionNormal;

	public Cliente(int j) {
		this.identificador = j;
		System.out.println("El cliente " +this.identificador+ " se ha creado");;
	}

	@Override
	public void run() {
		while(true) {
			try{
				Thread.sleep((long)distribucionNormal.getMean());
			}catch (InterruptedException e) {}
			System.out.println("El cliente " +this.identificador+ " llega a la barbería.");
			barberia.llegaCliente(this);
		}
	}
	
}
