package utiliserthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExempleExecutorService {
	
	private static Runnable runnable = ()->System.out.println("Exercice1.Etape1");

	public static void main(String[] args) {
		ExecutorService service=Executors.newSingleThreadExecutor();
		service.submit(runnable);
		service.shutdown();
	}

}
