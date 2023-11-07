package transfer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import source.Layer;


/**
 * @author Enoch Arulprakash & A. Martin
 *
 */

public class SaveLoadWeights {


		public static boolean storeWeighToDesk(ArrayList<Layer> layers, String fileName)  {

			try {

				FileOutputStream fs = new FileOutputStream(fileName);
				ObjectOutputStream os = new ObjectOutputStream(fs);
				os.writeObject(layers);
				
			}

			catch(IOException io){
					System.out.println("IO Exception "+io);
				
			}
			catch(Exception e){
				
				System.out.println("Other exception "+e);
			}
			return true;
		
		}
		public static ArrayList<Layer> getWeighFromDesk(String fileName) {
			
			ArrayList<Layer> lrs = new ArrayList<Layer>();	
			try{
				
				FileInputStream fi = new FileInputStream(fileName);
				ObjectInputStream oi = new ObjectInputStream(fi);
				lrs = (ArrayList<Layer>) oi.readObject();
				return lrs;
	
			}
			catch (ClassNotFoundException cn) {
				
				System.out.println("Class not found "+cn);
			}

			catch(IOException io){
				
				System.out.println("IO Exception"+ io);
			}
			
			catch (Exception e) {
				
				System.out.println("Other Exception "+e);
			}
			return lrs;
			
		}
		
}
