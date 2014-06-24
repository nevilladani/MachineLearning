/*

Class Accuracy has the key method dataAcc which calculates the accuracy of result we get using 
training as well as test data set tested by the generated decision tree

 */



package decisionTreeML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Accuracy {
	TNode x;
	TNode currentNode;
	int b;
	double accuracy=0;
	static ArrayList<Example> data ; // ArrayList to store examples from training data file.
	public Accuracy() {
		
	}
	public void dataAcc(ArrayList<Example> d, TNode tn) // method to calculate accuracy of the Training data.
	{
		
		data = d;
		x = tn;
		

		int correct =0;
		int wrong =0;
		int[] arrD = new int[6];
		for(int i=0;i<(data.size());i++)
		{	
			
			tn = x;
			for(int j=0;j<6;j++)
			{
				
				
				for(int k=0; k< (tn.child.size());k++)
				{
				
					if(tn.child.get(k).branch == data.get(i).getA(tn.Attribute))
					{
						tn = tn.child.get(k);
				
						break;
					}
				
				}
				
				
			}
		
			if((tn.pClass1 > tn.pClass2 && data.get(i).getCls() == 0) || (tn.pClass1 < tn.pClass2 && data.get(i).getCls() == 1))
			{
				correct++; 
			}
			else 
			{
				wrong++;
				
			}
				
		}
		System.out.println();
		System.out.println("Accuracy of training data: ");
		System.out.println("correct :  " + correct);
		System.out.println("wrong :  " + wrong);
		accuracy = (correct*100)/(wrong + correct);
		System.out.println("Accuracy in % : " + accuracy);
	}
	
	
	public void getTestData(TNode tn, String fileName) // Method to calculate accuracy of test data.
	{
		x = tn;

		int correct =0;
		int wrong =0;
		int[] arrD = new int[6];
		File f2 = new File(fileName);
		ArrayList<Example> exmp2 = new ArrayList<Example>();
		try{
    		
        	Scanner scan = new Scanner(f2);
        	
        	for(int i=0; i<6; i++)
        	{
        		scan.next();

        		arrD[i] = scan.nextInt();

        	}
        	System.out.println();
        	while (scan.hasNextInt())
        	{
        		exmp2.add(new Example(scan.nextInt(),scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt()));
        		
        	}
       
		scan.close();
		
    	}
    	
        catch(FileNotFoundException filenotfoundexception)
    	{
       		System.out.println("File not found.");
    	}
    	     
		catch(IOException ioexception)
    	{
       		System.out.println("File input error occured!");
       
    	}
		
		for(int i=0;i<(exmp2.size());i++)
		{	
			
			tn = x;
			for(int j=0;j<6;j++)
			{
				
				
				for(int k=0; k< (tn.child.size());k++)
				{

					if(tn.child.get(k).branch == exmp2.get(i).getA(tn.Attribute))
					{
						tn = tn.child.get(k);

						break;
					}
				
				}
				
				

				
			}

			if((tn.pClass1 > tn.pClass2 && exmp2.get(i).getCls() == 0) || (tn.pClass1 < tn.pClass2 && exmp2.get(i).getCls() == 1))
			{
				correct++; 
			}
			else 
			{
				wrong++;
				
			}
				
		}
		System.out.println();
		System.out.println("Accuracy of test data: ");
		System.out.println("correct :  " + correct);
		System.out.println("wrong :  " + wrong);
		accuracy = (correct*100)/(wrong + correct); 
		System.out.println("Accuracy in % : " + accuracy);
	}
	
	

}
