package ie.gmit.sw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * API Interface for methods used in document similarity comparisons
 * @author kimburke
 *
 */
public interface SimilarityComparison {

	public String getJaccardIndex(String file1, String file2);
	public String getShingles(List<String> file1);
	public String getBlockingQueue(List<String> file1);
	public HashMap<String, String> getMinHash(ArrayList<String> queue);
	
}
