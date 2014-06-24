
/*


Class Example is used to story the ArrayList of the examples from training data set.


 */

package decisionTreeML;

public class Example {

	private int a1;
	private int a2;
	private int a3;
	private int a4;
	private int a5;
	private int a6;
	private int cls;
	
	public Example() {
	}
	public Example(int a1, int a2, int a3, int a4, int a5, int a6, int cls)
	{
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
		this.a4 = a4;
		this.a5 = a5;
		this.a6 = a6;
		this.cls = cls;
	}
	
	public int getA(int p) 
	{
		if(p==1)
			return a1;
		else if(p==2)
			return a2;
		else if(p==3)
			return a3;
		else if(p==4)
			return a4;
		else if(p==5)
			return a5;
		else 
			return a6;
	}

	public void setA1(int a1) {
		this.a1 = a1;
	}

	public void setA2(int a2) {
		this.a2 = a2;
	}

	public void setA3(int a3) {
		this.a3 = a3;
	}

	public void setA4(int a4) {
		this.a4 = a4;
	}

	public void setA5(int a5) {
		this.a5 = a5;
	}

	public void setA6(int a6) {
		this.a6 = a6;
	}
	public int getCls() {
		return cls;
	}
	public void setCls(int cls) {
		this.cls = cls;
	}
	
}
