import java.util.LinkedList;
import java.util.Queue;

public class Barberia {
	
	private Barbero[] barberos;
	
	private int numSillas;
	
	private static Barberia INSTANCE = null;
	
	public int clientesEsperandoNum = 0;
	
	public Queue<Cliente> clientesEsperando = new LinkedList<Cliente>();
	
	private Barberia() {}
	
	private static void createBarberia() {
		if (INSTANCE == null) { 
            INSTANCE = new Barberia();
        }
	}
	
	 public static Barberia getBarberia() {
		 if (INSTANCE == null)
			 createBarberia();
		 return INSTANCE;
	}

	public void setBarberos(Barbero[] barberos) {
		this.barberos=barberos;
	}
	
	public synchronized Cliente buscarCliente(Barbero barbero) {
		while(clientesEsperandoNum == 0) {
			try {
				System.out.println("El barbero " +barbero.getCharidentificador()+ " se pone a dormir.");
				wait();
			} catch (InterruptedException e) {};
		}
		return cogerCliente(barbero);
	}
	
	public synchronized Cliente cogerCliente(Barbero barbero) {
		System.out.println("El barbero " +barbero.getCharidentificador()+ " atiende al cliente " +clientesEsperando.peek().getIdentificador()+ ".");
		this.clientesEsperandoNum--;
		return clientesEsperando.poll();
	}

	public void setNumeroSillas(int num) {
		this.numSillas = num;
	}

	public void llegaCliente(Cliente cliente) {
		System.out.println("El cliente " +cliente.getIdentificador()+ " llega a la barbería.");
		if(clientesEsperandoNum == numSillas) {
			System.out.println("El cliente " +cliente.getIdentificador()+ " se marcha sin ser atendido.");
			return;
		}
		this.aEsperar(cliente);	
	}

	private synchronized void aEsperar(Cliente cliente) {
		clientesEsperandoNum++;
		clientesEsperando.add(cliente);
		System.out.println("El cliente " +cliente.getIdentificador()+ " se sienta en una silla de espera.");
		notifyAll();
	}

}
