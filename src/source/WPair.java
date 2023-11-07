package source;

import java.io.Serializable;

/**
 * @author Enoch Arulprakash & A. Martin
 *
 */

public class WPair implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8933956835743137883L;
	private double weight;
	transient private double  nweight;
	
	public WPair(double weight) {
		super();
		this.weight = weight;
	}
	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/**
	 * @return the nweight
	 */
	public double getNweight() {
		return nweight;
	}
	/**
	 * @param nweight the nweight to set
	 */
	public void setNweight(double nweight) {
		this.nweight = nweight;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WPair [weight=" + weight + "]";
	}
	
	

}
