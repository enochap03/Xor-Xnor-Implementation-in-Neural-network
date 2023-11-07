package impsource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;




import java.util.Map;

import source.Layer;
import source.NN;
import source.Node;
import source.WPair;
import utility.ActivationFunction;
import utility.ComputeGradient;
import utility.GenerateRandomWeight;

public class SetupNN {

	static NN network = new NN();
	static GenerateRandomWeight rw = new GenerateRandomWeight(0, 1);
	
	static double inArray[][] = new double [NN.getTrainingSize()][NN.getNumOfInput()];
	static double otArray[][] = new double [NN.getTrainingSize()][NN.getNumOfInput()];
	public static  void SetHyperParameters(int nInput, int nlayers, int bSize ) {
		
		NN.setNumOfLayers(nlayers);
		NN.setTrainingSize(bSize);
		NN.setLrate(0.001);
		NN.setNumOfInput(nInput);
		NN.setNumOfOutput(nInput);
		
	}
	
	

	public static ArrayList<Layer> createLayer(){
		
		ArrayList<Layer> layers = new ArrayList<Layer>();
		Layer layer = null;
		for(int i=0;i<NN.getNumOfLayers();i++) {
			layer = new Layer();
			layer.setNodes(createNodes());
		}
		mapLayers(layers);
		
		return layers;
	}
	static List<Node> createNodes(){
			List<Node> nodes=  new ArrayList<Node>();
			for(int i = 0 ;i<=NN.getNumOfInput(); i++){
				Node node = new Node();
				if(i==0){
					node.setValue(1.0);
				}
				nodes.add(node);
			}
			return nodes;
			
	}
	static void mapLayers(List<Layer> layers){
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
	
	private static void Train(ArrayList<Layer>layers){
		
	
		
		for (int k=0;k<NN.getEphocs();k++){
			for(int j=0;j<NN.batchSize;j++) {
				setInputToInputLayer(layers.get(0),NN.getNumOfInput(),j);
				
				for(int i=1;i<layers.size();i++){

					ArrayList<Node> prevnodes = (ArrayList<Node>) layers.get(i-1).getNodes();
					ArrayList<Node> nodes = (ArrayList<Node>) layers.get(i).getNodes();

					computeNodeValue(prevnodes,nodes);

				}
				findLose(layers,j);
				propogatelosebackward(layers);
				updateWeight(layers);

			}
		}
	}
	
	
	

	private static void updateWeight(ArrayList<Layer> layers) {

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
					 wpair.setWeight(wpair.getNweight());
					 wpair.setNweight(0.0);
				 } 

			}
			
		}

		private static void findLose(List<Layer>layers, int j) {
			
			Layer llayer =  layers.get(layers.size()-1);
			List<Node> lnodes = llayer.getNodes();
			for(int i =0;i<NN.getNumOfOutput();i++) {
				double lose = lnodes.get(i).getValue() -  otArray[j][i];
				double activlose = ComputeGradient.sigGrad((lnodes.get(i).getValue()));
				lnodes.get(i).setDelta(lose*activlose);
	
			}
	
	}
		
	private static void propogatelosebackward(List<Layer>layers){
		
		for(int i = (layers.size()-2);i>-1;i--){
			
			NodewiseLoseTransfer(layers.get(i).getNodes());

			
		}
			
			
			
	}
		

		private static void NodewiseLoseTransfer(List<Node> nodes) {
			
			for (Node node : nodes) {
				
				HashMap<Node,WPair> map = node.getConNodes();

		        Iterator hmIterator = map.entrySet().iterator(); 
		  
		        double  bklose = 0;
		        while (hmIterator.hasNext()) { 
		            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
		            Node nnode = (Node) mapElement.getKey();
		            WPair wpair = (WPair)mapElement.getValue();
		            wpair.setNweight(nnode.getDelta()*node.getValue());
		            bklose = bklose + nnode.getDelta()*wpair.getWeight();
	
		        } 
		        node.setDelta(ComputeGradient.sigGrad(node.getValue())*bklose);	
			}
			
		
		
	}

	private static void computeNodeValue(ArrayList<Node> prev, ArrayList<Node> cur){
			
			
			for(int i =1 ;i<cur.size();i++){
				
				Node n = cur.get(i);
				n.setValue(computeFromPrevNode(prev,n));
	
			}
	
			
		}
		
		private static double computeFromPrevNode(ArrayList<Node>prev, Node cur){
			
			double value =0;
			for (Node node : prev) {
				
				HashMap<Node,WPair> map = node.getConNodes();
				WPair wp = map.get(cur);
				value = value + node.getValue()*wp.getWeight();
				
			}
			value = ActivationFunction.sigmoid(value);
			return value;
		}
		private static void setInputToInputLayer(Layer layer, int numInput,int batchNum){
			
			
			List<Node> nodes = layer.getNodes();
			for(int i=1;i<=numInput;i++){
				
				nodes.get(i).setValue(inArray[batchNum][i]);

			}

			
		}
		
		
	}
		
	

