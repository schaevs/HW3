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

			int j = 0;
			int index = 0;

			for (Element e = (this.head).n1; j<this.sqCount(); e = (((this.rest()).head).n1)){
				if (e instanceof Sequence){
					nwSeq.add(((Sequence)e).copy(),index);
					index++;
				}
				else{
					nwSeq.add(e,index);
					index++;
				}
				if (j==sqCount()-1)
					break;
				j++;
			}
			
			nwSeq.sequenceCount = this.sqCount();
			return nwSeq;
		
	}
	
	public static int flIndex;
	public Sequence flatten(){

		Sequence nwSeq = new Sequence();
		Sequence olSeq = this.copy();
		flIndex = 0;
		flatten2(olSeq,nwSeq);

		nwSeq.sequenceCount = flIndex;
		//System.out.println("sqCount: " + nwSeq.sequenceCount);
		return nwSeq;
	}
	
	public static void flatten2(Sequence notFlat, Sequence toFlatten){
		int j = 0;
		for (Element e = (notFlat.head).n1; j<notFlat.sqCount(); e = (((notFlat.rest()).head).n1)){
			if (e instanceof Sequence){
				flatten2((Sequence) e, toFlatten);
			}
			else{
				toFlatten.add(e,flIndex);
				flIndex++;
				//System.out.println("flIndex is now " + flIndex);	
			}
			if (j == (notFlat.sqCount())-1){
				break;
			}
			j++;
		}
	}
	
	Link getLink(int index){
		Link gottenLink=this.head;
		//if (index == this.sequenceCount)
			//System.out.println("trying to get index this.sequenceCount");
		for(int i=0; i<index; i++)
			gottenLink = gottenLink.nextLink;
		return gottenLink;		
	}
	
	public Element index(int pos){
		if (pos>this.sqCount()-1){
			//error
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
		/* NEED TO FIX SO THAT WHEN HEAD ELEMENT IS PRINTED,
		NO SPACE IS INCLUDED */
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
			System.exit(1);
			// add error!!!
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
		
		//ADD A CASE HERE FOR PRINTING ANOTHER SEQUENCE
		//need to print [ [ 0 ] 0 ] instead of [[0 ] ]
		
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