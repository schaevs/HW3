class Sequence extends Element {

	//contains what is necessary to produce a list of elements
	//should include dynamic sizing and other functions mentioned in hw
	
	private Link head;
	public int sequenceCount;
	
	public Sequence(){
		head = null;
		sequenceCount = 0;
	}


	public Sequence copy(){ //produces deep copy of elements
		Sequence newSeq = new Sequence(); //our new copy

		int i = 0; //used to iterate thru
		Link current = this.getLink(0); //get head node

		while(current != null){
			//System.out.println(current.getData());
			if (current.Get() instanceof MyInteger){
				//System.out.println(" INT:");
                                //Link newLink = new Link(current.Get());		
				//newSeq.add(newLink.Get(), i);
				MyInteger newInt = new MyInteger();
				newInt = (MyInteger)(current.Get());
				newSeq.add(newInt, i);
				newSeq.sequenceCount++;	
				//i++;
			}
			else if (current.Get() instanceof MyChar){
				//System.out.println(" CHAR:");
                                //Link newLink = new Link(current.Get());		
				//newSeq.add(newLink.Get(), i);
				MyChar newChar = new MyChar();
				newChar = (MyChar)(current.Get());
				newSeq.add(newChar, i);
				newSeq.sequenceCount++;
				//i++;
			}
			else if(current.Get() instanceof Sequence){
				Sequence cpy = new Sequence();
				Sequence s = ((Sequence)current.Get()).copy();//creates a shallow copy for me to do easier referencing
				Link c = s.head;
				while(c != null){
					Link n = new Link(c.Get()); 
					cpy.add(n.Get(),cpy.sequenceCount);
					cpy.sequenceCount++;
					c = c.nextLink;

					/* Tried something; didn't work.
					if (c.Get() instanceof MyInteger) {
						MyInteger newInt = new MyInteger();
						newInt = (MyInteger)(c.Get());
						cpy.add(newInt, i);
						cpy.sequenceCount++;
					}
					else if (c.Get() instanceof MyChar) {
						MyChar newChar = new MyChar();
						newChar = (MyChar)(c.Get());
						cpy.add(newChar, i);
						cpy.sequenceCount++;
					}
					else if (c.Get() instanceof Sequence) {
						Sequence ss = ((Sequence)(c.Get())).copy(); //call it recusively
					}
					c = c.nextLink; */
				} 	
				//cpy  = add(((Sequence)current.getData()).copy(), 0); //recursive copy
				newSeq.add(cpy,i);
				newSeq.sequenceCount++;
			}
			
			i++;
			current = current.nextLink;
		}//end of while loop
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
		if (pos>this.sqCount()-1){
			System.out.println("That position doesn't fall in the range, bruh. Exiting now.");
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
	
	public void Print(){
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
