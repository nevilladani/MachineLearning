
/*
 
- The class Entropy has method entropyCal() which is used to calculate the entropy of a given splitting Node attribute.
- It returns the entropy value of the splitting node and all its corresponding blanching values.


 */


package decisionTreeML;

import java.util.*;

public class Entropy {
	
	
	int a=0;
	public Entropy() {

	}
	public double[] entropyCal(ArrayList<Example> exmp, int a, int b)
	{
		
		int total = exmp.size();
		int[][] v = new int[b][3];
		this.a = a;
		for (int i = 0; i< b; i++)
		{
			v[i][0] = -1;
			v[i][1] = 0;
			v[i][2] = 0;
		}

		for (int i = 0; i< exmp.size(); i++)
		{

			if(exmp.get(i).getCls()==1)
			{
				
				for(int j = 0; j< b;j++)
				{
					if(v[j][0] == -1 )
					{
						v[j][0]= exmp.get(i).getA(a);
						v[j][2] = 1;
						break;
					}
					else if(exmp.get(i).getA(a)== v[j][0])
					{
						v[j][2]++;
						break;
					}
				}
			}					
			else
			{
				
				for(int j = 0; j< b;j++)
				{
					if(v[j][0] == -1 )
					{
						v[j][0]= exmp.get(i).getA(a);
						v[j][1] = 1;
						break;
					}
					else if(exmp.get(i).getA(a)== v[j][0])
					{
						v[j][1]++;
						break;
					}
				}
			}
		}
		double vTotal= 0;
		double E1=0,E2=0;
		double p = 0;
		double entropyValue=0;
		double attrData[] = new double[b+1];
		for(int i =0; i< b;i++)
		{
			
			vTotal = v[i][1]+v[i][2];
			p = (vTotal/total);
			if(v[i][1]==0)
			{
				E1 = 0;
			}
			else
			{
				E1 = (v[i][1]/vTotal)*(Math.log(v[i][1]/vTotal)/Math.log(2));
			}

			if(v[i][2]==0)
			{
				E2=0;
			}
			else
			{
				E2 = (v[i][2]/vTotal)*(Math.log(v[i][2]/vTotal)/Math.log(2));
			}


			entropyValue = entropyValue - p*(E1+E2);
			
			
		}

		attrData [0]= entropyValue;
		for(int i=0;i<b;i++)
		{
			attrData[i+1] = v[i][0];
		}
		
		return attrData;
	}
}
