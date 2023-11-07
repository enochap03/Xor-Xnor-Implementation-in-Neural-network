package impsource;

import java.util.ArrayList;
import java.util.HashMap;


import source.Layer;
import source.Node;
import source.WPair;
import utility.ActivationFunction;


/**
 * @author Enoch Arulprakash & A. Martin
 *
 */
public class ForwardFlow {
	
	
	
	public static void forwardpropogate(ArrayList<Layer> layers){
		
		for(int i=1;i<layers.size();i++){
			ArrayList<Node> prevnodes = (ArrayList<Node>) layers.get(i-1).getNodes();
			ArrayList<Node> nodes = (ArrayList<Node>) layers.get(i).getNodes();

				
			if(i==layers.size()-1){
				
				computeFinalLayerNodeValue(prevnodes,nodes);
			}
			else
				computeNodeValue(prevnodes,nodes);		
		}
	}
	


	private static void computeNodeValue(ArrayList<Node> prev, ArrayList<Node> cur){
		for(int i =1 ;i<cur.size();i++){
			Node n = cur.get(i);
			n.setValue(computeFromPrevNode(prev,n));
		}
		
	}
	
	private static void computeFinalLayerNodeValue(ArrayList<Node> prev, ArrayList<Node> cur){
		for (Node node : cur) {
			node.setValue(ActivationFunction.sigmoid(computeFromPrevForLastNode(prev,node)));
			
		}
	}
		
	
	private static double computeFromPrevForLastNode(ArrayList<Node>prev, Node cur){
		double value = 0;
		//tree
		for (Node node : prev) {
			HashMap<Node,WPair> map = node.getConNodes();
			WPair wp = map.get(cur);
			if(wp!=null)
				value = value + node.getValue()*wp.getWeight();
		}
		return value;
	}
	private static double computeFromPrevNode(ArrayList<Node>prev, Node cur){
		double value = 0;
		for (Node node : prev) {
			HashMap<Node,WPair> map = node.getConNodes();
			WPair wp = map.get(cur);
			if(wp!=null)
				value = value + node.getValue()*wp.getWeight();
			else
				return cur.getValue();
		}
		return (ActivationFunction.sigmoid(value));
	}
	
	
}
