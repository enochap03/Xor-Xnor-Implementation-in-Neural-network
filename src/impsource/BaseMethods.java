package impsource;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Enoch Arulprakash & A. Martin
 *
 */
public interface BaseMethods{
	
	
	public void setInputOutputData(int[][] in, int[][] ot);
	public void establishNn();
	public void establishNn(ArrayList<Object> seq);
	public void initializeInput(int batchNum);
	public void forwardPass();
	public void backwardPass(int rowNum,FileWriter fw1[]) throws IOException ;
	public void updateWeights();
	public boolean saveWeightMatrix(String fileName);
	public void loadWeightMatrix(String fileName);
	public boolean  testResult(int index);

}
