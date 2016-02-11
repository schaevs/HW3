class Sequence extends Element {

	//contains what is necessary to produce a list of elements
	//should include dynamic sizing and other functions mentioned in hw
	
	public Link head;
	public int sequenceCount;
	
	public Sequence() {
		head = null;
		sequenceCount = 0;
	}

	public Sequence copy(){ //produces deep copy of elements
		Sequence newSeq = new Sequence();
		int j = 0;
		int index = 0;
		//for ( Element e = (this.head).Get(); j < this.sequenceCount; e = ((this.rest()).head).Get() ) {
		for ( Element e = index(j); j < this.sequenceCount; e = index(j)) {
			if (e instanceof MyInteger || e instanceof MyChar) {
			    if (e instanceof MyInteger) {
			        MyInteger newInt = new MyInteger();
			        newInt.Set(((MyInteger)e).Get());
				    newSeq.add(newInt, index);//newLink.Get(), index);
				    index++;
				    newSeq.sequenceCount++;
			    }
			    else { // e instanceof MyChar
                    MyChar newChar = new MyChar();
                    newChar.Set(((MyChar)e).Get());
				    newSeq.add(newChar, index);//newLink.Get(), index);
			    	index++;
			    	newSeq.sequenceCount++;  
			    }
			    /*
                Link newLink = new Link(e);		
				newSeq.add(e, index);//newLink.Get(), index);
				index++;
				newSeq.sequenceCount++;
				*/
				
			}
			else {
				//((Sequence)e).copy();
				newSeq.add(((Sequence)e).copy(), index);
				index++;
			}
			if (j==sequenceCount-1)
				break;
			j++;
			
		}
		return newSeq;
	}	
	
	public Sequence flatten(){
		Sequence flSeq = new Sequence();
		Sequence nfSeq = new Sequence();
		nfSeq.head = this.head;
		flatten2(nfSeq,flSeq);
		return flSeq;
	}

	public static void flatten2(Sequence notFlatOG, Sequence newFlatOne){
		Link l = notFlatOG.head;
		while (l != null){
			if (l.n1 instanceof MyDummy)
				break;
			if ((l.n1 instanceof MyInteger) || (l.n1 instanceof MyChar))
				newFlatOne.add(l.n1, newFlatOne.sqCount());
			else if (l.n1 instanceof Sequence)
				flatten2((Sequence)(l.n1),newFlatOne);
			l = l.nextLink;
		}
	}
	
	Link getLink(int index){
		Link gottenLink=this.head;
		for(int i=0; i<index; i++)
			gottenLink = gottenLink.nextLink;
		return gottenLink;		
	}
	
	public Element index(int pos){
		if (pos>(this.sqCount()-1)){
		    //System.out.println("m1 * m2 = Matrix dimensions incompatible for Product");
			//System.out.println("That position doesn't fall in the range, bruh. Exiting now.");
			System.exit(1);
		}
		return (this.getLink(pos)).n1;
	}
	
	public int sqCount() {
	    int count = 0;
	    Link ctLink = new Link();
	    ctLink = this.head;
	    while (ctLink != null && !(ctLink.n1 instanceof MyDummy)) {
	        count++;
	        if (ctLink.nextLink == null)
	            break;
	        ctLink = ctLink.nextLink;
	    }
	    return count;
	}
	
	Element first(){
		return (this.head).n1;
	}

	Sequence rest(){
		// returns the rest of the elements in the sequence
		// without creating a new sequence, only pointing to the rest of the orig sequence
		Sequence sqRest = new Sequence();
		sqRest.head = this.getLink(1);
		sqRest.sequenceCount = (this.sqCount()) - 1;
		return sqRest;
	}
	
	int length(){
		return this.sqCount();
	}
	
	void add(Element elm, int pos){
		if (pos > this.sqCount()){
			//System.exit(1);
		}
		else{
			Link newLink = new Link(elm);
			if (pos<this.sqCount())
				newLink.nextLink = this.getLink(pos);
			if (pos == 0)
				head = newLink;
			else
				(this.getLink(pos-1)).nextLink = newLink;
			sequenceCount++;
		}
	}
	
	void delete(int pos) {
		// method to remove an element at specified position
		// after deleting, all elements to the right are pushed to the left

		if (pos == 0) {
		    this.head = this.getLink(1);
		}
		else {
		    (this.getLink(pos-1)).nextLink = (this.getLink(pos)).nextLink;
		}
		sequenceCount--;
	}
	
	void Print(){
		System.out.print("[ ");
		for (int p=0; p < this.sqCount(); p++){
			((this.getLink(p)).n1).Print();
			System.out.print(" ");
		}
		System.out.print("]");
	}
	
	SequenceIterator begin() {
	// gives the start of the sequence
		SequenceIterator beginIt = new SequenceIterator();
		beginIt.sqPtr = this.head;
		return beginIt;
	}

	public SequenceIterator end() {
		/* Iterate until this.nextLink == NULL,
		then, add the dummy to the next one */
		
		SequenceIterator endIt = new SequenceIterator();
		if ((this.getLink(this.sqCount())) == null){
			MyDummy x = new MyDummy();
			this.add(x,this.sequenceCount);
			this.sequenceCount--;
		}
		endIt.sqPtr = this.getLink(this.sqCount());
		
		return endIt;
	}
}
