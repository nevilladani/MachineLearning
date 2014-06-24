/*

Project completed by: Nevil Ladani
Utd ID: 2021190700



Class Decision tree has the main class and it performs the following functionalities:
- Takes file name input from user.
- reads the training data from the training input file.
- Passes on the training data to class "Tree"
- Prints the decision tree using class "displayTree"
- Get and prints the accuracy of training and test data using class "Accuracy".

*/
package decisionTreeML;

import java.io.*;
import java.util.*;
import java.lang.*;


public class DecisionTree {

	public DecisionTree() {
		
	}

	public static void main(String[] args) 
	{
		String fName1="";
		String fName2="";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a file name with extention(example: train.dat ) for training data input: ");
		fName1 = sc.nextLine();
		System.out.println("Enter a file name with extention(example: test.dat) for test data input:  ");
		fName2 = sc.nextLine();
		File f = new File(fName1);
    	String s = "";
    	float e[] = new float[6];
    	double initEnt;
    	double n=0 , m=0;
    	ArrayList<Example> exmp = new ArrayList<Example>(); //ArrayList to store training file data
    	int[] arr = new int [6]; //Array to store flags to keep record of the processed attributes. 
    	System.out.println("Training Data listed:  ");
    	try{
    		
        	Scanner scan = new Scanner(f);
        
        	
        	for(int i=0; i<6; i++)
        	{
        		System.out.print(scan.next());
        		arr[i] = scan.nextInt();
        		System.out.print(" "+arr[i]+"\t");
        	}
        	System.out.print("class");
        	System.out.println();
        	while (scan.hasNextInt())  //storeing file input into an ArrayList.
        	{
        		exmp.add(new Example(scan.nextInt(),scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt()));
        		
        	}
        	for(int i=0; i<exmp.size(); i++)
        	{
        		System.out.println(exmp.get(i).getA(1)+"\t"+exmp.get(i).getA(2)+"\t"+exmp.get(i).getA(3)+"\t"+exmp.get(i).getA(4)+"\t"+exmp.get(i).getA(5)+"\t"+exmp.get(i).getA(6)+"\t"+exmp.get(i).getCls());
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
    	System.out.println("...................");
    	
    	for(int i=0;i<exmp.size();i++)
    	{
    		if(exmp.get(i).getCls()==1)
    		{
    			m++;
    		}
    		else
    		{
    			n++;
    		}
    	}
    	
    	initEnt = -(((m/(m+n))*(Math.log(m/(m+n)))+(n/(m+n))*(Math.log(n/(m+n)))))/Math.log(2); //Initializing entropy for root node.
    	
    	int c1 =0,c2 =0;
    	
    	TNode tnRoot = new TNode(initEnt);
    	
    	c1=0;
		c2=0;
		for(int k=0;k<exmp.size();k++)
		{
			if(exmp.get(k).getCls() == 0)
			{
				c1 ++;
			}
			else
			{
				c2++;
			}
		}
		tnRoot.setpClass1(c1); //setting the number of class values to a node in decision tree.
		tnRoot.setpClass2(c2);
		
    	
    	
		
    	Tree dt = new Tree(arr);
  
    	dt.newANode(exmp, tnRoot);
    	
    	tnRoot.setBranch(-1);
    	
  
    	System.out.println("Decision Tree Display: ");
    	System.out.println();
    	
    	displayTree.dispT(tnRoot, 0);	
    	
    	Accuracy ac = new Accuracy();
    	ac.dataAcc(exmp, tnRoot);
    	ac.getTestData(tnRoot, fName2);
    	
	}
	
	
}
