import java.util.*;

public class classdefinitions{
	public static void main(String[] args){
		Sequence list = new Sequence();

	    list.add(new MyInteger(0),0);
		//printcheck(list);
		
	    list.add(new MyInteger(1),0);
		//printcheck(list);
		
	    list.add(new MyInteger(2),0);
		//printcheck(list);
		
	    list.add(new MyInteger(3),0);
		//printcheck(list);
		
	    list.add(new MyInteger(4),0);
		//printcheck(list);
		
		list.add(new MyInteger(5),5);
		//printcheck(list);
		
		list.add(new MyInteger(6),5);
		//printcheck(list);
		
		list.add(new MyInteger(7),7);
		//printcheck(list);
		
		list.add(new MyChar('f'),8);
		
		Sequence list2 = new Sequence();
		
		list2.add(new MyChar('g'),0);
		
		System.out.println("checking list2 ");
		list2.PrintElement();
		System.out.println("checking list ");
		list.PrintElement();
		
		list.add(list2,1);
		
		System.out.println("added list2 to list ... checking list ");
		list.PrintElement();
		
		Sequence list3 = list.copy();
		
		System.out.println("printing the copy");
		list3.PrintElement();
			
		
		//printcheck(list);
		//list.delete(5);
		
		//printcheck(list);
		
		
		//System.out.println("checking copy");
		
		//(list.copy()).PrintElement();
		
		
		//list.get(1).printLink();	
	}
	
	public static void printcheck(Sequence checkedSequence)
	{
		System.out.println("\n\nsequence count is: " + checkedSequence.length());
		for (int k = 0; k<checkedSequence.length(); k++){
			System.out.println("printing "+ ((checkedSequence.get(k)).n1).i);
		}
		
	}
}

abstract class Element{
	//element content
	//contain functions shared between char, int, and sequence

	public Element(){
		
	}
	/*public Element Get(){
		return this;
	}
	public void Set(Element e){
		this = e;
	}*/
		
		char c;
		int i;
	
	// Define PRint to be an abstract method
	abstract void PrintElement();
	
}

class MyChar extends Element {
	public MyChar(){
		c = '0';
	}
	public MyChar(char value){
		c = value;
	}
	
	
	public char Get(){
		return this.c;
	}
	public void Set(char val){
		this.c = val;
	}
	public void PrintElement(){
		System.out.print("'" + this.c + "'");
	}
}

class MyInteger extends Element {
	public MyInteger(){
		i = 0;
	}
	public MyInteger(int value){
		i = value;
	}
	public int Get(){
		return this.i;
	}
	public void Set(int val){
		this.i = val;
	}			
	public void PrintElement(){
		System.out.print(" " + this.i + " ");
	}
}


class Link{
	public Element n1;
	public Link nextLink;
	
	public Link(Element n1arg){
		n1 = n1arg;
	}	
}

class Sequence extends Element {
	//Element content;
	//Sequence next;
	
	//contains what is necessary to produce a list of elements
	//should include dynamic sizing and other functions mentioned in hw
	
	private Link head;
	private int sequenceCount;
	
	public Sequence(){
		head = null;
		sequenceCount = 0;
	}
	public Sequence copy(){
		Sequence nwSeq = new Sequence();
		/*for (int i=0; i < sequenceCount; i++){
			if ((this.get(i)).n1 instanceof Sequence){
				nwSeq.add( (Sequence)((this.get(i)).n1).copy() );
			}
			else {
				nwSeq.add((this.get(i)).n1,nwSeq.sequenceCount);
			}
		}*/
			int j = 0;
			int index = 0;
			System.out.println("LOOK AT ME " + index);

			for (Element e = (this.head).n1; j<this.sequenceCount; e = (((this.rest()).head).n1)){
				if (e instanceof Sequence){
					((Sequence)e).copy();
					System.out.println("Bruh");
				}
				else{
					nwSeq.add(e,index);
					System.out.println(e.i + "or " + e.c + " added to index  " + index);
					index++;
				}
				if (j==sequenceCount-1)
					break;
				j++;
			}
			return nwSeq;
		
	}
	
	public Sequence flatten(){
		//returns a flattened sequence object
		Sequence flSequence = new Sequence();
		Sequence tempSequence = new Sequence();
		int i = 0;
		
		while (!((this.get(i)).n1 instanceof Sequence)){
			
			
		}
		
		
		return flSequence;
		
	}
	
	Link get(int index){
		
		Link gottenLink=head;
		for(int i=0; i<index; i++)
			gottenLink = gottenLink.nextLink;
		return gottenLink;		
	}
	
	public Element index(int pos){
		if (pos>sequenceCount-1){
			//error
		}
		
			return (this.get(pos)).n1;
		
		
	}
	
	Element first(){
		// returns first element of sequence
		// pointer to the first and last element
		// -- implement linked list
		//Element * ptr = ;
		
		return (get(0)).n1;
	}
	Sequence rest(){
		// returns the rest of the elements in the sequence
		// without creating a new sequence, only pointing to the rest of the orig sequence
		this.head = this.get(1);
		return this;
	}
	
	int length(){
		return this.sequenceCount;
	}
	void add(Element elm, int pos){
		// method to add an element in a specified position
		// if element already exists at pos, elm is inserted at pos
		// all elements starting at location pos are pushed to the right
		// if pos is not between 0 and length of Sequence, throw error
	
		if (pos > sequenceCount){
			//error
		}
		else{
			Link newLink = new Link(elm);
			newLink.nextLink = this.get(pos);
			if (pos == 0)
				head = newLink;
			else
				(this.get(pos-1)).nextLink = newLink;
			sequenceCount++;
		}
	}
	
	void delete(int pos) {
		// method to remove an element at specified position
		// after deleting, all elements to the right are pushed to the left
		(this.get(pos-1)).nextLink = (this.get(pos)).nextLink;
		sequenceCount--;
	}
	
	public void PrintElement(){
		System.out.print(" [");
		for (int p=0; p < sequenceCount; p++){
			((this.get(p)).n1).PrintElement();
			//System.out.print(" ");
		}
		System.out.print("] ");
	}
	
	void PrintSequence() {
		// print sequence by surrounding each sequence with [,]
		// e.g.: [[1] [2] '3' 'c' [ 1 3 ['4' '5'] ] ]
	}
}
