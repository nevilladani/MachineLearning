
/*

Class displayTree has method dispT which display the entire decision tree with it key information.

 */


package decisionTreeML;

public class displayTree {

	public displayTree() {

	}
	public static void dispT(TNode r, int sp)
	{
		
		if((r.branch != -1))
		{
			for(int i=0;i<sp-1;i++)
			{
				System.out.print("| ");
			}
		}
		
		if(r.branch != -1)
		{
			//System.out.println( "Attribute: " + r.Attribute + " | Branch: " + " Root Node " + " | Entropy: " + r.NodeEntValue +  " | # of class1 value:" + r.pClass1+ " | # of class2 values:"+r.pClass2);
		//	System.out.println( "Attribute: " + r.Attribute + " | Branch: " + " Root Node " );
			System.out.print( "Attribute " + r.parent.Attribute + " = Branch " +r.branch +" : ");
		}
		//else
		//{
			//System.out.println( "Attribute: " + r.Attribute + " | Branch: " +r.branch + " | Entropy: " + r.NodeEntValue +  " | # of class1: " + r.pClass1+ " | # of class2 values: "+r.pClass2);
			//System.out.print( "Attribute " + r.parent.Attribute + " = Branch " +r.branch +" : ");
		//}	
		
		if(r.Attribute == 0)
		{
			if(r.branch != -1)
			{
				//System.out.println( "Leaf Node: "  + "  | Branch: " +r.branch + " | Entropy: " + r.NodeEntValue +  " | # of class1 value:" + r.pClass1+ " | # of class2 values: "+r.pClass2);
				System.out.print( "  Leaf Node "  + " -> " );
				
				if(r.pClass1>r.pClass2)
				{
					System.out.print("  Class = " + 0);
				}
				else
				{
					System.out.print("  Class = " + 1	);
				}
			}
			
		}
		if((r.branch != -1))
		{
			System.out.println();
		}
		
		for(int i=0;i<r.child.size();i++)
		{
			
			displayTree.dispT(r.child.get(i), sp+1);
		}
	}
}
