
/*
- Class Tree has a method newANode() which is called recursively to generate the decision tree.
- In each recursion call the program passes the sub AraayList in focus to generate the subtree of a given Node.

 */

package decisionTreeML;

import java.util.ArrayList;

public class Tree {

	double[][] ent; // 2d array to store the entropy of each attribute along with its element values. first column stores all the entropies.
	double minEnt = 0;
	ArrayList<Example> children; // ArrayList to store sub ArrayList formed after splitting the given arrayList 
	private int[] arr2; // array to keep track of the processed and unprocessed attributes during recursion. "-1" stands for the attribute already processed.
	// is the value is not -1, it signifies the possible values of considered attribute.
	int newN;
	Tree dt;
	private int temp;
	int c1 =0;
	int c2 =0;
	public Tree(int[] arr) 
	{
		this.arr2 = arr;

	}
	
	public void newANode(ArrayList<Example> exmp, TNode tnRoot) //this method is called recursively to add new spliting nodes to the decision tree.
	{
		

		Entropy et = new Entropy();
		ent = new double[6][];
		int height=0;
		
		for (int i=0;i<6;i++)
		{
			if(this.arr2[i] != -1)
			{
				ent[i] = et.entropyCal(exmp,i+1,arr2[i]);
				
			}
			else
			{
	
				height ++;
			}
		}
    	
    	
    	int newNode=1;
    	minEnt = 1000;
    	

    	for(int i = 0; i<6; i++)
    	{
    		if(this.arr2[i] != -1)
    		{
    			if(ent[i][0]<minEnt)
    			{
    				minEnt = ent[i][0];
    				newNode = i+1;
    			}
    		}	
    	}

    	for(int i=1; i< ((arr2[newNode-1])+1) ; i++) // the iteration creates all the possible children and assigns a sub ArrayList for the current Node.
    	{	


    		children = new ArrayList<Example>(); // defining a new sub ArrayList for child node.
    		for(int j=0;j<exmp.size(); j++)
    		{
    			if(exmp.get(j).getA(newNode) == ent[newNode-1][i] && ent[newNode-1][i]!=-1)
    			{
    				children.add(exmp.get(j)); // Adding values to sub ArrayList
    			}
    		}

    		TNode tn = new TNode(ent[newNode-1][0]);
    		tnRoot.addChild(tn);
    		tn.parent = tnRoot;
    		tn.parent.setValue(newNode);
    		
    		tn.setBranch((int)(ent[newNode-1][i]));
    		c1=0;
    		c2=0;
    		for(int k=0;k<children.size();k++)
    		{
    			if(children.get(k).getCls() == 0)
    			{
    				c1 ++;
    			}
    			else
    			{
    				c2++;
    			}
    		}
    		tn.setpClass1(c1);
    		tn.setpClass2(c2);
 
    		

    		if(minEnt>0 && height < 5 )
    		{

    			this.temp = arr2[newNode-1]; 
    			this.arr2[newNode-1] = -1;   
    			dt = new Tree(this.arr2);  // add a new child node to the current node(or spliting node)

    			dt.newANode(children,tn); // passing the sub ArrayList of the child node to the method newANode() to recursively get its sub tree.

    			this.arr2[newNode-1] = this.temp;
    		}
    		
    	
    	}
    	// The recursion would continue till it reaches all the leaf nodes.
    	
   	}
	
}
