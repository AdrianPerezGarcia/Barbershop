import java.util.LinkedList;
import java.util.Queue;

public class Barberia {
	
	private Barbero[] barberos;
	
	private int numSillas;
	
	private static Barberia INSTANCE = null;
	
	public int clientesEsperandoNum = 0;
	
	public static int barberosEsperandoNum = 0;
	
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

	public void setNumeroSillas(int num) {
		this.numSillas = num;
	}

	public void setBarberos(Barbero[] barberos) {
		this.barberos=barberos;
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
		if(barberosEsperandoNum == 0) System.out.println("El cliente " +cliente.getIdentificador()+ " se sienta en una silla de espera.");
		clientesEsperandoNum++;
		clientesEsperando.add(cliente);
		cliente.esperando=true;
		notifyAll();
	}

	public synchronized Cliente buscarCliente(Barbero barbero) {
		barberosEsperandoNum++;
		if (clientesEsperandoNum == 0) System.out.println("El barbero " +barbero.getCharidentificador()+ " se pone a dormir.");
		while(clientesEsperandoNum == 0) {
			try {
				wait();
			} catch (InterruptedException e) {};
		}
		barberosEsperandoNum--;
		return cogerCliente(barbero);
	}

	public synchronized Cliente cogerCliente(Barbero barbero) {
		System.out.println("El barbero " +barbero.getCharidentificador()+ " atiende al cliente " +clientesEsperando.peek().getIdentificador()+ ".");
		this.clientesEsperandoNum--;
		return clientesEsperando.poll();
	}

}
