package impsource;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import source.Layer;
import source.NN;
import transfer.SaveLoadWeights;

/**
 * @author Enoch Arulprakash & A. Martin
 *
 */
public class ImpBaseMethods implements BaseMethods {

	private ArrayList<Layer> layers ;
	private int inArray[][];
	private int otArray[][];

	/**
	 * @return the layers
	 */
	public ArrayList<Layer> getLayers() {
		return layers;
	}

	/**
	 * @param layers the layers to set
	 */
	public void setLayers(ArrayList<Layer> layers) {
		this.layers = layers;
	}

	
	
	/**
	 * @return the inArray
	 */
	public int[][] getInArray() {
		return inArray;
	}

	/**
	 * @param inArray the inArray to set
	 */
	public void setInArray(int[][] inArray) {
		this.inArray = inArray;
	}

	/**
	 * @return the otArray
	 */
	public int[][] getOtArray() {
		return otArray;
	}

	/**
	 * @param otArray the otArray to set
	 */
	public void setOtArray(int[][] otArray) {
		this.otArray = otArray;
	}

	public void establishNn() {


			setLayers(NNCreation.createLayer());


	}

	public void initializeInput(int batchNum) {
		
	
		
		LoadInputToNeauralNetwork.setInputToInputLayer(layers.get(0),getInArray(),NN.numOfInput,batchNum);
		// TODO Auto-generated method stub

	}

	public void forwardPass() {
		
		ForwardFlow.forwardpropogate(getLayers());
		// TODO Auto-generated method stub
		
	}

	public void backwardPass(int rowNum,FileWriter fw[]) throws IOException {
		
		BackPropogate.findLoseBackwardPass(getLayers(),rowNum,getOtArray(),fw);
		// TODO Auto-generated method stub

	}
	
	public void updateWeights() {
		
		BackPropogate.updateWeight(getLayers());
	}

	
	public boolean saveWeightMatrix(String fileName){
		
		boolean b = SaveLoadWeights.storeWeighToDesk(getLayers(), fileName);
		return b;
	
		
		
	}
	
	public void loadWeightMatrix(String fileName){
		
		setLayers(SaveLoadWeights.getWeighFromDesk(fileName));
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ImpBaseExecutionSeq [layers=" + layers + "]";
	}

	public void setInputOutputData(int[][] in, int[][] ot) {
		setInArray(in);
		setOtArray(ot);
	}


	public void establishNn(ArrayList<Object> seq) {
		// TODO Auto-generated method stub
		
	}

	public boolean testResult(int index) {
		// TODO Auto-generated method stub
		return false;
	}






}
