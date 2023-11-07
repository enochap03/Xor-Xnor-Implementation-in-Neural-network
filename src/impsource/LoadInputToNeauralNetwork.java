package impsource;


import java.util.List;

import source.Layer;
import source.Node;


/**
 * @author Enoch Arulprakash & A. Martin
 *
 */
public class LoadInputToNeauralNetwork {
	
	public static void setInputToInputLayer( Layer layer, int[][] js,  int numInput, int batchNum){
		List<Node> nodes = layer.getNodes();
		for(int i=1;i<=numInput;i++){
			nodes.get(i).setValue(js[batchNum][i-1]);
		}
	}
	
	public static void setConvInputToInputLayer( Layer layer, int[][] ds,  int numInput, int rowNum){
		List<Node> nodes = layer.getNodes();
		try {
			for(int i=0;i<numInput;i++){
				nodes.get(i).setValue(ds[rowNum][i]);
			}
		}
		catch(Exception ie) {
			ie.printStackTrace();
		}
	}
	

}
