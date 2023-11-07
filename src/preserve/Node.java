package preserve;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import source.WPair;

/**
 * @author Enoch Arulprakash & A. Martin
 *
 */

/* Preserve for debug */
public class Node implements Serializable {
	
	private double value;
	transient private double delta;
	private HashMap<Node,WPair> conNodes = new HashMap<Node,WPair>();
	private List<Node> PrevConn = new ArrayList();
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
	public List<Node> getPrevConn() {
		return PrevConn;
	}
	public void setPrevConn(List<Node> prevConn) {
		PrevConn = prevConn;
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
