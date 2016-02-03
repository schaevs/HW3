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
	
}

class MyChar extends Element {
	public MyChar(){
		char c = '0';
	}
	public char Get(){
		return this.c;
	}
	Public void Set(char val){
		this.c = val;
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
}

class Sequence extends Element {
	//Element content;
	//Sequence next;
	
	//contains what is necessary to produce a list of elements
	//should include dynamic sizing and other functions mentioned in hw
	
	//public Sequence(){}
	//public Add(Element e){} 
	
}