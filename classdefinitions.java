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
	
	Element first(){
		// returns first element of sequence
		// pointer to the first and last element
		// -- implement linked list
		Element * ptr = ;
		return 
	}
	
	Sequence rest(){
		// returns the rest of the elements in the sequence
		// without creating a new sequence, only pointing to the rest of the orig sequence
	}
	
	int length(){
		// returns number of elements in Sequence object
	}
	
	void add(Element elm, int pos){
		// method to add an element in a specified position
		// if element already exists at pos, elm is inserted at pos
		// all elements starting at location pos are pushed to the right
		// if pos is not between 0 and length of Sequence, throw error
	}
	
	void delete(int pos) {
		// method to remove an element at specified position
		// after deleting, all elements to the right are pushed to the left
	}
	
	void PrintSequence() {
		// print sequence by surrounding each sequence with [,]
		// e.g.: [[1] [2] '3' 'c' [ 1 3 ['4' '5'] ] ]
	}
}
