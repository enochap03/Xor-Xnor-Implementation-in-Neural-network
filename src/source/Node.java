package source;

import java.io.Serializable;

import java.util.HashMap;

/**
 * @author Enoch Arulprakash & A. Martin
 *
 */

public class Node implements Serializable {
	
	private double value;
	transient private double delta;
	private HashMap<Node,WPair> conNodes = new HashMap<Node,WPair>();
	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}
	/**
	 * @return the delta
	 */
	public double getDelta() {
		return delta;
	}
	/**
	 * @param delta the delta to set
	 */
	public void setDelta(double delta) {
		this.delta = delta;
	}
	/**
	 * @return the conNodes
	 */
	public HashMap<Node, WPair> getConNodes() {
		return conNodes;
	}
	/**
	 * @param conNodes the conNodes to set
	 */
	public void setConNodes(HashMap<Node, WPair> conNodes) {
		this.conNodes = conNodes;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [value=" + value + ", delta=" + delta + ", conNodes="
				+ conNodes + "]";
	}


}
