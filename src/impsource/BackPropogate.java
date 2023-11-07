package impsource;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import source.Layer;
import source.NN;
import source.Node;
import source.WPair;
import utility.ComputeGradient;


/**
 * @author Enoch Arulprakash & A. Martin
 *
 */
public class BackPropogate {

	static long count = 0;
 static void findLoseBackwardPass(ArrayList<Layer>layers, int j, int otArray[][], FileWriter fw[]) throws IOException {
		
	 	
	 	Layer llayer =  layers.get(layers.size()-1);
		List<Node> lnodes = llayer.getNodes();
		double lose =0;
		for(int i = 0;i<NN.getNumOfOutput();i++) {
			lose =  otArray[j][i] -  lnodes.get(i).getValue();
	
				if(NN.count%10==0)	{
					fw[i].write("\n"+String.valueOf(lnodes.get(i).getValue()));
				}
				lnodes.get(i).setDelta(-((2/NN.getNumOfOutput())*lose)*ComputeGradient.sigGrad(lnodes.get(i).getValue()));
	
		}
		
	
		//System.out.println("----------------------------------------------------------------------------After a Batch----------------------------------------------------------------------------------------");
		propogatelosebackward(layers);
		//updateWeight(layers);
		
	}

	public static void propogatelosebackward(List<Layer>layers){
		for(int i = (layers.size()-2);i>-1;i--){
			NodewiseLoseTransfer(layers.get(i).getNodes(),i);
		}
	}

	private static void NodewiseLoseTransfer(List<Node> nodes, int pos) {
		for (Node node : nodes) {
			HashMap<Node,WPair> map = node.getConNodes();
			Iterator hmIterator = map.entrySet().iterator(); 
			double  bklose = 0;
			while (hmIterator.hasNext()) { 
				Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
				Node nnode = (Node) mapElement.getKey();
				WPair wpair = (WPair)mapElement.getValue();
				wpair.setNweight(wpair.getNweight()+(nnode.getDelta()*node.getValue()));
				if(pos>0)
					bklose = bklose + nnode.getDelta()*wpair.getWeight();
			} 
			if(pos>0)

				node.setDelta(ComputeGradient.sigGrad(node.getValue())*bklose);	
		}
	}
	
	public static void updateWeight(ArrayList<Layer> layers) {
		for(int i=0;i<layers.size()-1;i++){
			Layer lyr = layers.get(i);
			updateLayerWegiht(lyr);
		}
	}
	
	private static void updateLayerWegiht(Layer lyr) {

		List<Node> nodes = lyr.getNodes();
		HashMap<Node, WPair> map;
		for (Node node : nodes) {
			map  = node.getConNodes();
			Iterator hmIterator = map.entrySet().iterator(); 
			while (hmIterator.hasNext()) { 
				Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
				WPair wpair = (WPair)mapElement.getValue();
				wpair.setWeight(updateNewWeightToNode(wpair.getWeight(),wpair.getNweight()));
				wpair.setNweight(0.0);
			} 
		}
	}
	
	private static double updateNewWeightToNode(double prev, double lose){
		
		return (prev - (NN.lrate*lose));
		
		
	}
}
