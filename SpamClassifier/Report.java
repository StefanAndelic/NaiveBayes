package SpamClassifier;

public class Report {

	
	public static void reportvalues() {
		
		
		for(int j = 0; j < Parser.pos.length-1; j++) {
			
			System.out.println("P(F" + (j+1)+ " =true|spam) " + (double)(Parser.pos[j]+1)/(Parser.pos[12]+2) );
			
		}
		System.out.println("---------------------------------------------------------------------------");	
		for(int j = 0; j < Parser.pos.length-1; j++) {
		System.out.println("P(F" + (j+1)+ " =false|spam) " + (double)(Parser.pos[12]-Parser.pos[j]+1)/(Parser.pos[12]+2) );
		
		}
		System.out.println("---------------------------------------------------------------------------");	
		for(int j = 0; j < Parser.neg.length-1; j++) {
			System.out.println("P(F" + (j+1)+ " =false|non-spam) " + (double)(Parser.neg[j]+1)/(Parser.neg[12]+2) );
			
		}
		
		System.out.println("---------------------------------------------------------------------------");	
		for(int j = 0; j < Parser.neg.length-1; j++) {
			System.out.println("P(F" + (j+1)+ " =true|non-spam) " + (double)(Parser.neg[12]-Parser.neg[j] +1)/(Parser.neg[12]+2) );
			
		}
		
		System.out.println("---------------------------------------------------------------------------");	
	}
	
}
