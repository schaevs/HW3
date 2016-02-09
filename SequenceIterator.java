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
		//System.out.println("Moving On");
		//SequenceIterator sqIt = new SequenceIterator();
		this.sqPtr = (this.sqPtr).nextLink;
		return this;
	}

	Element get() {
	// return the object to which the SequenceIterator points
		return this.sqPtr.n1;
	}
	
	
}
