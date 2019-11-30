public class Barberia {
	
	private Barbero[] barberos;
	
	private int numSillas;
	
	private static Barberia INSTANCE = null;
	
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

	public void setNumeroSillas(int nextInt) {
		this.numSillas=nextInt;
	}

}
