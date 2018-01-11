package ie.gmit.sw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Thread handling and jaccard indexing
 * @author kimburke
 * @version 1.0
 *
 */

public class Launcher {
	
	int k; //minHash
	private int [] minHash;
	
	public Launcher(String file1, String file2, int hash) throws InterruptedException{
		
		//initialize k
		k = hash;
		
		Random random =new Random();
		minHash = new int [k];
		
		//adding random ints to minHash
		for (int i=0;i<minHash.length;i++) {
			minHash[i] = random.nextInt();
	
		}
		
		//Queues of Shingles for each file
		BlockingQueue <Shingle> q1 = new LinkedBlockingQueue<>();
		BlockingQueue <Shingle> q2 = new LinkedBlockingQueue<>();
		
		//minHash maps
		Map <Integer,List<Integer>> m1 = new HashMap<>();
		Map <Integer,List<Integer>> m2 = new HashMap<>();
		
		// Document Parser Threads
		//updated thread to meet the doc parser parameters
		Thread t1 = new Thread (new documentParser(file1, q1, 4, k),"T1");
		Thread t2 = new Thread (new documentParser(file2, q2, 4, k),"T2");
		
		//start thread t1 and t2
		t1.start();
		t2.start();
		
		//Consumer Thread
		Thread t3 = new Thread (new Consumer(q1, m1, k, minHash),"T3");
		Thread t4 = new Thread (new Consumer(q2, m2, k, minHash),"T4");
		
		//start thread t3 and t4
		t3.start();
		t4.start();
		
		t1.join();
		t2.join();
		
		t3.join();
		t4.join();
		
		//initailizing result
		float result = Jaccard(m1.get(0),m2.get(0));
		
		////result print 
		System.out.println("---------------------------------------------");
		System.out.println("Similarity: "+result+"%");//jaccard result
		System.out.println("---------------------------------------------");
		

	}
	
	float Jaccard(List<Integer> A,List<Integer> B) {
		    
		System.out.println("A ="+A);
		System.out.println("B ="+B);
		
		
		    //A.get(0);
			float result = 0.0f;
			
			List<Integer> intersection = new ArrayList<Integer>(A);
			
			intersection.retainAll(B);
			
			//calculations for Jaccard indexing
			int AxB = intersection.size();
			int AuB = A.size() + B.size() - AxB;
		
			System.out.println("Common (AxB): "+AxB);
			System.out.println("Total  (AuB): "+AuB);
			
			// Calculates Jaccard percentage and assigns to result
			result = ((float)AxB/AuB)*100.0f;
			

			return result;
		}
	
	

}
