package ie.gmit.sw;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SimilarityComparisonImplTest {
	
	@Test
	public void testGetShingles() {
		String file = "This is a nice string test";
		List<String> file1 = new ArrayList<>();
		
		file1.add(file);
		
		SimilarityComparisonImpl similarityComparisonImpl = new SimilarityComparisonImpl();
		String shingle = similarityComparisonImpl.getShingles(file1);
		
		System.out.println(shingle);
		assertNull(shingle);
		//once implementation is complete shingle should not be null
		//assertNotNull(shingle)
		//Complete this equals test
		//assertEquals();
	}
	
	@Test
	public void testGetJaccardIndex() {
		
	}
	

	
	@Test
	public void testGetBlockingQueue() {
		
	}
	
	// Junit tests will ignore this particular test
	@Ignore 
	@Test
	public void testGetMinHash() {
		
	}
	
}
