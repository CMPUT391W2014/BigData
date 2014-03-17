
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
			new FileWritingTest(thId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
