import java.util.*;

public class classdefinitions{
	public static void main(){}
}

abstract class Element{
	//element content
	//contain functions shared between char, int, and sequence

	/*public Element Get(){
		return this;
	}
	public void Set(Element e){
		this = e;
	}*/
	
	// Define PRint to be an abstract method
	abstract void PrintElement(){
		// System.out.println();
	}
	
}

class MyChar extends Element {
	public MyChar(){
		char c = '0';
	}
	public char Get(){
		return this.c;
	}
	public void Set(char val){
		this.c = val;
	}
	public void PrintChar(char val){
		System.out.print(val);
	}
}

class MyInteger extends Element {
	public MyInteger(){
		int i = 0;
	}
	public int Get(){
		return this.i;
	}
	public void Set(int val){
		this.i = val;
	}			
	public void PrintInt(int val){
		System.out.print(val);
	}
}

class Sequence extends Element {
	//Element content;
	//Sequence next;
	
	//contains what is necessary to produce a list of elements
	//should include dynamic sizing and other functions mentioned in hw
	
	public void first(){
		// returns first element of sequence
		
	}
	
	public void rest(){
		
	}
	
}
