package impsource;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import source.NN;
import utility.file.InputFromFile;


/**
 * @author Enoch Arulprakash & A. Martin
 *
 */
public class NeuralNetworkImp {

	static NN network = new NN();
	static int inArray[][] ;
	static int otArray[][] ;
	
 static BaseMethods  bsExSeq = new  ImpBaseMethods();


	/**
	 * @param nInput
	 * @param nOutput
	 * @param nlayers
	 * @param bSize
	 * @param lrate
	 * @param ephocs
	 */
	public static  void setHyperParameters(int nInput, int nOutput, int nlayers, int bSize, double lrate,int ephocs ) {
		

		
		NN.setNumOfLayers(nlayers);
		NN.setTrainingSize(bSize);
		NN.setLrate(lrate);
		NN.setNumOfInput(nInput);
		NN.setNumOfOutput(nOutput);
		NN.setEphocs(ephocs);
		
	}
	private static void  loadData(String fileName){
		
		 inArray = new int [NN.getTrainingSize()][NN.getNumOfInput()];
		 otArray = new int [NN.getTrainingSize()][NN.getNumOfOutput()]; 
		 InputFromFile.loadFromCSVFile(inArray,otArray,fileName);
		 bsExSeq.setInputOutputData(inArray, otArray);
	
		 
//		 System.out.println("last out put "+inArray[3][0]);
//		 System.out.println("last out put "+inArray[3][1]);
//		 System.out.println("last out put "+otArray[3][0]);
//		 System.out.println("last out put "+otArray[1][1]);
		
	}
	public static void main(String args[]){
		
		
		/**
		 * @param nInput * @param nOutput  * @param nlayers  * @param bSize  * @param lrate  * @param ephocs
		 */
		String substring ="yes";
		String subChar ="y";
		setHyperParameters(2,2,3,4,0.1,6000);
		String fileName = "InputFile.csv";
		loadData(fileName);
		System.out.println("Do you wish to load weight matrix press Y for yes and N for No");
		 Scanner scanner = new Scanner(System.in);
		 String inputString = scanner.nextLine();
		 if(inputString.toLowerCase().contains(substring)||inputString.toLowerCase().contains(subChar)){
			  System.out.println("Enter the File name");
			 scanner = new Scanner(System.in);
			  fileName = scanner.nextLine();
			 bsExSeq.loadWeightMatrix(fileName);
		 }
			 
		 else
			 bsExSeq.establishNn();
		
		train();
	}
	
	
	private static void train(){

		try {
			FileWriter fwriter[] = new FileWriter[NN.getNumOfOutput()];  
			String fileName ;
			for(int i=0;i<NN.getNumOfOutput();i++) {
				fileName="output"+Integer.toString(i);
				fwriter[i] = new FileWriter(fileName);
				
			}
			for (int k=0;k<NN.getEphocs();k++){
				for(int j=0;j<NN.trainingSize;j++) {

					bsExSeq.initializeInput(j);
					bsExSeq.forwardPass();
					bsExSeq.backwardPass(j,fwriter);

				}
				NN.count++;
				if(NN.count%10==0) {
					for(int i=0;i<NN.getNumOfOutput();i++) {

						fwriter[i].write("\n"+"------------------------------------------after  "+NN.count+"  ephoc-----------------------------------------------");
					}
				}
				bsExSeq.updateWeights();


			}
			for(int i=0;i<NN.getNumOfOutput();i++) {

				fwriter[i].close();
			}
			boolean status = bsExSeq.saveWeightMatrix("ConnectionWeight");
			System.out.println("Saved "+status);

		} 
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

		
	}
		
	

