package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 *  this class implements Runnable
 *  calculates min hash 
 * @author kimburke
 * @version 1.0
 * 
 *generating from workshop notes
 */

public class Consumer implements Runnable{

	private BlockingQueue <Shingle>queue;
	private int [] minHash;
	private int k;
	private Map <Integer,List<Integer>> map;
	private ExecutorService pool;
	
	public Consumer(BlockingQueue<Shingle>q, int k, int poolSize) {
		
		this.queue = q;
		this.k = k;
		//pool = Executor.fixedSizeThreadPool(poolSize);
		init();
	}
	
	
	public void init() {
		Random random = new Random();
		minHash = new int [k];
		
		for(int i = 0;i<minHash.length;i++) {
			minHash[i] = random.nextInt();
		}
		
	}

	@Override
	public void run() {
		
		int docCount = 1;
		int value = 0;
		
		while(docCount>0) {
			
			Shingle s;
			
			try {
				s = queue.take();
				
				if(s.getHashCode()==0) {
					docCount--;
					continue;
				}
				
				List<Integer> list = map.get(s.getDocID());
				
				if(list == null) {
					
					list = new ArrayList<Integer>(k);
					
					for(int j=0; j<k; j++){
						list.set(j, Integer.MAX_VALUE);
					}
					
					map.put(s.getDocID(), list);
				}
				
				for(int i = 0;i<minHash.length;i++) {
					
					value =s.getHashCode() ^ minHash[i];
									
					//populate with minimum hash calculated
					if(list.get(i) > value) {
						list.set(i, value);
					}
					
				}
				
				
				
			} 
			
				catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//blocking method
			
			
		}
		
	}

	public Consumer(BlockingQueue<Shingle> q, Map <Integer,List<Integer>> map,int[] hash, int k) {
		super();
		this.queue = q;
		this.map = map;
		this.minHash = hash;
		this.k = k;
	}

}
