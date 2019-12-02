import org.apache.commons.math3.distribution.NormalDistribution;

public class Cliente implements Runnable {

	public static Barberia barberia;
	
	private int identificador;
	
	public int getIdentificador() {
		return this.identificador;
	}

	public boolean esperando = false;
	
	public static NormalDistribution distribucionNormal;

	public Cliente(int j) {
		this.identificador = j;
		System.out.println("El cliente " +this.identificador+ " se ha creado");;
	}

	@Override
	public void run() {
		try{
			while(true) {
				Thread.sleep((long)Math.abs(distribucionNormal.sample()));
				if (this.esperando == false) barberia.llegaCliente(this);
			}
		}catch(InterruptedException e) {
			System.out.println("El cliente " +this.identificador+ " ha sido destruido.");
		}
		
	}
	
}
