public class Generator {
	
	private static int numThreads = 4;
	private static GeneratorThread threads[] = new GeneratorThread[numThreads];
	
	public static void main(String[] args) {
		for (int i = 0; i < numThreads; i++) {
			threads[i] = new GeneratorThread(i);
		}
		
		for (int i = 0; i < numThreads; i++) {
			threads[i].begin();
		}
		
	}

}
