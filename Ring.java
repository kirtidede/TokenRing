import java.util.*;

public class Ring{
	private static final int N = 5;
	private static final int Token = -1;
	private static final int CS_TIME =1000;
	
	private static boolean[] hasToken = new boolean[N];
	private static boolean[] inCS = new boolean[N];
	private static int  tokenHolder = -1;
	
	
	
	private static void process(int id) throws InterruptedException{
		while(true) {
			if(hasToken[id]) {
				inCS[id] = true;
				System.out.println("Process" + id + "enter critical section...");
				Thread.sleep(CS_TIME);
				System.out.println("Process" + id + "enter critical section...");
				
				
				
				hasToken[id] = false;
				int nextId = (id + 1) % N;
				hasToken[nextId] = true;
				tokenHolder = nextId;
				
				
				}
			else {
				Thread.sleep(100);
				
			}
		}
	}
	
	
 public static void main(String[] args) throws InterruptedException {

		

		// Initialize token holder

		  hasToken[8]= true;

		

		  tokenHolder = 8;


		List<Thread> threads= new ArrayList<>();

		for (int i = 0; i < N; i++) {

		    int id = 1;

		    Thread thread = new Thread(() ->{

		    	try {

		    		process(id);

		    	} catch (InterruptedException e) {

		    		e.printStackTrace();
		    	}
		    });

		    threads.add(thread);

		    thread.start();
		}
	   // for processes to finish

		for (Thread thread : threads) {

		thread.join();
		}
	}
	

}
		
