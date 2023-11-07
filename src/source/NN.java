package source;

/**
 * @author Enoch Arulprakash & A. Martin
 *
 */

public class NN {


	public static double lrate ;
	public static int  ephocs;
	public static int trainingSize;
	public static int numOfLayers;
	public static int numOfInput;
	public static int numOfOutput;
	public static int batchSize;
	public static long count = 0;
	public static long saveAfterEvery;
	

	/**
	 * @return the lrate
	 */
	public static double getLrate() {
		return lrate;
	}
	/**
	 * @param lrate the lrate to set
	 */
	public static void setLrate(double lrate) {
		NN.lrate = lrate;
	}
	/**
	 * @return the ephocs
	 */
	public static int getEphocs() {
		return ephocs;
	}
	/**
	 * @param ephocs the ephocs to set
	 */
	public static void setEphocs(int ephocs) {
		NN.ephocs = ephocs;
	}

	
	/**
	 * @return the trainingSize
	 */
	public static int getTrainingSize() {
		return trainingSize;
	}
	/**
	 * @param trainingSize the trainingSize to set
	 */
	public static void setTrainingSize(int trainingSize) {
		NN.trainingSize = trainingSize;
	}
	/**
	 * @return the numOfLayers
	 */
	public static int getNumOfLayers() {
		return numOfLayers;
	}
	/**
	 * @param nlayers the numOfLayers to set
	 */
	public static void setNumOfLayers(int nlayers) {
		NN.numOfLayers = nlayers;
	}
	/**
	 * @return the numOfInput
	 */
	public static int getNumOfInput() {
		return numOfInput;
	}
	/**
	 * @param numOfInput the numOfInput to set
	 */
	public static void setNumOfInput(int numOfInput) {
		NN.numOfInput = numOfInput;
	}
	/**
	 * @return the numOfOutput
	 */
	public static int getNumOfOutput() {
		return numOfOutput;
	}
	/**
	 * @param numOfOutput the numOfOutput to set
	 */
	public static void setNumOfOutput(int numOfOutput) {
		NN.numOfOutput = numOfOutput;
	}
	/**
	 * @return the batchSize
	 */
	public static int getBatchSize() {
		return batchSize;
	}
	/**
	 * @param batchSize the batchSize to set
	 */
	public static void setBatchSize(int batchSize) {
		NN.batchSize = batchSize;
	}
	/**
	 * @return the saveAfterEvery
	 */
	public static long getSaveAfterEvery() {
		return saveAfterEvery;
	}
	/**
	 * @param saveAfterEvery the saveAfterEvery to set
	 */
	public static void setSaveAfterEvery(long saveAfterEvery) {
		NN.saveAfterEvery = saveAfterEvery;
	}
	
	
	

}
