package ie.gmit.sw;

/**
 *  this class provides the Shingle calculations
 * @author kimburke
 * @version 1.0
 * 
 *
 */

public class Shingle {
	
	private int docID;
	private int hashCode;
	///Constructors & getters & setters
	
	public Shingle(int docID, int hashCode) {
		super();
		this.docID = docID;
		this.hashCode = hashCode;
	}

	//getters & setters
	
	public int getDocID() {
		return docID;
	}

	public void setDocID(int docID) {
		this.docID = docID;
	}
	
	public int getHashCode() {
		// TODO Auto-generated method stub
		return hashCode;
	}
	
	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}
}
