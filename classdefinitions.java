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
		
		list2.add(new MyChar('O'),0);
		Sequence list4 = new Sequence();
		list4.add(new MyChar('G'),0);
		list2.add(list4,1);
		
		System.out.println("checking list2 ");
		list2.PrintElement();
		System.out.println("checking list ");
		list.PrintElement();
		
		list.add(list2,1);
		
		System.out.println("added list2 to list ... checking list ");
		list.PrintElement();
		
		Sequence list3 = list.copy();
		
		System.out.println("printing the copy");
		//list3.PrintElement();
		
		System.out.println("printing the flat version");
		(list3.flatten()).PrintElement();
		
		//testing Part 4
		
		SequenceIterator it = new SequenceIterator();
		if (it.equal(list3.end()))
			System.out.println("Equal");

/*
		for (it = list3.begin(); !it.equal(list3.end()); it.advance()) {
			// not working because?
			System.out.println("I'm woking...");
			//(it.sqPtr).n1.PrintElement();
		} */

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
		
		char c;
		int i;
	
	// Define PRint to be an abstract method
	abstract void PrintElement();
	
}

class MyDummy extends Element {
	public MyDummy(){
		int i = -1;
	}
	public void PrintElement(){
	}
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

	public Link(){
	}	
}

class Sequence extends Element {
	//Element content;
	//Sequence next;
	
	//contains what is necessary to produce a list of elements
	//should include dynamic sizing and other functions mentioned in hw
	
	private Link head;
	public int sequenceCount;
	
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
			//System.out.println("LOOK AT ME " + index);

			for (Element e = (this.head).n1; j<this.sequenceCount; e = (((this.rest()).head).n1)){
				if (e instanceof Sequence){
					nwSeq.add(((Sequence)e).copy(),index);
					//System.out.println("sequence "+ " added to index  " + index);
					index++;
					//System.out.println("Bruh");
				}
				else{
					nwSeq.add(e,index);
					//System.out.println(e.i + "or " + e.c + " added to index  " + index);
					index++;
				}
				if (j==sequenceCount-1)
					break;
				j++;
			}
			return nwSeq;
		
	}
	public static int flIndex;
	
	public Sequence flatten(){

		Sequence nwSeq = new Sequence();
		Sequence olSeq = this.copy();
		flIndex = 0;
		flatten2(olSeq,nwSeq);
		
		
		//flSeq.head = null;
		//flSeq.sequenceCount = 0;
		//j = 0; //iterator for Elements in OG sequence
	
		//int index = 0; //iterator for new sequence
		//this.flatten2();

		nwSeq.sequenceCount = flIndex;
		System.out.println("sqCount: " + nwSeq.sequenceCount);
		return nwSeq;
		
	}
	
	
	
	public static void flatten2(Sequence notFlat, Sequence toFlatten){
		int j = 0;
		for (Element e = (notFlat.head).n1; j<notFlat.sequenceCount; e = (((notFlat.rest()).head).n1)){
			if (e instanceof Sequence){
				flatten2((Sequence) e, toFlatten);
			}
			else{
				toFlatten.add(e,flIndex);
				flIndex++;
				System.out.println("flIndex is now " + flIndex);	
			}
			
			if (j == (notFlat.sequenceCount)-1){
				break;
			}
			j++;
		}
		
	}
	/*public void append(Sequence s){
		for (Element e = (this.head).n1; j<this.sequenceCount; e = (((this.rest()).head).n1)){
			if (e instanceof Sequence){		
				s.append((Sequence)e)
			}
			else{
				this.
				
			}
		}
	}*/
	
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

	
	SequenceIterator begin() {
	// gives the start of the sequence
		SequenceIterator beginIt = new SequenceIterator();
		beginIt.sqPtr = this.head;
		return beginIt;
	}

	public SequenceIterator end() {
		/*
		Iterate until this.nextLink == NULL,
		then, add the dummy to the next one
		*/
		SequenceIterator endIt = new SequenceIterator();
		endIt.sqPtr = this.head;		
		while ((endIt.sqPtr).nextLink != null) {
			endIt.sqPtr = (endIt.sqPtr).nextLink;
		}
		MyDummy x = new MyDummy();
		Link xLink = new Link(x);
		(endIt.sqPtr).nextLink = xLink;

		return endIt;
		
		/* Method One
		SequenceIterator endIt = new SequenceIterator();
		this.add(new MyDummy(), this.sequenceCount);
		this.sequenceCount--;
		endIt.sqPtr = this.get(this.sequenceCount);
		return endIt;
		*/
	}
}


class SequenceIterator {

	Link sqPtr = new Link();
	
	public boolean equal(SequenceIterator other) {
	// check if two iterators point to the same thing
		if (other.sqPtr == this.sqPtr)
			return true;
		return false;
	}

	SequenceIterator advance() {
	// move the iterator forward
		System.out.println("Moving On");
		SequenceIterator sqIt = new SequenceIterator();
		sqIt.sqPtr = (this.sqPtr).nextLink;
		return sqIt;
	}

	Element get() {
	// return the object to which the SequenceIterator points
		return this.sqPtr.n1;
	}
	
	
}
