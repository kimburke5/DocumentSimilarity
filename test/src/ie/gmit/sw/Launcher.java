package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *Thread handling and jaccard calculations
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
		
		//Queues of Shingles for each file
		BlockingQueue <Shingle> q1 = new LinkedBlockingQueue<>();
		BlockingQueue <Shingle> q2 = new LinkedBlockingQueue<>();
		
		// Document Parser Threads
		Thread t1 = new Thread (new documentParser(file1),"T1");
		Thread t2 = new Thread (new documentParser(file2),"T2");
		
		t1.start();
		t2.start();
		
		//// Consumer threads- creates mini-hashes for Jaccard indexing
		
		///fix ShingleSize
		//Thread t3 = new Thread (new documentParser(file1,q1,ShingleSize,k),"T3");
		//Thread t4 = new Thread (new documentParser(file2,q2,ShingleSize,k),"T4");
		
		t1.join();
		t2.join();

		//join when fix is made
		
		//t3.join();
		//t4.join();
		
		////result print when calculations are inserted
		System.out.println("------------------------------------------------------");
		System.out.println("Similarity: ...%");//jaccard result
		System.out.println("------------------------------------------------------");
		

	}
	
	float Jaccard(List<Integer> A,List<Integer> B) {
			
			//Need to Calculate Jaccard algorithm in here
		
			//bit from notes....need to add the maths to calc
			float result = 0;
			
			List<Integer> intersection = new ArrayList<Integer>(A);
			
			intersection.retainAll(B);

			return result;
		}
	
	

}
