package transfer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import source.Layer;
import source.Node;
import source.WPair;
import utility.GenerateRandomWeight;


/**
 * @author Enoch Arulprakash & A. Martin
 *
 */

/* For exprimentation and checking serialization process */

public class TestSerialize implements Serializable {
	
	private List<Layer> layers ;
	
	
	
	/**
	 * @return the layers
	 */
	public List<Layer> getLayers() {
		return layers;
	}

	/**
	 * @param layers the layers to set
	 */
	public void setLayers(List<Layer> layers) {
		this.layers = layers;
	}

	static GenerateRandomWeight rw = new GenerateRandomWeight(0, 1);
	
	public  List<Layer> createLayer(){

		ArrayList<Layer> layers = new ArrayList<Layer>();
		Layer layer = null;
		for(int i=0;i<10;i++) {
			layer = new Layer();
			layer.setLnumNodes(10);
			layer.setNodes(createNodes(i,layer.getLnumNodes()));
			layers.add(layer);
		}
		setLayers(layers);
		mapLayers(getLayers());
		return getLayers();
	}
	
	private static List<Node> createNodes(int pos, int num){
		List<Node> nodes=  new ArrayList<Node>();
		for(int i = 0 ;i<=num; i++){
			Node node = new Node();
			if(i==0){
				node.setValue(0);
			}
			else
				node.setValue(Double.parseDouble(Integer.toString(pos).concat(Integer.toString(i))));
			nodes.add(node);
		}
		return nodes;
	}
	
	
	private static void mapLayers(List<Layer> layers){
		for(int i = 0; i<layers.size()-1;i++){
			mapNode(layers.get(i).getNodes(),layers.get(i+1).getNodes());
		}
	}
	
	private static void mapNode(List<Node> nodesl1, List<Node> nodesl2) {

		for(int j=0;j<nodesl1.size();j++) {
			HashMap<Node,WPair> map = new HashMap<Node,WPair>();
			for(int i=1;i<nodesl2.size();i++){
				Node n = nodesl2.get(i);
				map.put(n,new WPair(rw.getRandomNumber()));
			}
			Node node = nodesl1.get(j);
			node.setConNodes(map);		
		}
	}

	
	public void printLayer(ArrayList<Layer> layers){
		
		for (Layer layer : layers) {
			
			printEachNode(layer);
			System.out.println("-----------------------------------------------------------After a Layer----------------------------------------------------------");
			
		}
		
	}
	private void printEachNode(Layer layer) {
		
		ArrayList<Node> nodes = (ArrayList<Node>) layer.getNodes();
		for (Node node : nodes) {
			
			System.out.println("Node value: "+node.getValue());
			printNodeAssociatedweight(node);
			System.out.println("-----------------------------------------------------------After a Node----------------------------------------------------------");
	
		}
	
	}

	private void printNodeAssociatedweight(Node node) {
		
		HashMap<Node,WPair> hm = node.getConNodes();
		Iterator hmIterator = hm.entrySet().iterator(); 
		while (hmIterator.hasNext()) { 
			Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
			Node nnode = (Node) mapElement.getKey();
			WPair wpair = (WPair)mapElement.getValue();
			
			System.out.println("Connected weight to "+nnode.getValue()+ " is "+wpair.getWeight());
		
		} 
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestSerialization [layers=" + layers + "]";
	}


}
