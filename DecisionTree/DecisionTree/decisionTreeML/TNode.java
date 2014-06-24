

/*

- Class TNode is used to store the Decision tree generated by recursive calls of method NewANode() in class "Tree".
- The program also keeps tract of the entropy, attribute value and number of each class values for each node.

 */

package decisionTreeML;

import java.io.*;
import java.util.*;

public class TNode {

	
	public Double NodeEntValue;
	ArrayList<TNode> child;
	public TNode parent;
	public int branch; 
	public int Attribute;
	public int pClass1;
	public int pClass2;
	public int leaf;
	public TNode(Double s) 
	{
		
		NodeEntValue = s;
		
		parent = null;
		child = new ArrayList<TNode>();
	}
	public void addChild(Double name) 
	{
        this.addChild(new TNode(name));
    }

    public void addChild(TNode child) 
    {
        this.child.add(child);
    }
    public void setValue(int nodeNew)
    {
    	Attribute = nodeNew;
    }
    public void setBranch(int br)
    {
    	branch = br;
    }
    public void setpClass1(int c1)
    {
    	pClass1 = c1;
    }
    public void setpClass2(int c2)
    {
    	pClass2 = c2;
    }

}