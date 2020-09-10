package SpamClassifier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Parser {

// stores the spam instances 
public static int pos[] = new int [13];
//stores the non-spam instances 
public static int neg[] = new int [13];

public static String result;


// loads the training set 
public static void loadtraining(String filename) {

	String line;
	// initialises the values in the arrays to 0
	Arrays.fill(pos, 0);
	Arrays.fill(neg, 0);
	try {
	
		BufferedReader br = new BufferedReader(new FileReader(filename));

	while ((line = br.readLine()) != null) {
	
	String[] temp = line.split("     ");
	
	for(int j = 0; j < temp.length-1; j++) { 
		temp[j]= temp[j+1];
	}
		if(temp[12].equals("1")) {
			
			pos[12]+=1;             // spam=true counter
		
		for(int j = 0; j < temp.length-2; j++) { 
			if(temp[j].equals("1")) {
			
			pos[j]+=1;	//feature[j]=true when spam=true counter
				
			}
				
			
			
		}
		
		
		
		}

		else {
			
			neg[12]+=1;   // spam=false counter
			for(int j = 0; j < temp.length-2; j++) { 
				if(temp[j].equals("0")) {
				
					neg[j]+=1;		//feature[j]=false when spam=false counter
					
				}
			
		}
		
		
	}
		

	}
		
		
	
	br.close();
}
	catch(IOException e) {
		
		
	e.printStackTrace();
	System.out.print("File not found");
	
	}

	

}
	
	
	
	
	


// loads the test set file	
public static void loadtest(String filename) {
	
	String line;
	// variables are initialised to 1 to avoid the 0 occurance problem  
	double spam = 1;
	double nonspam = 1;
	int row = 0;
	
	spam = spam * (pos[12] + 1)/(pos[12]+neg[12]+ 20);  
	nonspam = nonspam * (neg[12] + 1)/((pos[12]+neg[12])*20); 	
	
	try {
	
		BufferedReader br = new BufferedReader(new FileReader(filename));

	while ((line = br.readLine()) != null) {
	 row++;
	String []  temp = line.split("     ");	
	
	for(int j = 0; j < temp.length-1; j++) { 
		temp[j]= temp[j+1];
	}
	
	for(int j = 0; j < temp.length-2; j++) {  
		if(temp[j].equals("1")) {
	
			spam = spam * (pos[j] + 1)/(pos[12] + 2);
			nonspam = nonspam * (neg[12]-neg[j] + 1)/(neg[12] + 2);
		}
		else {
			
			spam = spam * (pos[12] - pos[j]+ 1)/(pos[12] + 2);    // t 
			nonspam = nonspam * (neg[j] + 1)/(neg[12] + 2);           // f
			
		}
		
		
	}
	
	
	if(spam > nonspam) { //label calculation 
		result = "spam";
		
		
	}
	else {
		
		result = "nonspam";
				
	}
	
	System.out.println("----------------------------------------------------------------------------");
	
	System.out.println("Instance " + row + " " +  "P(S|D)=" + " " + spam + " " + "P(!S|D)=" + nonspam);

	System.out.println("Classification for" + " " + "instance in line" + " " + row + " " + "is" + " " + result);
		
	}
	
	br.close();
}
	catch(IOException e) {
		
		
	e.printStackTrace();
	
	
	}
	System.out.println("------------------------------------------------------------------------------");
	
	

	
	
	
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
