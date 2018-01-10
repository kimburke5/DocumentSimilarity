package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Main class for running the Document Similarity 
 * @author kimburke
 * @version 1.0
 *
 */

public class Launcher {
	
	int k; //minHashes
	//private int [] minHash;
	
	public Launcher(String file1, String file2, int hash) throws InterruptedException{
		
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
		//Thread t3 = new Thread (new documentParser(file1,q1,ShingleSize,k),"T3");
		//Thread t4 = new Thread (new documentParser(file2,q2,ShingleSize,k),"T4");
		
		t1.join();
		t2.join();

		//t3.join();
		//t4.join();
		

	}
	
	
	

}
