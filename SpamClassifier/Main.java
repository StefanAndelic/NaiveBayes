package SpamClassifier;

import SpamClassifier.Parser;
public class Main {

	
	public static void main(String [] args) {
		
		// adjust the path variable
		String path = "";
/*		String training= "spamLabelled.dat";
		String test = "spamUnlabelled.dat";
*/		
		String training = args[0];
		String test = args[1];
		
		if(args.length < 2){
			
		System.out.println("Please enter the training and test data files again:");
					
		}
			
		String dir = System.getProperty("user.dir");
		System.out.println("Reading data from:" + dir + "\\" + training);
		System.out.println("Reading data from:" + dir + "\\" + test);
		System.out.println("Classifying the unlabelled test set");
		System.out.println("------------------------------------------------------------");

		//loads the training set
		SpamClassifier.Parser.loadtraining(/*path + */training);
		
		//prints out the values that are requested in the assignment handout
		SpamClassifier.Report.reportvalues();
		
		// loads the test set 
		SpamClassifier.Parser.loadtest(/*path +*/ test);
		
		
	}
}
