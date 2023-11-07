package impsource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import source.Layer;
import source.NN;
import source.Node;
import source.WPair;
import utility.GenerateRandomWeight;

/**
 * @author Enoch Arulprakash & A. Martin
 *
 */

public class NNCreation {


	static GenerateRandomWeight rw = new GenerateRandomWeight(-1, 1);
	public static ArrayList<Layer> createLayer(){

		ArrayList<Layer> layers = new ArrayList<Layer>();
		Layer layer = null;
		for(int i=0;i<NN.getNumOfLayers();i++) {
			layer = new Layer();
			if(i+1==NN.getNumOfLayers())
				layer.setLnumNodes(NN.getNumOfOutput()-1);
			else
				layer.setLnumNodes(NN.getNumOfInput());
			layer.setNodes(createNodes(layer.getLnumNodes()));
			layers.add(layer);
		}
		mapLayers(layers);
		return layers;
	}

	private static List<Node> createNodes(int num){
		List<Node> nodes=  new ArrayList<Node>();
		for(int i = 0 ;i<=num; i++){
			Node node = new Node();
			if(i==0){
				node.setValue(1.0);
			}
			nodes.add(node);
		}
		return nodes;

	}


	private static void mapLayers(List<Layer> layers){
		for(int i = 0; i<layers.size()-1;i++){

			if(i==layers.size()-2)
				mapNodeLlayer(layers.get(i).getNodes(),layers.get(i+1).getNodes());
			else

				mapNode(layers.get(i).getNodes(),layers.get(i+1).getNodes());
		}
	}


	private static void mapNode(List<Node> nodesl1, List<Node> nodesl2) {

		for (Node node : nodesl1) {
			HashMap<Node,WPair> map = new HashMap<Node,WPair>();
			for(int i=1;i<nodesl2.size();i++){
				Node n = nodesl2.get(i);
				map.put(n,new WPair(rw.getRandomNumber()));
			}
			node.setConNodes(map);
		}

	}
	private static void mapNodeLlayer(List<Node> nodesl1, List<Node> nodesl2) {
		for (Node node : nodesl1) {
			HashMap<Node,WPair> map = new HashMap<Node,WPair>();
			for (Node node2 : nodesl2) {
				map.put(node2,new WPair(rw.getRandomNumber()));
			}
			node.setConNodes(map);

		}
	}
}
