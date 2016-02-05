import java.util.*;

public class classdefinitions{
	public static void main(String[] args){
		Sequence list = new Sequence();

	    list.add(new MyInteger(),0);
	    list.add(new MyInteger(),0);
	    list.add(new MyInteger(),1);
	    list.add(new MyInteger(),3);
	    list.add(new MyInteger(),2);
		
		list.get(2).printLink();
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
	
	// Define PRint to be an abstract method
	abstract void PrintElement();
	
}

class MyChar extends Element {
	char c;
	public MyChar(){
		c = '0';
	}
	public char Get(){
		return this.c;
	}
	public void Set(char val){
		this.c = val;
	}
	public void PrintElement(){
		System.out.print(this.c);
	}
}

class MyInteger extends Element {
	int i;
	public MyInteger(){
		i = 0;
	}
	public int Get(){
		return this.i;
	}
	public void Set(int val){
		this.i = val;
	}			
	public void PrintElement(){
		System.out.print(this.i);
	}
}


class Link{
	public Element n1;
	public Link nextLink;
	
	public Link(Element n1arg){
		n1 = n1arg;
	}
	public void printLink() {
		    System.out.print(n1 + ",");
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
	public void PrintElement(){
		
	}
	
	/*public void printSequence() {
		    Link currentLink = head;
		    System.out.print("List: ");
		    while(currentLink != null) {
			    currentLink.printLink();
			    currentLink = currentLink.nextLink;
		    }
		    System.out.println("");
	}*/
	
	/*public void insert(Element n1)){
		Link link = new Link(n1);
		link.nextLink = head;
		head = link;
	}*/
	Link get(int index){
		
		Link gottenLink=head;
		for(int i=0; i<index; i++)
			gottenLink = gottenLink.nextLink;
		return gottenLink;		
	}
	
	/*Element first(){
		// returns first element of sequence
		// pointer to the first and last element
		// -- implement linked list
		//Element * ptr = ;
	}
	Sequence rest(){
		// returns the rest of the elements in the sequence
		// without creating a new sequence, only pointing to the rest of the orig sequence
	}
	
	int length(){
		// returns number of elements in Sequence object
	}*/
	void add(Element elm, int pos){
		// method to add an element in a specified position
		// if element already exists at pos, elm is inserted at pos
		// all elements starting at location pos are pushed to the right
		// if pos is not between 0 and length of Sequence, throw error
	
		
		Link newLink = new Link(elm);
		newLink.nextLink = this.get(pos);
		if (this.get(pos-1)==null)
			head = newLink;
		else
			this.get(pos-1).nextLink = newLink;
		sequenceCount++;
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
