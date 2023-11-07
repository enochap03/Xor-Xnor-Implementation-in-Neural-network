package source;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Enoch Arulprakash & A. Martin
 *
 */


public class Layer implements Serializable{

	private static final long serialVersionUID = 1L;
	private int lnumNodes;
	private List<Node> nodes = new ArrayList<Node>();


	/**
	 * @return the nodes
	 */
	public List<Node> getNodes() {
		return nodes;
	}

	/**
	 * @param nodes the nodes to set
	 */
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	/**
	 * @return the lnumNodes
	 */
	public int getLnumNodes() {
		return lnumNodes;
	}

	/**
	 * @param lnumNodes the lnumNodes to set
	 */
	public void setLnumNodes(int lnumNodes) {
		this.lnumNodes = lnumNodes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Layer [lnumNodes=" + lnumNodes + ", nodes=" + nodes + "]";
	}

	
	

}
