package preserve;


import java.util.HashMap;


import preserve.Layer;
import preserve.Node;
import source.WPair;

/**
 * @author Enoch Arulprakash & A. Martin
 *
 */

public class ConLayer extends Layer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7483019775441127963L;
	private int inputSize;
	private int kerrnals;
	private boolean isPooling;
	private HashMap<Node,WPair> biases = new HashMap<Node,WPair>();
	/**
	 * @return the inputSize
	 */
	public int getInputSize() {
		return inputSize;
	}
	/**
	 * @param inputSize the inputSize to set
	 */
	public void setInputSize(int inputSize) {
		this.inputSize = inputSize;
	}
	/**
	 * @return the kerrnals
	 */
	public int getKerrnals() {
		return kerrnals;
	}
	/**
	 * @param kerrnals the kerrnals to set
	 */
	public void setKerrnals(int kerrnals) {
		this.kerrnals = kerrnals;
	}
	/**
	 * @return the biases
	 */
	public HashMap<Node, WPair> getBiases() {
		return biases;
	}
	/**
	 * @param biases the biases to set
	 */
	public void setBiases(HashMap<Node, WPair> biases) {
		this.biases = biases;
	}
	/**
	 * @return the isPooling
	 */
	public boolean isPooling() {
		return isPooling;
	}
	/**
	 * @param isPooling the isPooling to set
	 */
	public void setPooling(boolean isPooling) {
		this.isPooling = isPooling;
	}

	

}
