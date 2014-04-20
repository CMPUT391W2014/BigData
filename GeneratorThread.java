
public class GeneratorThread extends Thread {
	private int thId;
	
	public GeneratorThread(int id) {
		super();
		thId = id;
	}
	
	public void begin() {
		start();
	}
	
	public void run() {
		try {
			new DataWriter2(thId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
